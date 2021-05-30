<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="help/header.jsp" %>
<%@ include file="help/footer.jsp" %>
<%@include file="help/menu.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta/>
    <link href="css/t.css" rel="stylesheet" type="text/css">
    <title>Пациенты</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>

<jsp:include page="help/header.jsp"></jsp:include>

<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">
        <h3>Карточка пациента</h3>
        <sec:authorize access="hasRole('ROLE_DOCTOR')">
            <form:form action="${pageContext.request.contextPath}/cases/${patientId}/add" cssClass="form" method="post">
                <input type="text" class="form-s" name="diagnosis" style="float: left" placeholder="Диагноз"
                       value="${diagnosis}"/>
                <button type="submit" class="btn" style="margin-left: 20px;">Новый страховой случай</button>
            </form:form>
        </sec:authorize>

        <br><br>

        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th colspan="5">Список страховых случаев</th>
            </tr>
            <tr>
                <th width="30%">ФИО пациента</th>
                <th width="25%">Врач</th>
                <th width="25%">Диагноз</th>
                <th width="10%">Дата начала</th>
                <th width="10%">Дата окончания</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cases}" var="c">
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/cases/${c.patient.id}/update/${c.id}">${c.patient.secondName} ${c.patient.firstName} ${c.patient.middleName}</a>
                    </td>
                    <td>${c.doctor.secondName} ${c.doctor.firstName}</td>
                    <td>${c.diagnosis}</td>
                    <td>${c.startDate}</td>
                    <td>${c.endDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div><!--/.content-->
</div><!-- /.container -->
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