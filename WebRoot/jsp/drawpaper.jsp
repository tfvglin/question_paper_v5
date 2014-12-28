<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



    <div class="center" style="width:350px;margin-top:10px;">
 	<form action="creatDrawPaper.action" method="post">
 		
		<div>抽取人数：</div>
		<input type="text" name="count"/>
		<input type="submit" value="开始抽奖"/>
 	</form>
 	</div>

