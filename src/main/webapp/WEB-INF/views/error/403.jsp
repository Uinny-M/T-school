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
    <link href="${pageContext.request.contextPath}/assets/css/t.css" rel="stylesheet" type="text/css">
    <title>Error</title>
</head>
<body>

<jsp:include page="../help/header.jsp"></jsp:include>
<div class="container http-error-container">
    <div class="content-exception">

        <h1>ERROR 403</h1>
        <h2> Access is denied</h2>
        <sec:authorize access="!isAuthenticated()">
            <h3>Please log in</h3>
            <a href="${pageContext.request.contextPath}/login" class="menu-index">
                Login</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <h3>Your account does not have access to this resource</h3>
        </sec:authorize>
        <button type="button" class="btn" style="margin-top: 1px; background: #28a347">
            <a href="${pageContext.request.contextPath}/">
                Return to the homepage</a>
        </button>
    </div>
</div><!-- /.container -->
<jsp:include page="../help/footer.jsp"></jsp:include>
</body>
</html>

<style>
    .content-exception {
        background-color: #fff;
        color: #d5272b;
        margin-top: 200px;
        overflow-y: auto;
        text-align: center;
        justify-content: center;
    }
</style>
