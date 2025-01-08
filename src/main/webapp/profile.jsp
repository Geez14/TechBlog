<%--
  Created by IntelliJ IDEA.
  User: imona
  Date: 08-01-2025
  Time: 06:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.geez14.techblogs.entities.User"%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h1>Welcome <%=((User)session.getAttribute("userSession")).getUsername()%></h1>
    <h1>Email: <%=((User)session.getAttribute("userSession")).getEmail()%></h1>
</body>
</html>
