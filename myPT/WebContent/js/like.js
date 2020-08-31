jQuery(document).ready(function ($) {
  $("div").on("click", function () {
    if (
      $(this).parents(".likebutton").find(".like").attr("checked") == "checked"
    ) {
      $(this).parents(".likebutton").find(".like").removeAttr("checked");
    } else {
      $(this).parents(".likebutton").find(".like").attr("checked", "checked");
    }
  });
});
