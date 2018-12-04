<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>web</title>
</head>
<body>
<h3>web-app</h3>
<br/>
<a href="<c:url value="/cars"/>">Cars list</a>
<a href="<c:url value="/users"/>">Users list</a>
<a href="<c:url value="/cars-info"/>">CarsInfo list</a>
<a href="<c:url value="/users-info"/>">UsersInfo list</a>
<br/>
</body>
</html>