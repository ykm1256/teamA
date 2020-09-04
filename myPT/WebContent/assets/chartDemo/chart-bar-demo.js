// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';


var ctx = document.getElementById("myBarChart");

// 그래프를 그릴 때의 데이터
// 툴팁에 띄워줄 데이터


// var datas= [60, 20, 12]; //자기수치
// 표준체중 대비 수치
 
// 자기
// 자기 키, 자기 체중
// 자기 골격근, 지방
 
//표준 체중 : 키*100 * 0.9

//남평균 골격근량= 자기체중/100*45 // +-3
//여평균 골격근량= 자기체중/100*36 // +-3
 
//남평균 지방량= 자기체중/100*18 // +-4
//여평균 지방량= 자기체중/100*25 // +-4

//평균대비% = 평균수치*100/자기수치
 
var gender="";
var height= 0;
var weight= 0;
var fat= 0;
var muscle= 0;


//표준 체중 대비 자기체중
function getPerStandardWeight()
{
	let standardWeight= (height*100)*0.9;  //표준체중
	let perStandardWeight= standardWeight*100/weight;	
	
	return perStandardWeight;
}

//표준 체중 대비 자기 골격근량
function getPerStandardMuscle()
{
	let standardMuscle = "";
	
	if(gender=="남성")
	{
		standardMuscle= muscle/100*45; //표준 골격근량	
	}
	else
	{
		standardMuscle= muscle/100*36;
	}
	
	perStandardMuscle= standardMuscle*100/muscle;
	
	return perStandardMuscle;

}

//표준 지방 대비 자기 지방
function getPerStandardMuscle()
{
	let standardFat = "";
	
	if(gender=="남성")
	{
		standardFat= fat/100*18; //표준 지방
	}
	else
	{
		standardFat= fat/100*25; 
	}
	
	perStandardFat= standardFat*100/fat;

	return perStandardFat;
}




var chartFixedTooltips = new Chart(ctx, {
    type: 'horizontalBar',
    data: {
          labels:["체중", "골격근량", "체지방량"],
          datasets:[
            {
              label: "%",
              backgroundColor: "#292b2c",
              borderColor: "#292b2c",
              data: [98.8, 133, 88.9],
            },
            {
              label: "kg",
              hidden: true,
              backgroundColor: "#292b2c",
              borderColor: "#292b2c",
              data: [60, 20, 20],
           }],
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
                    min: 60,
                    max: 140,
                    stepSize: 10,
                },
            }],
        },
        scaleShowLabelBackdrop : true,
        showAllTooltips : false,
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
