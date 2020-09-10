 jQuery(document).ready(function ($) {
  $("div").on("click", function () {
    if (
      $(this).parents(".likebutton").find(".like").attr("checked") == "checked"
    ) {
      $(this).parents(".likebutton").find(".like").removeAttr("checked");
    } else {
      $(this).parents(".likebutton").find(".like").attr("checked", "checked");
    }
  });
});

/*$(".likebutton").on("click",function(){
	console.log($(this).attr("id"));
	var id=$(this).attr("id");
	$.ajax({
		url:"likeToggle.do",
		type:"post",
		data:{
			"id":id
		},
		success:function(data){
			alert("성공"+data);
		},
		error:function(e){
			alert("실패");
			alert(e);
		}
	})
})*/

$(".likebutton").on("click", function () {
	var likenum = $("#likenum").text() * 1;
	var num = $("#num").val();
	var board = $("#board").val();
	if ($("#like").attr("checked")) {
		$.ajax({
			url: "boardLike.do",
			type: "post",
			data: { "num": num, "flag": 1,"board":board },
			success: function(data) {
				likenum += 1;
				$("#likenum").text(likenum);
			},
			error: function(e) {
				alert(e);
			}

		})
	}else {
		$.ajax({
			url: "boardLike.do",
			type: "post",
			data: { "num": num, "flag": 0, "board":board },
			success: function(data) {
				likenum -= 1;
				$("#likenum").text(likenum);
			},
			error: function(e) {
				alert(e);
			}

		})
		
	}
});
