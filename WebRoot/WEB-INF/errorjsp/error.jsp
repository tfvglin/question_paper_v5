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
    
    <title>My JSP 'error.jsp' starting page</title>
    

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
    	出错了！页面不存在，检查地址是否输入正确！
    	<a href="javascript:history.go(-1)">返回</a>
  </body>
</html>
