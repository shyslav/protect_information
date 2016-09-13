package com.shyslav.utils;

import lazyfunction.LazyBootstrap;

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

    protected void setFlashMessage(HttpServletRequest request,String message){
        request.getSession().setAttribute("flash_message",message);
    }
}
