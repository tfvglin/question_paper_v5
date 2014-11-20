<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

	<div style=" height:100%">
		<div class="center" style="padding-top:15px">
		<ul style="padding:0 auto;margin:0 auto">
			<li  class="dropdown"><a href="<%=path%>/adminuser_resultquestion.action">查询结果</a></li>
			<li  class="dropdown"><a>题目管理</a>
				<ul class="childmenu hide">
					<li><a href="<%=path%>/adminuser_addquestion.action">增加题目</a></li>
					<li><a href="">删除题目</a></li>
					<li><a href="">修改题目</a></li>
				</ul>
			</li>
		</ul>
		</div>
	</div>

