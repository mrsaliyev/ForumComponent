
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="header.jsp"%>

<form action="Registration" method="post">
    <h2>Registration Form</h2>
    Login: <input type="text" name="login" placeholder = "Enter login" required>
    <br/>
    Password: <input type="password" name="password" placeholder="Enter password" required>
    <br>
    <input type="submit" value="Register">
</form>

</body>
</html>
