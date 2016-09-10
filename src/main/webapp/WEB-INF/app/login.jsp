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
            <label for="login"> Login: </label>
            <input class="form-control" type="text" placeholder="login" id="login" name="login" required>
            <label for="password"> Password:</label>
            <input class="form-control" type="password" id="password" name="password" required>
            <input type="submit" class="btn btn-default">
        </form>
    </div>
</div>
