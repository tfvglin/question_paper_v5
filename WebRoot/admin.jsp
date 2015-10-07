<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>admin登陆</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	
	<meta http-equiv="description" content="admin page"/>
	
	<!--  <link rel="stylesheet" type="text/css" href="css/admin-styles.css">-->
	

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
   				<h1><b style="border-right:2px solid #ADADAD;padding-right:10px;margin-right:10px;">本科招生情况调查问卷</b><small >后台管理</small></h1>
   				
   			 </div>
   			 	
			</div>
	    </div>
    	
    	<h3>欢迎使用西安电子科技大学新生调查问卷后台管理系统</h3>
    	
	   
	    	<form action="adminuser_login.action"  method="post" theme="simple">
			<div class="container" >
	    		<div class="row ">
					<div class="col-md-4 col-md-offset-4">
						<div class="input-group " style="margin:10px;">
			    			<span class="input-group-addon glyphicon  glyphicon-user"  ></span>
			    			<input class="form-control" type="text" name="adminname" id="adminname" placeholder="用户名" aria-describedby="adminname"/>
						</div>	
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
			    		<div class="input-group" style="margin:10px;">
			    			<span class="input-group-addon glyphicon  glyphicon-lock"  ></span>
			    			<input class="form-control" type="password" name="adminpassword" id="adminpassword" placeholder="密码" aria-describedby="adminname"/>
						</div>
					</div>	
				</div>
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
					<button type="submit" class="btn btn-default pull-right"	onclick="this.form.submit()" >管理员登录</button>	
	    			</div>
				</div>
			<%-- 	<div><label for="adminname">用户名：</label><s:textfield name="adminname" id="adminname"></s:textfield></div>
	    		<div><label for="adminpassword">密　码：</label><s:password name="adminpassword" id="adminpassword" ></s:password></div>
	    		<div><s:submit value="登陆"></s:submit> </div>
	    	 --%>
	    	</div>
	    	 </form>
	
	    </div>
    
    <div align="center" style="padding-top:30px"><s:include value="jsp/footer.jsp"></s:include>	</div>	
    
  </body>
</html>
