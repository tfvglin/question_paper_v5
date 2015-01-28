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
			for(var key in data.omap){
					//alert(key+"--"+data.omap[key]);
					pernum =  (parseInt(data.omap[key])/all);
					//alert(pernum);
					width = pernum*450;
					per=(pernum*100).toFixed(1)+"%";
					
					//per=pernum*10 ;
					
					html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
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
			for(var key in data.omap){
					pernum =  (parseInt(data.omap[key])/all);
					width = pernum*450;
					per=(pernum*100).toFixed(1)+"%";
					html1 +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
			}

			
			all=0;
			for(var key in data.omap2){
				
				i = parseInt(data.omap2[key]);
				all += i; 
			}
		//	alert(all);
			for(var key in data.omap2){
				pernum =  (parseInt(data.omap2[key])/all);
				width = pernum*450;
				per=(pernum*100).toFixed(1)+"%";
				html2 +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap2[key]+'</td><td class="tableshort">'+per+'</td></tr>';
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
			for(var key in data.omap){
				pernum =  (parseInt(data.omap[key])/all);
				width = pernum*450;
				per=(pernum*100).toFixed(1)+"%";
				html1 +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
			}
			
			
			all=0;
			for(var key in data.omap2){
				
				i = parseInt(data.omap2[key]);
				all += i; 
			}
			//alert(all);
			for(var key in data.omap2){
				pernum =  (parseInt(data.omap2[key])/all);
				width = pernum*450;
				per=(pernum*100).toFixed(1)+"%";
				html2 +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap2[key]+'</td><td class="tableshort">'+per+'</td></tr>';
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
						for(var key in data.omap){
								pernum =  (parseInt(data.omap[key])/all);
								width = pernum*450;
								per=(pernum*100).toFixed(1)+"%";
								//alert(per);
								html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
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
					for(var key in data.omap){
							pernum =  (parseInt(data.omap[key])/all);
							width = pernum*450;
							per=(pernum*100).toFixed(1)+"%";
							html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
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
					for(var key in data.omap){
						pernum =  (parseInt(data.omap[key])/all);
						width = pernum*450;
						per=(pernum*100).toFixed(1)+"%";
						//alert(per);
						html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
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
					for(var key in data.omap){
						pernum =  (parseInt(data.omap[key])/all);
						width = pernum*450;
						per=(pernum*100).toFixed(1)+"%";
						html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
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
			alert("请选择专业");
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
					//console.log(data);
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
					for(var key in data.omap){
						pernum =  (parseInt(data.omap[key])/all);
						width = pernum*450;
						per=(pernum*100).toFixed(1)+"%";
						//alert(per);
						html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
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
			alert("请选择专业");
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
					for(var key in data.omap){
						pernum =  (parseInt(data.omap[key])/all);
						width = pernum*450;
						per=(pernum*100).toFixed(1)+"%";
						html +='<tr><td class="tableshort">'+key+'</td><td class="tablelong"><img src="img/progress1.png" width="'+width+'" height="20px"/></td><td class="tableshort">'+data.omap[key]+'</td><td class="tableshort">'+per+'</td></tr>';
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