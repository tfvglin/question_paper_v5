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
    <s:set value="#session.singlemap" var="sa"  ></s:set>
    <s:set value="#session.multiplemap" var="ma" ></s:set>
    <s:set value="#session.textmap" var="ta" ></s:set>
    <s:set value="#session.listmap" var="la" ></s:set>
 
  </head>
  
  <body>
  <div>姓名： <s:property value="#session.studentcontent.stuname" /></div>
  <div>答题时间： <s:property value="#session.studentcontent.time" /></div>
  <div>联系方式： <s:property value="#session.studentcontent.phone" /></div>


 <div><h5>一、单选题</h5></div>
 <div>
   <s:iterator value="#session.sqsinlist" var="sq" >
   <div><s:property value="#sq.sqnum" />、<s:property value="#sq.sque" /></div>
   <div>答案：<s:property value="#sa[#sq.sqnum].sans"/></div>
   <div>
  	 <s:if test="#sa[#sq.sqnum].other!=''">
		其他：<s:property value="#sa[#sq.sqnum].other"/>
  	 </s:if>
   </div>
   </s:iterator>
 </div>   
   <div><h5>二、多选题</h5></div>    
   <s:iterator value="#session.sqmullist" var="mq" >
   	<div><s:property value="#mq.sqnum" />、<s:property value="#mq.sque" /></div>
   	<div>答案：<s:property value="#ma[#mq.sqnum].mans"/></div>
	  <div>
  	 <s:if test="#ma[#mq.sqnum].other!=''">
		其他：<s:property value="#ma[#mq.sqnum].other"/>
  	 </s:if>
   </div>   
   </s:iterator>
  
  <div><h5>三、简答题</h5></div>  
   <s:iterator value="#session.textlist" var="tq" >
   <div><s:property value="#tq.sqnum" />、<s:property value="#tq.sque" /></div>
   	<div>答案：<s:property value="#ta[#tq.sqnum].tans"/></div>
    </s:iterator>    
  
  
  <div><h5>四、列举题</h5></div>  
   <s:iterator value="#session.listlist" var="lq" >
   <div><s:property value="#lq.sqnum" />、<s:property value="#lq.sque" /></div>
   	<div>答案：<s:property value="#la[#lq.sqnum].lans"/></div>
   </s:iterator>

 
 
 
  </body>
</html>
