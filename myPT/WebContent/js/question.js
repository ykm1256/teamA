

//페이징
function paging(keyWord,page){
	if((keyWord==null||keyWord=="")){
		window.location.href="moveQuestion.do?page="+page;
	}else{
		window.location.href="searchQuestion.do?page="+page;
	}
}
function gtltPaging(keyWord,arrow){
	if((keyWord==null||keyWord=="")&&head=="all"){
		window.location.href="moveQuestion.do?next="+arrow;
	}else{
		window.location.href="searchQuestion.do?next="+arrow;
	}s
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
		window.location.href="moveQuestion.do"
	}else{
		window.location.href="searchQuestion.do?keyField="+keyField+"&keyWord="+keyWord;
	}
}


