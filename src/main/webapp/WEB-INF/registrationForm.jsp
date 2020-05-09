<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Registration Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/registration.css">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body id="form-body">


<div class="container">
    <div class="appointmentError text-center" id="appointmentError">
    </div>
    <div class="appointmentSuccess text-center" id="appointmentSuccess">
    </div>

    <h1 class="text-center">Registration Form</h1>
    <div class="form-group text-center">
        <label>Username</label>
        <input type="text" class="form-control text-center" id="username">
    </div>

    <div class="form-group text-center">
        <label>Password</label>
        <input type="password" class="form-control text-center" id="password">
    </div>
    <div class="text-center">
        <input class="btn btn-primary" type="button" onclick="registration()" value="Add">
    </div>

</div>


<div class="btn-container text-center">
    <div>
        <a class="btn btn-outline-light btn-lg " href="/login">Go Back</a>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/mainPanel.js"></script>
<script src="${pageContext.request.contextPath}/js/registration.js"></script>
</body>
</html>