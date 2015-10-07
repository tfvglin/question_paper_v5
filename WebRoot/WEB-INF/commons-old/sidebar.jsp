<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

	<div style=" height:100%">
		<div class="center" style="padding-top:15px">
		<ul >
			<li  class="dropdown"><a>结果管理</a>
				<ul class="childmenu hide">
					<li><a href="<%=path%>/adminuser_resultQuestion.action">结果导出</a></li>
					<li><a href="<%=path%>/adminuser_creatChart.action">生成图表</a></li>
					
				</ul>
			</li>
			<li  class="dropdown"><a>题目管理</a>
				<ul class="childmenu hide">
					<li><a href="<%=path%>/adminuser_addQuestion.action">增加题目</a></li>
					<li><a href="<%=path%>/adminuser_editQuestion.action">编辑题目</a></li>
					
				</ul>
			</li>
			<li  class="dropdown"><a>学生管理</a>
				<ul class="childmenu hide">
					<li><a href="<%=path%>/adminuser_showStudents.action">所有学生</a></li>
					<li><a href="<%=path%>/adminuser_showAnswerStudents.action">答题学生</a></li>
					<li><a href="<%=path%>/adminuser_drawPaper.action">抽奖</a></li>
				</ul>
			</li>
		</ul>
		</div>
	</div>

