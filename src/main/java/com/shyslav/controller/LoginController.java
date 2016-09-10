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

    @WebMethodFramework(role = RoleType.USER, jspPath = "login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().print("login ");
        //request.getRequestDispatcher("/WEB-INF/app/custom.jsp").forward(request, response);
    }

    @WebMethodFramework(role = RoleType.USER, url = "logout", jspPath = "ajax")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().print("logout ");
        //request.getRequestDispatcher("/WEB-INF/app/custom.jsp").forward(request, response);
    }

    @WebMethodFramework(role = RoleType.USER, url = "signin", jspPath = "ajax")
    public void signin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println(login + " " + password);
        response.sendRedirect("/login");
    }
}
