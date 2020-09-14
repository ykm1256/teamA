/**
 * 
 */

$(function(){

	$("#btnUser").click(function(){
		if($("#email").val()==""){
			alert("이메일을 입력하세요.")
			$("#email").focus();
			return false;
		}
		if($("#pw2").val()==""){
			alert("비밀번호를 입력하세요.")
			$("#pw2").focus();
			return false;
		}
		
		
		$.ajax({
			type:"post",
			url:"userLogin.do",
			data : {"email":$("#email").val(), "pw":$("#pw2").val()},
			success: function(data){
				
				
				data=data.trim();
				if(data==0){
					alert("id나 비밀번호가 틀렸습니다.");
					
					
				}else if(data==1){					
					location.href="userMain.do";					
				}
			},
			error: function(e){
				alert("에러가 발생했습니다.")
			}		
				
		})
		
	});	
	
	$("#btntrainer").click(function(){
		if($("#id").val()==""){
			alert("아이디를 입력하세요.")
			$("#id").focus();
			return false;
		}
		if($("#pw1").val()==""){
			alert("비밀번호를 입력하세요.")
			$("#pw1").focus();
			return false;
		}
		
		
		$.ajax({
			type:"post",
			url:"trainerLogin.do",
			data : {"id":$("#id").val(), "pw":$("#pw1").val()},
			success: function(data){
				
				
				data=data.trim();
				if(data==0){
					alert("id나 비밀번호가 틀렸습니다.");
					
					
				}else if(data==1){					
					location.href="trainerMain.do";
				}
				else if(data==2){					
					location.href="userList.do";
				}
			},
			error: function(e){
				alert("에러가 발생했습니다.")
			}		
				
		})
		
	});	
	
});