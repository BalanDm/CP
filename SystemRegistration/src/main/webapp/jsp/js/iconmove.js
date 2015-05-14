$(document).ready(function() {
      $(".email").focus(function() {
        $(".email-icon-idx").css("left","-48px");
      });
      $(".email").blur(function() {
        $(".email-icon-idx").css("left","0px");
      });

      $(".password").focus(function() {
        $(".pass-icon-idx").css("left","-48px");
      });
      $(".password").blur(function() {
        $(".pass-icon-idx").css("left","0px");
      });
    });