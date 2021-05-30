<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="help/header.jsp" %>
<%@ include file="help/footer.jsp" %>
<%@include file="help/menu.jsp" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta/>
    <link href="${pageContext.request.contextPath}/assets/css/t.css" rel="stylesheet" type="text/css">
    <title>Procedures</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <c:set var="now" value="<%=new java.util.Date()%>"/>
    <fmt:formatDate pattern="yyyy-MM-dd" value="${now}"/>
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">
        <h3>List of procedures</h3>
        <button class="btn">
            <a href="${pageContext.request.contextPath}/event/today" style="color: #efffe9">For today</a>
        </button>
        <button class="btn">
            <a href="${pageContext.request.contextPath}/event/now" style="color: #efffe9">For now</a>
        </button>
        <button class="btn">
            <a href="${pageContext.request.contextPath}/patient/" style="color: #efffe9">Patient search</a>
        </button>
        <br>

        <table class="table table-striped table-bordered table-hover" style="margin-top: 20px;">
            <thead>
            <tr>
                <th colspan="5">List of procedures</th>
            </tr>
            <tr>
                <th width="15%">Date and time</th>
                <th width="35%">Full name</th>
                <th width="10%">Type of procedure</th>
                <th width="15%">Medicament</th>
                <th width="25%">Status</th>
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

                        <c:choose>
                            <c:when test="${e.status eq 'Planned'}">
                                <%--                                todo && ${e.date eq parsedDatetime}--%>
                                <td>
                                    <form:form action="${pageContext.request.contextPath}/event/${e.id}/done"
                                               cssClass="form" method="get">
                                        <button type="submit" class="btn" style="margin-left: 20px;">Completed</button>
                                    </form:form>
                                    <hr>
                                    <form:form action="${pageContext.request.contextPath}/event/${e.id}/cancel"
                                               cssClass="form" method="get">
                                        <button type="submit" class="btn" style="margin-left: 20px;"> Canceled</button>
                                        <input type="text" class="form-s" style="margin-top: 5px;" name="comment"
                                               style="float: left"
                                               placeholder="reason for canceling"/>
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