<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="help/header.jsp" %>
<%@ include file="help/footer.jsp" %>
<%@include file="help/menu.jsp" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta/>
    <link href="${pageContext.request.contextPath}/assets/css/t.css" rel="stylesheet" type="text/css">
    <title>Пациенты</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">
        <h3>Данные пациента</h3>
        <form:form action="/T_school_war_exploded/patient/add" method="post" modelAttribute="patient"
                   cssClass="form">
            <div class="form-group-create row">
                <b class="col-xs-3">Фамилия</b>
                <form:input cssClass="form-s" path="secondName"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Имя</b>
                <form:input cssClass="form-s" path="firstName"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Отчество</b>
                <form:input cssClass="form-s" path="middleName"/>
            </div>
            <div class="form-group row">
                <b class="col-xs-3">Дата рождения</b>
                <form:input cssClass="form-s" max="" type="date" path="birthdate"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Пол</b>
                Мужской <form:radiobutton cssClass="form-s" value="MALE" path="gender"/><br>
                Женский <form:radiobutton cssClass="form-s" value="FEMALE" path="gender"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">№ страховки</b>
                    <form:input cssClass="form-s"  path="insurance"/>
            </div>
            <br>
            <sec:authorize access="hasRole('ROLE_DOCTOR')">
                <button type="submit" class="btn">Сохранить изменения</button>
            </sec:authorize>
        </form:form>
        <br>
        <c:if test="${not empty patient.id}">
            <botton class="btn" style="margin: 10px">
                <a href="http://localhost:8080/T_school_war_exploded/cases/${patient.id}" style="color: #efffe9">Карточка
                    пациента</a>
            </botton>
            <botton class="btn">
                <a href="http://localhost:8080/T_school_war_exploded/event/${patient.id}" style="color: #efffe9">Процедурный
                    лист</a>
            </botton>
        </c:if>
    </div>
</div>
<jsp:include page="help/footer.jsp"></jsp:include>
</body>
</html>

<style>
    /*Menu*/
    .vertical-menu a.menu-patient {
        background-color: #28a347;
        color: #efffe9;
    }
</style>