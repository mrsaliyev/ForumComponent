<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
pageContext.setAttribute("user",login,PageContext.SESSION_SCOPE);
<%= "Welcome " + request.getParameter("login") %><br>
<form action="CreatePost" method="post">
    <h2>Create Post Form</h2>
    Title: <input type="text" name="title" placeholder = "Enter title" required>
    <br/>
    Text: <input type="text" name="text" placeholder="Enter text" required>
    <br>
    <%= request.getParameter("login") %>
    <input type="submit" value="Create">
</form>
</body>
</html>
