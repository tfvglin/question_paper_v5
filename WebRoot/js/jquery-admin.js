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
		var $list=$("<div id='listquestion'>" +
					"<div>题目:<input type='text' name='questioncontent' id='listquestioncontent'/></div>" +
					"</div>");
		var $text =$("<div id='textquestion' class='text'>" +
					"<div>题目：<input type='text' name='questioncontent'></div>" +
					"</div>");
		var $multiple = $("<div id='multiplequestion' class='select'>" +
				"<div>题目：<input type='text' name='questioncontent' id='multiplequestioncontent'></div>" +
				"<div class='option'>" +
					"<div order='1' other='0'>" +
						"选项1:<input name='option1content' type='text' >" +
						"<input class='optiontype' type='hidden' name='option1type' value='0'/>" +
						"<button type='button' class='addother' >添加备注</button>" +
					"</div>" +
				"</div>" +
				"<input type='hidden' name='optionnum' value='1'/>" +
				"<button type='button' class='addoption'>增加选项</button>" +
				"<button type='button' class='deloption'>删除选项</button>" +
				"</div>");
		var $single = $("<div id='singlequestion' class='select'>" +
						"<div>" +"题目：<input type='text' name='questioncontent' ></div>" +
						"<div class='option'>" +
							"<div order='1' other='0'>" +
								"选项1:<input name='option1content' type='text' >" +
								"<input class='optiontype'  type='hidden' name='option1type' value='0'/>" +
								"<button type='button' class='addother'>添加备注</button>" +
							"</div>" +
						"</div>" +
						"<input type='hidden' name='optionnum' value='1'/>" +
						"<button type='button' class='addoption'>增加选项</button>" +
						"<button type='button' class='deloption'>删除选项</button>" +
						"</div>");
		
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
	
	$(".addform , .editoption").on("click",".addother",function(){
		
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
	
	$("div.showoption").click(function(){
		$(this).siblings("div.option").slideDown();
		$(this).siblings("div.hideoption").show();
		$(this).hide();
	});
	
	$("div.hideoption").click(function(){
		$(this).siblings("div.option").slideUp();
		$(this).siblings("div.showoption").show();
		$(this).hide();
	});
	
	$(window).resize(function(event) {
		var winhei=$(window).height();
		var winwid=$(window).width();
		var editwinwid=$("div.editwin").width();
		var editwinhei=$("div.editwin").height();
		$("div.editwin").show();
		$("div.editwin").css("top",winhei/2-editwinhei/2);
		$("div.editwin").css("left",winwid/2-editwinwid/2);
    });
	
});


	function edit(e,qnum,qtype){
		//alert(qtype);
		var e=$(e);
		var optionbody= e.parent().siblings("div.option");
		var optioncount =optionbody.children("div.select").size();
		//alert(optioncount);
		var optioncontent = {};
		var optiontype = {};
		if(qtype=="3")
			{
				$("#addbut").hide();
				$("#delbut").hide();
				
				$("div.editquestiontitle").prepend("简答第"+qnum+"题");
			}
		else if(qtype=="4")
		{
			$("#addbut").hide();
			$("#delbut").hide();
			$("div.editquestiontitle").prepend("列举第"+qnum+"题");
		}		
		else
			{
			
			if(qtype=="1"){
				$("div.editquestiontitle").prepend("单选第"+qnum+"题");
			}
			if(qtype=="2")
			{
				$("div.editquestiontitle").prepend("多选第"+qnum+"题");
			}
				for(var i=0;i<optioncount;i++)
					{
						optiontype[i] = optionbody.find("span.optiontype:eq("+i+")").text();
						optioncontent[i] = optionbody.find("span.optioncontent:eq("+i+")").text();
						if(optiontype[i]==1)
							{
								$("div.editoption").append("<div>" +
										"<span class='beforecontent'>选项"+(i+1)+"：</span>" +
										"<span class='content'>"+optioncontent[i]+"</span>"+
										"<input class='optiontype'  type='hidden' name='option"+(i+1)+"type' value='1'/>" +
										"<button type='button' onclick='alter(this,"+(i+1)+")'>修改</button>"+
										"<button type='button' class='addother'>删除备注</button>" +
										"</div>");
							}
						else{
							$("div.editoption").append("<div>" +
									"<span class='beforecontent'>选项"+(i+1)+"：</span>" +
									"<span class='content'>"+optioncontent[i]+"</span>"+
									"<input class='optiontype'  type='hidden' name='option"+(i+1)+"type' value='0'/>"+
									"<button type='button' onclick='alter(this,"+(i+1)+")'>修改</button>"+
									"<button type='button' class='addother'>添加备注</button>" +
									"</div>");
						}
					
					}
			}
		var questiontitle =  e.parent().siblings("div.title").children("span.questiontitle").text();
		
		$("div.cover").show();
		$("div.cover").width($(document).width());
		$("div.cover").height($(document).height());
		
		var winhei=$(window).height();
		var winwid=$(window).width();
		var editwinwid=$("div.editwin").width();
		var editwinhei=$("div.editwin").height();
		
		
		$("#questiontitle").text(questiontitle);
		$("input[name='questionnum']").attr('value',qnum);
		$("input[name='questiontype']").attr('value',qtype);
		$("input[name='optioncount']").attr('value',optioncount);
		//$("div.body").html(" <s:property value='#session.sqsinlist["+qnum+"].sque' />");
		$("div.editwin").show();
		$("div.editwin").css("top",winhei/2-editwinhei/2);
		$("div.editwin").css("left",winwid/2-editwinwid/2);
	}
	function closeShow()
	{
	//div1.style.display="none";
	//div2.style.display="none";
		$("div.editquestiontitle").empty();
		$("div.editoption").empty();
		$("div.cover").hide();
		$("div.editwin").hide();

	}
	
	function deloption(e)
	{
		var optioncount = parseInt($("input[name='optioncount']").attr('value'));
		$(e).siblings("div.editoption").children(":last").remove();
		$("input[name='optioncount']").attr('value',optioncount-1);
	}
	
	function addoption(e)
	{
		var optioncount = parseInt($("input[name='optioncount']").attr('value'));
		$("input[name='optioncount']").attr('value',optioncount+1);
		var optionnum = $(e).siblings("div.editoption").children().size();
		$(e).siblings("div.editoption").append("<div>" +
							"<span>选项"+(optionnum+1)+"：</span>" +
							"<input type='text' value='' name='option"+(optionnum+1)+"'\/>" +
							"<input class='optiontype'  type='hidden' name='option"+(optionnum+1)+"type' value='0'/>"+
							
							"<button type='button' class='addother'>添加备注</button>" +
							"</div>");
	
	}
	
	function alter(e,optionnum)
	{
		
		var content=$(e).siblings("span.content").text();
		$(e).siblings("span.content").remove();
		if(optionnum==0)	
		{
			$(e).siblings("span.beforecontent").after("<input type='text' value='"+content+"' name='questiontitle' class='questiontitleinput'\/>");
		}
		else
			{
			
			$(e).siblings("span.beforecontent").after("<input type='text' value='"+content+"' name='option"+optionnum+"'\/>");
			}
		$(e).hide();
	}