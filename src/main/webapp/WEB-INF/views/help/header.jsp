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
            <h4>Адрес клиники: г.Санкт-Петерубрг, наб.Обводного канала, д.9</h4>
            <h4>Телефон: 8-800-800-80-80</h4>
        </div>
        <div class="col-lg-3">
            <h4>ИМЯ ПОСЕТИТЕЛЯ</h4>
            <img src="${pageContext.request.contextPath}/assets/admin.jpg" width="140" height="88"  alt="admin.jpg">
            <button type="button" class="btn" style="padding-top: 20px">
                <a href="${pageContext.request.contextPath}/auth" class="menu-index">Войти</a>
            </button>
            <button type="button" class="btn" style="padding-top: 20px">
                <a href="${pageContext.request.contextPath}/logout" class="menu-index">Выйти</a>
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
