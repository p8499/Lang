package com.p8499.lang.server.task;

import com.p8499.lang.server.FilterLogicExpr;
import com.p8499.lang.server.bean.Usercreation;
import com.p8499.lang.server.mapper.local.UsercreationMapper;
import com.p8499.lang.server.mask.UsercreationMask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2/23/2017.
 */
//@Component("usercreationRecycler")
public class UsercreationRecycler {
    @Scheduled(fixedDelay = 1000)
    public void start() {
        Date now = new Date();
        Calendar calr1 = Calendar.getInstance();
        calr1.setTime(now);
        calr1.add(Calendar.SECOND, -90);
        Calendar calr2 = Calendar.getInstance();
        calr2.setTime(now);
        calr2.add(Calendar.HOUR, -24);
        List<Usercreation> list = usercreationMapper.query(new FilterLogicExpr(FilterLogicExpr.OP_OR)
                .append(new FilterLogicExpr().leDate(Usercreation.FIELD_UCUPDT, calr1.getTime())
                        .equalsNumber(Usercreation.FIELD_UCAC, Usercreation.UCAC_INITIAL)
                        .equalsNumber(Usercreation.FIELD_UCST, Usercreation.UCST_VALID))
                .append(new FilterLogicExpr().leDate(Usercreation.FIELD_UCUPDT, calr1.getTime())
                        .equalsNumber(Usercreation.FIELD_UCAC, Usercreation.UCAC_SENT)
                        .equalsNumber(Usercreation.FIELD_UCST, Usercreation.UCST_VALID))
                .append(new FilterLogicExpr().leDate(Usercreation.FIELD_UCUPDT, calr2.getTime())
                        .equalsNumber(Usercreation.FIELD_UCAC, Usercreation.UCAC_VERIFIED)
                        .equalsNumber(Usercreation.FIELD_UCST, Usercreation.UCST_VALID)).toString(), null, 0, 100, new UsercreationMask().setUcid(true));
        for (Usercreation bean : list) {
            usercreationMapper.update(bean, new UsercreationMask().setUcst(true));
        }
    }

    @Value(value = "#{usercreationMapper}")
    private UsercreationMapper usercreationMapper;
}
