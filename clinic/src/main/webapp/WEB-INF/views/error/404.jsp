<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../help/header.jsp" %>
<%@ include file="../help/footer.jsp" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link href="${pageContext.request.contextPath}/src/main/webapp/assets/css/t.css" rel="stylesheet" type="text/css">
    <title>Ошибка</title>
</head>
<body>

<jsp:include page="../help/header.jsp"></jsp:include>
<div class="container http-error-container">
    <div class="content-exception">
        <h1>404</h1>
        <h2>Страница не найдена</h2>
        <button type="button" class="btn" style="margin-top: 1px">
            <a href="${pageContext.request.contextPath}/src/main/webapp">
                Вернуться на главную страницу</a>
        </button>
    </div>
</div><!-- /.container -->
<jsp:include page="../help/footer.jsp"></jsp:include>
</body>
</html>

<style>
    .vertical-menu a.menu-index {
        background-color: #28a347;
        color: #efffe9;
    }
</style>