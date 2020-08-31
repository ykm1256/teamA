// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';


var ctx = document.getElementById("myBarChart");

// 그래프를 그릴 때의 데이터
// 툴팁에 띄워줄 데이터
//  170/60/여 표준체중: 60.69kg, 표준 골격근량 체중 25% 15kg , 표준 체지방량 체중 23% 13.8kg 

// var datas= [60, 20, 12]; //자기수치
// 평균대비% = 자기수치*100/평균수치

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
