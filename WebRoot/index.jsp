<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page session="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>西安电子科技大学本科招生情况调查问卷</title>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="description" content="调查问卷认证页面"/>
	<meta name="viewport" content="width = device-width,initial-scale =1.0,minimum-scale=1.0,maximum-scale=1.0"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
	<script src="js/jquery-style.js" type="text/javascript" charset="utf-8"></script>


  <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"></link></head>
  
  <body>
	<div class="container">
		<div class="page-header">
		
	    	<div class="media">
  			 <div class="media-left media-middle">
    			<a href="#">
     		 		<img src="img/xiaohui.png" ></img>
  				 </a>
 			 </div>
 			 <div class="media-body" style="padding-top:20px;">
   				<h1>本科招生情况调查问卷</h1>
   				
   			 </div>
   			 	
			</div>
	    </div>
	<div class="jumbotron">

	    	
	    	
	    	<p>亲爱的新同学：</p>
	    	<p>你们好！</p>
	    	<p>欢迎你们加入西安电子科技大学，成为“西电人”中的一员。</p>
	    	<p>西安电子科技大学是一所有着悠久历史的全国重点大学，一代一代西电学子和老师们共同谱写了西电的辉煌篇章。学校的发展与您息息相关，您的关心和支持无疑会帮助学校更快更好地发展。</p>
	    	<p>为了更好地做好学校本科招生宣传工作，吸引更多优秀考生报考我校，学校招生办公室设计了一份调查问卷。对于每个问题，您可以根据自己的情况单选或者多选，也可以在最后的横线上写出其他情况。请如实、认真地填写，以便我们科学决策。</p>
	    	<p>为感谢大家的支持，我们将在认真完成调查问卷的同学中进行抽奖活动：</p>
	    	<p>一等奖5名    xx</p>
	    	<p>二等奖10名   xx</p>
	    	<p>三等奖50名   xx</p>
	    	<p>感谢您的支持，预祝您在西电学习进步，实现人生路上更高更远的腾飞！</p>
	   </div>
	    	
	    	
	    		
	    		<div class="container-fluid">
	    			<fieldset >
    				<legend align="left">身份认证</legend>
	    			<form  name="loginform" action="begin.action" method="post" id="form">
					<s:actionmessage cssStyle="color:red"/><s:fielderror cssStyle="color:red" />
	    			<div class="row">
	    			<div class="col-md-5">
	    			<div class="input-group" style="margin:10px;">
	    				 <span class="input-group-addon glyphicon  glyphicon-user"  id="username"></span>
	    				<input class="form-control" type="text" name="stuname" id="stuname" placeholder="学生姓名" aria-describedby="username"/>
	
	    			</div>	
	    			</div>	
	    			<div class="col-md-5">
	    			<div class="input-group" style="margin:10px;">
	    					<span class="input-group-addon glyphicon glyphicon-tag"  id="username"></span>
	    					 <input class="form-control" type="text" name="cardid" id="cardid" placeholder="身份证号" aria-describedby="username"/>
	    			</div>
	    			</div>		
	    			</div>	
		
   						<button value="submit" class="btn btn-primary" onclick="document.getElementById('form').submit();">开始作答</button>
	    			
					</form>
					</fieldset>
	  			</div>
	     </div>
	     <div align="center"><s:include value="jsp/footer.jsp"></s:include>	</div>	
 	
  </body>
</html>
    		
