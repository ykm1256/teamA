//숫자 반올림 num자리까지 표시 
function numRound(x) 
{
  return Math.round(x*1e1)/1e1;
}

//	날짜 포맷 yy.MM.dd	
	function getFormattedDate(text)
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

//비포, 애프터 차이 구하기
function getDifference()
{
	let before= document.querySelectorAll(".before");
	let after= document.querySelectorAll(".after");
	let result= document.querySelectorAll(".result");
	
	for(let i=0; i<before.length; i++)
	{   
		
	    var subResult= after[i].textContent-before[i].textContent;
	    subResult= numRound(subResult);
	    
//골격근량의 경우 -면 빨간색, +면 파란색
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
//체중, 지방은 -면 파란색, +면 빨간색
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


//계산 기준

//표준 체중 : 키-100 * 0.9
//남평균 골격근량= 자기체중/100*45 // +-3
//여평균 골격근량= 자기체중/100*36 // +-3
//남평균 지방량= 자기체중/100*18 // +-4
//여평균 지방량= 자기체중/100*25 // +-4
//표준대비% = 자기수치*100/표준수치
 

//표준 체중 대비 자기체중 비율
function getPerStandardWeight()
{
	let standardWeight= (height-100)*0.9;  //표준체중

	return weight*100/standardWeight;
}


//표준 체중 대비 자기 골격근량 비율
function getPerStandardMuscle()
{
	let standardMuscle = 0;
	
	if(gender=="남성")
	{
		standardMuscle= weight/100*45; //표준 골격근량	
	}
	else
	{
		standardMuscle= weight/100*36;
	}
	
	return muscle*100/standardMuscle;
}

//표준 지방 대비 자기 지방 비율
function getPerStandardFat()
{
	let standardFat = 0;
	
	if(gender=="남성")
	{
		standardFat= weight/100*18; //표준 지방
	}
	else
	{
		standardFat= weight/100*25; 
	}	
	
	return fat*100/standardFat;
}


////////
var resultArray= new Array();	//데이터 받아올 배열
var userName="";
var birth="";
var gender="";
var height= 0;
var weight= 0;
var fat= 0;
var muscle= 0;
var latestMeasuerDay=0;

var numOfMyChartDatas=0;

var inbodyChartMyStatus = []; //inbodyChart용 배열
var inbodyChartPerStandard = [];  //표준 대비 %

var measurementDays =[];
var weightChartDatas = [];
var muscleChartDatas = []; 
var fatChartDatas =  [];
var myChartDatas = 	[measurementDays,weightChartDatas, muscleChartDatas, fatChartDatas];

var weightChart = document.querySelector("#weightChart").getContext('2d');
var muscleChart = document.querySelector("#muscleChart").getContext('2d');
var fatChart = document.querySelector("#fatChart").getContext('2d');

var myWeightChart="";
var myMuscleChart="";
var myFatChart="";
var myInbodyChart="";

//비교표 -비포 or 애프터 데이터 세팅
function setBeforeAfterDatas(BAtype, num)
{
	$("#"+BAtype+"Weight").html(resultArray[num].inbody.weight);
	$("#"+BAtype+"Muscle").html(resultArray[num].inbody.muscle);
	$("#"+BAtype+"Fat").html(resultArray[num].inbody.fat);
}

//비교표- 날짜 출력
function showDates()
{
	$("#showBeforeDay").text(getFormattedDate($("#beforeMeasureDay option:selected").text()));
	$("#showAfterDay").text(getFormattedDate($("#afterMeasureDay option:selected").text()));
}

//비교표의 애프터 데이터- 비포 데이터 이전의 날짜는 선택 못하게
function setEnabledAfterSelect(num)
{
	for(let i=2; i<=num+1; i++)
	{
		$("#afterMeasureDay option:nth-child("+i+")").removeAttr('disabled');
	}

	for(let i=resultArray.length; i>num; i--)
	{
		//	옵션이 기본적으로 하나 있기 때문에 i+1	
		$("#afterMeasureDay option:nth-child("+(i+1)+")").attr('disabled', true);
	}
}

//비교표의 비포 데이터- 애프터 데이터 이후의 날짜는 선택 못하게
function setEnabledBeforeSelect(num)
{

	for(let i=resultArray.length-1; i>num; i--)
	{
		if(i!=1)
		{
			$("#beforeMeasureDay option:nth-child("+i+")").removeAttr('disabled');	
		}		
	}
	
	for(let i=2; i<=num+1; i++)
	{
		$("#beforeMeasureDay option:nth-child("+i+")").attr('disabled', true);
	}
}

//기본 정보 세팅
function setUserBasicInfo(num)
{
	userName=resultArray[num].name;
	birth=getAge(resultArray[num].birth);
	gender=resultArray[num].gender;
	height=resultArray[num].inbody.height;
	weight=resultArray[num].inbody.weight;
	fat=resultArray[num].inbody.fat;
	muscle=resultArray[num].inbody.muscle;
	latestMeasuerDay=resultArray[num].inbody.strDate;
}

//차트용 데이터 담기
function addInbodyChartDatas(num)
{
	inbodyChartMyStatus.push(resultArray[num].inbody.weight);
	inbodyChartMyStatus.push(resultArray[num].inbody.muscle);
	inbodyChartMyStatus.push(resultArray[num].inbody.fat);
		
	inbodyChartPerStandard.push(numRound(getPerStandardWeight()));
	inbodyChartPerStandard.push(numRound(getPerStandardMuscle()));
	inbodyChartPerStandard.push(numRound(getPerStandardFat()));
}

function addMyChartDatas(type, num)
{	
	if(type==="addPre")
	{
		for(let i=numOfMyChartDatas, length=numOfMyChartDatas+num; i<length; i++)
		{		
			measurementDays.unshift(getFormattedDate(resultArray[i].inbody.strDate))
			weightChartDatas.unshift(resultArray[i].inbody.weight);
			muscleChartDatas.unshift(resultArray[i].inbody.muscle);
			fatChartDatas.unshift(resultArray[i].inbody.fat);
		}
	}
	else
	{
		for(let i=preAfter-2; i>preAfter-2-num; i--)
		{		
			measurementDays.push(getFormattedDate(resultArray[i].inbody.strDate))
			weightChartDatas.push(resultArray[i].inbody.weight);
			muscleChartDatas.push(resultArray[i].inbody.muscle);
			fatChartDatas.push(resultArray[i].inbody.fat);
		}
	}
				
}

function removeMyChartDatas(type, num)
{
	if(type==="removePre")
	{
		for(let i=0; i<num; i++)
		{		
			$.each(myChartDatas, function(index, item){ 
				item.shift();				
			});
		}	
	}
	else
	{
		for(let i=0; i<num; i++)
		{		
			$.each(myChartDatas, function(index, item){ 
				item.pop();				
			});

		}	
	}
	
}

function updateMyCharts()
{
	myWeightChart.update();
	myMuscleChart.update();
	myFatChart.update();
}


//db에서 데이터 가져옴
function getDatas()
{	
	$.ajax({
		url: "getInbodyResult.do",
		type: "post",
		async: false,
		success: function(data) 
		{
			resultArray = data;
			
			setUserBasicInfo(0);
				
			$("#userName").html(userName);
			$("#age").html("만 "+ birth +"세");
			$("#gender").html(gender);
			$("#height").html(height +"cm");
		
//		card footer 최근 측정일
		$("#latestMeasureDay").html(latestMeasuerDay);


//		비교 측정일 드롭다운	
		$("#beforeMeasureDay").append("<option selected>"+resultArray[1].inbody.strDate+"</option> ");
		$("#afterMeasureDay").append("<option selected>"+latestMeasuerDay+"</option> ");
		
		for(let i=2, length=resultArray.length; i<length; i++)
		{
			$("#beforeMeasureDay").append("<option>"+resultArray[i].inbody.strDate+"</option> ");
			$("#afterMeasureDay").append("<option>"+resultArray[i-1].inbody.strDate+"</option> ");			
		}			

		setEnabledAfterSelect(1);
		setEnabledBeforeSelect(1);
		
//	     과거 측정일 값 세팅. 최근 2번째 측정일
//	      최근 측정일 값을 애프터 데이터에 세팅		
		setBeforeAfterDatas("before", 1);
		setBeforeAfterDatas("after", 0);

//		선택한 날짜 표시
		showDates();
		
//		비포-애프터 비교
		getDifference();

//		차트용 데이터 담기
		addInbodyChartDatas(0);	
	
		if(resultArray.length>=6)
		{
			addMyChartDatas("addPre", 6);
			numOfMyChartDatas=6;
		}
		else
		{
			addMyChartDatas("addPre",resultArray.length);
			numOfMyChartDatas= resultArray.length;
		}
		
			
	},
	error: function(e) {
		alert(e);
	}
});
}



var xMap= ["","","표준이하","","","","표준", "","","", "표준이상","",""];

//인바디 차트	
	function createInbodyChart()
	{			

		let inbodyChart = document.querySelector("#inbodyChart").getContext('2d');
		myInbodyChart = new Chart(inbodyChart, {
		    type: 'horizontalBar',
		    data: {
		          labels:["체중", "골격근량", "체지방량"],
		          datasets:
				  [
					{
		              label: "표준 대비 %",
		              backgroundColor: "#292b2c",
		              data: inbodyChartPerStandard
		            },
		            {
		              label: "kg",
		              hidden: true,
		              backgroundColor: "#292b2c",
		              data: inbodyChartMyStatus
		           }],
		   		 },
		    animation:{
		        animateScale: true,
		        animateRotate:true
		    },
		    options: {
          		responsive: true,
				maintainAspectRatio: false,
	            plugins: {
	                datalabels: {
						color: "black",
	                    anchor: "end",
	                    align: "right",
	                    offset: 5,
 						display: function (context) {
	                        return context.dataset.data[context.dataIndex];
	                    },
	                    font: {
	                        weight: 'bold',
	                        size: 15
	                    },
	                }
				},
		        legend: {
		            display: false,
		        },
		        scales: {
		            xAxes: [{
		                ticks: {
		                    min: 40,
		                    max: 160,
		                    stepSize: 5
		               		 },
		           		 	},
						  {
							gridLines: {
							color: 'black', 
								},
						        type: 'linear',
						        position: 'bottom',
						        display: true,
									  ticks: {
								      min: 0,
								      max: xMap.length-1,
								      callback: function(value) {
								        return xMap[value];
								      }
								}  
					        }],
		        },
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


//차트 설정
function createMyChartConfig(dataSet){	
return {
		type: 'line',
	  	data: {
	    labels: measurementDays,
	    datasets: dataSet,
	  },
	  options: {
    		responsive: true,
	            plugins: {
	                datalabels: {
						color: "black",
	                    anchor: "top",
	                    align: "center",
	                    offset: 20,
 						display: function (context) {
	                        return context.dataset.data[context.dataIndex];
	                    },
	                    font: {
	                        weight: 'bold',
	                        size: 15
	                    },
	                }
				},
	    scales: {
	      xAxes: [{
	        time: {
	          unit: 'date'
	        },
	        gridLines: {
	          display: true,          
	          color: "rgba(0, 0, 0, .15)",
	        },
	        ticks: {
	          maxTicksLimit: 30
	        }
	      }],
	      yAxes: [{
	        ticks: {
//	          min: minMaxDatas[minMaxLabel][0]-1,
//	          max: minMaxDatas[minMaxLabel][1]+1,
	          suggetedmin: 0,
	          suggestedmax: 200,
	          stepSize: 1,
	        },
	        gridLines: {
	          color: "rgba(0, 0, 0, .2)",
	        }
	      }],
	    },
	    legend: {
	      display: false
	    }
	  }	
	}
}

	


function createMyCharts()
{
myWeightChart= new Chart(weightChart, createMyChartConfig(
		[{
	      label: "체중(kg)",
	      lineTension: 0.5,
	      backgroundColor: "rgba(255,255,255,0)",
	      borderColor: "rgba(164,220,160,1)",
	      pointRadius: 5,
	      pointBackgroundColor: "rgba(134,200,140,1)",
	      pointBorderColor: "rgba(255,255,255,0.8)",
	      pointHoverBackgroundColor: "rgba(2,117,216,1)",
	      data: weightChartDatas
	    }]));

myMuscleChart= new Chart(muscleChart, createMyChartConfig(
			[{
		      label: "골격근량(kg)",
		      lineTension: 0.5,
		      backgroundColor: "rgba(255,255,255,0)",
		      borderColor: "rgba(180,180,180,1)",
		      pointRadius: 5,
		      pointBackgroundColor: "rgba(150,180,180,1)",
		      pointBorderColor: "rgba(255,255,255,0.8)",
		      pointHoverBackgroundColor: "rgba(2,117,216,1)",
		      data: muscleChartDatas,
		    }]));

myFatChart= new Chart(fatChart, createMyChartConfig(
		[{
	      label: "체지방량(kg)",
	      lineTension: 0.5,
	      backgroundColor: "rgba(255,255,255,0)",
	      borderColor: "rgba(200,80,110,1)",
	      pointRadius: 5,
	      pointBackgroundColor: "rgba(230,80,110,0.87)",
	      pointBorderColor: "rgba(255,255,255,0.8)",
	      pointHoverBackgroundColor: "rgba(2,117,216,1)",
	      data: fatChartDatas
	    }]));
				
}




//처음 불러올때
	getDatas();
	
//	차트 그리기
	createInbodyChart();
	createMyCharts();
	
	
var beforeMeasureDay = document.querySelector("#beforeMeasureDay");
var afterMeasureDay = document.querySelector("#afterMeasureDay")

var preAfter= 1;
var after = 1;

function beforeDayIschanged()
{	    
	beforeAfterChanged("before", beforeMeasureDay.selectedIndex);
}

function afterDayIschanged()
{
	beforeAfterChanged("after", afterMeasureDay.selectedIndex-1);
}


function beforeAfterChanged(BAtype, num)
{
	let numOfExcution=0;
	
	setBeforeAfterDatas(BAtype, num);
	showDates();
    getDifference();
	
	if(BAtype=="before")
	{
		setEnabledAfterSelect(num);
		
		before= num;
		
		if(before-numOfMyChartDatas>=0)
		{
//			앞- 추가될 데이터 수
			numOfExcution=before-numOfMyChartDatas+1;
			addMyChartDatas("addPre", numOfExcution);
//			추가된 후 차트 데이터 수
			numOfMyChartDatas= numOfMyChartDatas+numOfExcution;	
		}
		else if(before-numOfMyChartDatas<-1)
		{
//			앞- 제거될 데이터 수
			numOfExcution=Math.abs(numOfMyChartDatas-before)-1;
			removeMyChartDatas("removePre", numOfExcution);
//			제거된 후 차트 데이터 수
			numOfMyChartDatas= numOfMyChartDatas-numOfExcution;			
		}

	}
	else
	{
		setEnabledBeforeSelect(num);

		preAfter= after;
		after= num+1;		

	   if(preAfter>after)
		{
		 //뒤 데이터 추가
		numOfExcution= preAfter-after;
		addMyChartDatas("addPost", numOfExcution);
		numOfMyChartDatas= numOfMyChartDatas+numOfExcution;	

		}
		else if(preAfter<after)
		{
		//뒤의 데이터를 뺀다
		numOfExcution=Math.abs(preAfter-after);
		removeMyChartDatas("removePost", numOfExcution);
		numOfMyChartDatas= numOfMyChartDatas-numOfExcution;	
		}

		 inbodyChartMyStatus.length=0;
		 inbodyChartPerStandard.length=0;

		setUserBasicInfo(num);
		addInbodyChartDatas(num);
		myInbodyChart.update();
		$("#latestMeasureDay").html(latestMeasuerDay);
	
			
	}
	
	updateMyCharts();

}


