<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 22.02.2018
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tutor Main Page</title>

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

<li><a class="text-primary" href="/tutor/getTopics">Редактировать тему/тест</a></li>
<li><a class="text-primary" href="/tutor/getQuestions">Редактировать вопросы/ответы</a></li>
<li><a class="text-primary" href="/tutor/getStatistics">Статистика</a></li>
</body>
</html>
