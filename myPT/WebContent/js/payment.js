$(".pTableWrapper").click(function () {
    $(this).addClass("active").siblings().removeClass("active");
  });





////

function pay(input)
{
    alert(input.id);
}

// $(function(){
//     var IMP = window.IMP;
//     IMP.init('imp50784155'); // 가맹점 식별코드
//     var msg;
    
//     IMP.request_pay({
//         pg : 'inicis',
//         pay_method : 'card',
//         merchant_uid : 'merchant_' + new Date().getTime(),
//         name : '주문명:결제테스트',
//         amount : <%=totalPrice%>,
//         buyer_email : '<%=email%>',
//         buyer_name : '<%=name%>',
//         buyer_tel : '<%=phone%>',
//         buyer_addr : '<%=address%>',
//         m_redirect_url : 'http://www.naver.com'
//     }, function(rsp) {
//         if (rsp.success ) {
//             //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
//             jQuery.ajax({
//                 url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
//                 type: 'POST',
//                 dataType: 'json',
//                 data: {
//                     imp_uid : rsp.imp_uid
//                     //기타 필요한 데이터가 있으면 추가 전달
//                 }
//             }).done(function(data) {
//                 //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
//                 if ( everythings_fine ) {
//                     msg = '결제가 완료되었습니다.';
//                     msg += '\n고유ID : ' + rsp.imp_uid;
//                     msg += '\n상점 거래ID : ' + rsp.merchant_uid;
//                     msg += '\결제 금액 : ' + rsp.paid_amount;
//                     msg += '카드 승인번호 : ' + rsp.apply_num;
//                     alert(msg);
//                 } else {
//                     //[3] 아직 제대로 결제가 되지 않았습니다.
//                     //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
//                 }
//             });
//             //성공시 이동할 페이지
//            location.href='<%=request.getContextPath()%>/importEx/paymentProc.jsp?apply_num='+rsp.apply_num+'&paid_amount='+rsp.paid_amount;
//         } else {
//             msg = '결제에 실패하였습니다.';
//             msg += '에러내용 : ' + rsp.error_msg;
//             alert(msg);
//             //실패시 이동할 페이지
//             location.href="<%=request.getContextPath()%>/importEx/payForm.jsp";
//         }
//     });
// });



// $('#emailCheck').click(function()
// 		{

// 			$.ajax({
// 				type:"post",
// 				url:"emailCheck.do",
// 				data : {"email":$("#email").val()},
// 				success: function(data){
// 					data=data.trim();
// 					console.log(data);
// 					if(data==0)
// 					{
// 						alert("사용 가능한 이메일입니다");
// 						$('#confirmEmail').val($('#email').val());
// 						 rightFormat($('#email'));
					
// 						//qr코드 생성 (안)
// 						var qrcode = new QRCode(document.getElementById("qrcode"), {
//         					text: "http://192.168.0.47:8080/myPT/qrCheck.do?email="+$("#email").val(),
//         					width: 500,
//         					height: 500,
// 						});
// 					}
// 					else if(data==1)
// 					{				
// 						alert("사용 불가한 이메일입니다");
// 						$('#email').val("");
// 					}
// 					else
// 					{
// 						alert("오류 발생");
// 					}
// 				},
// 				error: function(e){
// 					alert("오류가 발생했습니다.")
// 				}		
					
// 		});
// 	});
	