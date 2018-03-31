<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 06.02.2018
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>

    <link href="/css/bootstrap/bootstrap.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="/js/testsLogic.js"></script>
</head>
<body>
<div>
    Название темы:
    <input type="text" name="topic" id="choose_topic" list="topic_list">
        <datalist id="topic_list">
            <c:forEach items="${topicList}" var="topic">
                <option>${topic.getName()}</option>
            </c:forEach>
        </datalist>
</div>
<div>
    Название теста:
    <input type="text" name="test" id="choose_test" list="test_list">
    <datalist id="test_list">
        <c:forEach items="${testList}" var="test">
            <option>${test.getName()}</option>>
        </c:forEach>
    </datalist>
</div>
<a class="btn btn-success" id="save">Сохранить</a>
<a class="btn btn-primary" href="/tutor/tutorMainPage">Назад</a>


<script>

    $("#choose_topic").on("change keyup input", function(){
        var topic = $(this).val();
        $("#choose_test").val('');

        $.ajax({
            type: "get",
            url: "/tutor/getTopics/getTestsByTopicId",
            data: {topic: topic},
            contentType:
                "application/json; charset=utf-8",
            success: function (data) {
                var item = $('<datalist id="test_list"></datalist>');
                for(var i=0; i<data.length; i++) {
                    item.append("<option>" + data[i].name +"</option>");
                }
                $("#test_list").replaceWith(item);
            },
            error: function () {
                var item = $('<datalist id="test_list"></datalist>');
                item.append("<option>" + "</option>");
                $("#test_list").replaceWith(item);
            }
        });
    });

    $("#save").on('click', function () {
        topicName = ($("#choose_topic").val());
        testName = ($("#choose_test").val());
        if (topicName != '' && testName != ''){
            $.ajax({
                type: "get",
                url: "/tutor/getTopics/addTopic",
                data: {topic: topicName, test: testName},
                contentType:
                    "application/json; charset=utf-8",
                success: function (data) {
                    alert(topicName + " was saved");
                    $("#choose_test").val('');
                    $("#choose_topic").val('');
                    $("#choose_topic").html(data);
                },
                error: function () {
                    alert(topicName + " was NOT saved");
                }
            });
        }
    });

</script>
</body>
</html>
