
//숫자 반올림 num자리까지 표시 
function numRound(x,num) 
{
  return Number.parseFloat(x).toFixed(num); 
}

//	날짜 포맷 yy.MM.dd	
	function getDateFormat(text)
	{
		 let a  = new Date(text);
		 
		 let year= (String)(a.getFullYear()).substring(2,4);
		 let month = a.getMonth()+1;
		 let day=  a.getDate();
		 
		 if(month<10)
		 {
		   month = "0"+month;
		 }
		 if(day<10)
		 {
		  day = "0"+day;
		 }
		 
		 return year+"."+month+"."+day;
		 
	}
	
function getAge(birth)
{
	var birthdate= new Date(birth);
	var today= new Date();
	
	// 나이구하기
	var years = today.getFullYear()- birthdate.getFullYear();

	// 생일비교를 위해 생년도를 올해로 세팅
	birthdate.setFullYear(today.getFullYear);
	if(today<birthdate)
	{
	    years= years-1;
	}

	return years;
	
}


function getDifference()
{
	let before= document.querySelectorAll(".before");
	let after= document.querySelectorAll(".after");
	let result= document.querySelectorAll(".result");
	
	for(let i=0; i<before.length; i++)
	{   
		
	    var subResult= after[i].textContent-before[i].textContent;
	    subResult= numRound(subResult,1);
	    
	    if(i==1)
	    {
	        if(subResult<0)
	        {
	            getResult(i,"red", subResult);
	        }
	        else if(subResult==0)
        	{
	        	getResult(i,"black", subResult)
        	}
	        else
	        {
	            getResult(i,"blue", "+"+subResult);
	        }
	    }
	    else
	    {
	        if(subResult<0)
	        {
	            getResult(i,"blue", subResult);
	        }
	        else if(subResult==0)
        	{
	        	getResult(i,"black", subResult)
        	}
	        else
	        {
	            getResult(i,"red", "+"+subResult);
	        }
	    }
	    
	    function getResult(num, color, res)
	    {
	        result[num].style.color= color;
	        result[num].innerHTML= res;
	    }
	}

	
}


//
//var inbodyChartMyStatus = []; //inbodyChart용 배열
//var inbodyChartPerStandard = [];  //표준 대비 %

var inbodyChartMyStatus = new Array(); //inbodyChart용 배열
var inbodyChartPerStandard = new Array();  //표준 대비 %

var weightChartMyStatus = [];
var muscleChartMyStatus = []; 
var fatChartMyStatus = []; 


/////	5까지?

//성별, 키, 무게, 근육, 지방

// var datas= [60, 20, 12]; //자기수치
// 표준체중 대비 수치
 
// 자기
// 자기 키, 자기 체중
// 자기 골격근, 지방
 
//표준 체중 : 키-100 * 0.9

//남평균 골격근량= 자기체중/100*45 // +-3
//여평균 골격근량= 자기체중/100*36 // +-3
 
//남평균 지방량= 자기체중/100*18 // +-4
//여평균 지방량= 자기체중/100*25 // +-4

//평균대비% = 평균수치*100/자기수치
 

//표준 체중 대비 자기체중 
function getPerStandardWeight()
{
	let standardWeight= (height-100)*0.9;  //표준체중

	return standardWeight*100/weight;
}


//표준 체중 대비 자기 골격근량
function getPerStandardMuscle()
{
	let standardMuscle = 0;
	
	if(gender=="남성")
	{
		standardMuscle= muscle/100*45; //표준 골격근량	
	}
	else
	{
		standardMuscle= muscle/100*36;
	}
	
	return standardMuscle*100/muscle;

}

//표준 지방 대비 자기 지방
function getPerStandardFat()
{
	let standardFat = 0;
	
	if(gender=="남성")
	{
		standardFat= fat/100*18; //표준 지방
	}
	else
	{
		standardFat= fat/100*25; 
	}	
	
	return standardFat*100/fat;
}



////////
var resultArray= new Array();	//데이터 받아올 배열
var gender="";
var height= 0;
var weight= 0;
var fat= 0;
var muscle= 0;

