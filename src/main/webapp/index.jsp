<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Let's go!</title>
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
  <h2 class="w3-text-white" style="text-shadow:1px 1px 0 #444">People and cars app.</h2>
</div>
<div class="w3-panel w3-gray" style="margin-top: 0;">
  <br/>
  <div style="display: flex; justify-content: space-around; width: 50%; margin: auto;">
    <a class="w3-button w3-light-gray" href="/cars">All Cars </a>
    <a class="w3-button w3-light-gray" href="/cars-info">Information about cars</a>
    <a class="w3-button w3-light-gray" href="/users">All Users</a>
    <a class="w3-button w3-light-gray" href="/users-info">Information about users</a>
  </div>
  <br/>
</div>
</body>
</html>