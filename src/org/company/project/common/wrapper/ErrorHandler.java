package org.company.project.common.wrapper;

import org.apache.log4j.Logger;
import org.company.project.common.exception.InvalidUsernameOrPassword;
import org.company.project.common.exception.ThereIsNotPermissionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ErrorHandler {
    private ErrorHandler () {}
    public static void getError (Exception e, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Logger logger = Logger.getLogger(ErrorHandler.class);
        e.printStackTrace();
        if(e instanceof InvalidUsernameOrPassword){
            logger.error(e.getMessage());
            logger.error(e.getClass());
            req.setAttribute("msg","InvalidUsernameOrPassword");
            resp.sendError(700);
        } else if (e instanceof ThereIsNotPermissionException) {
            logger.error(e.getMessage());
            logger.error(e.getClass());
            req.setAttribute("msg","ThereIsNotPermissionException");
            resp.sendError(403);
        } else {
            logger.error(e.getMessage());
            logger.error(e.getClass());
            req.setAttribute("msg",e.getMessage());
            resp.sendError(700);
        }
    }
}
