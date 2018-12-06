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
                <td>ID(User ID)</td>
                <td>Model</td>
                <td>Country</td>
                <td>Type</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach items="${listCars}" var = "car">
                <tr>
                    <td>${car.getId()}(${car.getUser().getId()})</td>
                    <td>${car.getModel()}</td>
                    <td>${car.getCountry()}</td>
                    <td>${car.getType()}</td>
                    <td><a href="<c:url value='/editCar/${car.id}'/>">Edit</a></td>
                    <td><a href="<c:url value='/removeCar/${car.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div> <br/>
<a class="w3-button w3-teal" href="../../index.jsp">Back to main </a>

<h1>Add a Car</h1>

<c:url var="addAction" value="/cars/add"/>

<form:form action="${addAction}" commandName="car">
    <table>
        <c:if test="${!empty car.model}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="model">
                    <spring:message text="Model"/>
                </form:label>
            </td>
            <td>
                <form:input path="model"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="country">
                    <spring:message text="Country"/>
                </form:label>
            </td>
            <td>
                <form:input path="country"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="type">
                    <spring:message text="Type"/>
                </form:label>
            </td>
            <td>
                <form:input path="type"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="user.id">
                    <spring:message text="User ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="user.id"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <br/>
                <c:if test="${!empty car.model}">
                    <input type="submit" class="w3-button w3-teal"
                           value="<spring:message text="Edit Car"/>"/>
                </c:if>
                <br />
                <c:if test="${empty car.model}">
                    <input type="submit" class="w3-button w3-teal"
                           value="<spring:message text="Add Car"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>