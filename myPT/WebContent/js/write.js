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
   $('img').parent().addClass('resizeable')


   // 테스트용
   $('#test').click(function(){
       var markupStr = $('.summernote').summernote('code');
           $('#result').html(markupStr);
   });