//임시
//var perStandardWeight= getPerStandardWeight();
//var perStandardFat=getPerStandardFat();
//var perStandardMuscle=getPerStandardMuscle();


function setBeforeDatas(num)
{
	$("#beforeWeight").html(resultArray[num].inbody.weight);
	$("#beforeMuscle").html(resultArray[num].inbody.muscle);
	$("#beforeFat").html(resultArray[num].inbody.fat);
}



function pushChartDatas()
{
	inbodyChartMyStatus.push(resultArray[0].inbody.weight);
	inbodyChartMyStatus.push(resultArray[0].inbody.muscle);
	inbodyChartMyStatus.push(resultArray[0].inbody.fat);
		

let standardWeight= (height-100)*0.9;
let standardMuscle= muscle/100*45
let standardFat = fat/100*18;
	
	
	inbodyChartPerStandard.push(standardMuscle*100/weight);
	inbodyChartPerStandard.push(standardMuscle*100/muscle);
	inbodyChartPerStandard.push(standardFat*100/fat);

	
//	inbodyChartPerStandard.push(getPerStandardWeight());
//	inbodyChartPerStandard.push(getPerStandardMuscle());
//	inbodyChartPerStandard.push(getPerStandardFat());

//	inbodyChartPerStandard.push(Math.round(getPerStandardWeight()*1e1)/1e1);
//	inbodyChartPerStandard.push(Math.round(getPerStandardMuscle()*1e1)/1e1);
//	inbodyChartPerStandard.push(Math.round(getPerStandardFat()*1e1)/1e1);
	
	
	
//	for(let i=resultArray.length; 0<length; i--)
//	{		
//		 weightChartMyStatus.push(resultArray[i].inbody.weight);
//		 muscleChartMyStatus.push(resultArray[i].inbody.muscle);
//		 fatChartMyStatus.push(resultArray[i].inbody.fat);
//	}		
}



function getDatas()
{
	
	$.ajax({
		url: "getInbodyResult.do",
		type: "post",
		async: false,
		success: function(data) 
		{
			resultArray = data;
			
			gender=resultArray[0].gender;
			height=resultArray[0].inbody.height;
			
//////			
			weight=resultArray[0].inbody.weight;
			fat=resultArray[0].inbody.fat;
			muscle=resultArray[0].inbody.fat;
			//////
			
		$("#userName").html(resultArray[0].name);
		$("#age").html("만 " + getAge(resultArray[0].birth) +"세");
		$("#gender").html(gender);
		$("#height").html(height +"cm");
		
//		현재 측정일
		$("#latestMeasureDay").html(resultArray[0].inbody.strDate);

//		과거 측정일
		$(".previousMeasureDay").html(getDateFormat(resultArray[1].inbody.strDate));
//		현재 측정일
		$(".latestMeasureDay").html(getDateFormat(resultArray[0].inbody.strDate));
		
//		과거 측정일 값 세팅. 최근 2번째 측정일
		setBeforeDatas(1);
		
//		현재 측정일 값 세팅	
		$("#afterWeight").html(weight);
		$("#afterMuscle").html(resultArray[0].inbody.muscle);
		$("#afterFat").html(resultArray[0].inbody.fat);
		
//		현재-과거 비교
		getDifference();

//		차트용 데이터 담기
		pushChartDatas();
			
//		이전 측정일 드롭다운
		for(let i=1, length=resultArray.length; i<length; i++)
		{
			 let day= resultArray[i].inbody.strDate;
			$("#previousMeasureDay").append("<option value='"+day+"'>"+day+"</option> ");			
		}			
		},
		error: function(e) {
			alert(e);
		}

	})
	
		

//$.getJSON("getInbodyResult.do", function(data) 
//	{
//		console.log(data); 
//		
//		resultArray = data;
//		
//		gender=resultArray[0].gender;
//		height=resultArray[0].inbody.height;
//		
////////		
//		weight=resultArray[0].inbody.weight;
//		fat=resultArray[0].inbody.fat;
//		muscle=resultArray[0].inbody.fat;
////////
//		
//	$("#userName").html(resultArray[0].name);
//	$("#age").html("만 " + getAge(resultArray[0].birth) +"세");
//	$("#gender").html(gender);
//	$("#height").html(height +"cm");
//	
////	현재 측정일
//	$("#latestMeasureDay").html(resultArray[0].inbody.strDate);
//
////	과거 측정일
//	$(".previousMeasureDay").html(getDateFormat(resultArray[1].inbody.strDate));
////	현재 측정일
//	$(".latestMeasureDay").html(getDateFormat(resultArray[0].inbody.strDate));
//	
////	과거 측정일 값 세팅. 최근 2번째 측정일
//	setBeforeDatas(1);
//	
////	현재 측정일 값 세팅	
//	$("#afterWeight").html(weight);
//	$("#afterMuscle").html(resultArray[0].inbody.muscle);
//	$("#afterFat").html(resultArray[0].inbody.fat);
//	
////	현재-과거 비교
//	getDifference();
//
////	차트용 데이터 담기
//	pushChartDatas();
//		
////	이전 측정일 드롭다운
//	for(let i=1, length=resultArray.length; i<length; i++)
//	{
//		 let day= resultArray[i].inbody.strDate;
//		$("#previousMeasureDay").append("<option value='"+day+"'>"+day+"</option> ");			
//	}			
//		
//	});
	
	
}






