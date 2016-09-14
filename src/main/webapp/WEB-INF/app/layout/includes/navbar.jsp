<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="siteentity.storage.UserStorage" %>
<%@ page import="siteentity.entity.RoleType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%UserStorage storage = (UserStorage) session.getAttribute("userstorage");%>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Vladyslav Shyshkin</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="/">Home</a>
                </li>
                <li>
                    <a href="#contact">Blog</a>
                </li>
                <li>
                    <a href="#about">About</a>
                </li>
                <li>
                    <a href="#contact">Contact</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%if (storage.getUser() == null) {%>
                <li>
                    <a href="/login">Login</a>
                </li>
                <%}%>
                <%if (storage.getUser() != null) {%>
                <li>
                    <a href="/profile">Profile</a>
                </li>
                <li>
                    <a href="/login/logout">Logout</a>
                </li>
                <%}%>
                <%if (storage.getUser()!= null && storage.getUser().getRole() == RoleType.ADMIN) {%>
                <li>
                    <a href="/admin">Admin panel</a>
                </li>
                <%}%>
            </ul>
        </div>
    </div>
</nav>

