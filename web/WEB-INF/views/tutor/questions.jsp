<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 22.02.2018
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tutor Question</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="/css/questions.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div>
    Название вопроса:
    <input type="text" name="question" id="choose_question" list="question_list">
        <datalist id="question_list">
            <c:forEach items="${questionList}" var="question">
                <option itemid="${question.getId()}" id="${question.getDescription()}">${question.getDescription()}</option>
            </c:forEach>
        </datalist>
</div>

<ol id = "answers">
    <c:forEach items="${answerList}" var="answer">
        <li>${answer.getDescription()}</li>
    </c:forEach>
</ol>

<div id = "addAnswer">
    <a class="text-primary" onclick="addAnswer()">Добавить ответ</a>
</div>

<a class="btn btn-primary" href="/tutor/tutorMainPage">Назад</a>

<script>

    $("#choose_question").on("change keyup input", function (){
        getAnswers();
        changeAnswerField();
    });

    function getAnswers() {
        var choose_question = $("#choose_question").val();
        try {
            var question = document.getElementById(choose_question).getAttribute('itemId');

            $.ajax({
                type: "get",
                url: "/tutor/getQuestions/getAnswersByQuestionId",
                data: {question: question},
                contentType:
                    "application/json; charset=utf-8",
                success: function (data) {
                    var item = $('<ol id="answers"></ol>');
                    for (var i = 0; i < data.length; i++) {
                        item.append("<li>" + data[i].description + "</li>");
                    }
                    $("#answers").replaceWith(item);
                },
                error: function () {
                    var item = $('<ol id="answers"></ol>');
                    item.append("<option>" + "</option>");
                    $("#answers").replaceWith(item);
                }
            });
        } catch (e){
            var item = $('<ol id="answers"></ol>');
            item.append("<option>" + "</option>");
            $("#answers").replaceWith(item);
        }
    }

    function addAnswer() {
        questionName = ($("#choose_question").val());
        if (questionName != '') {
            var item = $('<div id="addAnswer"></div>');
            item.append('<input type="text" id="answer">');
            item.append('<a class="btn btn-success" onclick="saveAnswer()">Сохранить</a>');
            $("#addAnswer").replaceWith(item);
        }
        else
            alert("please select your question");
    }

    function saveAnswer() {
        try {
            var answer = $("#answer").val();
            var question = $("#choose_question").val();
            var questionId = document.getElementById(question).getAttribute('itemId');
        } catch (e) {
            questionId = -1;
        }
        if (answer != '' && question != '') {

            console.log(answer, question, questionId);

            $.ajax({
                type: "get",
                url: "/tutor/getQuestions/addAnswer",
                data: {answer: answer, question: question, questionId: questionId},
                contentType:
                    "application/json; charset=utf-8",
                success: function () {
                    alert(question + " was updated");
                    getAnswers();
                    changeAnswerField();
                },
                error: function () {

                }
            });
        }
    }
        
    function changeAnswerField() {
        var item = $('<div id="addAnswer"></div>');
        item.append('<a class="text-primary" onclick="addAnswer()">Добавить ответ</a>');
        $("#addAnswer").replaceWith(item);
    }
</script>
</body>
</html>
