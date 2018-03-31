<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 22.02.2018
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tutor Statistics</title>

    <link href="/css/bootstrap/bootstrap.css" rel="stylesheet">
</head>
<body>
<li><a href="/tutor/getStatistics/getTestStatistic">Статистика по тесту</a></li>
<li><a href="/tutor/getStatistics/getQuestionStatistic">Статистика по вопросам</a></li>
<li><a href="/tutor/getStatistics/getUserStatistic">Статистика пользователей</a></li>
<a class="btn btn-primary" href="/tutor/tutorMainPage">Назад</a>
</body>
</html>
