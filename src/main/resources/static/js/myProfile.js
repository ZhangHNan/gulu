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

function toVIP(){
    var vipPassword = prompt("请输入会员密码");
    if (vipPassword) {
        $.ajax({
            type:"POST",
            url:"/vip",
            contentType:"application/json",
            data:JSON.stringify({
                "data": vipPassword
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
function fileUpload(){
    debugger;
    var fileName = $("#upfile").val();
    if(fileName == null || fileName==""){
        alert("请选择文件");
    }else{
        var fileType = fileName.substr(fileName.length-4,fileName.length);
        if(1){
            // fileType == ".png" || fileType == "png"||fileType == ".jpg"||fileType == "jpg"
            var formData = new FormData();
            formData.append("file",$("#upfile").prop("files")[0]);
            $.ajax({
                type:"post",
                url:"/updateAvatar",
                data:formData,
                cache:false,
                processData:false,
                contentType:false,
                dataType:"json",
                success:function(data){
                    if(null != data){
                        if(data.code == 200){
                            if(confirm("更新成功！")){
                                window.location.reload();
                            }
                        }else{
                            alert("更新失败！");
                        }
                    }
                },
                error:function(){
                    alert("更新失败！");
                }
            });
        }else{
            alert("上传文件类型错误！");
        }
    }
}
