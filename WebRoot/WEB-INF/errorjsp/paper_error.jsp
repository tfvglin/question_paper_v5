<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>404error page</title>
    
		<meta name="viewport" content="width = device-width,initial-scale =1.0,minimum-scale=1.0,maximum-scale=1.0"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 		
 		<div style="width:400px ;margin:0 auto;" align="center">
 		<img src="<%=path%>/img/404error.jpg" alt="404error"/>
  
    	<div>出错了！页面不存在，检查地址是否输入正确！</div>
    	<div><a href="javascript:history.go(-1)">返回上一页</a></div>
    	</div>
  </body>
</html>
