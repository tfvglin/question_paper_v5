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
    
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery-table.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/admin-styles.css">

  </head>
  
  <body>
    <div style="width:680px;margin:0 auto;">
    	<div>
    	 	<h3 class="questiontype">级联查询</h3>
    	 	<div style="float:left">
	    		<s:select id="cascadesex" list="#{1:'男',0:'女'}"  headerKey="unselected" headerValue="--选择性别--"></s:select>
	    		<s:select id="cascadehukou" list="#{1:'城镇',0:'农村'}"  headerKey="unselected" headerValue="--选择户口--"></s:select>
	    		<s:select id="cascadedepartment" list="#session.departmentmap"  headerKey="unselected" headerValue="--选择学院--"></s:select> 
	    		<s:select id="cascademarjor" list="#session.marjormap"  headerKey="unselected" headerValue="--选择专业--"></s:select> 
	    		<s:select id="cascadeprovince" list="#session.provincemap"  headerKey="unselected" headerValue="--选择省份--"></s:select>
	    		<s:select id="cascadesqtype" list="#{1:'单选',2:'多选'}" headerKey="" headerValue="--题目类别--"></s:select>
	    		题号：<input id="cascadesqnum" type="text" style="width:20px;">
    		</div>
    		<button style="float:left;" onclick="cascadetable(this)">查询</button>
    		<div style="clear:both;"></div>
    		<table id="cascadetable" class="table">
    		
    		</table>
    		<div id="remark" style="color:red;"></div>
    	</div>
    	 <div id="sinquestion"><h3 class="questiontype">一、单选题</h3>
    		<s:iterator value="#session.sqsinlist" var="q" >
    		<div class="question area single" >
    			<div class="question title bold"><s:property value="#q.sqnum" />.<s:property value="#q.sque" /></div>
    			<s:set value="#session.qsinmap[#q.sqnum]" var="selectlist"/>
    			
    			  <s:iterator value="#selectlist" var="seitem">
    				
    				 <div class="question select" >
    				 		<div><s:property value="#seitem.item"/>、<s:property value="#seitem.sqoption"/></div>
    				</div>
    			</s:iterator> 
    		</div>
    		<div>
	    		<button class="all" style="float:left;margin-left:2px;" onclick="totaltable(1,<s:property value='#q.sqnum '/>,this)">总体情况</button>
	    		<button class="sex" style="float:left;margin-left:10px;" onclick="sextable(1,<s:property value='#q.sqnum '/>,this)">男女情况</button>	
	    		<button class="hukou" style="float:left;margin-left:10px;" onclick="hukoutable(1,<s:property value='#q.sqnum '/>,this)">农村城镇情况</button>	

				<div style="clear:both;"></div>
	    		<div style="float:left;padding-top:6px;">
	    		<s:select id="singlequestiondepartment%{#q.sqnum}" list="#session.departmentmap"  headerKey="" headerValue="--选择学院--"></s:select> 
	    	
				</div>	
				<button style="float:left;margin-left:10px;margin-top:6px;" class="department" onclick="departmenttable(1,<s:property value='#q.sqnum '/>,this)">学院情况</button>
	    		<div style="clear:both;"></div>
	    		<div style="float:left;padding-top:6px;">
	    			<s:select id="singlequestionmarjor%{#q.sqnum}" list="#session.marjormap"  headerKey="" headerValue="--选择专业--"></s:select> 
	    	
				</div>	
				<button style="float:left;margin-left:10px;margin-top:6px;" class="marjor" onclick="marjortable(1,<s:property value='#q.sqnum '/>,this)">专业情况</button>
	    		<div style="clear:both;"></div>
	    		<div style="float:left;padding-top:6px;">
	    			<s:select id="singlequestionprovince%{#q.sqnum}" list="#session.provincemap"  headerKey="" headerValue="--选择省份--"></s:select> 
	    	
				</div>	
				<button style="float:left;margin-left:10px;margin-top:6px;" class="province" onclick="provincetable(1,<s:property value='#q.sqnum '/>,this)">省份情况</button>
	    		<div style="float:right;padding-left:10px;" class="pointer">
	    			<span style="font-size:15px;color:#8C8C96">收起图表</span>
    				<img src="<%=path%>/img/arrowsup.gif" style="width:10px;height:10px"/>
    			</div>
	    		<div style="clear:both;"></div>
    			
    			<div class="twotable hide" >
    				<table id="singlefirsttable<s:property value='#q.sqnum '/>" class="table">
    				</table>
    				<table id="singlesecondtable<s:property value='#q.sqnum '/>" class="table">
    				</table>
    			</div>	
    			
    			<div class="onetable hide">
    				<table id="singlethirdtable<s:property value='#q.sqnum '/>" class="table">
    				</table>
    			</div>

	    		<div><hr/></div>
    		</div>
    		</s:iterator>
    	</div>	
    	
    	<div id="mulquestion"><h3 class="questiontype" >二、多选题</h3>
    		<s:iterator value="#session.sqmullist" var="q">
    		<div class="question area multiple" >
    			<div class="question title bold"><s:property value="#q.sqnum" />.<s:property value="#q.sque" /></div>
    			<s:set value="#session.qmulmap[#q.sqnum]" var="selectlist"/>
    			
    			  <s:iterator value="#selectlist" var="seitem">
    				
    				 <div class="question select">
    					 <div><s:property value="#seitem.item"/>、<s:property value="#seitem.sqoption"/></div>
    				</div>
    			</s:iterator> 
    		</div>	
    		<div>
    			<button style="float:left;margin-left:2px;" onclick="totaltable(2,<s:property value='#q.sqnum '/>,this)">总体情况</button>
	    		<button class="sex" style="float:left;margin-left:10px;" onclick="sextable(2,<s:property value='#q.sqnum '/>,this)">男女情况</button>	
	    		<button class="hukou" style="float:left;margin-left:10px;" onclick="hukoutable(2,<s:property value='#q.sqnum '/>,this)">农村城镇情况</button>
	  			<div style="clear:both;"></div>
	    		<div style="float:left;padding-top:6px;">
	    			<s:select id="multiplequestiondepartment%{#q.sqnum}" list="#session.departmentmap"  headerKey="" headerValue="--选择学院--"></s:select> 
	    		</div>	
				<button style="float:left;margin-left:10px;margin-top:6px;" class="department" onclick="departmenttable(2,<s:property value='#q.sqnum '/>,this)">学院情况</button>
	    		<div style="clear:both;"></div>
	    		<div style="float:left;padding-top:6px;">
	    			<s:select id="multiplequestionmarjor%{#q.sqnum}" list="#session.marjormap"  headerKey="" headerValue="--选择专业--"></s:select> 
	    	
				</div>	
				<button style="float:left;margin-left:10px;margin-top:6px;" class="marjor" onclick="marjortable(2,<s:property value='#q.sqnum '/>,this)">专业情况</button>
	    		<div style="clear:both;"></div>
	    		<div style="float:left;padding-top:6px;">
	    			<s:select id="multiplequestionprovince%{#q.sqnum}" list="#session.provincemap"  headerKey="" headerValue="--选择省份--"></s:select> 
	    	
				</div>	
				<button style="float:left;margin-left:10px;margin-top:6px;" class="province" onclick="provincetable(2,<s:property value='#q.sqnum '/>,this)">省份情况</button>
	    		<div style="float:right;padding-left:10px;" class="pointer">
	    			<span style="font-size:15px;color:#8C8C96">收起图表</span>
    				<img src="<%=path%>/img/arrowsup.gif" style="width:10px;height:10px"/>
    			</div>
	    	
	    		<div style="clear:both;"></div>
	    		
	    		
    			<div class="twotable hide" >
    				<table id="multiplefirsttable<s:property value='#q.sqnum '/>" class="table">
    				</table>
    				<table id="multiplesecondtable<s:property value='#q.sqnum '/>" class="table">
    				</table>
    			</div>	
    			<div class="onetable hide">
    				<table id="multiplethirdtable<s:property value='#q.sqnum '/>" class="table">
    				</table>
    			</div>
    		<div><hr/></div>
    		</div>
    		</s:iterator>
    	</div>	
    	
    </div>
  </body>
</html>
