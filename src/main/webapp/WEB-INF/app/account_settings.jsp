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
        <h1>Hello, <%=storage.getUser().getLogin()%>
        </h1>
        <div id="flash_message">
            <%
                if (request.getSession().getAttribute("flash_message") != null) {
                    out.print(request.getSession().getAttribute("flash_message"));
                    request.getSession().removeAttribute("flash_message");
                }
            %>
        </div>
        <form action="/profile/changePassword" method="POST">
            <label for="password"> New password:</label>
            <input class="form-control" type="password" id="password" name="password" placeholder="New password"
                   required>
            <label for="confirm_password"> Confirm new password:</label>
            <input class="form-control" type="password" id="confirm_password" name="confirm_password"
                   placeholder="Confirm new password" required>
            <br>
            <input type="submit" class="btn btn-default">
        </form>
    </div>
</div>

