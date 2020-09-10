var result = document.querySelector("#result");

//var htmldata =
//  "<p><iframe class='col-10' allowfullscreen='' frameborder='0' height='360' src='https://www.youtube.com/embed/sk-zjzHqN00' width='640'></iframe></p> <p>안녕하세요~</p>";
//result.innerHTML = htmldata;

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