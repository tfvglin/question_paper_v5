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
<script src="js/jquery-answer.js" type="text/javascript"></script>
 <link rel="stylesheet" type="text/css" href="css/admin-styles.css">

  </head>
  
  <body>
    <div style="width:680px;margin:0 auto;">
    	
    	 <div id="sinquestion"><h3 class="questiontype">一、单选题</h3>
    		<s:iterator value="#session.sqsinlist" var="q">
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
	    		<button class="all">总体情况</button>
	    		<button class="sex">男女情况</button>	
	    		<button class="hukou">农村城镇情况</button>	
	    		<s:url var="selshowchart" action="showChart.action" escapeAmp="false">
	    			<s:param name="sqtype" value="1"/>
					<s:param name="sqnum" value="%{#q.sqnum}" />
	    		</s:url>
	    		<s:url var="selshowchartbysex" action="showChartBySex.action" escapeAmp="false">
	    			<s:param name="sqtype" value="1"/>
					<s:param name="sqnum" value="%{#q.sqnum}" />
	    		</s:url>
	    		<s:url var="selshowchartbyhukou" action="showChartByHukou.action" escapeAmp="false">
	    			<s:param name="sqtype" value="1"/>
					<s:param name="sqnum" value="%{#q.sqnum}" />
	    		</s:url>
	    		<div class="chartall hide"><img src="<s:property value="selshowchart"/>" /></div>
	    		
	    		<div class="chartsex hide">
	    			<img src="<s:property value="selshowchartbysex"/>&sex=1" />
	    			<img src="<s:property value="selshowchartbysex"/>&sex=0" />
	    		</div>
	    		<div class="charthukou hide">
	    			<img src="<s:property value="selshowchartbyhukou"/>&hukou=1" />
	    			<img src="<s:property value="selshowchartbyhukou"/>&hukou=0" />
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
    		<button class="all">总体情况</button>
	    	<button class="sex">男女情况</button>	
	    	<button class="hukou">农村城镇情况</button>
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
    		<div><hr/></div>
    		</div>
    		</s:iterator>
    	</div>	
    	
    </div>
  </body>
</html>
