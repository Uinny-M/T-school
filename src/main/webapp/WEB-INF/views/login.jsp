<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="help/header.jsp" %>
<%@ include file="help/footer.jsp" %>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Авторизация</title>
 </head>
 <body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<jsp:include page="help/header.jsp"></jsp:include>

<div class="container">
<%-- <c:if test="${not empty errormessage}">--%>
  <h2>${errormessage}</h2>
<%-- </c:if>--%>

 <div class="row">

 <div class="col-md-offset-3 col-md-6">
 <form class="form-horizontal">
 <span class="heading">АВТОРИЗАЦИЯ</span>
 <div class="form-group">
 <input type="username" class="form-control" id="username" placeholder="Username">
 <i class="fa fa-user"></i>
 </div>
 <div class="form-group help">
 <input type="password" class="form-control" id="password" placeholder="Password">
 <i class="fa fa-lock"></i>
 <a href="#" class="fa fa-question-circle"></a>
 </div>
 <div class="form-group">
 <div class="main-checkbox">
 <input type="checkbox" value="none" id="checkbox1" name="check"/>
 <label for="checkbox1"></label>
 </div>
 <span class="text">Запомнить</span>
 <button type="submit" class="btn btn-default">ВХОД</button>
 </div>
 </form>
 </div>

 </div><!-- /.row -->
</div><!-- /.container -->

<jsp:include page="help/footer.jsp"></jsp:include>
 </body>
</html>

<style>
 /* Demo Background */
 /*body{background:url(/images/bg/bg-6.png)}*/

 /* Form Style */
 .container {
  margin-top: 220px;
 }

 .form-horizontal{
  background: #fcfff6;
  padding-bottom: 40px;
  border: 3px solid #28a347;
  border-radius: 15px;
  text-align: center;
 }
 .form-horizontal .heading{
  display: block;
  font-size: 35px;
  font-weight: 700;
  padding: 35px 0;
  border-bottom: 1px solid #28a347;
  margin-bottom: 30px;
  color: #28a347;
 }
 .form-horizontal .form-group{
  padding: 0 40px;
  margin: 0 0 25px 0;
  position: relative;
 }
 .form-horizontal .form-control{
  background: #f9e9ff;
  border: none;
  border-radius: 20px;
  box-shadow: none;
  padding: 0 20px 0 45px;
  height: 40px;
  transition: all 0.3s ease 0s;
 }
 .form-horizontal .form-control:focus{
  background: #efffe9;
  box-shadow: none;
  outline: 0 none;
  color: #28a347;
 }
 .form-horizontal .form-group i{
  position: absolute;
  top: 12px;
  left: 60px;
  font-size: 17px;
  color: #28a347;
  transition : all 0.5s ease 0s;
 }
 .form-horizontal .form-control:focus + i{
  color: #00b4ef;
 }
 .form-horizontal .fa-question-circle{
  display: inline-block;
  position: absolute;
  top: 12px;
  right: 60px;
  font-size: 20px;
  color: #28a347;
  transition: all 0.5s ease 0s;
 }
 .form-horizontal .fa-question-circle:hover{
  color: #000;
 }
 .form-horizontal .main-checkbox{
  float: left;
  width: 20px;
  height: 20px;
  background: #28a347;
  border-radius: 50%;
  position: relative;
  margin: 5px 0 0 5px;
  border: 1px solid #11a3fc;
 }
 .form-horizontal .main-checkbox label{
  width: 20px;
  height: 20px;
  position: absolute;
  top: 0;
  left: 0;
  cursor: pointer;
 }
 .form-horizontal .main-checkbox label:after{
  content: "";
  width: 10px;
  height: 5px;
  position: absolute;
  top: 5px;
  left: 4px;
  border: 3px solid #fff;
  border-top: none;
  border-right: none;
  background: transparent;
  opacity: 0;
  -webkit-transform: rotate(-45deg);
  transform: rotate(-45deg);
 }
 .form-horizontal .main-checkbox input[type=checkbox]{
  visibility: hidden;
 }
 .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after{
  opacity: 1;
 }
 .form-horizontal .text{
  float: left;
  margin-left: 7px;
  line-height: 20px;
  padding-top: 5px;
  text-transform: capitalize;
 }
 .form-horizontal .btn{
  float: right;
  font-size: 14px;
  color: #fff;
  background: #28a347;
  border-radius: 30px;
  padding: 10px 25px;
  border: none;
  text-transform: capitalize;
  transition: all 0.5s ease 0s;
 }
 @media only screen and (max-width: 479px){
  .form-horizontal .form-group{
   padding: 0 25px;
  }
  .form-horizontal .form-group i{
   left: 45px;
  }
  .form-horizontal .btn{
   padding: 10px 20px;
  }
 }
</style>