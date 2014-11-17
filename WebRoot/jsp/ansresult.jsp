<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


	<div class="center" style="width:350px;margin-top:10px;">
  	<div style="margin-top:5px;">截止目前共有<s:property value="#session.c"/>人提交问卷 </div>
	<div style="margin-top:5px;"><a href="<%=path%>/admin_creatExcel.action" ><button >生成excel表</button></a></div>
	<div style="margin-top:5px;"><a href="D:\answer.xls"><input type="button" value="下载表格"/></a></div> 
  	</div>
