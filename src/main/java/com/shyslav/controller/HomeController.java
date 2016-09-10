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
@WebClassFramework(layout = "custom", urlPath = "index")
public class HomeController extends GlobalController {
    private static final Logger log = Logger.getLogger(HomeController.class.getName());

    @WebMethodFramework(role = RoleType.USER, url = "/index")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/app/index.jsp").forward(request, response);
    }
}
