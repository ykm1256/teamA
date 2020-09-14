
function changePage(page)
{
	  nowPage= page;
	  getChangedComment();
}

function changeBlock(block)
{
	 nowPage= pagePerBlock*(block-1)+1;	  
	 getChangedComment();
}


function setComment()
{
	let htmlForNew=""; 
//	  var today = new Date();
//	  today.setHours(today.getHours()-24)
//	  
//	  
//	  for(var i=0; i<numOfComments;i++)
//	{
//		  var commentdate= new Date($('.commentDate').eq(i).text())
//
//		if(boardWriter== $('.commentNick').eq(i).text())
//			{
//				$('.commentNick').eq(i).append('<span class="badge badge-success ml-1">작성자</span>');		
//			}
//		if(commentdate>today && $('.commentNick').eq(i).children('.newImg').length!=1)
//			{
//				$('.commentNick').eq(i).append('<img src="img/new.png" width="12px" class="ml-1 newImg">');
//			}
//		
		
	$.each (comments, function (index, com) 
	{
		htmlForNew+='<div class="comments"><div class="row"><div class="row col-9">';
		htmlForNew+='<div class="col font-weight-bold commentNick">'+com.c_nick+'</div></div>';			
											
		if(sessionNick== com.c_nick)
			{
				htmlForNew+='<div class="col-3 text-right dropdown"><a class="mt-1 text-secondary" href="#" role="button" data-toggle="dropdown"><i class="fas fa-ellipsis-v"></i></a><div class="dropdown-menu dropdown-menu-right">';
				htmlForNew+='<a class="dropdown-item commentUpdate">수정</a><a class="dropdown-item commentDelete">삭제</a><input type="number" hidden="true" value='+com.c_num+'></div></div>';
			}
		else if(sessionGrade==0)
			{
				htmlForNew+='<div class="col-3 text-right dropdown"><a class="mt-1 text-secondary" href="#" role="button" data-toggle="dropdown"><i class="fas fa-ellipsis-v"></i></a><div class="dropdown-menu dropdown-menu-right">';
				htmlForNew+='<a class="dropdown-item commentDelete">삭제</a><input type="number" hidden="true" value='+com.c_num+'></div></div>';
			}
									
		htmlForNew+='</div><div class="row"><div class="col py-2 content">'+com.c_content+'</div></div>';
		htmlForNew+='<div class="row"><div class="col text-secondary"><span class="commentDate">'+com.c_date+'</span><span class="ml-2 replyComment" style="cursor:pointer;">댓글쓰기</span></div></div></div>';						
			
	});
	
	$('#commentsWrapper').append(htmlForNew);
	setBadge(comments.length);
}


function setBlock()
{
	$('#page').empty();
	
		if(totalPage>0 && nowBlock>1)
		{
		   $('#page').prepend('<li class="page-item"><span class="page-link" style="cursor:pointer;" onclick="changeBlock('+(nowBlock-1)+')"> < </span></li>');					   
		}
	
		for(var i = pageStart; i<=pageEnd; i++)
			{
				
				if(nowPage==i)
					{
						$('#page').append('<li class="page-item" id="pageNum'+i+'"></li>');
						$('#pageNum'+i).append('<span class="page-link text-white bg-primary" style="cursor:pointer;" onclick="changePage('+i+');">'+i+'</span>')
					}		
				else
					{
						$('#page').append('<li class="page-item" id="pageNum'+i+'"></li>');
						$('#pageNum'+i).append('<span class="page-link" style="cursor:pointer;" onclick="changePage('+i+');">'+i+'</span>')
					}					
			}
		
		if(totalPage>pagePerBlock && nowBlock!=totalBlock)
		{
		   $('#page').append('<li class="page-item"><span class="page-link" style="cursor:pointer" onclick="changeBlock('+(nowBlock+1)+')"> > </span></li>');					   
		}
}

	




