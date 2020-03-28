function bindingPhone() {
    var phone = prompt("请输入要绑定的手机号");
    if (phone) {
        $.ajax({
            type:"POST",
            url:"/bindingPhone",
            contentType:"application/json",
            data:JSON.stringify({
                "data": phone
            }),
            success:function (response) {
                if(response.code == 200){
                    window.location.reload();
                }else{
                    alert(response.message);
                }
            },
            dataType:"json"
        })
    }
}

function bindingEmail() {
    var email = prompt("请输入要绑定的email");
    if (email) {
        $.ajax({
            type:"POST",
            url:"/bindingEmail",
            contentType:"application/json",
            data:JSON.stringify({
                "data": email
            }),
            success:function (response) {
                if(response.code == 200){
                    window.location.reload();
                }else{
                    alert(response.message);
                }
            },
            dataType:"json"
        })
    }
}

function bindingPassword(){
    var password = prompt("请设置你的新密码");
    if (password) {
        $.ajax({
            type:"POST",
            url:"/bindingPassword",
            contentType:"application/json",
            data:JSON.stringify({
                "data": password
            }),
            success:function (response) {
                if(response.code == 200){
                    window.location.reload();
                }else{
                    alert(response.message);
                }
            },
            dataType:"json"
        })
    }
}

function updateBio() {
    var oldBio = $("#old-bio").text();
    $("#bioText").text(oldBio);
    $("#bioArea").toggleClass("none");
    $("#old-bio").toggleClass("none");
}