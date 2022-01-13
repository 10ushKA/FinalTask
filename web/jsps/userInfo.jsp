<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 29.12.2021
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<h3>Hello:${user.login}</h3>
<form method="POST" action="/logout"><%--отсcылка к LogoutServlet--%>
<a href="/logout">Logout</a>
</form>
</body>
</html>