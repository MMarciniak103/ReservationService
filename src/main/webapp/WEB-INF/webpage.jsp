<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/webpage.css">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <script>
        let userName = "${pageContext.request.userPrincipal.name}"
    </script>
</head>
<body onload="getAppointments();">

<div class="parallax"></div>

<section class="jumbotron text-center">
    <div class="container presentation">
        <h1>IB RESERVATION SYSTEM</h1>
        <p>Make an appointmentDto with a specialist of your choice.
            The service allows you to choose a convenient date and its possible cancellation.
            In addition, you have the option of monitoring all your visits.
        </p>
    </div>

</section>


<div class="container text-center">
    <div class="row">

        <div class="col-5">
            <div class="appointmentError text-center" id="appointmentError">
<%--                <c:if test="${appointmentError != null}">--%>
<%--                    <p>Status: ${appointmentError}</p>--%>
<%--                </c:if>--%>
            </div>
            <div class="appointmentSuccess text-center" id="appointmentSuccess">
<%--                <c:if test="${appointmentSuccess != null}">--%>
<%--                    <p>Status: ${appointmentSuccess}</p>--%>
<%--                </c:if>--%>
            </div>
            <div class="appointment-form">
                <h2>Make an appointment</h2>
                <p>Doctor Specialization</p>
                <select class="custom-select" id="specialization">
                    <c:forEach var="doctor" items="${doctors}">
                        <option value="${doctor.getSpecialization()}">${doctor.getSpecialization()}</option>
                    </c:forEach>
                </select>
                <p>Date</p>
                <input type="date" id="date"/>
                <p>Institution</p>
                <select class="custom-select" id="institution">
                    <c:forEach var="doctor" items="${doctors}">
                        <option value="${doctor.getInstitution()}">${doctor.getInstitution()}</option>
                    </c:forEach>
                </select>
                <input type="button" class="btn btn-light" onclick="makeAppointment()" value="Confirm"/>
            </div>
        </div>
        <div class="col-7">

            <div class="appointment-container">
                <table class="table" id="appointment-table">
                    <thead>
                    <tr>
                        <th scope="col">Date</th>
                        <th scope="col">Doctor</th>
                        <th scope="col">Institution</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/js/mainPanel.js"></script>
</body>
</html>