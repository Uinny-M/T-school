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
    <title>Patients</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">
        <h3>Case report</h3>
        <form:form action="/T_school_war_exploded/cases/${patientId}/update/${caseId}" method="POST"
                   modelAttribute="case"
                   cssClass="form">
            <div class="form-group-create row">
                <b class="col-xs-3">Patient</b>
                <form:input cssClass="form-s" disabled="true" path="patient.secondName"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Diagnosis</b>
                <form:input cssClass="form-s" path="diagnosis"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">Start date</b>
                <form:input cssClass="form-s" disabled="true" readonly="true" type="data" path="startDate"/>
            </div>
            <div class="form-group-create row">
                <b class="col-xs-3">End date</b>
                <form:input cssClass="form-s" disabled="true" readonly="true" type="data" path="endDate"/>
            </div>
            <div class="form-group row">
                <b class="col-xs-3">Doctor</b>
                <form:input cssClass="form-s" disabled="true" path="doctor.login"/>
            </div>
            <br>
            <sec:authorize access="hasRole('ROLE_DOCTOR')">
                <button type="submit" class="btn">Save changes</button>
            </sec:authorize>
        </form:form>
        <br>
        <br>
        <button class="btn" style="margin: 10px">
            <a href="${pageContext.request.contextPath}/cases/${patientId}" style="color: #efffe9">
                Patient's card record</a>
        </button>
        <sec:authorize access="hasRole('ROLE_DOCTOR')">
            <button type="button" class="btn">
                <a href="${pageContext.request.contextPath}/cases/close/${caseId}"
                   style="color: #efffe9">Close the case</a></button>
            <button class="btn">
                <a href="${pageContext.request.contextPath}/prescription/case/${caseId}/add"
                   style="color: #efffe9">Add new prescription</a>
            </button>
            <button class="btn">
                <a href="http://localhost:8080/T_school_war_exploded/event/${patientId}"
                   style="color: #efffe9">List of procedures</a>
            </button>
        </sec:authorize>

        <h3>Prescriptions in the case</h3>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th colspan="4">List of prescriptions</th>
            </tr>
            <tr>
                <th width="25%">Type of manipulation</th>
                <th width="25%">Duration</th>
                <th width="25%">Medicament</th>
                <th width="25%">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${prescription}" var="p">
                <tr>
                    <td>${p.manipulation.title}</td>
                    <td>${p.duration} дн.</td>
                    <td>${p.dosage} ${p.drug}</td>
                    <td>
                        <c:if test="${p.closed}">Completed</c:if>
                        <c:if test="${not p.closed}">In progress</c:if>
                        <sec:authorize access="hasRole('ROLE_DOCTOR')">
                            <c:if test="${not p.closed}">
                                <button class="btn">
                                    <a href="${pageContext.request.contextPath}/prescription/cancel/${p.id}"
                                       style="color: #efffe9">Cancel</a>
                                </button>
                            </c:if>
                        </sec:authorize>
                    </td>
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

    .fix {
        background: #efffe9;
    }
</style>