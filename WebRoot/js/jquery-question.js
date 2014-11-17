	$(document).ready(function(){
		
		$("input[type='radio']").change(function(){
			 if($(this).attr("optiontype")=="1")
			 {
			  
				$(this).siblings(".other").show("1000");
			}
			else
			{
				$(this).parent().siblings(".question").children(".other").hide("1000")
																	.val("请注明...")	;
				
			}
			
			});
			
			
		$("input[type='checkbox'][optiontype='1']").change(function(){
			
		
			
			if($(this).prop("checked")==true)
			 {
			  
				$(this).siblings(".other").show("1000");
			}
			else
			{
				$(this).siblings(".other").hide("1000")
										.val("请注明...");
				
			}
			
			});
	
		
		 $('form').submit(function() {
			    if(typeof jQuery.data(this, "disabledOnSubmit") == 'undefined') {
			      jQuery.data(this, "disabledOnSubmit", { submited: true });
			      $('input[type=submit], input[type=button]', this).each(function() {
			        $(this).attr("disabled", "disabled");
			      });
			      return true;
			    }
			    else
			    {
			      return false;
			    }
			  });
		
				
			 $("#papersubmit").click(function(e){
					
			  if($("#phone").val()=="请填写联系电话")
				{
				
				alert("请填写联系电话！");
				return false;
				}
			if($("#phone").val().length!=11)
				{
				alert("联系电话填写错误，请填写11位手机号码！");
				return false;
				}
			
			
			
				var sinqnum = parseInt($(".single").children(":last").attr("qnum"));
			for(var i=1;i<=sinqnum;i++)
				{
					var val = $("input:radio[name=sinquestion"+i+"]:checked").val();
					if(val==null)
						{
						alert("请选择第"+i+"道单选题");
						return false;
						}
				}
				
							var mulqnum = parseInt($(".multiple:last").attr("qnum"));
			
			for(var i=1;i<=mulqnum;i++)
				{
					var val = $("input:checkbox[name=mulquestion"+i+"]:checked").val();
					if(val==null)
						{
						alert("请选择第"+i+"道多选题！");
						return false;
						}
				}
			
			var textqnum = parseInt($(".textquestion:last").attr("qnum"));
			
			for(var i=1;i<=textqnum;i++)
				{
					var val = $.trim($("#textq"+i).val());
				/*	if(val==null || val == "")
						{
						alert("请填写第"+i+"道简答题！");
						return false;
						}*/
					if(val.length>300)
					{
					alert("第"+i+"道简答题字数过多，请填写300字以内！");
					return false;
					}
				}
			
			var listqnum = parseInt($(".list:last").attr("qnum"));
			
			for(var i=1;i<=listqnum;i++)
				{
					var val = $.trim($("#listq"+i+"_1").val());
					
					if(val==null || val == "")
						{
						alert("请填写第"+i+"道列举题！");
						return false;
						}
				}
				});
			 
			 $(".list").on("click","button.addtextfile",function(){
				var qnum = $("input[name=listqnum]").attr("value");	
				var optionnum;
				obj =$(this).siblings(".textfile").children(":last");
			if(obj.length > 0)
				{
				 optionnum= obj.attr("order");
				}
			else
				{
				 optionnum = 0;
				}
				
			var nextoptionnum =parseInt(optionnum)+1;
			$(this).siblings(".textfile").append("<div class='option' order='"+nextoptionnum+"'><input type='text' name='listquestion"+qnum+"_"+nextoptionnum+"' id='listq"+qnum+"_"+nextoptionnum+"' class='listtext'> </div>");
			$(this).siblings("input[name=optionnum]").attr("value",nextoptionnum);
		});
			 
			});