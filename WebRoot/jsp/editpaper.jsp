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

 <link rel="stylesheet" type="text/css" href="css/admin-styles.css">

  </head>
  
  <body>
    <div style="width:680px;margin:0 auto;">
    	
    	 <div id="sinquestion"><h3 class="questiontype">一、单选题</h3>
    		<s:iterator value="#session.sqsinlist" var="q">
    		<div class="question area single" >
    			<div class="question title bold" style="float:left;width:480px;margin-right:20px">
    				<span><s:property value="#q.sqnum" />.</span>
    				<span class="questiontitle"><s:property value="#q.sque" /></span>
    			</div>
    			<div style="float:left;padding-right:20px" class="showoption pointer">
    				<span style="font-size:15px;color:#8C8C96">显示选项</span>
    				<img src="<%=path%>/img/arrowsdown.gif" style="width:10px;height:10px"/>
    			</div>
    			<div style="float:left;padding-right:20px;" class="hideoption pointer hide">
    				<span style="font-size:15px;color:#8C8C96">隐藏选项</span>
    				<img src="<%=path%>/img/arrowsup.gif" style="width:10px;height:10px"/>
    			</div>
    			
    			<div style="float:left"><button onclick="edit(this,<s:property value="#q.sqnum" />,1)" class="editbutton">编辑</button></div>	
    			<div style="clear:both"></div>
    			<s:set value="#session.qsinmap[#q.sqnum]" var="selectlist"/>
    			<div class="option hide">
	    			 <s:iterator value="#selectlist" var="seitem">
	    				
	    				 <div class="question select" >
	    				 		<span class="optionitem"><s:property value="#seitem.item"/>、</span>
	    				 		<span class="optioncontent"><s:property value="#seitem.sqoption"/></span>
	    						<span class="optiontype hide"><s:property value="#seitem.optiontype"/></span>
	    				</div>
	    			</s:iterator> 
    			</div>

	    		<div><hr/></div>
    		</div>
    		</s:iterator>
    	</div>
    	
    	
    	<div id="mulquestion"><h3 class="questiontype" >二、多选题</h3>
    		<s:iterator value="#session.sqmullist" var="q">
    		<div class="question area multiple" >
    			<div class="question title bold" style="width:480px;float:left;margin-right:20px;">
    				<span><s:property value="#q.sqnum" />.</span>
    				<span class="questiontitle"><s:property value="#q.sque" /></span>
    			</div>
    			<div style="float:left;padding-right:20px" class="showoption pointer">
    				<span style="font-size:15px;color:#8C8C96">显示选项</span>
    				<img src="<%=path%>/img/arrowsdown.gif" style="width:10px;height:10px"/>
    			</div>
    			<div style="float:left;padding-right:20px;" class="hideoption pointer hide">
    				<span style="font-size:15px;color:#8C8C96">隐藏选项</span>
    				<img src="<%=path%>/img/arrowsup.gif" style="width:10px;height:10px"/>
    			</div>
    			
    			<div style="float:left"><button onclick="edit(this,<s:property value="#q.sqnum" />,2)">编辑</button></div>	
    			<div style="clear:both"></div>
    			<s:set value="#session.qmulmap[#q.sqnum]" var="selectlist"/>
    			<div class="option hide">
    			  <s:iterator value="#selectlist" var="seitem">
    				
    				
    				<div class="question select" >
	    				 		<span class="optionitem"><s:property value="#seitem.item"/>、</span>
	    				 		<span class="optioncontent"><s:property value="#seitem.sqoption"/></span>
	    						<span class="optiontype hide"><s:property value="#seitem.optiontype"/></span>
	    			</div>
    			  </s:iterator> 
    			</div>
    	
    		<div><hr/></div>
    		</div>
    		</s:iterator>
    	</div>	
    	
    	<div id="textquestion"><h3 class="questiontype">三、简答题</h3>
    		<s:iterator value="#session.textlist" var="q">
    		<div class="question area textquestion" qnum="<s:property value="#q.sqnum" />">
    			<div class="question title bold" style="width:600px;float:left;">
    				<span><s:property value="#q.sqnum" />.</span>
    				<span class="questiontitle"><s:property value="#q.sque" /></span>
    			</div>
    			<div style="float:left"><button onclick="edit(this,<s:property value="#q.sqnum" />,3)">编辑</button></div>	
    			<div style="clear:both"></div>
    		</div>
    		<div><hr/></div>
    		</s:iterator>
    	</div>	
    	
    	<div id="listquestion"><h3 class="questiontype">四、列举题</h3>
    		<s:iterator value="#session.listlist" var="q">
    		<div class="question area list" qnum="<s:property value="#q.sqnum" />">
    			<div class="question title bold" style="width:600px;float:left;">
    				<span><s:property value="#q.sqnum" />.</span>
    				<span class="questiontitle"><s:property value="#q.sque" /></span>
    			</div>
    			<div style="float:left"><button onclick="edit(this,<s:property value="#q.sqnum" />,4)">编辑</button></div>	
    			<div style="clear:both"></div>
    		</div>
    		<div><hr/></div>
    		</s:iterator>
    	</div>
    	

    </div>
        	<div class="cover hide">
    	</div>
    	
    	<div class="editwin hide" >
    	
    		<div  style="width:100%;height:20px; background-color:#9EDBFA;border-bottom:3px groove  #FFFFFF;" >
               <label style="float:left;font-weight:700;color:#5F5F5F;padding-left:10px;">题目编辑框</label>
               <div onClick="closeShow()" style="font-size:15px;cursor:pointer;float:right;height:20px">
                    	 <img src="<%=path%>/img/close.gif" style="width:20px;height:20px;"/>
                    	 <div style="padding-right:10px;padding-top:2px;float:right;">关闭</div>
               </div>
               <div style="clear:both;"></div>
        	</div>

	    	 <div class="editdiv">
	    		<form action="<%=path%>/question_updateQuestion.action" method="post" id="editform">
	    			<input type="hidden" value="" name="questionnum" />
		    		<input type="hidden" value="" name="questiontype" />
		    		<input type="hidden" value="" name="optioncount" />	
	    			<div class="editform">
	    				<div class="editquestiontitle"></div>
		    			<div>	
		    				<span class="beforecontent">题目：</span>
		    				<span class="content" id="questiontitle"></span>
		    				<button type="button" onclick="alter(this,0)">修改</button>
		    			</div>
		    			<div class="editoption">
		    			
		    			</div>
		    			<button type="button" onclick="deloption(this)" id="delbut">删除选项</button>
		    			<button type="button" onclick="addoption(this)" id="addbut">增加选项</button>
		    			<input type="submit" value="保存" />
	    			</div>
	    		</form>
	    	 </div>	  
	    	 
    	</div>
    
  </body>
</html>
