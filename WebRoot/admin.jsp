<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>admin登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<meta http-equiv="description" content="admin page">
	
	<!--  <link rel="stylesheet" type="text/css" href="css/admin-styles.css">-->
	

  </head>
  
  <body>
  	<div style="width:1000px;margin:0 auto;">
    <div style="width:600px;height:100px;">
  		<img src="<%=path%>/img/schoollogo.gif" style="width:70px;height:70px;float:left;" />
  		<div style="float:left;font-size:50px;margin-top:6px;margin-left:10px;">新生调查问卷管理系统</div>
  		<div style="clear:both;"></div>
  	</div>
    
    	<div style="width:400px;">
    	<p>欢迎使用西安电子科技大学新生调查问卷后台管理系统</p>
    	</div>
	    <div class="center" style="margin:0 auto;width:300px;padding:10px 0;">
	    <fieldset   >
	    	<legend align="left">身份认证</legend>
	    	<s:form action="adminuser_login.action"  method="post" theme="simple">
	    		<div><label for="adminname">用户名：</label><s:textfield name="adminname" id="adminname"></s:textfield></div>
	    		<div><label for="adminpassword">密　码：</label><s:password name="adminpassword" id="adminpassword" ></s:password></div>
	    		<div><s:submit value="登陆"></s:submit> </div>
	    	</s:form>
	    </fieldset>	
	    </div>
    
    <div align="center"><s:include value="jsp/footer.jsp"></s:include>	</div>	
    </div>
  </body>
</html>
