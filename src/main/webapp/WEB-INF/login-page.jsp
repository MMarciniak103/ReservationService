<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<body>
<div class="loginbox">
    <i class="fa fa-user-circle fa-3x"></i>
    <h1>Login</h1>
    <form>
        <p>Username</p>
        <input type="text" name="" placeholder="Enter Username">
        <p>Password</p>
        <input type="password" name="" placeholder="Enter Password"/>
        <input type="submit" name="" value="Login">
        <a href="#">Forgot password?</a><br>
        <a href="#">Don't have an account?</a>
    </form>
</div>
</body>
</html>