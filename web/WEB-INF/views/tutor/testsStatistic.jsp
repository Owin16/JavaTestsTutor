<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 22.02.2018
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tutor Test Statistic</title>

    <link href="/css/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="/css/tableStyle.css" rel="stylesheet">
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Название теста</th>
        <th>Пройдено всего</th>
        <th>Правильно</th>
    </tr>
    </thead>
    <c:forEach items="${testStatistic}" var="test">
        <tr>
            <td>${test.getName()}</td>
            <td>${test.getCount()}</td>
            <td>${test.getCorrect()*100}%</td>
        </tr>
    </c:forEach>
</table>
<a class="btn btn-primary" href="/tutor/getStatistics">Назад</a>
</body>
</html>
