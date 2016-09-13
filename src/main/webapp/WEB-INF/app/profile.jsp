<%@ page import="siteentity.storage.UserStorage" %>
<%--
  Created by IntelliJ IDEA.
  User: shyslav
  Date: 9/10/16
  Time: 7:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UserStorage storage = (UserStorage) session.getAttribute("userstorage");%>
<div class="container">
    <h1>Hello, <%=storage.getUser().getLogin()%>
    </h1>
    <h4>Enter your password again to open account settings.</h4>
    <div id="flash_message">

    </div>
    <div class="col-lg-12">
        <label for="login"> Login: </label>
        <input class="form-control" type="text" placeholder="login" id="login" name="login"
               value="<%=storage.getUser().getLogin()%>" disabled>
        <label for="password"> Password:</label>
        <input class="form-control" type="password" id="password" name="password" placeholder="password" required>
        <br>
        <button class="btn btn-default" onclick="checkPass()"> Submit</button>
    </div>
</div>
<script>
    function checkPass() {
        $.ajax({
            url: "/login/checkpass",
            method: "POST",
            data: {
                password: document.getElementById("password").value
            },
            success: function (content) {
                if(content == "OK") {
                    window.location.href = "/profile/settings";
                }else {
                    document.getElementById("flash_message").innerHTML = content;
                }
            },
            error: function () {
                window.location.reload();
            }
        });
        return false;
    }
</script>