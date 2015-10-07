<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<nav class="navbar navbar-default">
  <div class="container-fluid">
   
   

   

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class=""><a href="#">基本信息</a></li>
        <li class=""><a href="#">结果概况</a></li>
        <li class=""><a href="#">题目管理</a></li>
        <li class=""><a href="#">学生管理</a></li>
       </ul>
	
      <ul class="nav navbar-nav navbar-right ">
      	<li><p class="navbar-text"><small>当前用户：</small></p></li>
        <li><a class="" href="#">注销</a></li>
      </ul>
   
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

  	

