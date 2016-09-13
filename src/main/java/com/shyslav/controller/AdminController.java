package com.shyslav.controller;

import com.google.gson.Gson;
import com.shyslav.models.UserList;
import siteentity.entity.RoleType;
import webframework.impls.WebClassFramework;
import webframework.impls.WebMethodFramework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shyslav on 9/11/16.
 */
@SuppressWarnings("unused")
@WebClassFramework(layout = "custom", urlPath = {"admin"})
public class AdminController {
    @WebMethodFramework(role = RoleType.ADMIN, jspPath = "admin")
    public void indexPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().write("index");
        UserList userList = new UserList();
        request.setAttribute("userList",userList);
    }

    @WebMethodFramework(role = RoleType.ADMIN, url = "users", jspPath = "ajax")
    public void userList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserList userList = new UserList();
        String json = new Gson().toJson(userList);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @WebMethodFramework(role = RoleType.ADMIN, url = "block", jspPath = "ajax")
    public void blockUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().write("blockUser");
    }
}
