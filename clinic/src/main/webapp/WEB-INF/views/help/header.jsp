<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="header">
    <div class="row-logo">
        <div class="col-lg-1">
            <a href="${pageContext.request.contextPath}/src/main/webapp">
                <img src="${pageContext.request.contextPath}/src/main/webapp/assets/logo-mini.jpg" width="200" height="160"
                     alt="logo-mini.jpg">
            </a>
        </div>
        <div class="col-lg-2">
            <h2>CLINIC</h2>
            <h4>Адрес клиники: г.Санкт-Петерубрг, наб.Обводного канала, д.9</h4>
            <h4>Телефон: 8-800-800-80-80</h4>
        </div>
        <div class="col-lg-3">
            <h4>
                <sec:authorize access="isAuthenticated()">
                    <sec:authentication property="name"/>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    ГОСТЬ
                </sec:authorize>
            </h4>
            <sec:authorize access="!isAuthenticated()">
                <img src="${pageContext.request.contextPath}/src/main/webapp/assets/logo-mini.jpg" width="120" height="88" alt="logo-mini.jpg">
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <img src="${pageContext.request.contextPath}/src/main/webapp/assets/admin.jpg" width="120" height="88" alt="admin.jpg">
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_DOCTOR')">
                <img src="${pageContext.request.contextPath}/src/main/webapp/assets/doctor.jpg" width="120" height="88" alt="doctor.jpg">
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_NURSE')">
                <img src="${pageContext.request.contextPath}/src/main/webapp/assets/nurse.jpg" width="120" height="88" alt="nurse.jpg">
            </sec:authorize>
            <button type="button" class="btn" style="margin-top: 1px">

                    <sec:authorize access="!isAuthenticated()">
                        <a href="${pageContext.request.contextPath}/login" class="menu-index">
                            Вход</a>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <a href="${pageContext.request.contextPath}/logout" class="menu-index">
                            Выход</a>
                    </sec:authorize>
            </button>
        </div>
    </div>
</header>
