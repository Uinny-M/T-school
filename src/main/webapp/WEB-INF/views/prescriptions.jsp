<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="help/header.jsp" %>
<%@ include file="help/footer.jsp" %>
<%@include file="help/menu.jsp" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta/>
  <link href="css/t.css" rel="stylesheet" type="text/css">
  <title>Назначения</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
  <div class="content">
      <button class="btn">
          <a href="${pageContext.request.contextPath}/prescription/case/${prescriptions.get(0).patientCase.id}/add" style="color: #efffe9">Новое назначение</a>
      </button>
      <h3>Назначения в страховом случае</h3>
      <table class="table table-striped table-bordered">
        <thead>
        <tr>
          <th colspan="4">Список назначений</th>
        </tr>
        <tr>
          <th width="25%">Тип манипуляции</th>
          <th width="25%">Продолжительность</th>
          <th width="25%">Дата начала</th>
          <th width="25%">Подробности</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${prescriptions}" var="p">
          <tr>
            <td>${p.manipulation.title}</td>
            <td>${p.duration} дн.</td>
            <td>${p.startDate}</td>
            <td>${p.drug}</td>
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
.vertical-menu a.menu-patient{
  background-color: #28a347;
  color: #efffe9;
}
/*Content*/
.content {
background-color: #fff;
height: auto;
width: auto;
right: 0;
display: block;
/*margin: 0px;*/
padding: 20px;
list-style: none;
position: absolute;
left: 200px;
bottom: 55px;
top: 165px;
overflow-y: scroll;
}
/*Form-search*/
.content .btn {
font-size: 14px;
height: 30px;
color: #fff;
background: #28a347;
border-radius: 15px;
padding: 5px 25px;
border: none;
text-transform: capitalize;
transition: all 0.5s ease 0s;
}
.form {
width: 100%;
height: auto;
display: block;
margin: 10px;
}
.form-group-search {
float: left;
margin-left: 10px;
margin-top: 10px;
display: inline;
}
.row {
margin-top: 20px;
}
.form-s {
background-color: #f9e9ff;
width: 300px;
border: 1px solid #28a347;
}
.form b {
font-size: 17px;
color: #28a347;
transition: all 0.5s ease 0s;
}
/*Table*/
.table {
background-color: #efffe9;
}
.table :active {
background-color: #efffe9;
}
</style>