<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="help/header.jsp" %>
<%@ include file="help/footer.jsp" %>
<%@include file="help/menu.jsp" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta/>
    <link href="css/t.css" rel="stylesheet" type="text/css">
    <title>Процедуры</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">
        <h3>Список процедур</h3>
        <button class="btn">
            <a href="${pageContext.request.contextPath}/event/" style="color: #efffe9">На ближайший день</a>
        </button>
        <button class="btn">
            <a href="${pageContext.request.contextPath}/event/now" style="color: #efffe9">На ближайший час</a>
        </button>
        <button class="btn">
            <a href="${pageContext.request.contextPath}/patient/" style="color: #efffe9">Поиск по пациентам</a>
        </button>
        <br>

        <table class="table table-striped table-bordered table-hover" style="margin-top: 20px;">
            <thead>
            <tr>
                <th colspan="5">Процедурный лист</th>
            </tr>
            <tr>
                <th width="15%">Дата и время</th>
                <th width="35%">ФИО пациента</th>
                <th width="10%">Вид процедуры</th>
                <th width="15%">Лекарство</th>
                <th width="25%">Статус</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${events}" var="e">
                <tr>
                    <td>${e.date} ${e.time}</td>
                    <td>${e.patient.secondName} ${e.patient.firstName} ${e.patient.middleName}</td>
                    <td>${e.manipulation.title}</td>
                    <td>${e.prescription.dosage} ${e.prescription.drug}</td>

                    <sec:authorize access="hasRole('ROLE_DOCTOR')">
                        <td>${e.status} ${e.comment}</td>
                    </sec:authorize>
                    <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_NURSE')">

<%--                        <c:if test="${e.status eq 'Запланировано'}">--%>

<%--                        </c:if>--%>
                        <c:choose>
                            <c:when test="${e.status eq 'Запланировано'}">
                                <td>
                                    <form:form action="/T_school_war_exploded/event/${e.id}/done" cssClass="form" method="get">
                                        <button type="submit" class="btn" style="margin-left: 20px;">Выполнено</button>
                                    </form:form>
                                    <form:form action="/T_school_war_exploded/event/${e.id}/cancel" cssClass="form" method="get">
                                        <input type="text" class="form-s" name="comment" style="float: left"
                                               placeholder="Причина отмены"/>
                                        <button type="submit" class="btn" style="margin-left: 20px;">Отменено</button>
                                    </form:form>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>${e.status} ${e.comment}</td>
                            </c:otherwise>
                        </c:choose>

<%--                        <c:if test="${e.status eq 'Запланировано'}">--%>
<%--                            <td>${e.status} ${e.comment}</td>--%>
<%--                        </c:if>--%>

                    </sec:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
    </div><!--/.content-->
</div><!-- /.container -->
<jsp:include page="help/footer.jsp"></jsp:include>
</body>
</html>

<style>
    /*Menu*/
    .vertical-menu a.menu-events {
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