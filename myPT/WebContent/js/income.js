var montharr = ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월"];

// 월선택 셀렉트
for (var count = 0; count < montharr.length; count++) {
  var option = $(
    "<option value='" + count + "'>" + montharr[count] + "</option>"
  );
  $("#selectmonth").append(option);
}
////////////////////////////

$("#selectmonth").change(function () {
  var month = $("#selectmonth").val();
  month++;
  $("#tincome").text(month + "월의 트레이너 수익");
  $("#tmonth").text(month + "월의 트레이너");
});

$(window).resize(function () {
  if (window.matchMedia("(max-width: 910px)").matches == true) {
    $("#card1").attr("class", "col-6");
    $("#card2").attr("class", "col-6");
    $("#card3").attr("class", "col-6");
    $("#card4").attr("class", "col-6");
  } else if (window.matchMedia("(max-width: 450px)").matches == true) {
    $("#card1").attr("class", "col-12");
    $("#card2").attr("class", "col-12");
    $("#card3").attr("class", "col-12");
    $("#card4").attr("class", "col-12");
  } else {
    $("#card1").attr("class", "col-3");
    $("#card2").attr("class", "col-3");
    $("#card3").attr("class", "col-3");
    $("#card4").attr("class", "col-3");
  }
});