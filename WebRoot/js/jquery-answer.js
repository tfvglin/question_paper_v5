﻿$(document).ready(function(){
	$(".all").click(function(){
		$(this).siblings(".hide").hide();
			$(this).siblings(".chartall").slideDown();
	
		
		});
	
	$(".sex").click(function(){
		$(this).siblings(".hide").hide();
		$(this).siblings(".chartsex").slideDown();

	
	});
	
	$(".hukou").click(function(){
		$(this).siblings(".hide").hide();
		$(this).siblings(".charthukou").slideDown();

	
	});
	
	$(".pointer").click(function(){
		$(this).siblings(".hide").slideUp();
	});
	
  $(".department").click(function(){
	  	$(this).siblings(".hide").hide();
		$(this).siblings(".chartdepartment").slideDown();
  });
  $(".marjor").click(function(){
	  $(this).siblings(".hide").hide();
	  $(this).siblings(".chartmarjor").slideDown();
  });
  $(".province").click(function(){
	  $(this).siblings(".hide").hide();
	  $(this).siblings(".chartprovince").slideDown();
  });
	
});

function checkdepartment(qtype,qnum)
{
	if(qtype==1)
		{
			var department=$("#singlequestiondepartment"+qnum+"").val();
			if(department=="")
			{
			 alert("请选择学院");
			// return false;
			}
			else{
				//alert("aa");
				//$("form[name='singlequestiondepartment'+qnum+'").submit;
				$("#singlequestiondepartmentchart"+qnum+"").attr("src","/question_paper_v5/showChartByDepartment.action?sqtype=1&sqnum="+qnum+"&department="+department);
			}
		
		}
	if(qtype==2)
	{
		var department=$("#multiplequestiondepartment"+qnum+"").val();
		if(department=="")
		{
			alert("请选择学院");
			// return false;
		}
		else{
			//alert("aa");
			//$("form[name='singlequestiondepartment'+qnum+'").submit;
			$("#multiplequestiondepartmentchart"+qnum+"").attr("src","/question_paper_v5/showChartByDepartment.action?sqtype=2&sqnum="+qnum+"&department="+department);
		}
		
	}
}
function checkmarjor(qtype,qnum)
{
	if(qtype==1)
	{
		var marjor=$("#singlequestionmarjor"+qnum+"").val();
		if(marjor=="")
		{
			alert("请选择专业");
			// return false;
		}
		else{
			//alert("aa");
			//$("form[name='singlequestiondepartment'+qnum+'").submit;
			$("#singlequestionmarjorchart"+qnum+"").attr("src","/question_paper_v5/showChartByMarjor.action?sqtype=1&sqnum="+qnum+"&marjor="+marjor);
		}
		
	}
	if(qtype==2)
	{
		var marjor=$("#multiplequestionmarjor"+qnum+"").val();
		if(marjor=="")
		{
			alert("请选择专业");
			// return false;
		}
		else{
			//alert("aa");
			//$("form[name='singlequestiondepartment'+qnum+'").submit;
			$("#multiplequestionmarjorchart"+qnum+"").attr("src","/question_paper_v5/showChartByMarjor.action?sqtype=2&sqnum="+qnum+"&marjor="+marjor);
		}
		
	}
}
function checkprovince(qtype,qnum)
{
	if(qtype==1)
	{
		var province=$("#singlequestionprovince"+qnum+"").val();
		if(province=="")
		{
			alert("请选择省份");
			// return false;
		}
		else{
			//alert("aa");
			//$("form[name='singlequestiondepartment'+qnum+'").submit;
			$("#singlequestionprovincechart"+qnum+"").attr("src","/question_paper_v5/showChartByProvince.action?sqtype=1&sqnum="+qnum+"&province="+province);
		}
		
	}
	
	if(qtype==2)
		{
		
			var province=$("#multiplequestionprovince"+qnum+"").val();
			if(province=="")
			{
				alert("请选择省份");
				// return false;
			}
			else{
				//alert("aa");
				//$("form[name='singlequestiondepartment'+qnum+'").submit;
				$("#multiplequestionprovincechart"+qnum+"").attr("src","/question_paper_v5/showChartByProvince.action?sqtype=2&sqnum="+qnum+"&province="+province);
			}
			
		}
}