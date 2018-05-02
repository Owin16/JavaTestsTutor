<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 04.04.2018
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose test</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<form id = "chooseTestName" action="/JavaTests/user/test/getQuestions">
    Название теста:
    <input type="text" name="test" id="choose_test" list="test_list">
    <datalist id="test_list">
        <c:forEach items="${testList}" var="test">
            <option>${test.getName()}</option>
        </c:forEach>
    </datalist>
    <button id="getTest" type="submit" class="btn btn-success">Пройти тест</button>
</form>

<a class="btn btn-primary" href="/JavaTests/user/test/mainPage">Назад</a>


</body>

<script>

    $("#getTest").on('click', function () {
        testName = ($("#choose_test").val());
            $.ajax({
                type: "get",
                url: "/JavaTests/user/test/checkTest",
                data: {test: testName},
                contentType:
                    "application/json; charset=utf-8",
                success: function (check) {
                    if (check) {
                    } else alert("please choose test");
                }
            });
    });

</script>

</html>
