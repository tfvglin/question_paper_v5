<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stu_list.jsp' starting page</title>
    
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
  <div style="height:500px; width: 600px; margin:10px auto;  " >
   <center>
   	<b>学生资料</b>
   	
   		<table  border="1" width="600px" class="stutable">
   			<tr>
   				<td>
   					<b>序号</b>
   				</td>
   				<td>
   					<b>姓名</b>
   				</td>
   			
   				<td>
   					<b>身份证</b>
   				</td>
   				<td>
   					<b>院系</b>
   				</td>
   			
   				<td align="center">
   					<b>操作</b>
   				</td>
   			</tr>
   			<s:iterator value="#session.pager.smallList" var="s" >
   			<tr>
   				<td>
   					<s:property value="#s.ID" />
   				</td>
   				<td>
   					<s:property value="#s.stuname" />
   				</td>
   			
   				<td>
   					<s:property value="#s.cardid" />
   				</td>
   				<td>
   					<s:property value="#s.studepartment" />
   				</td>
   

   				<td align="center">
   					<b>..</b>
   				</td>	
   				</tr>
   			</s:iterator>
   		</table>
   		<s:include value="pager.jsp"></s:include>
 
   </center>
   </div>
  </body>
</html>
