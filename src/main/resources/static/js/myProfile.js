function bindingEmail() {
    var email = prompt("请输入要绑定的email");
    if (email) {
        $.ajax({
            type:"POST",
            url:"/bindingEmail",
            contentType:"application/json",
            data:JSON.stringify({
                "email": email
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