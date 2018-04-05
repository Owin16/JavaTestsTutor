<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 04.04.2018
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>

    <link href="/css/bootstrap/bootstrap.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<form method="post" id = "question" action="/user/test/getAnswer">
    ${question.description}<br>

    <c:forEach items="${answerList}" var="answer">
        <input type="checkbox" name="answerId" value="${answer.getId()}">
            <label>${answer.getDescription()}</label>
        </input><br>
    </c:forEach>

        <button id="getTest" type="submit" class="btn btn-success">Ответить</button>

</form>

<script>

   // window.onbeforeunload = function() { return "С этой страницы назад не жалательно переходить."; };


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

</body>
</html>