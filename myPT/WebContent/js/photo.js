

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

$("img").on("click",function(){
	var id=$(this).parent().attr("id");
	alert(id);
	window.location.href="boardView.do?num="+id;
})