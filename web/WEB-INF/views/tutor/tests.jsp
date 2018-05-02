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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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
<div id = "chooseTestName" style="display:none;">
    Название теста:
    <input type="text" name="test" id="choose_test" list="test_list">
    <datalist id="test_list">
        <c:forEach items="${testList}" var="test">
            <option>${test.getName()}</option>
        </c:forEach>
    </datalist>
</div>
<div id = "chooseQuestionName" style="display:none;">
    Название вопроса:
    <input type="text" name="question" id="choose_question" list="question_list">
    <datalist id="question_list">
        <c:forEach items="${questionList}" var="question">
            <option>${question.getDescription()}</option>>
        </c:forEach>
    </datalist>
</div>
<a class="btn btn-success" id="save">Сохранить</a>
<a class="btn btn-primary" href="/JavaTests/tutor/tutorMainPage">Назад</a>


<script>

    $("#choose_topic").on("change keyup input", function(){
       // checkSymbols("choose_topic");
        var topic = $(this).val();
        if (topic != '') {
            document.getElementById("chooseTestName").style.display = "block";
        }else document.getElementById("chooseTestName").style.display = "none";

        $("#choose_test").val('');


        $.ajax({
            type: "get",
            url: "/JavaTests/tutor/getTopics/getTestsByTopicId",
            data: {topic: topic},
            contentType:
                "application/json; charset=utf-8",
            success: function (data) {
                var item = $('<datalist id="test_list"></datalist>');
                for(var i=0; i<data.length; i++) {
                    item.append("<option>" + data[i].name + "</option>");
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

    $("#choose_test").on("change keyup input", function(){
        var test = $(this).val();

        if (test != '') {
            document.getElementById("chooseQuestionName").style.display = "block";
        }else document.getElementById("chooseQuestionName").style.display = "none";
        try {
            $("#choose_question").val('');
            $.ajax({
                type: "get",
                url: "/JavaTests/tutor/getTopics/getQuestionsByTestId",
                data: {test: test},
                contentType:
                    "application/json; charset=utf-8",
                success: function (data) {
                    var item = $('<datalist id="question_list"></datalist>');
                    for (var i = 0; i < data.length; i++) {
                        item.append("<option>" + data[i].description + "</option>");
                    }
                    $("#question_list").replaceWith(item);
                },
                error: function () {
                    var item = $('<datalist id="question_list"></datalist>');
                    item.append("<option>" + "</option>");
                    $("#question_list").replaceWith(item);
                }
            });
        }catch (e){
        }
    });

    $("#save").on('click', function () {
        topicName = ($("#choose_topic").val());
        testName = ($("#choose_test").val());
        questionName = ($("#choose_question").val());
        if (topicName != '' && testName != '' && questionName != ''){
            $.ajax({
                type: "get",
                url: "/JavaTests/tutor/getTopics/addTopic",
                data: {topic: topicName, test: testName, question: questionName},
                contentType:
                    "application/json; charset=utf-8",
                success: function (data) {
                    alert(topicName + " was saved");
                    $("#choose_topic").val('');
                    document.getElementById("chooseQuestionName").style.display = "none";
                    document.getElementById("chooseTestName").style.display = "none";
                },
                error: function () {
                    alert(topicName + " was NOT saved");
                }
            });
        }
    });

/*    function checkSymbols(id){
        if (/^[a-zA-Z0-9]{,255}*$/.test(id.value)) {<!-- "На лету" создаем объект класса RegExp -->
            alert("Правильно");
        }
        else {
            alert("Не правильно");
        }
    }*/

</script>
</body>
</html>
