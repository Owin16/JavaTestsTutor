<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

    <link href="/css/bootstrap/bootstrap.css" rel="stylesheet">

</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h5>Welcome ${pageContext.request.userPrincipal.name} | <button onclick="document.forms['logoutForm'].submit()">Logout</button>
        </h5>

    </c:if>


</div>

<li><a class="text-primary" href="/user/test/getTests">Выбрать тест</a></li>

</body>
</html>
