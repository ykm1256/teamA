$(document).ready(function() {
            
    $('#subject').focus();

     $('.summernote').summernote({
       toolbar: [
           ['fontname', ['fontname']],
           ['fontsize', ['fontsize']],
           ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
           ['color', ['forecolor','color']],
           ['table', ['table']],
           ['para', ['ul', 'ol', 'paragraph']],
           ['height', ['height']],
           ['insert',['picture','link','video']],
           ['view', ['fullscreen', 'help']]
         ],

       fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
       fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
       
       height: 400,
       minHeight: null,  
       maxHeight: null, 
       lang: 'ko-KR',
       focus: false,
       disableDragAndDrop: true,
       maximumImageFileSize: 3*1024*1024, // 최대 3mb

    // 이미지 팝오버 제외
       popover: {
           link: [
                    ['link', ['linkDialogShow', 'unlink']]
                 ],
           table:[
                   ['add', ['addRowDown', 'addRowUp', 'addColLeft', 'addColRight']],
                   ['delete', ['deleteRow', 'deleteCol', 'deleteTable']],
                 ],
           air:[
                   ['color', ['color']],
                   ['font', ['bold', 'underline', 'clear']],
                   ['para', ['ul', 'paragraph']],
                   ['table', ['table']],
                   ['insert', ['link', 'picture']]
               ]
           },

       //이미지 업로드 관련 콜백
       callbacks: 
       {
       // 	onImageUpload: function(files, editor, welEditable) {
       //         for (var i = files.length - 1; i >= 0; i--) {
       //         	sendFile(files[i], this);
       //         }
       //     }
           onImageUploadError: function(msg)
               {
                   alert(msg + '(3MB)');
               }
       }
     });
     
   });

   // 이미지 사이즈 드래그로 조절
//   $('img').parent().draggable();
/*   $('img').parent().addClass('resizeable')*/


   // 테스트용
   $('#test').click(function(){
       var markupStr = $('.summernote').summernote('code');
           $('#result').html(markupStr);

   });


// 글쓰기 (윤)
function postForm(){
	var head = $("#writeHead").val()
	var subject = $("#subject").val()
	
	if(head== null){
		alert("말머리를 선택하세요!")
		return false;
	}else if(subject.trim() == "" | subject==null){
		alert("올바른 제목을 입력하세요!")
		return false;
	}else{
	var content = $(".note-editable").html();
	$("#content").val(content);
	return true;
	}	
}

// 답글쓰기 (윤)
function repForm(){	
	var subject = $("#subject").val()
	
	if(subject.trim() == "" | subject==null){
		alert("올바른 제목을 입력하세요!")
		return false;
	}else{
	var content = $(".note-editable").html();
	$("#content").val(content);
	return true;
	}	
}

// 글 수정하기
function postUpdate(){
	var subject = $("#subject").val()
	if(subject.trim() == "" | subject==null){
		alert("올바른 제목을 입력하세요!")
		return false;
	}else{
		if(confirm("수정하시겠습니까?")){
			var content = $(".note-editable").html();
			$("#content").val(content);
			return true;
		}else {
			return false;
		}	
	}	
}

// 질문게시판 글쓰기 (윤)
function qPostForm(){	
	var subject = $("#subject").val()
	
	if(subject.trim() == "" | subject==null){
		alert("올바른 제목을 입력하세요!")
		return false;
	}else{
	var content = $(".note-editable").html();
	$("#content").val(content);
	return true;
	}	
}

// 포토게시판 글쓰기
function pPostForm(){	
	var subject = $("#subject").val();
	if(subject.trim() == "" | subject==null){
		alert("올바른 제목을 입력하세요!")
		return false;
	}else{
		var content = $(".note-editable").html();
		if(content.indexOf("<img")==-1){
			alert("이미지를 넣어주세요!");
			return false;
		}else{
			$("#content").val(content);
			return true;
		}
	}	
}



