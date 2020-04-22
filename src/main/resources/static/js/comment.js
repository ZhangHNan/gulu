//提交帖子的回复（评论）
function post(){
    var questionId = $("#questionId").val();
    var commentContent = $("#commentContent").val();
    comment2target(questionId,1,commentContent)
}

function secondPost(e){
    var id = e.getAttribute("data-id");
    var contentId = "#input-"+id;
    var content = $(contentId).val();
    console.log(id);
    console.log(content);
    comment2target(id,2,content);
}

//评论功能
function comment2target(targetId, type, content){
    if (!content) {
        alert("评论不能为空！！！");
        return;
    }
    $.ajax({
        type:"POST",
        url:"/comment",
        contentType:"application/json",
        data:JSON.stringify({
            "targetId": targetId,
            "content": content,
            "type": type
        }),
        success:function (response) {
            if(response.code == 200){
                //刷新页面
                window.location.reload();
            }else{
                if(response.code == 3005){
                    var isAccepted = confirm(response.message);
                    if(isAccepted){
                        $(location).attr('href', 'http://localhost:8887/login');
                        // window.open("http://localhost:8887/login");
                        // window.localStorage.setItem("closable","true");//设置closable，当登录成功跳转到首页时判断，如果有closable等于true则删除closable并关闭浏览器
                    }
                }else{
                    alert(response.message);
                }
            }
        },
        dataType:"json"
    })
}


