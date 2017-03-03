package com.p8499.lang.server.controller;

import com.p8499.lang.server.FilterExpr;
import com.p8499.lang.server.OrderByListExpr;
import com.p8499.lang.server.bean.Language;
import com.p8499.lang.server.controller.base.LanguageControllerBase;
import com.p8499.lang.server.mask.LanguageMask;
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
public class LanguageController extends LanguageControllerBase {
    @Override
    protected Language onGet(HttpSession session, HttpServletRequest request, HttpServletResponse response, String lsid, LanguageMask mask) throws Exception {
        Language bean = baseGet(lsid, mask);
        if (bean == null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return bean;
    }

    @Override
    protected Language onAdd(HttpSession session, HttpServletRequest request, HttpServletResponse response, String lsid, Language bean) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }

    @Override
    protected Language onUpdate(HttpSession session, HttpServletRequest request, HttpServletResponse response, String lsid, Language bean, LanguageMask mask) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }

    @Override
    protected void onDelete(HttpSession session, HttpServletRequest request, HttpServletResponse response, String lsid) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    @Override
    protected Long onCount(HttpSession session, HttpServletRequest request, HttpServletResponse response, FilterExpr filter) throws Exception {
        return baseCount(filter);
    }

    @Override
    protected List<Language> onQuery(HttpSession session, HttpServletRequest request, HttpServletResponse response, FilterExpr filter, OrderByListExpr orderByList, long start, long count, LanguageMask mask) throws Exception {
        return baseQuery(filter, orderByList, start, count, mask);
    }

    @Override
    protected InputStream inputStream(HttpSession session, HttpServletRequest request, HttpServletResponse response, String lsid, String name) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }

    @Override
    protected OutputStream outputStream(HttpSession session, HttpServletRequest request, HttpServletResponse response, String lsid, String name) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }

    @Override
    protected void onDeleteAttach(HttpSession session, HttpServletRequest request, HttpServletResponse response, String lsid, String name) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    @Override
    protected List<String> onListAttaches(HttpSession session, HttpServletRequest request, HttpServletResponse response, String lsid) throws Exception {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return null;
    }
}
