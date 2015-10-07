<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page session="false" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<s:set value="com.opensymphony.xwork2.ActionContext.name"  name="actionname" ></s:set>
<s:url var="firstPage" action="%{#actionname}" >
	<s:param name="PageIndex" value="1"></s:param>
</s:url>
<s:a href="%{firstPage}">首页</s:a>

<s:if test="#session.pager.firstPage==false">
	<s:url id="prePage" action="%{#actionname}">
		<s:param name="PageIndex" value="#session.pager.prePageIndex" ></s:param>
	</s:url>
	<s:a href="%{prePage}">上一页</s:a>
</s:if>
<s:else>上一页</s:else>

<s:if test="#session.pager.lastPage==false">
	<s:url id="nextPage" action="%{#actionname}" >
		<s:param name="PageIndex" value="#session.pager.nextPageIndex" ></s:param>
	</s:url>
	<s:a href="%{nextPage}">下一页</s:a>
</s:if>
<s:else>下一页</s:else>
<s:url id="lastPage" action="%{#actionname}" >
	<s:param name="PageIndex" value="#session.pager.pageCount"></s:param>
</s:url>
<s:a href="%{lastPage}">末页</s:a>

	
	<s:url var="jumpPage" action="%{actionname}" >
		<s:param name="PageIndex" value="%{pageindex}"></s:param>
	</s:url>
	<s:property  value="javascript:document.getElementById('pageN').value;"/>
	<s:a href="#" onclick="javascript:location.href='%{actionname}?PageIndex='+document.getElementById('pageN').value;return false;">转到</s:a>
	<s:textfield id="pageN" name="pageIndex" var="pageindex" maxLength="3" style="width:25px"/>页
	
	共<s:property value="#session.pager.pageCount" />页
