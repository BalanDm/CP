$(document).ready(function() {
	$(".organization").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".organization").blur(function() {
		$(".user-icon").css("left","0px");
	});

	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
	
	$(".phone").focus(function() {
		$(".phone-icon").css("left","-48px");
	});
	$(".phone").blur(function() {
		$(".phone-icon").css("left","0px");
	});
	
	$(".email").focus(function() {
		$(".email-icon").css("left","-48px");
	});
	$(".email").blur(function() {
		$(".email-icon").css("left","0px");
	})
});