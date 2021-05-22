<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="help/header.jsp" %>
<%@ include file="help/footer.jsp" %>
<%@include file="help/menu.jsp" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link href="${pageContext.request.contextPath}/assets/css/t.css" rel="stylesheet" type="text/css">
    <title>Главная</title>
</head>
<body>

<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">
        <div class="navi-block ">
            <a href="${pageContext.request.contextPath}/patient/" class="block">
                <h2>Пациенты</h2>
            </a>
            <a href="${pageContext.request.contextPath}/event/" class="block">
                <h2>Процедуры</h2>
            </a>
        </div>
        <div class="navi-block">
            <a href="${pageContext.request.contextPath}/employee/" class="block">
                <h2>Сотрудники</h2>
            </a>
            <a href="${pageContext.request.contextPath}/employee/manipulation" class="block">
                <h2>Приемная</h2>
            </a>
        </div>
    </div>
</div><!-- /.container -->
<jsp:include page="help/footer.jsp"></jsp:include>
</body>
</html>

<style>
    .vertical-menu a.menu-index {
        background-color: #28a347;
        color: #efffe9;
    }
</style>