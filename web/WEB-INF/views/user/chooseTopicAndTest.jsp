<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TopicAndTest</title>
    <%--<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
</head>
<body>
<%--<form>--%>
<%--<p><select size="1">--%>
<%--<c:forEach items="${listOfTopics}" var="topic">--%>
<%--<option value ="topic.getName">${topic.getName()}</option>--%>
<%--</c:forEach>--%>
<%--</select></p>--%>
<%--</form>--%>
<%--<form>--%>
<%--<p><select size="1">--%>
<%--<c:forEach items="${listOfTests}" var="test">--%>
<%--<option value ="test.getName">${test.getName()}</option>--%>
<%--</c:forEach>--%>
<%--</select></p>--%>
<%--</form>--%>

<label for="choose_topic">Выбирите тему:</label>
<input type="text" name="topic" id="choose_topic" list="topic_list">
<datalist id="topic_list">
    <option value="0">- выберите тему -</option>
    <c:forEach items="${listOfTopics}" var="topic">
        <option>${topic.getName()}</option>
    </c:forEach>
</datalist>

<label for="choose_test">Выбирите тест:</label>
<input type="text" name="test" id="choose_test" list="test_list">
<datalist id="test_list">
    <option value="0">- выберите тест -</option>
    <%--<c:forEach items="${listOfTests}" var="test">--%>
    <%--<option>${test.getName()}</option>--%>
    <%--</c:forEach>--%>
</datalist>

<p><input type="submit" value="Пройти тестирование"></p>

<form action="/example/">
    <button type="submit">Пройти тестирование</button>
</form>

<%--<script>--%>
<%--$(document).ready(function () {--%>
<%--$('#topic_list').change(function () {--%>
<%--var topic_id = $(this).val();--%>
<%--if (topic_list == '0') {--%>
<%--$('#test_list').html('<option>- выберите тест -</option>');--%>
<%--$('#test_list').attr('disabled', true);--%>
<%--return(false);--%>
<%--}--%>
<%--$('#test_list').attr('disabled', true);--%>
<%--$('#test_list').html('<option>загрузка...</option>');--%>
<%--var url = '/test/getTestsFromTopic';--%>
<%--$.get(--%>
<%--url,--%>
<%--"topic_id=" + topic_id,--%>
<%--function (result) {--%>
<%--if (result.type == 'error') {--%>
<%--alert('error');--%>
<%--return(false);--%>
<%--}--%>
<%--else {--%>
<%--var options = '';--%>
<%--$(result.regions).each(function() {--%>
<%--options += '<option value="' + $(this).attr('id') + '">' + $(this).attr('title') + '</option>';--%>
<%--});--%>
<%--$('#test_list').html(options);--%>
<%--$('#test_list').attr('disabled', false);--%>
<%--}--%>
<%--},--%>
<%--"json"--%>
<%--);--%>
<%--});--%>
<%--});--%>
<%--</script>--%>
</body>
</html>
