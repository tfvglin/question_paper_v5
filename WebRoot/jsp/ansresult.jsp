<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


	<div class="center" style="width:350px;margin-top:10px;">
  	<div style="margin-top:5px;">截止目前共有<s:property value="#session.c"/>人提交问卷 </div>
	<div style="margin-top:5px;"><a href="<%=path%>/adminuser_creatExcel.action" ><button >生成excel表</button></a></div>
	<div style="margin-top:5px;"><a href="D:\answer.xls"><input type="button" value="下载表格"/></a></div> 
  <s:set value="com.opensymphony.xwork2.ActionContext.name" var="action" name="actionname" ></s:set>
  <s:url var="firstPage" action="%{#actionname}" escapeAmp="false">
	<s:param name="PageIndex" value="1"></s:param>
	<s:param name="menuIndex" value="2" ></s:param>
</s:url>
  
 <!-- %#<s:property value="%{#firstPage}"/><br>
  #<s:property value="#firstPage"/><br>
--> 
 <div style="color:red"> <s:property value="firstPage"/> </div>
  	<hr>
  	  %#<s:property value="%{#action}"/><br>
  #<s:property value="#action"/><br>
  
  	</div>
<s:debug></s:debug>