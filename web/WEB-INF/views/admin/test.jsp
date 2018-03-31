<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topic</title>
</head>
<body>

<label for="choose_topic">Select Topic:</label>
<input type="text" name="topic" id="choose_topic" list="topic_list">
<datalist id="topic_list">
    <option value="0">- Select Topic -</option>
    <c:forEach items="${topicList}" var="topic">
        <option>${topic.getName()}</option>
    </c:forEach>
</datalist>

<label for="choose_test">Select Test:</label>
<input type="text" name="test" id="choose_test" list="test_list">
<datalist id="test_list">
    <option value="0">- Select Test -</option>
    <%--<c:forEach items="${listOfTests}" var="test">--%>
    <%--<option>${test.getName()}</option>--%>
    <%--</c:forEach>--%>
</datalist>

<p><input type="submit" value="Go"></p>

<form action="/example/">
    <button type="submit">Go</button>
</form>


</body>
</html>
