<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="help/header.jsp" %>
<%@ include file="help/footer.jsp" %>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link href="${pageContext.request.contextPath}/src/main/webapp/assets/css/t.css" rel="stylesheet" type="text/css">
  <title>Авторизация</title>
 </head>
 <body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<jsp:include page="help/header.jsp"></jsp:include>

<div class="container">
<%-- <c:if test="${not empty errormessage}">--%>
  <h2>${errormessage}</h2>
<%-- </c:if>--%>

 <div class="row">

 <div class="col-md-offset-3 col-md-6">
 <form action="${pageContext.request.contextPath}/login" method="post" class="form-horizontal">
 <span class="heading">АВТОРИЗАЦИЯ</span>
  <c:if test="${not empty errorMessage}">
  <div style="color: #d5272b">${errorMessage}</div>
  </c:if>
 <div class="form-group">
 <input type="text" class="form-control" name="username"  placeholder="Username">
 <i class="fa fa-user"></i>
 </div>
 <div class="form-group help">
 <input type="password" class="form-control" name="password"  placeholder="Password">
 <i class="fa fa-lock"></i>
<%-- <a href="#" class="fa fa-question-circle"></a>--%>
 </div>
<%-- <div class="form-group">--%>
<%-- <div class="main-checkbox">--%>
<%-- <input type="checkbox" value="none" id="checkbox1" name="check"/>--%>
<%-- <label for="checkbox1"></label>--%>
<%-- </div>--%>
<%-- <span class="text">Запомнить</span>--%>
 <button type="submit" class="btn btn-default" style="right: auto">ВХОД</button>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

 </div>
 </form>
 </div>

 </div><!-- /.row -->
</div><!-- /.container -->

<jsp:include page="help/footer.jsp"></jsp:include>
 </body>
</html>

<style>
  /*Form Style*/
 .container {
  margin-top: 220px;
 }
</style>