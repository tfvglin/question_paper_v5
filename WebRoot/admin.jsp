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
    <div class="center">
    <fieldset >
    	<legend align="left">身份认证</legend>
    	<s:form action="admin_login.action"  method="post" theme="simple">
    		<div><label for="adminname">用户名：</label><s:textfield name="adminname" id="adminname"></s:textfield></div>
    		<div><label for="adminpassword">密&nbsp&nbsp码：</label><s:password name="adminpassword" id="adminpassword" ></s:password></div>
    		<div><s:submit value="登陆"></s:submit> </div>
    	</s:form>
    </fieldset>	
    </div>
    <div align="center"><s:include value="jsp/footer.jsp"></s:include>	</div>	
  </body>
</html>
