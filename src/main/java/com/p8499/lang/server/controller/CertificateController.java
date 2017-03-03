package com.p8499.lang.server.controller;

import com.p8499.lang.server.FilterExpr;
import com.p8499.lang.server.OrderByListExpr;
import com.p8499.lang.server.bean.Certificate;
import com.p8499.lang.server.controller.base.CertificateControllerBase;
import com.p8499.lang.server.mask.CertificateMask;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrator on 2/27/2017.
 */
@RestController
public class CertificateController extends CertificateControllerBase {
    @Override
    protected Certificate onGet(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer crid, CertificateMask mask) throws Exception {
        Certificate bean = baseGet(crid, mask);
        if (bean == null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return bean;
    }

    @Override
    protected Certificate onAdd(HttpSession session, HttpServletRequest request, HttpServletResponse response, Certificate bean) throws Exception {
        //TODO
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return null;
    }

    @Override
    protected Certificate onUpdate(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer crid, Certificate bean, CertificateMask mask) throws Exception {
        //TODO
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return null;
    }

    @Override
    protected void onDelete(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer crid) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    @Override
    protected Long onCount(HttpSession session, HttpServletRequest request, HttpServletResponse response, FilterExpr filter) throws Exception {
        return baseCount(filter);
    }

    @Override
    protected List<Certificate> onQuery(HttpSession session, HttpServletRequest request, HttpServletResponse response, FilterExpr filter, OrderByListExpr orderByList, long start, long count, CertificateMask mask) throws Exception {
        return baseQuery(filter, orderByList, start, count, mask);
    }

    @Override
    protected InputStream inputStream(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer crid, String name) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }

    @Override
    protected OutputStream outputStream(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer crid, String name) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }

    @Override
    protected void onDeleteAttach(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer crid, String name) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    @Override
    protected List<String> onListAttaches(HttpSession session, HttpServletRequest request, HttpServletResponse response, Integer crid) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }
}
