//关注功能
function toWatch(e) {
    var watchId = e.getAttribute("data-id");
    if (watchId) {
        $.ajax({
            type:"POST",
            url:"/watch",
            contentType:"application/json",
            data:JSON.stringify({
                "data": watchId
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