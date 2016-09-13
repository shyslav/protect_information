package com.shyslav.controller;

import siteentity.entity.RoleType;
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
@WebClassFramework(layout = "custom", urlPath = "profile")
public class ProfileController {
    @WebMethodFramework(role = {RoleType.ADMIN,RoleType.USER}, jspPath = "profile")
    public void indexPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("enter");
        request.setAttribute("test","lol");
    }
    @WebMethodFramework(role = {RoleType.ADMIN,RoleType.USER},url = "settings", jspPath = "account_settings")
    public void getAccountSettings(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getSession().getAttribute("checkpass") != null){
            request.getSession().removeAttribute("checkpass");
        }else {
            response.sendError(303);
        }
    }

}
