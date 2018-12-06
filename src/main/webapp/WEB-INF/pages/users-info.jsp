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
    <h2 class="w3-text-white" style="text-shadow:1px 1px 0 #444">List of information about users</h2>
</div>
<div>
    <c:if test="${!empty listUsersInfo}">
        <table class="w3-table-all w3-hoverable">
            <tr class="w3-gray">
                <td>ID(User ID)</td>
                <td>Drive Lic.</td>
                <td>Description</td>
                <td>DTP-Date</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
            <c:forEach items="${listUsersInfo}" var="userInfo">
                <tr>
                    <td>${userInfo.getId()}(${userInfo.getUser().getId()})</td>
                    <td>${userInfo.getDriveLicence()}</td>
                    <td>${userInfo.getDescription()}</td>
                    <td>${userInfo.getDtpDate()}</td>
                    <td><a href="<c:url value='/editUserInfo/${userInfo.id}'/>">Edit</a></td>
                    <td><a href="<c:url value='/removeUserInfo/${userInfo.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<br/>
<a class="w3-button w3-teal" href="../../index.jsp">Back to main </a>

<h1>Add Information about User</h1>

<c:url var="addAction" value="/users-info/add"/>

<form:form action="${addAction}" commandName="userInfo">
    <table>
        <c:if test="${!empty userInfo.description}">
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
                <form:label path="driveLicence">
                    <spring:message text="Drive Licence"/>
                </form:label>
            </td>
            <td>
                <form:input path="driveLicence"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dtpDate">
                    <spring:message text="DTP Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="dtpDate"/>
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
                <c:if test="${!empty userInfo.description}">
                    <input type="submit" class="w3-button w3-teal"
                           value="<spring:message text="Edit information"/>"/>
                </c:if>
                <br/>
                <c:if test="${empty userInfo.description}">
                    <input type="submit" class="w3-button w3-teal"
                           value="<spring:message text="Add information"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>