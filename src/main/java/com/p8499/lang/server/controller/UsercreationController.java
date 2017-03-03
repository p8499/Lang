package com.p8499.lang.server.controller;

import com.mysms.sdk.SendMsg;
import com.p8499.lang.server.FilterExpr;
import com.p8499.lang.server.FilterLogicExpr;
import com.p8499.lang.server.OrderByListExpr;
import com.p8499.lang.server.bean.User;
import com.p8499.lang.server.bean.Usercreation;
import com.p8499.lang.server.controller.base.UsercreationControllerBase;
import com.p8499.lang.server.mapper.local.UserMapper;
import com.p8499.lang.server.mask.UsercreationMask;
import org.patchca.service.Captcha;
import org.patchca.service.ConfigurableCaptchaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2/26/2017.
 */
@RestController
public class UsercreationController extends UsercreationControllerBase {
    @Override
    protected Usercreation onGet(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer ucid, UsercreationMask mask) throws Exception {
        return null;
    }

    @Override
    protected Usercreation onAdd(HttpSession session, HttpServletRequest request, HttpServletResponse response, Usercreation bean) throws Exception {
        if (userMapper.count(new FilterLogicExpr().equalsString(User.FIELD_USCELL, bean.getUccell()).toString()) > 0) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return null;
        }
        Date now = new Date();
        if (usercreationMapper.count(new FilterLogicExpr().equalsString(Usercreation.FIELD_UCCELL, bean.getUccell())
                .equalsNumber(Usercreation.FIELD_UCST, Usercreation.UCAC_SENT)
                .gtDate(Usercreation.FIELD_UCCRDT, timeZero(now, 0))
                .leDate(Usercreation.FIELD_UCCRDT, timeZero(now, 1)).toString()) >= 3) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }
        Captcha captcha = configurableCaptchaService.getCaptcha();
        bean = baseAdd(bean.setUccrdt(now).setUcupdt(now).setUcpv(captcha.getChallenge()).setUcmv(null).setUcst(Usercreation.UCAC_INITIAL).setUcst(Usercreation.UCST_VALID));
        if (bean == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        OutputStream out = outputStream(session, null, response, bean.getUcid(), "captcha.png");
        ImageIO.write(captcha.getImage(), "png", out);
        out.close();
        return bean.setUcpv(null);
    }

    @Override
    protected Usercreation onUpdate(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer ucid, Usercreation bean, UsercreationMask mask) throws Exception {
        Usercreation origBean = usercreationMapper.get(ucid, null);
        if (origBean == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        if (origBean.getUcac() == Usercreation.UCAC_INITIAL && origBean.getUcst() == Usercreation.UCST_VALID) {
            if (!origBean.getUcpv().equals(bean.getUcpv())) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return null;
            }
            origBean.setUcmv(String.format("%06d", new Random().nextInt(1000000))).setUcac(Usercreation.UCAC_SENT).setUcupdt(new Date());
            SendMsg.sendBatch(smsServer, smsUsername, smsPassword, origBean.getUccell(), String.format(smsFormat, origBean.getUcmv()));
            usercreationMapper.update(origBean, new UsercreationMask().setUcmv(true).setUcac(true));
        } else if (origBean.getUcac() == Usercreation.UCAC_SENT && origBean.getUcst() == Usercreation.UCST_VALID) {
            if (!origBean.getUcmv().equals(bean.getUcmv())) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return null;
            }
            usercreationMapper.update(origBean.setUcac(Usercreation.UCAC_VERIFIED).setUcupdt(new Date()), new UsercreationMask().setUcac(true).setUcupdt(true));
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }
        return origBean.setUcmv(null);
    }

    @Override
    protected void onDelete(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer ucid) throws Exception {

    }

    @Override
    protected Long onCount(HttpSession session, HttpServletRequest request, HttpServletResponse response, FilterExpr filter) throws Exception {
        return null;
    }

    @Override
    protected List<Usercreation> onQuery(HttpSession session, HttpServletRequest request, HttpServletResponse response, FilterExpr filter, OrderByListExpr orderByList, long start, long count, UsercreationMask mask) throws Exception {
        return null;
    }

    @Override
    protected InputStream inputStream(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer ucid, String name) throws Exception {
        if (usercreationMapper.count(new FilterLogicExpr().equalsNumber(Usercreation.FIELD_UCID, ucid)
                .equalsNumber(Usercreation.FIELD_UCAC, Usercreation.UCAC_INITIAL)
                .equalsNumber(Usercreation.FIELD_UCST, Usercreation.UCST_VALID).toString()) == 0) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        File file = new File(session.getServletContext().getRealPath(String.format("%s%s/%d/%s", attachmentFolder, Usercreation.NAME, ucid, name)));
        if (!file.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        InputStream input = new FileInputStream(file);
        return input;
    }

    @Override
    protected OutputStream outputStream(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer ucid, String name) throws Exception {
        if (request != null)
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        File file = new File(session.getServletContext().getRealPath(String.format("%s%s/%d/%s", attachmentFolder, Usercreation.NAME, ucid, name)));
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        OutputStream output = new FileOutputStream(file);
        if (output == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return output;
    }

    @Override
    protected void onDeleteAttach(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer ucid, String name) throws Exception {

    }

    @Override
    protected List<String> onListAttaches(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer ucid) throws Exception {
        return null;
    }

    @RequestMapping(value = path + "check_ucpv/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void checkUcpv(HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam Integer ucid, @RequestParam String ucpv) {
        Usercreation bean = usercreationMapper.get(ucid, new UsercreationMask().setUcac(true).setUcst(true).setUcpv(true));
        if (bean == null || bean.getUcac() != Usercreation.UCAC_INITIAL || bean.getUcst() != Usercreation.UCST_VALID || !bean.getUcpv().equals(ucpv)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
    }

    @RequestMapping(value = path + "check_ucmv/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void checkUcmv(HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam Integer ucid, @RequestParam String ucmv) {
        Usercreation bean = usercreationMapper.get(ucid, new UsercreationMask().setUcac(true).setUcst(true).setUcmv(true));
        if (bean == null || bean.getUcac() != Usercreation.UCAC_SENT || bean.getUcst() != Usercreation.UCST_VALID || !bean.getUcpv().equals(ucmv)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
    }

    private Date timeZero(Date ref, int offset) {
        Calendar calr = Calendar.getInstance();
        calr.setTime(ref);
        calr.set(Calendar.HOUR_OF_DAY, 0);
        calr.set(Calendar.MINUTE, 0);
        calr.set(Calendar.SECOND, 0);
        calr.set(Calendar.MILLISECOND, 0);
        calr.add(Calendar.DAY_OF_MONTH, offset);
        return calr.getTime();
    }

    @Value(value = "#{userMapper}")
    protected UserMapper userMapper;

    @Value(value = "${app.attachmentFolder}")
    protected String attachmentFolder;

    @Value(value = "${sms.server}")
    protected String smsServer;

    @Value(value = "${sms.username}")
    protected String smsUsername;

    @Value(value = "${sms.password}")
    protected String smsPassword;

    @Value(value = "${sms.format}")
    protected String smsFormat;

    @Value(value = "#{configurableCaptchaService}")
    protected ConfigurableCaptchaService configurableCaptchaService;
}
