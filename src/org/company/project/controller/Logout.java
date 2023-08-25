package org.company.project.controller;

import org.company.project.common.wrapper.ErrorHandler;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            request.getSession().invalidate();
            response.sendRedirect("/index.jsp");
        }catch (Exception e){
            ErrorHandler.getError(e, (HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
