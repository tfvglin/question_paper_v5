<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html style="height:100%">
  <head>
    <base href="<%=basePath%>"/>
    
    <title>本科招生情况调查问卷</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    

	<meta http-equiv="description" content="success"/>
	<meta name="viewport" content="width = device-width,initial-scale =1.0,minimum-scale=1.0,maximum-scale=1.0"/> 
	<meta http-equiv="refresh" content="4;url= http://zsxt.xidian.edu.cn "/>
	

	<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>

  </head>
  
  <body style="height:100%">
  <div style="width:60%;height:70%; margin:0 auto;padding-top:10%" align="center">
    
   
      <div><p style="color:#66FF66;font-size:150%;align:center;font-weight: 900">调查结果已提交，感谢你的参与！</p> </div>
      
      <div><p style="color:#C4C4C4;font-size:100%;align:center;">4秒后跳转到招生系统首页</p> </div>
 		<div><p style="color:#C4C4C4;font-size:100%;align:center;"><a href="http://zsxt.xidian.edu.cn">点击马上跳转</a></p></div>
 </div>
 <div align="center" style="width:100%;height:30%"><s:include value="jsp/footer.jsp"></s:include>	</div>	
  </body>
</html>
