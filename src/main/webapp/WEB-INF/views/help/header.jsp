<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="header">
    <div class="row-logo">
        <div class="col-lg-1">
            <a href="${pageContext.request.contextPath}/">
                <img src="${pageContext.request.contextPath}/assets/logo-mini.jpg" width="200" height="160"
                     alt="logo-mini.jpg">
            </a>
        </div>
        <div class="col-lg-2">
            <h2>CLINIC</h2>
            <h4>Clinic address: St. Petersburg, Shepetovskaya st., 14A</h4>
            <h4>Phone: 8-800-800-80-80</h4>
        </div>
        <div class="col-lg-3">
            <h4>
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication property="name"/>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    Guest
                </sec:authorize>
            </h4>
            <sec:authorize access="!isAuthenticated()">
                <img src="${pageContext.request.contextPath}/assets/logo-mini.jpg" width="120" height="88"  alt="logo-mini.jpg">
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <img src="${pageContext.request.contextPath}/assets/admin.jpg" width="120" height="88"  alt="admin.jpg">
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_DOCTOR')">
                <img src="${pageContext.request.contextPath}/assets/doctor.jpg" width="120" height="88"  alt="doctor.jpg">
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_NURSE')">
                <img src="${pageContext.request.contextPath}/assets/nurse.jpg" width="120" height="88"  alt="nurse.jpg">
            </sec:authorize>
            <button type="button" class="btn" style="margin-top: 1px; color: #efffe9">

                    <sec:authorize access="!isAuthenticated()">
                        <a href="${pageContext.request.contextPath}/login" class="menu-index" style="color: #efffe9">
                            Login</a>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <a href="${pageContext.request.contextPath}/logout" class="menu-index" style="color: #efffe9">
                            Logout</a>
                    </sec:authorize>

            </button>

        </div>

    </div>
</header>


<style>
    .header {
        position: absolute;
        top: 0;
        width: 100%;
        height: 165px;
        line-height: 25px;
        background-color: #efffe9;
        border-bottom: 3px solid #28a347;
    }

    .row-logo {
        display: flex;
        flex: 1;
        height: 16.5rem;
        line-height: 50px;
        color: #28a347;
    }

    .col-lg-1 {
        min-width: 200px;
        max-width: 200px;
    }

    .col-lg-2 {
        text-align: center;
        height: 16.5rem;
        flex: 1;
        min-width: 300px;
        overflow: hidden;
    }

    .col-lg-3 {
        text-align: center;
        min-width: 200px;
        max-width: 200px;
    }

    .col-lg-3 .btn {
        font-size: 14px;
        color: #fff;
        background: #28a347;
        border-radius: 30px;
        border: none;
        text-transform: capitalize;
        transition: all 0.5s ease 0s;
        margin-top: -30px;
    }
</style>
