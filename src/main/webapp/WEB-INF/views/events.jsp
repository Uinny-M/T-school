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
    <link href="${pageContext.request.contextPath}/assets/css/t.css" rel="stylesheet" type="text/css">
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
            <a href="${pageContext.request.contextPath}/event/today" style="color: #efffe9">На ближайший день</a>
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
                    <sec:authorize access="hasAnyRole('ROLE_NURSE')">
                        <c:choose>
                            <c:when test="${e.status eq 'Запланировано'}">
                                <td>
                                    <form:form action="/T_school_war_exploded/event/${e.id}/done" cssClass="form" method="get">
                                        <button type="submit" class="btn" style="margin-left: 20px;">Выполнено</button>
                                    </form:form>
                                    <hr>
                                    <form:form action="/T_school_war_exploded/event/${e.id}/cancel" cssClass="form" method="get">
                                        <button type="submit" class="btn" style="margin-left: 20px;"> Отменено </button>
                                        <input type="text" class="form-s" style="margin-top: 5px;" name="comment" style="float: left"
                                               placeholder="Причина отмены"/>
                                    </form:form>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>${e.status} ${e.comment}</td>
                            </c:otherwise>
                        </c:choose>
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
</style>