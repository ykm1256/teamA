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

//CHART2
//////////////////////////////////////////////////
var ctx2 = document.getElementById("myChart2");
var charData2 = {
  labels: ["흑자", "양치승", "말왕", "박준우", "힘콩", "황철순"],
  datasets: [
    {
      label: "월 수익(만원)",
      yAxisID: "A",
      data: [80, 130, 100, 70, 90, 150],
      backgroundColor: "rgba(75, 192, 192, 0.8)",
    },
  ],
};
var myChart2 = new Chart(ctx2, {
  type: "bar",
  data: charData2,
  // 옵션
  options: {
    scales: {
      yAxes: [
        {
          id: "A",
          type: "linear",
          position: "left",
          ticks: {
            max: 200,
            min: 0,
          },
        },
      ],
    },
  },
});
//////////////////////////////////////////////
// CHART2 END
