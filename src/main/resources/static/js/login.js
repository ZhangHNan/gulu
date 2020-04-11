function toggleLogin() {
    $("#uNamePWord").toggleClass("none-active");
    $("#sms").toggleClass("none-active");
}

function getSmsCode() {
    var phone = $("#smsPhone").val();
    if (!phone){
        alert("请输入手机号!");
        return;
    }
    $.ajax({
        type: "get",
        url: "/smsCodeLogin",
        data: {
            "phone": phone
        },
        success: function (json) {
            if(json.isok){
                alert(json.data)
            }else{
                alert(json.message)
            }
        },
        error: function (e) {
            console.log(e.responseText);
        }
    });
}
