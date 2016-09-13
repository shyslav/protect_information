package com.shyslav.controller;

import com.shyslav.validations.PasswordValidations;
import lazyfunction.LazyBootstrap;
import siteentity.entity.RoleType;
import webframework.impls.UserVariables;
import webframework.impls.WebClassFramework;
import webframework.impls.WebMethodFramework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shyslav on 9/13/16.
 */
@SuppressWarnings("unused")
@WebClassFramework(layout = "custom", urlPath = {"profile","profile/"})
public class ProfileController {
    @WebMethodFramework(role = {RoleType.ADMIN,RoleType.USER}, jspPath = "profile")
    public void indexPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
    @WebMethodFramework(role = {RoleType.ADMIN,RoleType.USER},url = "settings", jspPath = "account_settings")
    public void getAccountSettings(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getSession().getAttribute("checkpass") != null){
            request.getSession().removeAttribute("checkpass");
        }else {
            response.sendRedirect("/profile");
        }
    }
    @WebMethodFramework(role = {RoleType.ADMIN,RoleType.USER},url = "changePassword", jspPath = "ajax")
    public void chagePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getMethod().equalsIgnoreCase("POST")){
            String pass = request.getParameter("password");
            String confpass = request.getParameter("confirm_password");
            if (confpass == null || pass == null){
                request.getSession().setAttribute("checkpass", "ok");
                request.getSession().setAttribute("flash_message", LazyBootstrap.generateAlert("danger", "Wrong data",
                        " Re-enter new passwords"));
                response.sendRedirect("/profile/settings");
                return;
            }
            if(!PasswordValidations.validate(pass,confpass)){
                request.getSession().setAttribute("checkpass", "ok");
                request.getSession().setAttribute("flash_message", LazyBootstrap.generateAlert("danger", "Wrong password",
                        " Re-enter new passwords"));
                response.sendRedirect("/profile/settings");
                return;
            }else {
                response.sendRedirect("/login/signout");
            }
        }
    }
}
