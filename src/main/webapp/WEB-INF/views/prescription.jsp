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
    <title>Назначение</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">
        <h3>Подробное назначение</h3>
        <form:form action="${pageContext.request.contextPath}/prescription/case/${caseId}/add" method="post"
                   modelAttribute="prescription" cssClass="form">
            <div class="form-group-create row">
                <b class="col-xs-3">Вид манипуляции</b>
                <form:select path="manipulationTitle" cssClass="form-select-lg">
                    <c:forEach var="manipulation" items="${manipulations}">
                        <form:option value="${manipulation.id}" label="${manipulation.title}"/>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Лекарство</b>
                <form:input cssClass="form-s" path="drug"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Дозировка</b>
                <form:input cssClass="form-s" path="dosage"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Длительность, дней</b>
                <form:input cssClass="form-s" type="number" path="duration"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Дни недели</b>
<%--                <select name="weekdays" size="7" Class="form-s" multiple="multiple">--%>
<%--                    <c:forEach var="weekday" items="${week}">--%>
<%--                        <option value="${weekday}">${weekday}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
                <form:select path="weekdays" cssClass="form-select-lg" multiple="multiple" size="7">
                    <c:forEach var="day" items="${days}">
                        <form:option value="${day.name()}"/>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Время приема</b>
<%--                <select name="week" size="4" Class="form-s" multiple="multiple">--%>
<%--                    <c:forEach var="time" items="${times}">--%>
<%--                        <option value="${time}">${time}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
                <form:select path="times" cssClass="form-select-lg" multiple="multiple">
                    <c:forEach var="time" items="${times}">
                        <form:option value="${time}"/>
                    </c:forEach>
                </form:select>
            </div>
            <br><br>
            <button type="submit" class="btn">Сохранить изменения</button>
        </form:form>
        <br>
        <botton class="btn">
        <a href="http://localhost:8080/T_school_war_exploded/cases/${patientId}/update/${caseId}"
           style="color: #efffe9">Назад</a>
    </botton>
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