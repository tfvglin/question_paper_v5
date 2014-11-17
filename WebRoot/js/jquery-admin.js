$(document).ready(function(){
	/*$("select[name=questiontype").change(function(){
		$("div.singlequestion").hide();
		$("div.multiplequestion").hide();
		$("div.textquestion").hide();
		if($(this).val()==1)
			{
			$("div.singlequestion").show();
			}
		if($(this).val()==2)
		{
		$("div.multiplequestion").show();
		}
		if($(this).val()==3)
		{
		$("div.textquestion").show();
		}
	});
	
	$("ul li.dropdown").mouseenter(function(){
		$(this).children("ul.childmenu").stop()
										.show("slow");	
	});
	$("ul li.dropdown").mouseleave(function(){
		$(this).children("ul.childmenu").stop()
										.hide("slow");	
	});*/
	
	$("select[name=questiontype]").change(function(){
		
		$("div.addform").empty();
		var $list=$("<div id='listquestion'><div>题目:<input type='text' name='questioncontent' id='listquestioncontent'/></div></div>");
		var $text =$("<div id='textquestion' class='text'><div>题目：<input type='text' name='questioncontent'></div></div>");
		var $multiple = $("<div id='multiplequestion' class='select'><div>题目：<input type='text' name='questioncontent' id='multiplequestioncontent'></div><div class='option'><div order='1' other='0'>选项1:<input name='option1content' type='text' ><input class='optiontype' type='hidden' name='option1type' value='0'/><button type='button' class='addother' >添加备注</button></div></div><input type='hidden' name='optionnum' value='1'/><button type='button' class='addoption'>增加选项</button><button type='button' class='deloption'>删除选项</button></div>");
		var $single = $("<div id='singlequestion' class='select'><div>题目：<input type='text' name='questioncontent' ></div><div class='option'><div order='1' other='0'>选项1:<input name='option1content' type='text' ><input class='optiontype'  type='hidden' name='option1type' value='0'/><button type='button' class='addother'>添加备注</button></div></div><input type='hidden' name='optionnum' value='1'/><button type='button' class='addoption'>增加选项</button><button type='button' class='deloption'>删除选项</button></div>");
		
		var questiontype = $(this).val();
		if(questiontype==1)
			{
				$("div.addform").append($single);
			}
		if(questiontype==2)
			{
				$("div.addform").append($multiple);
			}
		if(questiontype==3)
		 	{
				$("div.addform").append($text);
		 	}
		if(questiontype==4)
			{
				$("div.addform").append($list);
			}
	});
	
	
	$(".addform").on("click",".addoption",function(){
			
			 obj =$(this).siblings(".option").children(":last");
		if(obj.length > 0)
			{
			var optionnum= obj.attr("order");
			}
		else
			{
			var optionnum = 0;
			}
			
		var nextoptionnum =parseInt(optionnum)+1;
		$(this).siblings(".option").append("<div other='false' order='"+nextoptionnum+"'>选项"+nextoptionnum+":<input name='option"+nextoptionnum+"content' type='text' ><input class='optiontype'  type='hidden' name='option"+nextoptionnum+"type' value='0'/><button type='button' class='addother' >添加备注</button></div>");
		$(this).siblings("input[name=optionnum]").attr("value",nextoptionnum);
	});
	$(".addform").on("click",".deloption",function(){
		
		$(this).siblings(".option").children(":last").remove();
		var qnum = parseInt($(this).siblings("input[name=optionnum]").attr("value"))-1;
		$(this).siblings("input[name=optionnum]").attr("value",qnum);
	});
	
	$(".addform").on("click",".addother",function(){
		var but=$(this).html();
		if(but=="添加备注")
			{
				$(this).html("删除备注");
				$(this).parent().attr("other","true");
				$(this).siblings(".optiontype").val("1");
			}
		else
			{
				$(this).html("添加备注");
				$(this).parent().attr("other","false");
				$(this).siblings(".optiontype").val("0");
			}
	});
	
	
	
	$("li.dropdown a").mouseenter(function(){
		
		$(this).siblings("ul").show("1000");
		});
	$("li.dropdown").mouseleave(function(){
		$(this).children(".childmenu").stop()
									  .hide("1000");
		});
});