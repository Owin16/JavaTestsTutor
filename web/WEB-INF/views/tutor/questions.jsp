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

    <style>
        <%@include file='../../../resources/css/questions.css' %>
        <%@include file='../../../resources/css/checkbox.css' %>
    </style>

    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div id = "chooseTestName">
    Выберете тест:
    <input type="text" name="test" id="choose_test" list="test_list">
    <datalist id="test_list">
        <c:forEach items="${testList}" var="test">
            <option>${test.getName()}</option>
        </c:forEach>
    </datalist>
</div>

<div id = "chooseQuestionName" style="display:none;">
    Выберете существующий или введите новый вопрос:
    <input pattern="[a-zA-Z0-9]{,100}" type="text" name="question" id="choose_question" list="question_list">
        <button id = "deleteQuestion" class="btn btn-danger" onclick="deleteQuestion()" style="display: none">Удалить Вопрос</button>
        <datalist id="question_list">
            <c:forEach items="${questionList}" var="question">
                <option>${question.getDescription()}</option>
            </c:forEach>
        </datalist>

<ol id = "answers">
    <c:forEach items="${answerList}" var="answer">
        <li>${answer.getDescription()}</li>
    </c:forEach>
</ol>

<div id = "addAnswer" >
    <a class="text-primary" onclick="addAnswerButton()">Добавить ответ</a>
</div>
</div>

<a class="btn btn-primary" href="/JavaTests/tutor/tutorMainPage">Назад</a>

<script>

    $("#choose_test").on("change keyup input", function(){
        getQuestions();
    });

    $("#choose_question").on("change keyup input", function (){
        checkQuestion();
        getAnswers();
        changeAnswerField();
    });

    function getQuestions() {
        checkQuestion();
        var test = $("#choose_test").val();

        $.ajax({
            type: "get",
            url: "/JavaTests/tutor/getQuestions/checkTest",
            data: {test: test},
            contentType:
                "application/json; charset=utf-8",
            success: function (check) {
                if (check) {
                    document.getElementById("chooseQuestionName").style.display = "block";
                } else document.getElementById("chooseQuestionName").style.display = "none";

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
            }
        });
    }

    function getAnswers() {
        var question = $("#choose_question").val();
        try {
            $.ajax({
                type: "get",
                url: "/JavaTests/tutor/getQuestions/getAnswersByQuestion",
                data: {question: question},
                contentType:
                    "application/json; charset=utf-8",
                success: function (data) {
                    var item = $('<ol id="answers"></ol>');
                    for (var i = 0; i < data.length; i++) {
                        item.append("<li>" + data[i].description + "<u class='alert-link' onclick=" + 'deleteAnswer(' + data[i].id + ')' + "> delete </u></li>");
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

    function addAnswerButton() {
        questionName = ($("#choose_question").val());
        if (questionName != '') {
            var item = $('<div id="addAnswer"></div>');
            item.append('<input type="text" id="answer">');
            item.append('<a class="btn btn-success" onclick="saveAnswer()">Сохранить</a>');
            item.append('<div><input type="checkbox" id="correct" /><label for="c1"><span></span> correct? </label></div>');
            $("#addAnswer").replaceWith(item);
        }
        else
            alert("please select your question");
    }

    function checkQuestion() {
        var question = $("#choose_question").val();
        $.ajax({
            type: "get",
            url: "/JavaTests/tutor/getQuestions/checkQuestion",
            data: {question: question},
            contentType:
                "application/json; charset=utf-8",
            success: function (check) {
                if (check) {
                    document.getElementById("deleteQuestion").style.display = "block";
                } else document.getElementById("deleteQuestion").style.display = "none";
            }
        });
    }

    function saveAnswer() {
        try {
            var answer = $("#answer").val();
            var question = $("#choose_question").val();
            var test = $("#choose_test").val();
            var correct = $('#correct').is(':checked');
        } catch (e) {
        }
        if (answer != '' && question != '') {
            $.ajax({
                type: "get",
                url: "/JavaTests/tutor/getQuestions/addAnswer",
                data: {answer: answer, question: question, correct: correct, test: test},
                contentType:
                    "application/json; charset=utf-8",
                success: function () {
                    alert(question + " was updated");
                    getQuestions();
                    getAnswers();
                    changeAnswerField();
                },
                error: function () {

                }
            });
        }
    }

    function deleteQuestion() {
        var question = $("#choose_question").val();
        $.ajax({
            type: "get",
            url: "/JavaTests/tutor/getQuestions/deleteQuestion",
            data: {question: question},
            contentType:
                "application/json; charset=utf-8",
            success: function () {
                getQuestions();
                $("#choose_question").val('');
                getAnswers();
                alert("question " + question + " was deleted")
            }
        });
    }

    function deleteAnswer(answerId) {
        $.ajax({
            type: "get",
            url: "/JavaTests/tutor/getQuestions/deleteAnswer",
            data: {answer: answerId},
            contentType:
                "application/json; charset=utf-8",
            success: function () {
                getAnswers();
            }
        });
    }
        
    function changeAnswerField() {
        var item = $('<div id="addAnswer"></div>');
        item.append('<a class="text-primary" onclick="addAnswerButton()">Добавить ответ</a>');
        $("#addAnswer").replaceWith(item);
    }
</script>
</body>
</html>
