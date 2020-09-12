
if (window.matchMedia("(min-width: 992px)").matches == true) {
  $(".card-img-top").css("height", "22vw");
} else if (window.matchMedia("(min-width: 768px)").matches == true) {
  $(".card-img-top").css("height", "40vw");
} else {
  $(".card-img-top").css("height", "80vw");
}

$(window).resize(function () {
  if (window.matchMedia("(min-width: 992px)").matches == true) {
    $(".card-img-top").css("height", "22vw");
  } else if (window.matchMedia("(min-width: 768px)").matches == true) {
    $(".card-img-top").css("height", "40vw");
  } else {
    $(".card-img-top").css("height", "80vw");
  }
});

//페이징
function pageing(keyWord,page){
	if(keyWord==null||keyWord==""){
		window.location.href="movePhoto.do?page="+page;
	}else{
		window.location.href="searchPhoto.do?page="+page;
	}
}

//검색 확인
function searchCheck(){
	var keyField=$("#keyField").val();
	var keyWord=$("#keyWord").val();
	if(keyField==null){
		alert("카테고리를 지정하세요.");			
		return false;
	}
	else if(keyWord==""){
		window.location.href="movePhoto.do"
	}else{
		window.location.href="searchPhoto.do?keyField="+keyField+"&keyWord="+keyWord;
	}
}

