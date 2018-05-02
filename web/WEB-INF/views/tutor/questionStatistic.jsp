<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <style>
        <%@include file='../../../resources/css/tableStyle.css' %>
    </style>


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
                <td><fmt:formatNumber value="${question.getCorrect()*100}" maxFractionDigits="2"/>%</td>
            </tr>
        </c:forEach>
</table>
<a class="btn btn-primary" href="/JavaTests/tutor/getStatistics">Назад</a>
</body>
</html>
