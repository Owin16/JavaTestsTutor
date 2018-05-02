<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 05.04.2018
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result Test</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link href="/css/resultTest.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <h3> Вы прошли тест на ${resultTest*100}% </h3>

</head>
<body>

<table class="table table-striped">
    <thead>
    <tr>
        <th>Название вороса</th>
        <th>Правильно</th>
    </tr>
    </thead>
    <c:forEach items="${resultStatistic}" var="statistic">
        <tr>
            <td>${statistic.getQuestion().getDescription()}</td>
            <td>${statistic.isCorrect()}</td>
        </tr>
    </c:forEach>
</table>



<a class="btn btn-primary" href="/JavaTests/user/test/getTests">Пройти еще тест</a>

</body>

<script>

    window.onload = function () {
        if (typeof history.pushState === "function") {
            history.pushState("jibberish", null, null);
            window.onpopstate = function () {
                history.pushState('newjibberish', null, null);
                // Handle the back (or forward) buttons here
                // Will NOT handle refresh, use onbeforeunload for this.
            };
        }
        else {
            var ignoreHashChange = true;
            window.onhashchange = function () {
                if (!ignoreHashChange) {
                    ignoreHashChange = true;
                    window.location.hash = Math.random();
                    // Detect and redirect change here
                    // Works in older FF and IE9
                    // * it does mess with your hash symbol (anchor?) pound sign
                    // delimiter on the end of the URL
                }
                else {
                    ignoreHashChange = false;
                }
            };
        }
    }

</script>

</html>
