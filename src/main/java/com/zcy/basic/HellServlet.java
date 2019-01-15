package com.zcy.basic;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 13:57 2019-01-15
 * @ Modified: By:
 *
 *
 * 为了Decompiler 查看Servlet相关接口及实现
 */
public class HellServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        HttpServletRequest
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
