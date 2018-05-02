<%--
  Created by IntelliJ IDEA.
  User: O'win
  Date: 04.04.2018
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>admin user's role</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<div id = "users">
    Выберите логин пользвателя:
    <input type="text" name="user" id="choose_user" list="user_list">
    <datalist id="user_list">
        <c:forEach items="${userList}" var="user">
            <option>${user.getLogin()}</option>
        </c:forEach>
    </datalist>
</div>

<a class="btn btn-success" id="saveAsTutor">Сделать учителем</a>
<a class="btn btn-primary" href="/JavaTests/admin/users/adminHome">Назад</a>

<script>

    $("#saveAsTutor").on('click', function () {
        var userLogin = ($("#choose_user").val());

        $.ajax({
            type: "get",
            url: "/JavaTests/admin/users/checkUser",
            data: {userLogin: userLogin},
            contentType:
                "application/json; charset=utf-8",
            success: function (data) {
                if (data) {
                    $.ajax({
                        type: "get",
                        url: "/JavaTests/admin/users/saveAsTutor",
                        data: {userLogin: userLogin},
                        contentType:
                            "application/json; charset=utf-8",
                        success: function () {
                            alert(userLogin + " was saved as Tutor");
                            $("#choose_user").val('');
                            updateUsers();
                        }
                    });
                }
                else {
                    alert("choose user");
                }
            }
        });
    });

    function updateUsers() {
        $.ajax({
            type: "get",
            url: "/JavaTests/admin/users/getUsersRest",
            contentType:
                "application/json; charset=utf-8",
            success: function (data) {
                var item = $('<datalist id="user_list"></datalist>');
                for(var i=0; i<data.length; i++) {
                    item.append("<option>" + data[i].login + "</option>");
                }
                $("#user_list").replaceWith(item);
            }
        });
    }

</script>

</body>
</html>
