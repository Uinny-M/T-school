<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="help/header.jsp" %>
<%@ include file="help/footer.jsp" %>
<%@include file="help/menu.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta/>
    <link href="${pageContext.request.contextPath}/assets/css/t.css" rel="stylesheet" type="text/css">
    <title>Employees</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">

        <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
            <button class="btn">
                <a href="${pageContext.request.contextPath}/employee/add" style="color: #efffe9">Add new
                    employee</a>
            </button>
        </sec:authorize>

        <table class="table table-striped table-bordered table-hover" style="margin-top: 10px">
            <thead>
            <tr>
                <th colspan="3">Staff list</th>
            </tr>
            <tr>
                <th width="50%">Full name</th>
                <th width="25%">Position</th>
                <th width="25%">Access level</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${employees}" var="e">
                <tr>
                    <td>${e.secondName} ${e.firstName} ${e.middleName} </td>
                    <td>${e.position}</td>
                    <td>${e.role}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="help/footer.jsp"></jsp:include>
</body>
</html>
<style>
    /*Menu*/
    .vertical-menu a.menu-employees {
        background-color: #28a347;
        color: #efffe9;
    }
</style>