function getChangedComment()
{
	 $.ajax({
			type:"post",
			url:"commentChangePage.do",
			data : {"nowPage": nowPage, "num": num},
			async: false,
			success: function(data)
			{
				console.log(data);
				
				nowBlock= data.paging.nowBlock;
				pageStart= data.paging.pageStart;
				pageEnd= data.paging.pageEnd;
									
				comments= data.comments;
				
				$('#commentsWrapper').empty();
				$('#page').empty();
				
				
				setComment();
				setBlock();
						
			},
			error: function(e){
				alert("에러가 발생했습니다.")
			}					
	})
}



  
  $('#commentBtn').click(function(){  
	
	$.ajax({
		type:"post",
		url:"commentInsert.do",
		data : {"nowPage": nowPage, "num": num, "c_content":$("#commentContent").val()},
		async: false,
		success: function(data)
		{
			console.log(data);
			let newComment= data;
			let lengthOfBeforeComments = comments.length==undefined?1:comments.length+1;
			
			if(nowPage!= newComment.paging.nowPage) //페이지가 바뀐 경우
				{
					comments= newComment.comments;	

					nowPage= data.paging.nowPage;
					nowBlock= data.paging.nowBlock;
					pageStart= data.paging.pageStart;
					pageEnd= data.paging.pageEnd;
										
					getChangedComment()
				}
			else //nowPage가 같아서 가장 최근 것만 덧붙이는 경우
			{
				let htmlForNew="";
				htmlForNew+='<div class="comments"><div class="row"><div class="row col-9">';
				htmlForNew+='<div class="col font-weight-bold commentNick">'+newComment.comments.c_nick+'</div></div>';
				htmlForNew+='<div class="col-3 text-right dropdown"><a class="mt-1 text-secondary" href="#" role="button" data-toggle="dropdown"><i class="fas fa-ellipsis-v"></i></a>';
				htmlForNew+='<div class="dropdown-menu dropdown-menu-right"><a class="dropdown-item commentUpdate" href="#">수정</a><a class="dropdown-item commentDelete" href="#">삭제</a> ';
				htmlForNew+='<input type="number" hidden="true" value='+newComment.comments.c_num+'></div></div></div>';
				htmlForNew+='<div class="row"><div class="col py-2 content">'+newComment.comments.c_content+'</div></div>';
				htmlForNew+='<div class="row"><div class="col text-secondary"><span class="commentDate">'+newComment.comments.c_date+'</span><span class="ml-2 replyComment" style="cursor:pointer;">댓글쓰기</span></div></div></div>';			

				$('#commentsWrapper').append(htmlForNew);
				setBadge(lengthOfBeforeComments);
				setBlock();
			}
			
			$('#commentContent').val('');
			
			
		},
		error: function(e){
			alert("에러가 발생했습니다.")
		}					
	})
  
})



