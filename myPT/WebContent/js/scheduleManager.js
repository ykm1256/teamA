jQuery(document).ready(function ($) {
  $(".btn").on("click", function () {
    if ($(this).is("#btnProgram")) {
      let cardId = $(this).parent().attr("id");
      let num = cardId[4];
      let dayPart = $("#" + cardId)
        .find("#pro" + num)
        .attr("id");
      let dayMention = $("#" + cardId)
        .find("#proMention" + num)
        .attr("id");
      if ($("#" + dayPart).val() == "") {
        let modalBody = $("#proSubmit").parent().prev().attr("class");
        $("." + modalBody)
          .find("#proPart")
          .val("");
        $("." + modalBody)
          .find("#proMention")
          .val("");
        $("#proSubmit").on("click", function () {
          $("#" + cardId)
            .find("#btnPT")
            .hide();
          $("#" + cardId)
            .find("#pro" + num)
            .attr("style", "display:flex");
          $("#" + dayPart).val(
            $("." + modalBody)
              .find("#proPart")
              .val()
          );
          $("#" + dayMention).val(
            $("." + modalBody)
              .find("#proMention")
              .val()
          );
          dayMention = "undefined";
          dayPart = "undefined";
          num = "undefined";
          cardId = "undefined";
        });
      } else {
        let modalBody = $("#proSubmit").parent().prev().attr("class");
        $("." + modalBody)
          .find("#proPart")
          .val($("#" + dayPart).val());
        $("." + modalBody)
          .find("#proMention")
          .val($("#" + dayMention).val());
        $("#proSubmit").on("click", function () {
          $("#" + cardId)
            .find("#btnPT")
            .hide();
          $("#" + cardId)
            .find("#pro" + num)
            .attr("style", "display:flex");
          $("#" + dayPart).val(
            $("." + modalBody)
              .find("#proPart")
              .val()
          );
          $("#" + dayMention).val(
            $("." + modalBody)
              .find("#proMention")
              .val()
          );
          dayMention = "undefined";
          dayPart = "undefined";
          num = "undefined";
          cardId = "undefined";
        });
      }

      $("#proCancel").on("click", function () {
        $("#" + cardId)
          .find("#btnPT")
          .show();
        $("#" + cardId)
          .find("#pro" + num)
          .attr("style", "display:none");

        $("#" + dayPart).val("");
        $("#" + dayMention).val("");
        dayMention = "undefined";
        dayPart = "undefined";
        cardId = "undefined";
        num = "undefined";
      });

      $(".close").on("click", function () {
        dayMention = "undefined";
        dayPart = "undefined";
        cardId = "undefined";
        num = "undefined";
      });
    }
    if ($(this).is("#btnPT")) {
      let cardId = $(this).parent().attr("id");
      let num = cardId[4];
      let dayTime = $("#" + cardId)
        .find(".PT")
        .attr("id");
      if ($("#" + dayTime).val() == "") {
        let modalBody = $("#ptSubmit").parent().prev().attr("class");
        $("." + modalBody)
          .find("#ptTime")
          .val("");
        $("#ptSubmit").on("click", function () {
          $("#" + cardId)
            .find("#btnProgram")
            .hide();
          $("#" + cardId)
            .find("#time" + num)
            .attr("style", "display:flex");
          $("#" + dayTime).val(
            $("." + modalBody)
              .find("#ptTime")
              .val()
          );
          dayTime = "undefined";
          num = "undefined";
          cardId = "undefined";
        });
      } else {
        let modalBody = $("#ptSubmit").parent().prev().attr("class");
        $("." + modalBody)
          .find("#ptTime")
          .val($("#" + dayTime).val());
        $("#ptSubmit").on("click", function () {
          $("#" + cardId)
            .find("#btnProgram")
            .hide();
          $("#" + cardId)
            .find("#time" + num)
            .attr("style", "display:flex");
          $("#" + dayTime).val(
            $("." + modalBody)
              .find("#ptTime")
              .val()
          );
          dayTime = "undefined";
          num = "undefined";
          cardId = "undefined";
        });
      }

      $("#ptCancel").on("click", function () {
        $("#" + cardId)
          .find("#btnProgram")
          .show();
        $("#" + cardId)
          .find("#time" + num)
          .attr("style", "display:none");

        $("#" + dayTime).val("");
        dayTime = "undefined";
        num = "undefined";
        cardId = "undefined";
      });
      $(".close").on("click", function () {
        dayMention = "undefined";
        dayPart = "undefined";
        cardId = "undefined";
        num = "undefined";
      });
    }
  });
});

$(".custom-select").css("width", "auto");
// $(this).attr("data-target", "#PT");

// 모바일에서 날짜
if (window.matchMedia("(max-width: 800px)").matches == true) {
  $(document).ready(function () {
    $(".custom-input").attr("style", "display:none");
    $(".custom-input").removeClass("input-group-prepend");
  });
} else {
  $(document).ready(function () {
    $(".custom-input").attr("style", "display:flex");
    $(".custom-input").addClass("input-group-prepend");
  });
}

$(window).resize(function () {
  if (window.matchMedia("(max-width: 800px)").matches == true) {
    $(document).ready(function () {
      $(".custom-input").attr("style", "display:none");
      $(".custom-input").removeClass("input-group-prepend");
    });
  } else {
    $(document).ready(function () {
      $(".custom-input").attr("style", "display:flex");
      $(".custom-input").addClass("input-group-prepend");
    });
  }
  if (window.matchMedia("(max-width: 574px)").matches == true) {
    $(".custom-submit").attr("style", "width:100%");
  } else {
    $(".custom-submit").attr("style", "width:");
  }
});
if (window.matchMedia("(max-width: 574px)").matches == true) {
  $(".custom-submit").attr("style", "width:100%");
} else {
  $(".custom-submit").attr("style", "width:");
}

// 달이랑 주차 정하면 해당 날짜
var date= new Date();
console.log(date);

