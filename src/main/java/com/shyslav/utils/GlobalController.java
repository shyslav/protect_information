package com.shyslav.utils;

import com.shyslav.data.UserStorage;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by shyslav on 9/9/16.
 */
public class GlobalController {
    private static final Logger log = Logger.getLogger(GlobalController.class.getName());
    protected void set(HttpServletRequest request, HttpServletResponse response){

    }
    protected void setPageTitle(HttpServletRequest req, String title) {
        req.setAttribute("title", title);
    }

    protected void setNewUser(HttpServletRequest req, HttpServletResponse resp){
        if(req.getSession().getAttribute("userstorage")==null){
            String ipAddress = req.getRemoteAddr();
            UserStorage userStorage = new UserStorage(ipAddress,0,null);
            req.getSession().setAttribute("userstorage",userStorage);
        }
    }
}
