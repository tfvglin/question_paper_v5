$(document).ready(function(){



	$(".pointer").click(function(){
		$(this).siblings(".hide").slideUp();
		//$(this).siblings(".secondtable").slideUp();
	});
	

	
});
function totaltable(qtype,qnum,a)
{
	var getthis = $(a);
	$.ajax({
		type:"GET",
		data: {
			'sqtype': qtype,
			'sqnum': qnum,
		},
		url:"showTable.action",
		dataType:"json",
		success: function(data){
		//console.log(data);
		$('#firsttable'+qnum).empty();
		var html='<caption align="top">总体情况</caption>';
		var all = 0;
		var i = 0;
		var pernum ;
		var per;
		var width;
		for(var key in data.omap){
				
				i = parseInt(data.omap[key]);
				//alert(i);
				all += i; 
			}
		//	alert(all);
		var colornum=0;
		var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
		for(var key in data.omap){
					//alert(key+"--"+data.omap[key]);
					pernum =  (parseInt(data.omap[key])/all);
					//alert(pernum);
					width = pernum*450;
					per=(pernum*100).toFixed(1)+"%";
					
					//per=pernum*10 ;
					
					html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
					colornum++;
		}
			
			if(qtype==1)
				{
				$('#singlethirdtable'+qnum).html(html);
				}
			else{
				$('#multiplethirdtable'+qnum).html(html);
			}
		}
	});
	getthis.siblings(".onetable").slideDown()
			.siblings(".twotable").hide();
}

function sextable(qtype,qnum,a)
{
	var getthis = $(a);
	$.ajax({
		type:"GET",
		data: {
			'sqtype': qtype,
			'sqnum': qnum,
		},
		url:"showTableBySex.action",
		dataType:"json",
		success: function(data){
		//console.log(data);
		$('#firsttable'+qnum).empty();
		$('#secondtable'+qnum).empty();
		var html1='<caption align="top">男生情况</caption>';
		var html2='<caption align="top">女生情况</caption>';
		var all = 0;
		var i = 0;
		var pernum ;
		var per;
		var width;
		for(var key in data.omap){
				
				i = parseInt(data.omap[key]);
				all += i; 
			}
		var colornum=0;
		var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
		for(var key in data.omap){
					pernum =  (parseInt(data.omap[key])/all);
					width = pernum*450;
					per=(pernum*100).toFixed(1)+"%";
					html1 +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
					colornum++;
		}

			
			all=0;
			for(var key in data.omap2){
				
				i = parseInt(data.omap2[key]);
				all += i; 
			}
		//	alert(all);
			var colornum=0;
			var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
			for(var key in data.omap2){
				pernum =  (parseInt(data.omap2[key])/all);
				width = pernum*450;
				per=(pernum*100).toFixed(1)+"%";
				html2 +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap2[key]+'</td><td class="tableshort">'+per+'</td></tr>';
				colornum++;
			}
		//	alert(html1);
			if(qtype==1)
			{
				$('#singlesecondtable'+qnum).html(html2);
				$('#singlefirsttable'+qnum).html(html1);
			}
			else{
			//	alert(html1);
				$('#multiplesecondtable'+qnum).html(html2);
				$('#multiplefirsttable'+qnum).html(html1);
			}
		}
	});
	
	getthis.siblings(".twotable").slideDown()
	.siblings(".onetable").hide();

}



