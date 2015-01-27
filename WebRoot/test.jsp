<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String sqtype=request.getParameter("sqtype");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
	<script src="js/jquery-answer.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="css/admin-styles.css">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		$(function(){
			$('#send').click(function(e){
			e.preventDefault();
				$.ajax({
					type:"GET",
					data: {
						'sqtype': $('input[name=sqtype]').val(),
						'sqnum': $('input[name=sqnum]').val()
					},
					url:"showTable.action",
					dataType:"json",
					success: function(data){
					console.log(data);
					$('#resText').empty();
					var html='';
				//	$.each(data,function(commentIndex,comment){
					
				//		alert(comment.omap);
				//	});
						for(var key in data.omap){
   							alert(key+"--"+data.omap[key]);
						}
					}
				});
			});
		})
		
	</script>

  </head>
  
  <body>
  <form action="<%=path%>/showTable.action" method="post" >
  	<input type="text" name="sqtype"/>
  	<input type="text" name="sqnum"/>
  	<!-- <input type="submit" value="确定" id="send"/> -->
  	<a href="" id="send">submit</a>
  </form>
	<div id="resText">
		<table>
			
		</table>
	<img src="<%=path%>/img/progress1.png" width="100" height="20px"/>
	</div>
	
  </body>
</html>
