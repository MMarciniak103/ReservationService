<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<body>
<div>
    <c:if test="${param.error != null}">
        Invalid username and password
    </c:if>
</div>
<div>
    <c:if test="${param.logout != null}">
        You have been logged out.
    </c:if>
</div>

<div class="loginbox">
    <i class="fa fa-user-circle fa-3x"></i>
    <h1>Login</h1>
    <form:form action="/authenticateUser" method="post">
        <p>Username</p>
        <input type="text" name="username" placeholder="Enter Username">
        <p>Password</p>
        <input type="password" name="password" placeholder="Enter Password"/>
        <input type="submit" value="Login">
        <a href="#">Forgot password?</a><br>
        <a href="#">Don't have an account?</a>
    </form:form>
</div>
</body>
</html>