function hukoutable(qtype,qnum,a)
{
	var getthis = $(a);
	$.ajax({
		type:"GET",
		data: {
			'sqtype': qtype,
			'sqnum': qnum,
		},
		url:"showTableByHukou.action",
		dataType:"json",
		success: function(data){
			//console.log(data);
			$('#firsttable'+qnum).empty();
			$('#secondtable'+qnum).empty();
			var html1='<caption align="top">城镇情况</caption>';
			var html2='<caption align="top">农村情况</caption>';
			var all = 0;
			var i = 0;
			var pernum ;
			var per;
			var width;
			for(var key in data.omap){
				
				i = parseInt(data.omap[key]);
				all += i; 
			}
			var colornum=0;
			var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
			for(var key in data.omap){
				pernum =  (parseInt(data.omap[key])/all);
				width = pernum*450;
				per=(pernum*100).toFixed(1)+"%";
				html1 +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
				colornum++;
			}
			
			
			all=0;
			for(var key in data.omap2){
				
				i = parseInt(data.omap2[key]);
				all += i; 
			}
			//alert(all);
			
			var colornum=0;
			var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
			for(var key in data.omap2){
				pernum =  (parseInt(data.omap2[key])/all);
				width = pernum*450;
				per=(pernum*100).toFixed(1)+"%";
				html2 +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap2[key]+'</td><td class="tableshort">'+per+'</td></tr>';
				colornum++;
			}
			if(qtype==1)
			{
				$('#singlesecondtable'+qnum).html(html2);
				$('#singlefirsttable'+qnum).html(html1);
			}
			else{
			//	alert(html1);
				$('#multiplesecondtable'+qnum).html(html2);
				$('#multiplefirsttable'+qnum).html(html1);
			}
		}
	});
	
	getthis.siblings(".twotable").slideDown()
	.siblings(".onetable").hide();
}

function departmenttable(qtype,qnum,a)
{
	var getthis = $(a);
	if(qtype==1)
		{
			var department=$("#singlequestiondepartment"+qnum+"").val();
			if(department=="")
			{
			 alert("请选择学院");
			}
			else{
				
				$.ajax({
					type:"GET",
					data: {
						'sqtype': qtype,
						'sqnum': qnum,
						'department': department,
					},
					url:"showTableByDepartment.action",
					dataType:"json",
					success: function(data){
					//console.log(data);
					$('#firsttable'+qnum).empty();
					var html='<caption align="top">'+department+'学院情况</caption>';
					var all = 0;
					var i = 0;
					var pernum ;
					var per;
					var width;
					for(var key in data.omap){
							i = parseInt(data.omap[key]);
							all += i; 
						}
					var colornum=0;
					var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
					for(var key in data.omap){
								pernum =  (parseInt(data.omap[key])/all);
								width = pernum*450;
								per=(pernum*100).toFixed(1)+"%";
								//alert(per);
								html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
								colornum++;
					}
						if(qtype==1)
							{
							$('#singlethirdtable'+qnum).html(html);
							}
						else{
							$('#multiplethirdtable'+qnum).html(html);
						}
					}
				});
				getthis.siblings(".onetable").slideDown()
				.siblings(".twotable").hide();
			}
		
		}
	if(qtype==2)
	{
		var department=$("#multiplequestiondepartment"+qnum+"").val();
		if(department=="")
		{
			alert("请选择学院");
			// return false;
		}
		else{
			$.ajax({
				type:"GET",
				data: {
					'sqtype': qtype,
					'sqnum': qnum,
					'department': department,
				},
				url:"showTableByDepartment.action",
				dataType:"json",
				success: function(data){
				//console.log(data);
				$('#firsttable'+qnum).empty();
				var html='<caption align="top">'+department+'学院情况</caption>';
				var all = 0;
				var i = 0;
				var pernum ;
				var per;
				var width;
				for(var key in data.omap){
						i = parseInt(data.omap[key]);
						all += i; 
					}
				var colornum=0;
				var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
				for(var key in data.omap){
							pernum =  (parseInt(data.omap[key])/all);
							width = pernum*450;
							per=(pernum*100).toFixed(1)+"%";
							html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
							colornum++;
				}
					if(qtype==1)
						{
						$('#singlethirdtable'+qnum).html(html);
						}
					else{
						$('#multiplethirdtable'+qnum).html(html);
					}
				}
			});
			getthis.siblings(".onetable").slideDown()
			.siblings(".twotable").hide();
		}
		
	}

}
function marjortable(qtype,qnum,a)
{
	var getthis = $(a);
	if(qtype==1)
	{
		var marjor=$("#singlequestionmarjor"+qnum+"").val();
		if(marjor=="")
		{
			alert("请选择专业");
		}
		else{
			
			$.ajax({
				type:"GET",
				data: {
					'sqtype': qtype,
					'sqnum': qnum,
					'marjor': marjor,
				},
				url:"showTableByMarjor.action",
				dataType:"json",
				success: function(data){
					//console.log(data);
					$('#firsttable'+qnum).empty();
					var html='<caption align="top">'+marjor+'专业情况</caption>';
					var all = 0;
					var i = 0;
					var pernum ;
					var per;
					var width;
					for(var key in data.omap){
						i = parseInt(data.omap[key]);
						all += i; 
					}
					var colornum=0;
					var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
					for(var key in data.omap){
						pernum =  (parseInt(data.omap[key])/all);
						width = pernum*450;
						per=(pernum*100).toFixed(1)+"%";
						//alert(per);
						html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
						colornum++;
					}
					if(qtype==1)
					{
						$('#singlethirdtable'+qnum).html(html);
					}
					else{
						$('#multiplethirdtable'+qnum).html(html);
					}
				}
			});
			getthis.siblings(".onetable").slideDown()
			.siblings(".twotable").hide();
		}
		
	}
	if(qtype==2)
	{
		var marjor=$("#multiplequestionmarjor"+qnum+"").val();
		if(marjor=="")
		{
			alert("请选择专业");
			// return false;
		}
		else{
			$.ajax({
				type:"GET",
				data: {
					'sqtype': qtype,
					'sqnum': qnum,
					'marjor': marjor,
				},
				url:"showTableByMarjor.action",
				dataType:"json",
				success: function(data){
				//	console.log(data);
					$('#firsttable'+qnum).empty();
					var html='<caption align="top">'+marjor+'专业情况</caption>';
					var all = 0;
					var i = 0;
					var pernum ;
					var per;
					var width;
					for(var key in data.omap){
						i = parseInt(data.omap[key]);
						all += i; 
					}
					var colornum=0;
					var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
					for(var key in data.omap){
						pernum =  (parseInt(data.omap[key])/all);
						width = pernum*450;
						per=(pernum*100).toFixed(1)+"%";
						html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
						colornum++;
					}
					if(qtype==1)
					{
						$('#singlethirdtable'+qnum).html(html);
					}
					else{
						$('#multiplethirdtable'+qnum).html(html);
					}
				}
			});
			getthis.siblings(".onetable").slideDown()
			.siblings(".twotable").hide();
		}
		
	}
	
}