//展开二级评论
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);
    //获取一下二级评论的展开状态
    var collapse = e.getAttribute("data-collapse", "in");
    if (collapse) {
        //折叠二级评论
        comments.removeClass("in");
        //
        e.removeAttribute("data-collapse", "in");
        e.classList.remove("active");
    } else {
        var subCommentContainer = $("#comment-" + id);
        if (subCommentContainer.children().length != 1) {
            //已经加载过了，直接展开即可
            //展开二级评论
            comments.addClass("in");
            //标记二级评论展开状态
            e.setAttribute("data-collapse", "in");
            e.classList.add("active");
        } else {
            $.getJSON("/comment/" + id, function (data) {
                $.each(data.data.reverse(), function (index, comment) {
                    var praiseClass ="";
                    var treadClass = "";
                    if (comment.praiseStatus == 1) {
                        praiseClass = "like-active";
                    }
                    if (comment.treadStatus == 1){
                        treadClass = "tread-active";
                    }
                    var a = "<div class=\"media\">\n" +
                        "                                <div class=\"media-left\">\n" +
                        "                                    <img class=\"media-object img-rounded img-comments\" src=\"" + comment.user.avatarUrl + "\"\n" +
                        "                                         src=\"../static/img/9150e4e5gy1gab4a9xjurj205h04wdfr.jpg\">\n" +
                        "                                </div>\n" +
                        "                                <div class=\"comments media-body\">\n" +
                        "                                    <span class=\"comment-commentator\">" + comment.user.name + "</span>\n" +
                        "                                    <div>\n" +
                        "                                        " + comment.content + "\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"comment-menu\">\n" +"" +
                        "                                        <span class=\"glyphicon glyphicon-thumbs-up comments-like icon "+praiseClass+"\"\n" +
                        "                                              data-id=\""+comment.id+"\"\n" +
                        "                                              id=\"comPraise-"+comment.id+"\" onclick=\"commentPraise(this)\"></span>\n" +
                        "                                        <span class=\"ICount\" id=\"comPraCount-"+comment.id+"\">"+comment.praiseCount+"</span>\n" +
                        "\n" +
                        "                                        <span class=\"glyphicon glyphicon-thumbs-down comments-like icon "+treadClass+"\"\n" +
                        "                                              data-id=\""+comment.id+"\"\n" +
                        "                                              id=\"comTread-"+comment.id+"\" onclick=\"commentTread(this)\"></span>\n" +
                        "                                        <span  class=\"ICount\" id=\"comTreCount-"+comment.id+"\">"+comment.treadCount+"</span>"+"" +
                        "                                        <span class=\"btn-report icon\" data-toggle=\"modal\" data-target=\"#commentModal-"+comment.id+"\">\n" +
                        "                                            举报\n" +
                        "                                        </span>"+
                        "                                        <span class=\"pull-right comments-data\">" + moment(comment.gmtCreate).format('YYYY-M-D HH:mm') + "</span>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                                <hr class=\"comments-hr\">\n" +
                        "                            </div>"+
                        "                            <div class=\"modal fade\" id=\"commentModal-"+comment.id+"\" tabindex=\"-1\" role=\"dialog\">\n" +
                        "                                <div class=\"modal-dialog\" role=\"document\">\n" +
                        "                                    <div class=\"modal-content\">\n" +
                        "                                        <div class=\"modal-header\">\n" +
                        "                                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                        "                                            <h2 class=\"modal-title\">请选择举报类型及填写举报原因</h2>\n" +
                        "                                        </div>\n" +
                        "                                        <form action=\"/report\" method=\"post\">\n" +
                        "                                            <div class=\"modal-body\">\n" +
                        "                                                <input type=\"hidden\" name=\"targetId\" value=\""+comment.id+"\">\n" +
                        "                                                <input type=\"hidden\" name=\"targetType\" value=\"2\">\n" +
                        "                                                <h3>选择举报的类型：</h3>\n" +
                        "                                                <div class=\"choose-row\">\n" +
                        "                                                    <label class=\"checkbox-inline\">\n" +
                        "                                                        <input type=\"checkbox\" name=\"reportType\" value=\"恶意中伤\"> 恶意中伤\n" +
                        "                                                    </label>\n" +
                        "                                                    <label class=\"checkbox-inline\">\n" +
                        "                                                        <input type=\"checkbox\" name=\"reportType\" value=\"言语攻击\"> 言语攻击\n" +
                        "                                                    </label>\n" +
                        "                                                    <label class=\"checkbox-inline\">\n" +
                        "                                                        <input type=\"checkbox\" name=\"reportType\" value=\"传播谣言\"> 传播谣言\n" +
                        "                                                    </label>\n" +
                        "                                                </div>\n" +
                        "                                                <div class=\"choose-row\">\n" +
                        "                                                    <label class=\"checkbox-inline\">\n" +
                        "                                                        <input type=\"checkbox\" name=\"reportType\" value=\"广告欺诈\"> 广告欺诈\n" +
                        "                                                    </label>\n" +
                        "                                                    <label class=\"checkbox-inline\">\n" +
                        "                                                        <input type=\"checkbox\" name=\"reportType\" value=\"违法言论\"> 违法言论\n" +
                        "                                                    </label>\n" +
                        "                                                    <label class=\"checkbox-inline\">\n" +
                        "                                                        <input type=\"checkbox\" name=\"reportType\" value=\"垃圾评论\"> 垃圾评论\n" +
                        "                                                    </label>\n" +
                        "                                                </div>\n" +
                        "                                                <h3>填写举报的原因：</h3>\n" +
                        "                                                <div class=\"reason-row\">\n" +
                        "                                                    <textarea class=\"form-control\" rows=\"4\" name=\"reportReason\" placeholder=\"请输入举报原因...\"></textarea>\n" +
                        "                                                </div>\n" +
                        "                                            </div>\n" +
                        "                                            <div class=\"modal-footer\">\n" +
                        "                                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\n" +
                        "                                                <button type=\"submit\" class=\"btn btn-primary\">提交</button>\n" +
                        "                                            </div>\n" +
                        "                                        </form>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                            </div>";
                    subCommentContainer.prepend(a);
                });
            });
            //展开二级评论
            comments.addClass("in");
            //标记二级评论展开状态
            e.setAttribute("data-collapse", "in");
            e.classList.add("active");
        }
    }
}

