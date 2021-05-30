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
    <title>Prescriptions</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">
        <h3>Prescription's details</h3>
        <form:form action="${pageContext.request.contextPath}/prescription/case/${caseId}/add" method="post"
                   modelAttribute="prescription" cssClass="form">
            <div class="form-group-create row">
                <b class="col-xs-3">Type of manipulation</b>
                <form:select path="manipulationTitle" cssClass="form-select-lg">
                    <c:forEach var="manipulation" items="${manipulations}">
                        <form:option value="${manipulation.id}" label="${manipulation.title}"/>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Medicament</b>
                <form:input cssClass="form-s" path="drug"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Dosage</b>
                <form:input cssClass="form-s" path="dosage"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Duration, days</b>
                <form:input cssClass="form-s" type="number" path="duration"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Days of week</b>
                <form:select path="weekdays" cssClass="form-select-lg" multiple="multiple" size="7">
                    <c:forEach var="day" items="${days}">
                        <form:option value="${day.name()}"/>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Time of day</b>
                <form:select path="times" cssClass="form-select-lg" multiple="multiple" size="10">
                    <c:forEach var="time" items="${times}">
                        <form:option value="${time}"/>
                    </c:forEach>
                </form:select>
            </div>
            <br><br>
            <button type="submit" class="btn">Save changes</button>
        </form:form>
        <br>
        <botton class="btn">
            <a href="http://localhost:8080/T_school_war_exploded/cases/${patientId}/update/${caseId}"
               style="color: #efffe9">Back</a>
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
</style>