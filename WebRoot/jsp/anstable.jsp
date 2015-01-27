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
	    		<button class="all" style="float:left;margin-left:2px;" onclick="totaltable(1,<s:property value='#q.sqnum '/>)">总体情况</button>
	    		<button class="sex" style="float:left;margin-left:10px;">男女情况</button>	
	    		<button class="hukou" style="float:left;margin-left:10px;">农村城镇情况</button>	

				<div style="clear:both;"></div>
	    		<div style="float:left;padding-top:6px;">
	    		<s:select id="singlequestiondepartment%{#q.sqnum}" list="#session.departmentmap"  headerKey="" headerValue="--选择学院--"></s:select> 
	    	
				</div>	
				<button style="float:left;margin-left:10px;margin-top:6px;" class="department" onclick="checkdepartment(1,<s:property value='#q.sqnum '/>)">学院情况</button>
	    		<div style="clear:both;"></div>
	    		<div style="float:left;padding-top:6px;">
	    			<s:select id="singlequestionmarjor%{#q.sqnum}" list="#session.marjormap"  headerKey="" headerValue="--选择专业--"></s:select> 
	    	
				</div>	
				<button style="float:left;margin-left:10px;margin-top:6px;" class="marjor" onclick="checkmarjor(1,<s:property value='#q.sqnum '/>)">专业情况</button>
	    		<div style="clear:both;"></div>
	    		<div style="float:left;padding-top:6px;">
	    			<s:select id="singlequestionprovince%{#q.sqnum}" list="#session.provincemap"  headerKey="" headerValue="--选择省份--"></s:select> 
	    	
				</div>	
				<button style="float:left;margin-left:10px;margin-top:6px;" class="province" onclick="checkprovince(1,<s:property value='#q.sqnum '/>)">省份情况</button>
	    		<div style="float:right;padding-left:10px;" class="pointer">
	    			<span style="font-size:15px;color:#8C8C96">收起图表</span>
    				<img src="<%=path%>/img/arrowsup.gif" style="width:10px;height:10px"/>
    			</div>
	    		<div style="clear:both;"></div>
    			<div class="firsttable">
    				<table id="firsttable<s:property value='#q.sqnum '/>" class="table">
    				</table>
    			</div>	
    			<div>
    				<table id="secondtable">
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
    		<button class="all" style="float:left;margin-left:2px;">总体情况</button>
	    	<button class="sex" style="float:left;margin-left:10px;">男女情况</button>	
	    	<button class="hukou" style="float:left;margin-left:10px;">农村城镇情况</button>
	  		<div style="clear:both;"></div>
	    	<div style="float:left;padding-top:6px;">
	    		<s:select id="multiplequestiondepartment%{#q.sqnum}" list="#session.departmentmap"  headerKey="" headerValue="--选择学院--"></s:select> 
	    	
			</div>	
			<button style="float:left;margin-left:10px;margin-top:6px;" class="department" onclick="checkdepartment(2,<s:property value='#q.sqnum '/>)">学院情况</button>
	    	<div style="clear:both;"></div>
	    	<div style="float:left;padding-top:6px;">
	    		<s:select id="multiplequestionmarjor%{#q.sqnum}" list="#session.marjormap"  headerKey="" headerValue="--选择专业--"></s:select> 
	    	
			</div>	
			<button style="float:left;margin-left:10px;margin-top:6px;" class="marjor" onclick="checkmarjor(2,<s:property value='#q.sqnum '/>)">专业情况</button>
	    	<div style="clear:both;"></div>
	    	<div style="float:left;padding-top:6px;">
	    		<s:select id="multiplequestionprovince%{#q.sqnum}" list="#session.provincemap"  headerKey="" headerValue="--选择省份--"></s:select> 
	    	
			</div>	
			<button style="float:left;margin-left:10px;margin-top:6px;" class="province" onclick="checkprovince(2,<s:property value='#q.sqnum '/>)">省份情况</button>
	    	<div style="float:right;padding-left:10px;" class="pointer">
	    		<span style="font-size:15px;color:#8C8C96">收起图表</span>
    			<img src="<%=path%>/img/arrowsup.gif" style="width:10px;height:10px"/>
    		</div>
	    	<div style="clear:both;"></div>	<div style="clear:both;"></div>
    		<s:url var="mulshowchart" action="showChart.action" escapeAmp="false">
    			<s:param name="sqtype" value="2"/>
				<s:param name="sqnum" value="%{#q.sqnum}" />
    		</s:url>
    		<s:url var="mulshowchartsex" action="showChartBySex.action" escapeAmp="false">
    			<s:param name="sqtype" value="2"/>
				<s:param name="sqnum" value="%{#q.sqnum}" />
    		</s:url>
    		<s:url var="mulshowcharthukou" action="showChartByHukou.action" escapeAmp="false">
    			<s:param name="sqtype" value="2"/>
				<s:param name="sqnum" value="%{#q.sqnum}" />
    		</s:url>
    		<div class="chartall hide">
    				<img src="<s:property value="mulshowchart"/>" />
    		</div>
    		<div class="chartsex hide">
	    			<img src="<s:property value="mulshowchartsex"/>&sex=1" />
	    			<img src="<s:property value="mulshowchartsex"/>&sex=0" />
	    	</div>
	    	<div class="charthukou hide">
	    			<img src="<s:property value="mulshowcharthukou"/>&hukou=1" />
	    			<img src="<s:property value="mulshowcharthukou"/>&hukou=0" />
	   		</div>
	   		<div class="chartdepartment hide">
	    		<img id="multiplequestiondepartmentchart<s:property value='#q.sqnum'/>" src="" />
	    	</div>
	    	<div class="chartmarjor hide">
	    		<img id="multiplequestionmarjorchart<s:property value='#q.sqnum'/>" src="" />
	    	</div>
	    	<div class="chartprovince hide">
	    		<img id="multiplequestionprovincechart<s:property value='#q.sqnum'/>" src="" />
	    	</div>	
    		<div><hr/></div>
    		</div>
    		</s:iterator>
    	</div>	
    	
    </div>
  </body>
</html>
