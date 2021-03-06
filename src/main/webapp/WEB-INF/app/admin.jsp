<%@ page import="com.shyslav.models.UserList" %>
<%@ page import="siteentity.entity.User" %>
<%@ page import="siteentity.entity.RoleType" %>
<%@ page import="lazyfunction.LazyBootstrap" %><%--
  Created by IntelliJ IDEA.
  User: shyslav
  Date: 9/11/16
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    table,th,td,tr,tbody {
        text-align: center;
    }
</style>
<div class="container">
    <div class="col-lg-12">
        <div id="flash_message">
            <%
                if (request.getSession().getAttribute("flash_message") != null) {
                    out.print(request.getSession().getAttribute("flash_message"));
                    request.getSession().removeAttribute("flash_message");
                }
            %>
        </div>
        <form action="/admin/add" method="POST">
            <div class="input-group">
                <input type="text" class="form-control" name="name" id="name" placeholder="Name">
                <span class="input-group-btn">
                <input class="btn btn-default" type="submit" value="Add new user">
              </span>
            </div>
        </form>
        <br>
        <table class="table">
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Name
                </th>
                <th>
                    Role
                </th>
                <th style="width:10%">
                    Action
                </th>
            </tr>
            <%
                UserList userList = (UserList) request.getAttribute("userList");
                if (userList != null) {
                    for (User user : userList) {
            %>
            <%String selector = user.getRole() == RoleType.BLOCKED ? "danger" : "success";%>

            <tr class="<%=selector%>" id="user_<%=user.getId()%>">
                <td>
                    <%=user.getId()%>
                </td>
                <td>
                    <%=user.getLogin()%>
                </td>
                <td>
                    <%=user.getRole()%>
                </td>
                <td>
                    <%if(selector.equals("success")){%>
                    <button onclick="blockUser(<%=user.getId()%>);" class="btn btn-danger">Block</button>
                    <%}else {%>
                    <button onclick="unBlockUser(<%=user.getId()%>);" class="btn btn-danger">Unblock</button>
                    <%}%>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>

</div>
<script>
    function blockUser(userID) {
        if (confirm("Block user")) {
            $.ajax({
                url: "/admin/block",
                method: "POST",
                data: {
                    id: userID
                },
                success: function (content) {
                    document.getElementById("flash_message").innerHTML = content;
                    document.getElementById("user_" + userID).className = "danger";
                },
                error: function () {
                    document.getElementById("flash_message").innerHTML
                            = "<%=LazyBootstrap.generateAlert("danger","Error", "You can't block himself")%>";
                }
            });
        } else {
            return false;
        }
    }

    function unBlockUser(userID) {
        if (confirm("Unblock user")) {
            $.ajax({
                url: "/admin/unblock",
                method: "POST",
                data: {
                    id: userID
                },
                success: function (content) {
                    document.getElementById("flash_message").innerHTML = content;
                    document.getElementById("user_" + userID).className = "success";
                },
                error: function () {
                    document.getElementById("flash_message").innerHTML
                            = "<%=LazyBootstrap.generateAlert("danger","Error", "You cant block himself")%>";
                }
            });
        } else {
            return false;
        }
    }
</script>
