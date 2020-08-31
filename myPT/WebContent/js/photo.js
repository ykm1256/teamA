if (window.matchMedia("(min-width: 992px)").matches == true) {
  $(".card-img-top").css("height", "22vw");
} else if (window.matchMedia("(min-width: 768px)").matches == true) {
  $(".card-img-top").css("height", "40vw");
} else {
  $(".card-img-top").css("height", "80vw");
}

$(window).resize(function () {
  if (window.matchMedia("(min-width: 992px)").matches == true) {
    $(".card-img-top").css("height", "22vw");
  } else if (window.matchMedia("(min-width: 768px)").matches == true) {
    $(".card-img-top").css("height", "40vw");
  } else {
    $(".card-img-top").css("height", "80vw");
  }
});
