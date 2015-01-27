<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


	<div class="center" style="width:600px;margin-top:10px;">
  	
	<div style="margin-top:20px;">
		<div style="display:inline-block;"><a href="<%=path%>/adminuser_creatExcel.action" ><button >生成最新excel表</button></a></div>
		<div style="display:inline-block;margin-left:20px;"><a href="<%=path%>/data/answer.xls"><input type="button" value="下载表格"/></a></div> 
	</div>
  		<table class="bordered" style="text-align:center;">
   		 	<caption align="top" style="font-size:20px;">答题人数统计表</caption>
   		 <thead>

     		<tr >
  				<th>类别</th>
  				<th>人数</th>
  			</tr>
  			<tr>
  				<td style="font-family:黑体;">总计</td>
  				<td><s:property value="#session.all"/></td>
  			</tr>
  			<tr>
  				<td class="classtitle" colspan="2">户口</td>
  			</tr>
  			<tr>
  				<td>城镇户口</td>
  				<td><s:property value="#session.city"/></td>
  			</tr>
  			<tr>
  				<td>农村户口</td>
  				<td><s:property value="#session.country"/></td>
  			</tr>
  			<tr>
  				<td class="classtitle" colspan="2">性别</td>
  			</tr>
  			<tr>
  				<td>男生</td>
  				<td><s:property value="#session.boy"/></td>
  			</tr>
  		    <tr>
  				<td>女生</td>
  				<td><s:property value="#session.girl"/></td>
  			</tr>
  			<tr>
  				<td class="classtitle" colspan="2">学院</td>
  			</tr>
  			<tr>
  				<td>电子工程</td>
  				<td><s:property value="#session.department['电子工程']" /> 
  			</tr>
  			<tr>
  				<td>通信工程</td>
  				<td><s:property value="#session.department['通信工程']" /> 
  			</tr>
  			<tr>
  				<td>计算机</td>
  				<td><s:property value="#session.department['计算机']" /> 
  			</tr>
  			<tr>
  				<td>物理与光电工程</td>
  				<td><s:property value="#session.department['物理与光电工程']" /> 
  			</tr>
  			<tr>
  				<td>机电工程</td>
  				<td><s:property value="#session.department['机电工程']" /> 
  			</tr>
  			<tr>
  				<td>微电子</td>
  				<td><s:property value="#session.department['微电子']" /> 
  			</tr>
  			<tr>
  				<td>软件</td>
  				<td><s:property value="#session.department['软件']" /> 
  			</tr>
  			<tr>
  				<td>空间科学与技术</td>
  				<td><s:property value="#session.department['空间科学与技术']" /> 
  			</tr>
  			<tr>
  				<td>数学与统计</td>
  				<td><s:property value="#session.department['数学与统计']" /> 
  			</tr>
  			<tr>
  				<td>先进材料与纳米科技</td>
  				<td><s:property value="#session.department['先进材料与纳米科技']" /> 
  			</tr>
  			<tr>
  				<td>人文</td>
  				<td><s:property value="#session.department['人文']" /> 
  			</tr>
  			<tr>
  				<td>经济与管理</td>
  				<td><s:property value="#session.department['经济与管理']" /> 
  			</tr>
  			<tr>
  				<td>国际教育</td>
  				<td><s:property value="#session.department['国际教育']" /> 
  			</tr>


	</table>
  		
</div>