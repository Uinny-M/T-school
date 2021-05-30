<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="help/header.jsp" %>
<%@ include file="help/footer.jsp" %>
<%@include file="help/menu.jsp" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta/>
    <link href="css/t.css" rel="stylesheet" type="text/css">
    <title>Patients</title>
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<jsp:include page="help/header.jsp"></jsp:include>
<div class="container">
    <jsp:include page="help/menu.jsp"></jsp:include>
    <div class="content">
        <h3>List of patients</h3>
        <form:form action="/T_school_war_exploded/patient/" cssClass="form" method="get">
            <input type="text" class="form-s" name="name" style="float: left" placeholder="Secondname" value="${search}"/>
            <button type="submit" class="btn" style="margin-left: 20px;">Find by secondname</button>
        </form:form>
        <sec:authorize access="hasAnyRole('ROLE_DOCTOR', 'ROLE_DOCTOR')">
        <button class="btn">
            <a href="http://localhost:8080/T_school_war_exploded/patient/add" style="color: #efffe9">New patient</a>
        </button>
        </sec:authorize>
        <br>

        <table class="table table-striped table-bordered table-hover" style="margin-top: 20px;">
            <thead>
            <tr>
                <th colspan="3">List of patients</th>
            </tr>
            <tr>
                <th width="50%">Full name</th>
                <th width="25%">Birthdate</th>
                <th width="25%">Insurance</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${patients}" var="p">
                <tr>
                    <td>
                        <a href="http://localhost:8080/T_school_war_exploded/patient/${p.id}">${p.secondName} ${p.firstName} ${p.middleName}</a>
                    </td>
                    <td>${p.birthdate}</td>
                    <td>${p.insurance}</td>
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