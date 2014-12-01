<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stu_ans.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <s:property value="#session.studentcontent.stuname" />
  <!-- <s:set value="#session.student.singleanswer" name="single" ></s:set>
    -->
   <s:iterator value="#session.singlelist" var="s" >
   	<s:property value="#s.sans" />
   </s:iterator>
   <s:iterator value="#session.multiplelist" var="m" >
   	<s:property value="#m.mans" />
   </s:iterator>
   <s:iterator value="#session.textlist" var="t" >
   	<s:property value="#t.tans" />
   </s:iterator>
   <s:iterator value="#session.listlist" var="l" >
   	<s:property value="#l.lans" />
   </s:iterator>
 
  </body>
</html>