///////

//var weightChart = document.querySelector("#weightChart");
//var muscleChart = document.querySelector("#muscleChart");
//var fatChart = document.querySelector("#fatChart");


	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';		

	function createInbodyChart()
	{	
		var inbodyChart = document.querySelector("#inbodyChart");
		
		var myInbodyChart = new Chart(inbodyChart, {
		    type: 'horizontalBar',
		    data: {
		          labels:["체중", "골격근량", "체지방량"],
		          datasets:[
		            {
		              label: "%",
		              backgroundColor: "#292b2c",
		              borderColor: "#292b2c",
		              data: inbodyChartPerStandard
//		              data: [120,100,150]
		            },
		            {
		              label: "kg",
		              hidden: true,
		              backgroundColor: "#292b2c",
		              borderColor: "#292b2c",
		              data: inbodyChartMyStatus
		           }
		            ],
		    },
		    animation:{
		        animateScale: true,
		        animateRotate:true
		    },
		    options: {
		        responsive: true,
		        legend: {
		            display: false,
		        },
		        scales: {
		            xAxes: [{
		                ticks: {
		                    min: 70,
		                    max: 140,
		                    stepSize: 10,
		                },
		            }],
		        },
		        scaleShowLabelBackdrop : true,
		        showAllTooltips : true,
		        tooltips: {
		            displayColors: false,
		            callbacks:{
		                        label: function(tooltipItem, data) {                  
		                        return data['datasets'][1]['data'][tooltipItem['index']];
		                        }
		                 }
		       }
		  }
	});

	
	}
	
/////	

	function createDetailChart()
	{
				
	}
	
	
//	
	

	// 그래프를 그릴 때의 데이터
	// 툴팁에 띄워줄 데이터

	
	


//처음 불러올때
	getDatas();
	
//	차트 그리기
	createInbodyChart();

	

		var latestMeasureDayDiv = document.querySelector("#latestMeasureDay");
		var showLDay = document.querySelector(".latestMeasureDay");
		
		var beforeWeight=  document.querySelector(".weight");
		var beforeMuscle=  document.querySelector(".muscle");
		var beforeFat=  document.querySelector(".fat");

		showLDay.innerText= getDateFormat(latestMeasureDayDiv.innerText)


		var previousMeasureDay = document.querySelector("#previousMeasureDay");
		var showPDay= document.querySelector(".previousMeasureDay");

		function preDayIschanged()
		{
		    showPDay.innerText= getDateFormat(previousMeasureDay.options[previousMeasureDay.selectedIndex].innerText)
		    
		    setBeforeDatas(previousMeasureDay.selectedIndex);
		    getDifference();
	   	    
		}

		function numOfResultIschanged()
		{
		   
		}






