package com.shyslav.controller;

import siteentity.entity.RoleType;
import webframework.impls.WebClassFramework;
import webframework.impls.WebMethodFramework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shyslav on 9/25/16.
 */
@SuppressWarnings("unused")
@WebClassFramework(layout = "custom", urlPath = "contacts")
public class ContactsController {
    private static final String mail = "shyshkin.vladyslav@gmail.com";
    private static final String name = "Vladyslav Shyshkin";
    private static final String phone = "+380(93)582-5956";
    @WebMethodFramework(role = {RoleType.ADMIN,RoleType.USER, RoleType.GUEST}, jspPath = "contacts")
    public void contacts(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("mail",mail);
        request.setAttribute("name",name);
        request.setAttribute("phone",phone);
    }
}
