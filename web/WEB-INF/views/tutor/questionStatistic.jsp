<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 15.02.2018
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tutor Question tatistic</title>

    <link href="/css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="/css/tableStyle.css" rel="stylesheet">


</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Название вопроса</th>
        <th>Пройдено всего</th>
        <th>Правильно</th>
    </tr>
    </thead>
        <c:forEach items="${questionStatistic}" var="question">
            <tr>
                <td>${question.getDescription()}</td>
                <td>${question.getCount()}</td>
                <td>${question.getCorrect()*100}%</td>
            </tr>
        </c:forEach>
</table>
<a class="btn btn-primary" href="/tutor/getStatistics">Назад</a>
</body>
</html>
