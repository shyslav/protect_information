<%@ page import="siteentity.storage.UserStorage" %>
<%@ page import="licenseframe.users.LicensedUsers" %>
<%@ page import="java.awt.*" %>
<%@ page import="lazyfunction.LazyComputerInfo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: shyslav
  Date: 9/10/16
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="jumbotron">
        <h1>Navbar example</h1>
        <p>This example is a quick exercise to illustrate how the default, static and fixed to top navbar work. It
            includes the responsive CSS and HTML, so it also adapts to your viewport and device.</p>
        <p>To see the difference between static and fixed top navbars, just scroll.</p>
        <p>
            <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
        </p>
    </div>
    <%
        UserStorage storage = (UserStorage) session.getAttribute("userstorage");
        LicensedUsers user = (LicensedUsers) request.getAttribute("user");
        Dimension screen = (Dimension) request.getAttribute("screen");
        ArrayList<String> mouses = (ArrayList<String>) request.getAttribute("mouselist");
        String currentDir = (String) request.getAttribute("currentdir");
        boolean checkLicense = (boolean) request.getAttribute("checkLicense");
        String licenseMd5 = (String) request.getAttribute("licenseMd5");
    %>
    Current dir: <%=currentDir%><br>
    Check license: <%=checkLicense%><br>
    Computer name: <%=user.getComputerName()%> <br>
    User name: <%=user.getUserName()%><br>
    Disc space: <%=user.getDiskTotalSpace()/1000000000%> gigabyte<br>
    System: <%=user.getSystem()%><br>
    Screen width: <%=screen.getWidth()%><br>
    Screen height: <%=screen.getHeight()%><br>
    Mouses list:
    <%for (String mouse : mouses){%>
        <%=mouse%>
    <%}%>
    <br>
    LicenseMD5: <%=licenseMd5%>
    <br><br><br>

</div>
