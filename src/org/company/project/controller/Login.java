package org.company.project.controller;

import org.apache.commons.lang3.StringEscapeUtils;
import org.company.project.common.wrapper.ErrorHandler;
import org.company.project.model.domain.User;
import org.company.project.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login.do")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = new User()
                    .setUsername(StringEscapeUtils.escapeHtml4(req.getParameter("username")))
                    .setPassword(StringEscapeUtils.escapeHtml4(req.getParameter("password")));
            UserService.getInstance().login(user);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/" + user.getRoleName().get(0) + "/index.jsp");
        } catch (Exception e) {
            ErrorHandler.getError(e, req, resp);
        }
    }
}
