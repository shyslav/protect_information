<%@ page import="SiteData.storage.UserStorage" %><%--
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
        <p>This example is a quick exercise to illustrate how the default, static and fixed to top navbar work. It includes the responsive CSS and HTML, so it also adapts to your viewport and device.</p>
        <p>To see the difference between static and fixed top navbars, just scroll.</p>
        <p>
            <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
        </p>
    </div>
    <%UserStorage storage = (UserStorage) session.getAttribute("userstorage");%>
    <%if(storage!=null){
        out.print(storage.getIpAddress()  + "<br>");
        out.print(storage.getAmountLogin()  + "<br>");
    }%>
    TEST:${test}
</div>
