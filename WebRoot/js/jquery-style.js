
	$(function(){  
		
		//var stuname = $("#stuname").val();

		var tooltip = "<div class='formbody'><fieldset ><legend align='left'>身份认证</legend><div class='form' align='center'><s:form  name='loginform' action='/begin.action' method='post' theme='simple'><s:actionmessage cssStyle='color:red'/><s:fielderror cssStyle='color:red' /><div style='margin:10px;'><label for='stuname'>姓名</label><s:textfield name='stuname' id='stuname' /></div><div ><label for='stunum'>学号</label><s:textfield name='stunum' id='stunum' /></div><div ><s:submit id='button' value='开始作答' style='background:#A4D3EE;weight:60px;height:30px;cursor:pointer;color:#fff'></s:submit></div></s:form></div></fieldset></div>";
		//var tooltip ="<p>adf</p>";
		$("#click").click(function(){
			//alert("aa");
			$("body").append(tooltip);
			$(".formbody").css({"top":"100px","left":"100px"}).show("slow");
			
		});
		
		$("input[class*=graytips]") //所有样式名中含有grayTips的input   
		.each(function(){   
			var oldVal=$(this).val();   //默认的提示性文本   
			$(this)   
					.css({"color":"#888"})  //灰色   
					.focus(function(){   
						if($(this).val()!=oldVal)
						{$(this).css({"color":"#000"});}
						else{$(this).val("").css({"color":"#888"});}   
					})   
					.blur(function(){   
						if($(this).val()==""){$(this).val(oldVal).css({"color":"#888"});}   
					})   
					.keydown(function(){$(this).css({"color":"#000"});
					});  
		}) ;  
		
		$(".area").mouseenter(function(){
					var child = $(this).children();
					$(this).css({"background-color" : "#F0FFFF"})
						   .children().css({"background-color" : "#F0FFFF"});
					child.mouseenter(function(){$(this).css({"background-color" : "#BBFFFF"});})
						 .mouseleave(function(){$(this).css({"background-color" : "#F0FFFF"});});
					
				})
				.mouseleave(function(){
					$(this).css({"background-color" : "#fff"})
							.children().css({"background-color" : "#FFF"});
					
				});	
		
		
		
		
		
		
		
		
		/*	$("input[type=submit]").mouseenter(function(){
			$(this).css({"background-color":"#fff"});
		});
		
		$(":button").mouseenter(function(){
			alert("aa");
			$(this).css({"color":"red"});
		});*/
		
		
		
	});