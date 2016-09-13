<%@ page import="com.shyslav.models.UserList" %>
<%@ page import="siteentity.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: shyslav
  Date: 9/11/16
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <%
        if (request.getSession().getAttribute("flash_message") != null) {
            out.print(request.getSession().getAttribute("flash_message"));
            request.getSession().removeAttribute("flash_message");
        }
    %>

    <div class="col-lg-12">
        <table>

        </table>
    </div>
    <%
        UserList userList = (UserList) request.getAttribute("userList");
        if (userList != null) {
            for (User user : userList) {
    %>
        <%=user.getLogin()%>
    <%
            }
        }
    %>
</div>
