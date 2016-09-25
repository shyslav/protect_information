<%@ page import="siteentity.storage.UserStorage" %><%--
  Created by IntelliJ IDEA.
  User: shyslav
  Date: 9/13/16
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UserStorage storage = (UserStorage) session.getAttribute("userstorage");%>
<div class="container">
    <div class="col-lg-12">
        <h1>Hello, my name is ${name}</h1>
        <h4>Phone: ${phone}</h4>
        <h4>Mail: ${mail}</h4>
    </div>
</div>

