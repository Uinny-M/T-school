<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mma
  Date: 22.04.2021
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach var="patients" items="${patients}">
    <td>${patients.id}</td>
    <td>${patients.secondName}</td>
    <td>${patients.firstName}</td>
    <td>${patients.insurance}</td>
</c:forEach>

</body>
</html>
