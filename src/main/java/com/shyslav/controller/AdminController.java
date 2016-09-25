package com.shyslav.controller;

import com.google.gson.Gson;
import com.shyslav.databasefunc.DatabaseFunc;
import com.shyslav.models.UserList;
import com.shyslav.utils.GlobalController;
import database.insert.DatabaseInsert;
import lazyfunction.LazyBootstrap;
import lazyfunction.LazyMD5;
import siteentity.entity.RoleType;
import siteentity.entity.User;
import siteentity.storage.UserStorage;
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
public class AdminController extends GlobalController {
    @WebMethodFramework(role = RoleType.ADMIN, jspPath = "admin")
    public void indexPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().write("index");
        UserList userList = new UserList();
        request.setAttribute("userList", userList);
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
        int id = Integer.parseInt(request.getParameter("id"));
        UserStorage userStorage = (UserStorage) request.getSession().getAttribute("userstorage");

        if (userStorage.getUser().getId() != id) {
            DatabaseFunc.blockUser(id);
            response.getWriter().print(LazyBootstrap.generateAlert("success", "Success", "User blocked"));
        } else {
            response.sendError(404);
        }
    }

    @WebMethodFramework(role = RoleType.ADMIN, url = "unblock", jspPath = "ajax")
    public void unblockUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserStorage userStorage = (UserStorage) request.getSession().getAttribute("userstorage");

        if (userStorage.getUser().getId() != id) {
            DatabaseFunc.unBlockUser(id);
            response.getWriter().print(LazyBootstrap.generateAlert("success", "Success", "User ublocked"));
        } else {
            response.sendError(404);
        }
    }

    @WebMethodFramework(role = RoleType.ADMIN, url = "add", jspPath = "ajax")
    public void addNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String password = LazyMD5.md5("12345");
        if (request.getMethod().equalsIgnoreCase("POST")) {
            if (request.getParameter("name") == null) {
                response.sendRedirect("/admin");
                return;
            }
            UserList userList = new UserList();
            String name = request.getParameter("name");
            if(name == null || name.length()<3){
                setFlashMessage(request, LazyBootstrap.generateAlert("danger", "User name error", "User name null or length<3"));
                response.sendRedirect("/admin");
                return;
            }
            for (User user : userList) {
                if (user.getLogin().equals(name)) {
                    setFlashMessage(request, LazyBootstrap.generateAlert("danger", "User name error", "User already exist"));
                    response.sendRedirect("/admin");
                    return;
                }
            }
            DatabaseInsert.prepareInsert("user", new Object[]{name, 2, password}, new String[]{"login", "role", "password"});
            setFlashMessage(request, LazyBootstrap.generateAlert("success", "Success add new user", "User added to user list"));
            response.sendRedirect("/admin");

        }
    }
}
