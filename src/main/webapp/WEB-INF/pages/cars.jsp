<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Cars</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        body {
            background: url(http://doanarae.com/doanarae/10064-car-background_42291.jpg) no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }
    </style>
</head>
<body>
<div class="w3-panel w3-teal" style="margin-bottom: 0; margin-top: 0">
    <h2 class="w3-text-white" style="text-shadow:1px 1px 0 #444">List of cars</h2>
</div>
<div>
    <c:if test="${!empty listCars}">
        <table class="w3-table-all w3-hoverable">
            <tr class="w3-gray">
                <td>ID</td>
                <td>Model</td>
                <td>Country</td>
                <td>Type</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach items="${listCars}" var = "car">
                <tr>
                    <td>${car.getId()}</td>
                    <td>${car.getModel()}</td>
                    <td>${car.getCountry()}</td>
                    <td>${car.getType()}</td>
                    <td><a href="<c:url value='/edit/${car.id}'/>">Edit</a></td>
                    <td><a href="<c:url value='/remove/${car.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div> <br/>
<a class="w3-button w3-teal" href="../../index.jsp">Back to main </a>
</body>
</html>