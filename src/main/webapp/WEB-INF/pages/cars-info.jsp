<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Info</title>
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
    <h2 class="w3-text-white" style="text-shadow:1px 1px 0 #444">List of information about cars</h2>
</div>
<div>
    <c:if test="${!empty listCarsInfo}">
        <table class="w3-table-all w3-hoverable">
            <tr class="w3-gray">
                <td>ID(Car ID)</td>
                <td>Mileage</td>
                <td>Color</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach items="${listCarsInfo}" var="carInfo">
                <tr>
                    <td>${carInfo.getId()}(${carInfo.getCar().getId()})</td>
                    <td>${carInfo.getMileage()}</td>
                    <td>${carInfo.getColor()}</td>
                    <td><a href="<c:url value='/editCarInfo/${carInfo.id}'/>">Edit</a></td>
                    <td><a href="<c:url value='/removeCarInfo/${carInfo.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<br/>
<a class="w3-button w3-teal" href="../../index.jsp">Back to main </a>

<h1>Add Information about Car</h1>

<c:url var="addAction" value="/cars-info/add"/>

<form:form action="${addAction}" commandName="carInfo">
    <table>
        <c:if test="${!empty carInfo.mileage}">
            <td>
                <form:label path="id">
                    <spring:message text="ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"/>
            </td>
        </c:if>
        <tr>
            <td>
                <form:label path="mileage">
                    <spring:message text="Mileage"/>
                </form:label>
            </td>
            <td>
                <form:input path="mileage"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="color">
                    <spring:message text="Color"/>
                </form:label>
            </td>
            <td>
                <form:input path="color"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="car.id">
                    <spring:message text="Car ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="car.id"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty carInfo.color}">
                    <input type="submit"
                           value="<spring:message text="Edit information"/>"/>
                </c:if>
                <c:if test="${empty carInfo.color}">
                    <input type="submit"
                           value="<spring:message text="Add information"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>