//评论点赞功能
function commentPraise(e) {
    var commentId = e.getAttribute("data-id");
    var creator = $("#loginId").val();
    var id = "#comPraise-"+commentId;
    var comPraCount= "#comPraCount-"+commentId;
    $.ajax({
        type:"POST",
        url:"/commentPraise",
        contentType:"application/json",
        data:JSON.stringify({
            "creator": creator,
            "praiseId": commentId,
            "type": 2
        }),
        success:function (response) {
            if(response.code == 200){
                var newStatus = response.nowStatus;
                var praiseCount = response.nowCount;
                debugger;
                if (newStatus==1){
                    $(id).toggleClass("like-active");
                    $(comPraCount).text(praiseCount);
                }else{
                    $(id).removeClass("like-active");
                    $(comPraCount).text(praiseCount);
                }
            }else{
                alert(response.message);
            }
        },
        dataType:"json"
    })
}

//评论踩功能
function commentTread(e) {
    var commentId = e.getAttribute("data-id");
    var creator = $("#loginId").val();
    var id = "#comTread-"+commentId;
    var comTreCount= "#comTreCount-"+commentId;
    $.ajax({
        type:"POST",
        url:"/commentTread",
        contentType:"application/json",
        data:JSON.stringify({
            "creator": creator,
            "treadId": commentId,
            "type": 2
        }),
        success:function (response) {
            if(response.code == 200){
                var newStatus = response.nowStatus;
                var TreadCount = response.nowCount;
                debugger;
                if (newStatus==1){
                    $(id).toggleClass("tread-active");
                    $(comTreCount).text(TreadCount);
                }else{
                    $(id).removeClass("tread-active");
                    $(comTreCount).text(TreadCount);
                }
            }else{
                alert(response.message);
            }
        },
        dataType:"json"
    })
}

//问题点赞功能
function questionPraise(e) {
    var questionId = e.getAttribute("data-id");
    var creator = $("#loginId").val();
    var id = "#quePraise-"+questionId;
    var quePraCount= "#quePraCount-"+questionId;
    $.ajax({
        type:"POST",
        url:"/questionPraise",
        contentType:"application/json",
        data:JSON.stringify({
            "creator": creator,
            "praiseId": questionId,
            "type": 1
        }),
        success:function (response) {
            if(response.code == 200){
                var newStatus = response.nowStatus;
                var praiseCount = response.nowCount;
                debugger;
                if (newStatus==1){
                    $(id).toggleClass("like-active");
                    $(quePraCount).text(praiseCount);
                }else{
                    $(id).removeClass("like-active");
                    $(quePraCount).text(praiseCount);
                }
            }else{
                alert(response.message);
            }
        },
        dataType:"json"
    })
}

//问题踩功能
function questionTread(e) {
    var questionId = e.getAttribute("data-id");
    var creator = $("#loginId").val();
    var id = "#queTread-"+questionId;
    var queTreCount= "#queTreCount-"+questionId;
    $.ajax({
        type:"POST",
        url:"/questionTread",
        contentType:"application/json",
        data:JSON.stringify({
            "creator": creator,
            "treadId": questionId,
            "type": 1
        }),
        success:function (response) {
            if(response.code == 200){
                var newStatus = response.nowStatus;
                var TreadCount = response.nowCount;
                debugger;
                if (newStatus==1){
                    $(id).toggleClass("tread-active");
                    $(queTreCount).text(TreadCount);
                }else{
                    $(id).removeClass("tread-active");
                    $(queTreCount).text(TreadCount);
                }
            }else{
                alert(response.message);
            }
        },
        dataType:"json"
    })
}

//问题收藏功能
function star(e) {
    var questionId = e.getAttribute("data-id");
    var creator = $("#loginId").val();
    var id = "#star-"+questionId;
    var starCount= "#starCount-"+questionId;
    $.ajax({
        type:"POST",
        url:"/star",
        contentType:"application/json",
        data:JSON.stringify({
            "collector": creator,
            "starId": questionId,
        }),
        success:function (response) {
            if(response.code == 200){
                var newStatus = response.nowStatus;
                var nowCount = response.nowCount;
                debugger;
                if (newStatus==1){
                    $(id).toggleClass("star-active");
                    $(starCount).text(nowCount);
                }else{
                    $(id).removeClass("star-active");
                    $(starCount).text(nowCount);
                }
            }else{
                alert(response.message);
            }
        },
        dataType:"json"
    })
}