function provincetable(qtype,qnum,a)
{
	var getthis = $(a);
	if(qtype==1)
	{
		var province=$("#singlequestionprovince"+qnum+"").val();
		if(province=="")
		{
			alert("请选择省份");
		}
		else{
			
			$.ajax({
				type:"GET",
				data: {
					'sqtype': qtype,
					'sqnum': qnum,
					'province': province,
				},
				url:"showTableByProvince.action",
				dataType:"json",
				success: function(data){
					console.log(data);
					$('#firsttable'+qnum).empty();
					var html='<caption align="top">'+province+'情况</caption>';
					var all = 0;
					var i = 0;
					var pernum ;
					var per;
					var width;
					for(var key in data.omap){
						i = parseInt(data.omap[key]);
						all += i; 
					}
					var colornum=0;
					var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
					for(var key in data.omap){
						pernum =  (parseInt(data.omap[key])/all);
						width = pernum*450;
						per=(pernum*100).toFixed(1)+"%";
						//alert(per);
						html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
						colornum++;
					}
					if(qtype==1)
					{
						$('#singlethirdtable'+qnum).html(html);
					}
					else{
						$('#multiplethirdtable'+qnum).html(html);
					}
				}
			});
			getthis.siblings(".onetable").slideDown()
			.siblings(".twotable").hide();
		}
		
	}
	if(qtype==2)
	{
		var province=$("#multiplequestionprovince"+qnum+"").val();
		if(province=="")
		{
			alert("请选择省份");
			// return false;
		}
		else{
			$.ajax({
				type:"GET",
				data: {
					'sqtype': qtype,
					'sqnum': qnum,
					'province': province,
				},
				url:"showTableByProvince.action",
				dataType:"json",
				success: function(data){
				//	console.log(data);
					$('#firsttable'+qnum).empty();
					var html='<caption align="top">'+province+'情况</caption>';
					var all = 0;
					var i = 0;
					var pernum ;
					var per;
					var width;
					for(var key in data.omap){
						i = parseInt(data.omap[key]);
						all += i; 
					}
					var colornum=0;
					var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
					for(var key in data.omap){
						pernum =  (parseInt(data.omap[key])/all);
						width = pernum*450;
						per=(pernum*100).toFixed(1)+"%";
						html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[colornum]+';"><div/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
						colornum++;
					}
					if(qtype==1)
					{
						$('#singlethirdtable'+qnum).html(html);
					}
					else{
						$('#multiplethirdtable'+qnum).html(html);
					}
				}
			});
			getthis.siblings(".onetable").slideDown()
			.siblings(".twotable").hide();
		}
		
	}
}
	function cascadetable(a)
	{
		var getthis = $(a);
		
			var sex=$("#cascadesex").val();
			var hukou=$("#cascadehukou").val();
			var province=$("#cascadeprovince").val();
			var department=$("#cascadedepartment").val();
			var marjor=$("#cascademarjor").val();
			var sqtype=$("#cascadesqtype").val();
			var sqnum=$("#cascadesqnum").val();
			if(sqtype=="")
			{
				alert("请选择题目类型");
			}
			else if(sqnum=="")
				{
				   alert("请输入题号");
				}
			else{
				
				$.ajax({
					type:"GET",
					data: {
						'sqtype': sqtype,
						'sqnum': sqnum,
						'province': province,
						'hukou': hukou,
						'sex': sex,
						'department': department,
						'marjor': marjor,
					},
					url:"showTableByCascade.action",
					dataType:"json",
					success: function(data){
						//console.log(data);
						$('#cascadetable').empty();
						$('#remark').empty();
						var title = "";
						var condition ="";
						if(sqtype==1)
							{
							title = "单选"+sqnum+"题  ";
							}
						else{
							title = "多选"+sqnum+"题  ";
						}
						if(sex!='unselected')
							{
								if(sex==1)
									{
										condition += "男生  "; 
									}
								else{
										condition += "女生  "; 
									}
							}
						if(hukou!='unselected')
							{
								if(hukou==1)
								{
									condition += "城镇户口  ";
								}
								else{
									condition += "农村户口  ";
								}
							}
						if(province!='unselected')
							{
							condition += province+" ";
							}
						if(department!='unselected')
							{
							condition += department+"学院  ";
							}
						if(marjor!='unselected')
							{
							condition += marjor+" ";
							}
						if(condition!="")
							{
								condition = "（" + condition +"）";
							}
						title += condition ;
						
						var html='<caption align="top">'+title+'情况</caption>';
						var all = 0;
						var i = 0;
						var pernum ;
						var per;
						var width;

						for(var key in data.omap){
							i = parseInt(data.omap[key]);
							all += i; 
						}
						if(all==0)
							{
								
								$('#remark').html('此条件下查询无结果');
							}
						else{
								var i=0;
								var colorarray = new Array('00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030','00BFFF','00EE00','EEEE00','FF3030');
								for(var key in data.omap){
									pernum =  (parseInt(data.omap[key])/all);
									width = pernum*450;
									per=(pernum*100).toFixed(1)+"%";
									
									
									
									html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><div style="height:20px;width:'+width+'px;background-color:#'+colorarray[i]+';"><div/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
									i++;
								}
								$('#cascadetable').html(html);	
						}
						
							
						
					}
				});
//				getthis.siblings(".onetable").slideDown()
//				.siblings(".twotable").hide();
			}
			
		
	}	
		
	
