$(".likebutton").on("click", function () {
	var likenum = $("#likenum").text() * 1;
	var num = $("#num").val();
	var board = $("#board").val();
	if ($("#like").attr("checked")) {
		$.ajax({
			url: "boardLike.do",
			type: "post",
			data: { "num": num, "flag": 1},
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
			data: { "num": num, "flag": 0},
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
