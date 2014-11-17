<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



    <div class="center" style="width:350px;margin-top:10px;">
 		<form action="question_add.action" method="post">
 		<select name="questiontype">
 			<option>--请选择--</option>
  			 <option value ="1">单选题</option>
 			 <option value ="2">多选题</option>
 			 <option value="3">简答题</option>
 			 <option value="4">列举题</option>
		</select>
		<div class="addform">
	<!--    	<div id='singlequestion' class='select'>
			<div>题目：<input type='text' name='questioncontent' ></div>
			<div class='option'>
				<div order='1' other='false'>
					选项1:<input name='optioncontent' type='text' />
					<input class='optiontype' type='hidden' name='1optiontype' value='0'/>
					<button type='button' class='addother'>添加备注</button>
				</div>
			</div>
			<input type='hidden' name='optionnum' value='1'/>
			<button type='button' class='addoption'>增加选项</button>
			<button type='button' class='deloption'>删除选项</button>
			
		</div>
		<div id='multiplequestion' class='select'>
			<div>题目：<input type='text' name='questioncontent' id='multiplequestioncontent'></div>
			<div class='option'>
				<div order='1' other='false'>
					选项1:<input name='optioncontent' type='text' >
					<input class='optiontype'  type='hidden' name='1optiontype' value='0'/>
					<button type='button' class='addother' >添加备注</button>
				</div>
			</div>
			<input type='hidden' name='optionnum' value='1'/>
			<button type='button' class='addoption'>增加选项</button>
			<button type='button' class='deloption'>删除选项</button>
			
		</div>
		<div id='listquestion'>
			<div>题目:<input type='text' name='questioncontent' id='listquestioncontent'/></div>
		</div>-->
		</div>
		
		<input type="submit" value="添加"/>
 	</form>
 	</div>

