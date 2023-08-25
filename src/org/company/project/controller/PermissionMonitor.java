package org.company.project.controller;


import org.company.project.common.exception.ThereIsNotPermissionException;
import org.company.project.common.wrapper.ErrorHandler;
import org.company.project.model.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PermissionMonitor implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            try {
                HttpServletRequest request = (HttpServletRequest) servletRequest;
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                String panelTarget = request.getRequestURI().split("/")[1];
                User user = (User) request.getSession().getAttribute("user");
                boolean flag = false;
                if (user != null && !user.getRoleName().isEmpty())
                    for (String role : user.getRoleName()) {
                        if (role.equals(panelTarget)) {
                            flag = true;
                            filterChain.doFilter(request, response);
                        }
                    }
                if (!flag){
                    System.out.println(request.getRemoteAddr());
                    throw new ThereIsNotPermissionException();
                }
            } catch(ThereIsNotPermissionException e){
                ErrorHandler.getError(e, (HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
            }

    }

    @Override
    public void destroy() {

    }
}
