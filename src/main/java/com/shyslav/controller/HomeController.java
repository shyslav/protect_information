package com.shyslav.controller;

import com.shyslav.utils.GlobalController;
import lazyfunction.LazyComputerInfo;
import licenseframe.InitialLicence;
import licenseframe.users.LicensedUser;
import siteentity.entity.RoleType;
import webframework.impls.WebClassFramework;
import webframework.impls.WebMethodFramework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by shyshkin_vlad on 10.04.16.
 */
@SuppressWarnings("unused")
@WebClassFramework(layout = "custom", urlPath = {"index","/",""})
public class HomeController extends GlobalController {
    private static final Logger log = Logger.getLogger(HomeController.class.getName());

    @WebMethodFramework(role = {RoleType.ADMIN,RoleType.USER,RoleType.GUEST}, jspPath = "index")
    public void indexPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LicensedUser user = new LicensedUser();
        user.setUserName(LazyComputerInfo.getUserName());
        user.setComputerName(LazyComputerInfo.getComputerName());
        user.setSystem(LazyComputerInfo.getOSName());
        user.setDiskTotalSpace(LazyComputerInfo.getDriverInfo().get(0).getTotalSpace());

        Dimension screen = LazyComputerInfo.getScreenSize();

        request.setAttribute("user", user);
        request.setAttribute("screen", screen);
        request.setAttribute("currentdir",LazyComputerInfo.getCurrentDir());
        request.setAttribute("mouselist",LazyComputerInfo.getLinuxMouseDevice());
        request.setAttribute("checkLicense",InitialLicence.checkLicense());
        request.setAttribute("licenseMd5",InitialLicence.generateComputerDataMd5());
        request.setAttribute("test","testData");
    }
}