function setBadge()
{
	  var today = new Date();
	  today.setHours(today.getHours()-24)
	
	for(var i=0; i<numPerPage;i++)
	{
		  var commentdate= new Date($('.commentDate').eq(i).text())

		if(boardWriter== $('.commentNick').eq(i).text())
			{
				$('.commentNick').eq(i).append('<span class="badge badge-success ml-1">작성자</span>');		
			}
		if(commentdate>today && $('.commentNick').eq(i).children('.newImg').length!=1)
			{
				$('.commentNick').eq(i).append('<img src="img/new.png" width="12px" class="ml-1 newImg">');
			}
	}
}



	$(document).on("click", '.commentDelete', function(){
		 let $selectedComment= $(this).parents('.comments');		 
		 if(confirm("정말 삭제하시겠습니까?")==true)
			{					 
			 $.ajax({
					type:"post",
					url:"commentDelete.do",
					data : {"num": num, "c_num": $(this).siblings('input').val()},
					async: false,
					success: function(data)
					{
						console.log(data);						
						if(data==1)
						{
							$selectedComment.remove();
							
							
							setBlock();
							
							
						}						
					},
					error: function(e){
						alert("에러가 발생했습니다.")
					}					
				})		 
			}
	})  	
	
	
	$(document).on("click", '.commentUpdate', function(){
		let $selectedComment= $(this).parents('.comments');	
		let c_num= $(this).siblings('input').val();		
		let $beforeContent= $selectedComment.find('div.content').text();
		$selectedComment.find('div.content').html('<textarea id="contentForUpdate" cols="30" rows="4" maxlength="500" style="width:100%; resize:none" class="border-0">'+$beforeContent+'</textarea>');
		$('#contentForUpdate').focus();		
		let $btnWrapper= $('<div class="text-right"></div>');
		$('#contentForUpdate').after($btnWrapper);
		$btnWrapper.append('<input type="button" class="btn btn-primary ml-auto" id="updateBtn" value="수정"><input type="button" class="btn btn-danger mx-2" id="cancelBtn" value="취소">');		
		
		$('#cancelBtn').click(function(){
			$selectedComment.find('div.content').text($beforeContent);
			return false;
		})		
		
		$(document).on("click", '#updateBtn', function(){
						let updateContent= $('#contentForUpdate').val();				
					 if(confirm("수정하시겠습니까?")==true)
					{					 
						 $.ajax({
								type:"post",
								url:"commentUpdate.do",
								data : {"num": num, "c_num": c_num, "c_content":updateContent},
								async: false,
								success: function(data)
								{
									console.log(data);
									if(data==1)
									{
										$selectedComment.find('div.content').text(updateContent);
										
									}								
								},
								error: function(e){
									alert("에러가 발생했습니다.")
								}					
							})
					}
			})		 				
	})	  

	
	var selectedComment;
	
	//대댓글
//	$(".replyComment").click(function(){
	$(document).on("click", '.replyComment', function(){
//	$(".text-secondary").on("click", function(){
		
		
		selectedComment= $(this).parent();
		console.log(selectedComment.children().last());
		
		console.log($(this).parent());
		
		let c_num= $(this).siblings('input').val();
		
//		let $beforeContent= $selectedComment.find('div.content').text(); //수정하기위해서 했었음	
		
		if(!$(this).siblings().hasClass('reComment'))	
			{
				selectedComment.append('<div class="reComment my-1 ml-md-4"><div class="row"><div class="row col-9"><div class="col text-dark font-weight-bold commentNick">'+sessionNick+'</div></div><textarea id="forRecomment" cols="50" rows="4" maxlength="500" style="width:100%; resize:none" class="border-1"></textarea></div>');
				$('#forRecomment').focus();	

				let $btnWrapper= $('<div class="mt-2 ml-auto"></div>');
				$('#forRecomment').after($btnWrapper);
				
				$btnWrapper.append('<input type="button" class="btn btn-dark ml-auto" id="replyBtn" value="등록"><input type="button" class="btn btn-danger mx-2" id="cancelBtn" value="취소">');		
				
			}
				
		
//		$('#cancelBtn').click(function(){
//			$selectedComment.children().last().remove();
//			return false;
//		})
		
		$(document).on("click", '#replyBtn', function()
			{
				console.log($('#forRecomment').val());
				
				if($('#forRecomment').val()=='')
					{
						alert('내용을 입력해주세요');
						return false;
					}
								 
				 $.ajax({
						type:"post",
						url:"commentInsert.do",
						data : {"c_num": c_num, "depth":1},
						async: false,
						success: function(data)
						{
							console.log(data);						
							if(data==1)
							{
								$('.reComment');
								$selectedComment.append('')
							}						
						},
						error: function(e)
						{
							alert("에러가 발생했습니다.")
						}					
					})	
						
				})	
				
				
	})
	
	$('#cancelBtn').click(function(){
			selectedComment.children().last().remove();
			return false;
		})
	
	


