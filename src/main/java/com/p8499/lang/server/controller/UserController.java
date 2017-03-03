package com.p8499.lang.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.p8499.lang.server.FilterExpr;
import com.p8499.lang.server.FilterLogicExpr;
import com.p8499.lang.server.OrderByListExpr;
import com.p8499.lang.server.bean.Roleauthority;
import com.p8499.lang.server.bean.User;
import com.p8499.lang.server.bean.Usercreation;
import com.p8499.lang.server.bean.Userrole;
import com.p8499.lang.server.controller.base.UserControllerBase;
import com.p8499.lang.server.mapper.local.RoleauthorityMapper;
import com.p8499.lang.server.mapper.local.UsercreationMapper;
import com.p8499.lang.server.mapper.local.UserroleMapper;
import com.p8499.lang.server.mask.UserMask;
import com.p8499.lang.server.mask.UsercreationMask;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

/**
 * Created by Administrator on 2/26/2017.
 */
@RestController
public class UserController extends UserControllerBase {
    @Override
    protected User onGet(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer usid, UserMask mask) throws Exception {
        if (session.getAttribute("usid") != null && session.getAttribute("usid").equals(usid))
            mask.setUspswd(false);
        else
            mask.setUspswd(false).setUscell(true);
        User bean = baseGet(usid, mask);
        if (bean == null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return bean;
    }

    @Override
    protected User onAdd(HttpSession session, HttpServletRequest request, HttpServletResponse response, User bean) throws Exception {
        List<Usercreation> usercreation = usercreationMapper.query(new FilterLogicExpr().equalsString(Usercreation.FIELD_UCCELL, bean.getUscell())
                .equalsNumber(Usercreation.FIELD_UCAC, Usercreation.UCAC_VERIFIED)
                .equalsNumber(Usercreation.FIELD_UCST, Usercreation.UCST_VALID).toString(), null, 0, 1, null);
        if (usercreation.size() == 0) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        userMapper.add(bean.setUspswd(DigestUtils.md5Hex(bean.getUspswd())).setUsst(User.DEFAULT_USST));
        userroleMapper.add(new Userrole().setUrusid(bean.getUsid()).setUrrlid("player"));
        usercreationMapper.update(usercreation.get(0).setUcac(Usercreation.UCAC_FINALIZED), new UsercreationMask().setUcst(true));
        return bean;
    }

    @Override
    protected User onUpdate(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer usid, User bean, UserMask mask) throws Exception {
        if (session.getAttribute("usid") == null || !session.getAttribute("usid").equals(usid)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }
        if (mask.getUscell()) {
            //TODO
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }
        if (mask.getUspswd())
            bean.setUspswd(DigestUtils.md5Hex(bean.getUspswd()));
        baseUpdate(bean, mask.setUsst(false));
        return bean;
    }

    @Override
    protected void onDelete(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer usid) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    @Override
    protected Long onCount(HttpSession session, HttpServletRequest request, HttpServletResponse response, FilterExpr filter) throws Exception {
        //TODO
        return null;
    }

    @Override
    protected List<User> onQuery(HttpSession session, HttpServletRequest request, HttpServletResponse response, FilterExpr filter, OrderByListExpr orderByList, long start, long count, UserMask mask) throws Exception {
        //TODO
        return null;
    }

    @Override
    protected InputStream inputStream(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer usid, String name) throws Exception {
        File file = new File(session.getServletContext().getRealPath(String.format("%s%s/%d/%s", attachmentFolder, User.NAME, usid, name)));
        if (!file.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        InputStream input = new FileInputStream(file);
        return input;
    }

    @Override
    protected OutputStream outputStream(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer usid, String name) throws Exception {
        if (session.getAttribute("usid") == null || !session.getAttribute("usid").equals(usid)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }
        File file = new File(session.getServletContext().getRealPath(String.format("%s%s/%d/%s", attachmentFolder, User.NAME, usid, name)));
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        OutputStream output = new FileOutputStream(file);
        if (output == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return output;
    }

    @Override
    protected void onDeleteAttach(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer usid, String name) throws Exception {
        //TODO
    }

    @Override
    protected List<String> onListAttaches(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer usid) throws Exception {
        //TODO
        return null;
    }

    @RequestMapping(value = path + "signin/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Integer signin(HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam String uscell, @RequestParam String uspswd) throws JsonProcessingException {
        List<User> userList = userMapper.query(new FilterLogicExpr().equalsString(User.FIELD_USCELL, uscell).toString(), null, 0, 1, new UserMask().setUsid(true).setUspswd(true));
        if (userList.size() == 0 || !userList.get(0).getUspswd().equals(DigestUtils.md5Hex(uspswd)) ||
                roleauthorityMapper.count(
                        new FilterLogicExpr().equalsString(Roleauthority.FIELD_RAAUID, "mobile").existsObject(
                                Userrole.TABLE, new FilterLogicExpr().equalsField(Userrole.FIELD_URRLID, Roleauthority.FIELD_RARLID).equalsNumber(Userrole.FIELD_URUSID, userList.get(0).getUsid())).toString()) == 0) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }
        session.setAttribute("usid", userList.get(0).getUsid());
        response.setStatus(HttpServletResponse.SC_OK);
        return userList.get(0).getUsid();
    }

    @RequestMapping(value = path + "status/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Integer status(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        if (session.getAttribute("usid") == null) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return null;
        }
        response.setStatus(HttpServletResponse.SC_OK);
        return (Integer) session.getAttribute("usid");
    }

    @RequestMapping(value = path + "signout/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void signout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        if (session.getAttribute("usid") == null) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return;
        }
        session.removeAttribute("usid");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Value(value = "#{usercreationMapper}")
    protected UsercreationMapper usercreationMapper;

    @Value(value = "#{roleauthorityMapper}")
    protected RoleauthorityMapper roleauthorityMapper;

    @Value(value = "#{userroleMapper}")
    protected UserroleMapper userroleMapper;

    @Value(value = "${app.attachmentFolder}")
    protected String attachmentFolder;
}
