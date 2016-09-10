<%@ page import="webframework.entity.UserStorage" %><%--
  Created by IntelliJ IDEA.
  User: shyslav
  Date: 9/10/16
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="col-lg-12">
        <form action="/login/signin" method="POST">
            <input class="form-group" type="text" placeholder="login" id="login" name="login" required>
            <input class="form-group" type="password" id="password" name="password" required>
            <input type="submit">
        </form>
    </div>
</div>
