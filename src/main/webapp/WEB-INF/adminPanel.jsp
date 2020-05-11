<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminPanel.css">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body id="form-body">


<div class="container">
    <div class="appointmentError text-center" id="appointmentError">
    </div>
    <h1 class="text-center">Add Doctor</h1>
    <div class="form-group text-center">
        <label>Specialization</label>
        <input type="text" class="form-control text-center" id="specialization">
    </div>

    <div class="form-group text-center">
        <label>Institution</label>
        <input type="text" class="form-control text-center" id="institution">
    </div>
    <div class="form-group text-center">
        <label>Working from:</label>
        <input type="number" class="form-control text-center" id="workingFrom">
    </div>
    <div class="from-group text-center">
        <label>Working to:</label>
        <input type="number" class="form-control text-center" id="workingTo">
    </div>
    <div class="text-center">
        <input class="btn btn-primary" type="button" onclick="addDoctor()" value="Add">
    </div>

</div>


<div class="form-group container text-center success-label">
    <div class="form-group text-center">
        <label id="institution-label"></label><br>
        <label id="specialization-label"></label><br>
        <label id="working-hours-label"></label>
    </div>
</div>

<div class="btn-container text-center">
    <div>
        <a class="btn btn-outline-light btn-lg " href="/">Go Back</a>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/adminPage.js"></script>
<script src="${pageContext.request.contextPath}/js/mainPanel.js"></script>
</body>
</html>