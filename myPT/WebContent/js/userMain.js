function getWeekNo(v_date_str) {
 var date = new Date();
 if(v_date_str){
  date = new Date(v_date_str);
 }
 return Math.ceil(date.getDate() / 7);
}
console.log(new Date(2020,7));
console.log(getWeekNo(new Date(2020,7)));
var today=new Date();
var year=today.getFullYear();
var month=today.getMonth()+1;
var date=today.getDate();
var thisDay=today.getDay();
var weekDates=new Array();
var week=getWeekNo(today);
var days=new Array();

for(var i=1;i<=5;i++){
	weekDates[i-1]=date-thisDay+i;
	console.log(weekDates[i-1]);
}



$.ajax({
		url:"userSchedule.do",
		type:"post",
		data:{
			"today":year+"-"+month+"-"+date,
			"day":thisDay,
			"weekDates":weekDates,
			"week":week
		},
		success:function(data){
			alert("성공"+data);
		},
		error:function(e){
			alert("실패");
			alert(e);
		}
})