<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

 
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>西安电子科技大学本科招生调查问卷</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="西电,招生,调查问卷"/>
	<meta http-equiv="description" content="本科调查问卷"/>
	<meta name="viewport" content="width = device-width,initial-scale =1.0,minimum-scale=1.0,maximum-scale=1.0"/>
	
	
	<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
	<script src="js/jquery-question.js" type="text/javascript"></script>
	<script src="js/jquery-style.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/paper-styles.css"/>


  </head>
  
  <body>
  <s:debug></s:debug>
  <div class="center" align="center" style="width:90%;padding-top: 30px;padding-bottom: 30px;" id="all">
  <h1>新生调查问卷 </h1><br/>
  <s:form name="reform" action="answer_add.action" method="post" theme="simple">
 	<s:token></s:token>
 	<s:actionmessage cssStyle="color:red"/><s:fielderror cssStyle="color:red" />
 	  <s:hidden name="stuname" value="%{#parameters.stuname}" id="stuname" />
 	  <s:hidden name="stunum" value="%{#parameters.stunum}"/> 
 	<s:property value="%{#parameters.stuname}"/>同学，你好！感谢你对本次问卷调查的积极参与！
 	<div style="margin: 10px"></div>
 	<div class="bold">联系电话： <input type="text" name="phone" id="phone" value="请填写联系电话" class="graytips"/><span style="color:red;">*</span></div>
   
    <div id="sinquestion"><h3 class="questiontype">一、单选题</h3>
    		<s:iterator value="#session.sqsinlist" var="q">
    		<div class="question area single" qnum="<s:property value="#q.sqnum" />" >
    			<div class="question title bold"><s:property value="#q.sqnum" />.<s:property value="#q.sque" /></div>
    			<s:set value="#session.qsinmap[#q.sqnum]" var="selectlist"/>
    			
    			  <s:iterator value="#selectlist" var="seitem">
    				
    				 <div class="question select" qnum="<s:property value="#q.sqnum" />">
    				 		
    				 		<input type="radio" 
    				 			 name="sinquestion<s:property value="#q.sqnum"/>" 
    				 			 id="sinq<s:property value="#q.sqnum"/>_<s:property value="#seitem.item"/>" 
    				 			 value="<s:property value="#seitem.item"/>"
    				 			 class="select" optiontype="<s:property value="#seitem.optiontype"/>" />
    				 		<label for="sinq<s:property value="#q.sqnum"/>_<s:property value="#seitem.item"/>"><s:property value="#seitem.sqoption"/></label>
    			 			<s:if test="#seitem.optiontype==1">
    			 				<input type="text" value="请注明..." class="other graytips" 
    			 					 name="sinquestion<s:property value="#q.sqnum"/>other"/>
    			 			</s:if>
    			 	
    			 	</div>
    			</s:iterator> 
    		</div>	
    		<div><hr/></div>
    		</s:iterator>
    	</div>	
    	
    	<div id="mulquestion"><h3 class="questiontype" >二、多选题</h3>
    		<s:iterator value="#session.sqmullist" var="q">
    		<div class="question area multiple" qnum="<s:property value="#q.sqnum" />">
    			<div class="question title bold"><s:property value="#q.sqnum" />.<s:property value="#q.sque" /></div>
    			<s:set value="#session.qmulmap[#q.sqnum]" var="selectlist"/>
    			
    			  <s:iterator value="#selectlist" var="seitem">
    				
    				 <div class="question select" qnum="<s:property value="#q.sqnum" />">
    				 
    				 <input type="checkbox" 
    				 			 name="mulquestion<s:property value="#q.sqnum"/>" 
    				 			 id="mulq<s:property value="#q.sqnum"/>_<s:property value="#seitem.item"/>" 
    				 			 value="<s:property value="#seitem.item"/>"
    				 			 class="select" optiontype="<s:property value="#seitem.optiontype"/>" />
    				 	<label for="mulq<s:property value="#q.sqnum"/>_<s:property value="#seitem.item"/>"><s:property value="#seitem.sqoption"/></label>
    			 		<s:if test="#seitem.optiontype==1">
    			 		<input type="text" value="请注明..." class="other graytips" 
    			 					 name="mulquestion<s:property value="#q.sqnum"/>other"/>
    			 		</s:if>
    			 	
    			 	</div>
    			</s:iterator> 
    		</div>	
    		<div><hr/></div>
    		</s:iterator>
    	</div>	
    	
    	<div id="textquestion"><h3 class="questiontype">三、简答题(选填)</h3>
    		<s:iterator value="#session.textlist" var="q">
    		<div class="question area textquestion" qnum="<s:property value="#q.sqnum" />">
    			<div class="question title bold"><s:property value="#q.sqnum" />.<s:property value="#q.sque" />（请填写300字以内）</div>
    			
    			 	
    		 <div><textarea cols="25" rows="5"  
    		 				name="textquestion<s:property value="#q.sqnum" />" 
    		 				id="textq<s:property value="#q.sqnum" />" 
    		 				class="text"></textarea>
    						
    			</div>
    			</div>
    		<div><hr/></div>
    		</s:iterator>
    	</div>	
    	
    	<div id="listquestion"><h3 class="questiontype">四、列举题</h3>
    		<s:iterator value="#session.listlist" var="q">
    		<div class="question area list" qnum="<s:property value="#q.sqnum" />">
    			<div class="question title bold"><s:property value="#q.sqnum" />.<s:property value="#q.sque" />（没有请在第一个输入框中填写“无”）</div>
    			<div class="textfile">
    			 <div class="option" order="1"><input type="text" name='listquestion<s:property value='#q.sqnum' />_1' id="listq<s:property value="#q.sqnum" />_1" class="listtext"/>  </div>
    			</div>
    			<button type='button' class='addtextfile'>添加输入框</button>
    			<input type="hidden" name="optionnum" value="1" /> 
    			<input type="hidden" name="listqnum" value="<s:property value="#q.sqnum" />" /> 
    			</div>
    		<div><hr/></div>
    		</s:iterator>
    	</div>	
    	 <div><p style="color:#C4C4C4;font-size:30px;align:center">问卷到此结束，感谢作答！</p> </div>	
    	<s:submit value="提交问卷" id="papersubmit"></s:submit>
    </s:form>
    </div>
    <div align="center"><s:include value="footer.jsp"></s:include>	</div>	
  </body>
</html>
    			 	