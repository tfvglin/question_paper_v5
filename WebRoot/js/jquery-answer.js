$(document).ready(function(){
	$(".all").click(function(){
		$(this).siblings(".hide").hide();
			$(this).siblings(".chartall").show();
	
		
		});
	
	$(".sex").click(function(){
		$(this).siblings(".hide").hide();
		$(this).siblings(".chartsex").show();

	
	});
	
	$(".hukou").click(function(){
		$(this).siblings(".hide").hide();
		$(this).siblings(".charthukou").show();

	
	});
});