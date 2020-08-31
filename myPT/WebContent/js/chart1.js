// CHART1
Chart.plugins.register({
  beforeRender: function (chart) {
    if (chart.config.options.showAllTooltips) {
      // create an array of tooltips
      // we can't use the chart tooltip because there is only one tooltip per chart
      chart.pluginTooltips = [];
      chart.config.data.datasets.forEach(function (dataset, i) {
        chart.getDatasetMeta(i).data.forEach(function (sector, j) {
          chart.pluginTooltips.push(
            new Chart.Tooltip(
              {
                _chart: chart.chart,
                _chartInstance: chart,
                _data: chart.data,
                _options: chart.options.tooltips,
                _active: [sector],
              },
              chart
            )
          );
        });
      });

      // turn off normal tooltips
      chart.options.tooltips.enabled = false;
    }
  },
  afterDraw: function (chart, easing) {
    if (chart.config.options.showAllTooltips) {
      // we don't want the permanent tooltips to animate, so don't do anything till the animation runs atleast once
      if (!chart.allTooltipsOnce) {
        if (easing !== 1) return;
        chart.allTooltipsOnce = true;
      }

      // turn on tooltips
      chart.options.tooltips.enabled = true;
      Chart.helpers.each(chart.pluginTooltips, function (tooltip) {
        tooltip.initialize();
        tooltip.update();
        // we don't actually need this since we are not animating tooltips
        tooltip.pivot();
        tooltip.transition(easing).draw();
      });
      chart.options.tooltips.enabled = false;
    }
  },
});

//////////////////////////////////////////////
var ctx1 = document.getElementById("myChart1");
var charData1 = {
  labels: [
    "1월",
    "2월",
    "3월",
    "4월",
    "5월",
    "6월",
    "7월",
    "8월",
    "9월",
    "10월",
    "11월",
    "12월",
  ],
  datasets: [
    {
      label: "등록회원수",
      yAxisID: "A",
      data: [10, 12, 5, 25, 30, 15, 15, 18, 22, 27, 5, 9, 10],
      backgroundColor: "rgba(75, 192, 192, 0.8)",
    },
    {
      label: "월 매출(만원)",
      yAxisID: "B",
      data: [209, 245, 383, 403, 589, 300, 580, 234, 346, 436, 451, 124, 467],
      backgroundColor: "rgba(54, 162, 235, 0.8)",
    },
  ],
};
var myChart1 = new Chart(ctx1, {
  type: "bar",
  data: charData1,
  // 옵션
  options: {
    scales: {
      yAxes: [
        {
          id: "A",
          type: "linear",
          position: "left",
          ticks: {
            max: 80,
            min: 0,
          },
        },
        {
          id: "B",
          type: "linear",
          position: "right",
          ticks: {
            max: 800,
            min: 0,
          },
        },
      ],
    },
  },
});
//////////////////////////////////////////////
// CHART1 END
