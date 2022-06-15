<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/15/2022
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items='${requestScope["users"]}' var="users">
        <p>${users.getName()}</p>
    </c:forEach>


</body>
</html>
