<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 22.02.2018
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Tutor User Statistic</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <style>
        <%@include file='../../../resources/css/tableStyle.css' %>
    </style>

</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Ф.И.О.</th>
        <th>Пройдено всего</th>
        <th>Правильно</th>
    </tr>
    </thead>
    <c:forEach items="${userStatistic}" var="user">
        <tr>
            <td>${user.getFirstName()} ${user.getLastName()}</td>
            <td>${user.getCount()}</td>
            <td><fmt:formatNumber value="${user.getCorrect()*100}" maxFractionDigits="2"/>%</td>
        </tr>
    </c:forEach>
</table>
<a class="btn btn-primary" href="/JavaTests/tutor/getStatistics">Назад</a>
</body>
</html>
