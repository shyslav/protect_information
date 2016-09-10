package com.shyslav.controller;

import com.shyslav.utils.GlobalController;
import webframework.entity.RoleType;
import webframework.impls.WebClassFramework;
import webframework.impls.WebMethodFramework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by shyshkin_vlad on 10.04.16.
 */
@SuppressWarnings("unused")
@WebClassFramework(layout = "custom", urlPath = "login")
public class LoginController extends GlobalController {
    private static final Logger log = Logger.getLogger(LoginController.class.getName());

    @WebMethodFramework(role = RoleType.USER, url = "login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().print("login ");
        //request.getRequestDispatcher("/WEB-INF/app/index.jsp").forward(request, response);
    }

    @WebMethodFramework(role = RoleType.USER, url = "logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().print("logout ");
        //request.getRequestDispatcher("/WEB-INF/app/index.jsp").forward(request, response);
    }
}
