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
    <link href="css/t.css" rel="stylesheet" type="text/css">
    <title>CLINIC</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">
        <h3>Подробности страхового случая</h3>
        <form:form action="/T_school_war_exploded/cases/update/" method="POST" modelAttribute="case"
                   cssClass="form">
            <div class="form-group-create row">
                <b class="col-xs-3">Пациент</b>
                <form:input cssClass="form-s" path="patient.secondName"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Диагноз</b>
                <form:input cssClass="form-s" path="diagnosis"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Начало</b>
                <form:input cssClass="form-s" readonly="true" type="data" path="startDate"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Окончание</b>
                <form:input cssClass="form-s" readonly="true" type="data" path="endDate"/>
            </div>
            <div class="form-group row">
                <b class="col-xs-3">Врач</b>
                <form:input cssClass="form-s" path="doctor.secondName"/>
            </div>
            <br>
            <button type="submit" class="btn">Сохранить изменения</button>
        </form:form>
        <br>
        <br>
        <button type="button" class="btn">
            <a href="${pageContext.request.contextPath}/cases/close/${prescription.get(0).patientCase.id}"
               style="color: #efffe9">Закрыть больничный</a></button>
        <button class="btn" style="margin: 10px">
            <a href="${pageContext.request.contextPath}/cases/${prescription.get(0).patient.id}" style="color: #efffe9">
                Карточка пациента</a>
        </button>
        <button class="btn">
            <a href="${pageContext.request.contextPath}/prescription/case/${prescription.get(0).patientCase.id}/add"
               style="color: #efffe9">Новое назначение</a>
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
            <c:forEach items="${prescription}" var="p">
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
    .vertical-menu a.menu-patient {
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

    .section-hidding {
        margin: 10px;
        margin-top: 100px;
    }

    .form {
        width: 100%;
        height: auto;
        display: block;
        margin: 10px;
    }

    .form-hidding {
        margin-top: 30px;
        border-bottom: 1px solid #28a347;
        border-top: 1px solid #28a347;
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