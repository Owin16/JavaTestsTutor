$("#choose_topic").on("change keyup input", function(){
    var topic = $(this).val();
    $("#choose_test").val('');

    $.ajax({
        type: "get",
        url: "/getTestsById",
        data: {topic: topic},
        contentType:
            "application/json; charset=utf-8",
        success: function (data) {
            $("#choose_test").html(data);
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
            url: "/addTopic",
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