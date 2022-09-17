$(document).ready(function () {

    $("#Btn--uploadComment").click(function () {
        // console.log($("#input--Bid").val());
        if ($("#input--Content").val() == "" || $("#input--Writer").val() == "" || $("#input--Pw").val() == "") {
            alert("모든 항목을 작성해주세요.");
            $("#input--Writer").focus();
        }else {
            $.ajax({
                type: "post",
                url: "/comment/upload",
                // data:JSON.stringify(data),
                data: "cContent=" + $("#input--Content").val() + "&cWriter=" + $("#input--Writer").val() + "&cPw=" + $("#input--Pw").val() + "&bId=" + $("#input--Bid").val(),
                dataType: 'text',
                success: function (data, status) {
                    alert("댓글이 등록되었습니다.");
                    location.href = "/comment/reply/" + $("#input--Bid").val();
                },
                error: function (xhr, status, error) {
                    alert("댓글 등록이 실패하였습니다.");
                    location.href = "/comment/reply/" + $("#input--Bid").val();
                }
            });
        }
    });
});

function deleteComment(comment_id) {
    // console.log(comment_id);
    $.ajax({
        type: "post",
        url: "/comment/deleteComment",
        data: {cId: comment_id},
        dataType: 'text',
        success: function (data, status) {
            alert("댓글이 삭제되었습니다.");
            location.href = "/comment/reply/" + $("#input--Bid").val();
        },
        error: function (xhr, status, error) {
            alert("댓글 삭제가 실패하였습니다.");
            location.href = "/comment/reply/" + $("#input--Bid").val();
        }
    });
}


//매개변수로 cContent랑 cWriter도 같이 받으려니까 숫자형이랑 같이 전달해서 그런지 오류남 - 완
//어떻게 cContent랑 cWriter를 매개변수로 받아서 사용할 건지 찾기 - 완
//수정하기 버튼 클릭하면 comment_id값을 받아와야하는데 그걸 못함 - 완
function commentUpdateForm(comment_id, comment_writer, comment_content, comment_date) {
    // console.log(comment_id);
    var commentview = "";
    commentview += '<div class="card" style="box-shadow: 10px 10px rgb(198, 197, 197);">';
    commentview += '<div class="card-header">';
    commentview += '<b style="float: left;">';
    commentview += comment_writer;
    commentview += '</b>';
    commentview += '&nbsp;<i><div style="color: rgb(136, 134, 134); float: right;">';
    commentview += comment_date;
    commentview += '</div></i>';
    commentview += '</div>';
    commentview += '<div class="card-body">'
    commentview += '<textarea class="form-control" placeholder="Leave a comment here" name="updateContent" id="update--Content" style="border: none">';
    commentview += comment_content;
    commentview += '</textarea>';
    commentview += '<div class="d-grid gap-2 d-md-flex justify-content-md-end">';
    commentview += '<button class="btn btn-outline-secondary btn-sm Btn--updateCancel" onclick="updateCancel()" style="float: right">수정취소</button>';
    commentview += '<button class="btn btn-outline-secondary btn-sm Btn--updateDB" onclick="updateComment(' + comment_id + ')" style="float: right">수정완료</button>';
    commentview += '</div>';
    commentview += '</div>';
    commentview += '</div>';
    $("#" + comment_id).replaceWith(commentview);
    $("#update--Content").focus();
}

//아무 것도 안하고 컨트롤러를 갔다와서 화면이 깜빡임 대안 찾기
function updateCancel() {
    $.ajax({
        success: function () {
            location.href = "/comment/reply/" + $("#input--Bid").val();
        }
    });
}


//수정 버튼을 누른 댓글 위치에 댓글 작성하는 것처럼 바꿔야하는데 어떻게? - 완
function updateComment(clickId) {
    if($("#update--Content").val() == ""){
        alert("내용을 입력해 주세요.");
        $("#update--Content").focus();
    }else {
        // console.log(clickId);
        $.ajax({
            type: "post",
            url: "/comment/updateComment",
            data: "cContent=" + $("#update--Content").val() + "&cId=" + clickId,
            dataType: "text",
            success: function (data, status) {
                alert("댓글이 수정되었습니다.");
                location.href = "/comment/reply/" + $("#input--Bid").val();
            },
            error: function (xhr, status, error) {
                alert("댓글 수정이 실패하였습니다.");
                location.href = "/comment/reply/" + $("#input--Bid").val();
            }
        });
    }
}


function listComment() {
    // var commentUrl = "/comment/reply";
    // var commentNum = $("#input-Bid").val();
    //
    // $.ajax({
    //   url: commentUrl+commentNum,
    //   type: "post",
    //   dataType: "json",
    //   success:function(result){
    //     alert(result.cWriter);
    //     var comments = ""
    //     if(result.length < 1){
    //       comments = "등록된 댓글이 없습니다.";
    //     }else{
    //       $(result).each(function(){
    //         comments +="<br/>"
    //         + "작성자 : " + this.cWriter
    //         + "댓글내용 : " + this.cContent
    //         + "<button class=\"Btn--updateComment\" th:id=\"${comments.getCId}\">수정</button>"
    //         + "<button class=\"Btn--deleteComment\" th:id=\"${comments.getCId}\">삭제</button>"
    //       });
    //
    //
    //     };
    //     $(".commentList").append(comments);
    //   }
    // })
    // $(".commentList").append("helloWorld");
}


//삭제버튼 누르면 삭제되게 하기 - 완
//삭제버튼 누르면 삭제되는데 제일 위의 값의 버튼만 정상적으로 작동하고 그 외에는 작동을 안함 - 완
//콘솔 찍어보니까 맨 위 삭제 버튼 뺴고는 cid 값을 못 가져옴 - 완
