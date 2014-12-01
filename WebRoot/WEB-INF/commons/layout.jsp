<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理</title>
 	<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
	<script src="<%=path %>/js/jquery-admin.js" type="text/javascript"></script>
	
	  
<link rel="stylesheet" type="text/css" href="<%=path %>/css/admin-styles.css">
	

  </head>
  
  <body>
  	<div class="center" style="width:1000px;">
  		<div >
   			<tiles:insertAttribute name="HEADER" ></tiles:insertAttribute>
    	</div>
    	<div>
    	<div style="float: left;width:200px;height:600px;background-color:#FFFF99">
			<tiles:insertAttribute name="SIDEBAR" ></tiles:insertAttribute>
		</div>	
		<div style="float: left;width:800px;height:600px;background-color:#FFEBCD ;overflow-y:auto; overflow-x:auto;">	
			
			<tiles:insertAttribute name="CONTENT" ></tiles:insertAttribute>
			
		</div>
		</div>
		<div style="clear:both;text-align:center">	
    		<tiles:insertAttribute name="FOOTER" ></tiles:insertAttribute>
    	</div>	
    </div>	
    <s:debug></s:debug>
  </body>
</html>
