package edu.xidian.research.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.struts2.json.annotations.JSON;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;
import edu.xidian.research.util.ChartUtil;
import edu.xidian.research.util.CountUtil;
@Controller("tableAction")
@Scope("prototype") 
public class TableAction extends SuperAction {
	
	private CountUtil countUtil;
	private ChartUtil chartUtil;
	private QuestionServiceImpl questionServiceImpl;
	private AnswerServiceImpl answerServiceImpl;
	
	Map<Character,Integer> omap2 = new HashMap<>();
	Map<Character,Integer> omap = new HashMap<>();
	@JSON(serialize=false)
	public CountUtil getCountUtil() {
		return countUtil;
	}
	@Resource
	public void setCountUtil(CountUtil countUtil) {
		this.countUtil = countUtil;
	}
	@JSON(serialize=false)
	public ChartUtil getChartUtil() {
		return chartUtil;
	}
	@Resource
	public void setChartUtil(ChartUtil chartUtil) {
		this.chartUtil = chartUtil;
	}
	
	

	@JSON(serialize=false)
	public QuestionServiceImpl getQuestionServiceImpl() {
		return questionServiceImpl;
	}
	@Resource
	public void setQuestionServiceImpl(QuestionServiceImpl questionServiceImpl) {
		this.questionServiceImpl = questionServiceImpl;
	}
	@JSON(serialize=false)
	public AnswerServiceImpl getAnswerServiceImpl() {
		return answerServiceImpl;
	}
	@Resource
	public void setAnswerServiceImpl(AnswerServiceImpl answerServiceImpl) {
		this.answerServiceImpl = answerServiceImpl;
	}
	
	public Map<Character, Integer> getOmap() {
		return omap;
	}
	public void setOmap(Map<Character, Integer> omap) {
		this.omap = omap;
	}
	
	
	public Map<Character, Integer> getOmap2() {
		return omap2;
	}
	public void setOmap2(Map<Character, Integer> omap2) {
		this.omap2 = omap2;
	}
	//显示统计表
	public String showTable()
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		
				if(sqtype==1)
				{
					omap=answerServiceImpl.getSingleAnswerOptionNumMap(sqnum, questionOptionNum);
				
			
				}
				else if(sqtype==2)
				{
					omap =answerServiceImpl.getMultipleQuestionOptionAnswerMap(sqnum,questionOptionNum);
					
				}
	
		return SUCCESS;
		
	}
	//显示统计表BySex
	public String showTableBySex()
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		
		if(sqtype==1)
		{
			omap=answerServiceImpl.getSingleAnswerOptionNumBySexMap(sqnum, questionOptionNum, "1"); //1男生,0女生
			omap2=answerServiceImpl.getSingleAnswerOptionNumBySexMap(sqnum, questionOptionNum, "0");
			
			
		}
		else if(sqtype==2)
		{
			omap =answerServiceImpl.getMultipleQuestionOptionAnswerBySexMap(sqnum,"1",questionOptionNum);
			omap2 =answerServiceImpl.getMultipleQuestionOptionAnswerBySexMap(sqnum,"0",questionOptionNum);
			
		}
		
		return SUCCESS;
		
	}
	//显示统计表Byhukou
	public String showTableByHukou()
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		
		if(sqtype==1)
		{
			omap=answerServiceImpl.getSingleAnswerOptionNumByHukouMap(sqnum, questionOptionNum, "1");	//1城镇，0农村
			omap2=answerServiceImpl.getSingleAnswerOptionNumByHukouMap(sqnum, questionOptionNum, "0");
			
			
		}
		else if(sqtype==2)
		{
			omap =answerServiceImpl.getMultipleQuestionOptionAnswerByHukouMap(sqnum,"1",questionOptionNum);
			omap2 =answerServiceImpl.getMultipleQuestionOptionAnswerByHukouMap(sqnum,"0",questionOptionNum);
			
		}
		
		return SUCCESS;
		
	}
	
	//显示图表（分学院）
		public String showTableByDepartment() 
		{
			int sqtype=Integer.parseInt(request.getParameter("sqtype"));
			int sqnum = Integer.parseInt(request.getParameter("sqnum"));
			String depar =request.getParameter("department");
			String department=null;
			try {
				department = new String(depar.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
			
			int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
			if(sqtype==1)
					{
						omap = answerServiceImpl.getSingleAnswerOptionNumByDepartmentMap(sqnum, questionOptionNum, department);
					
				
					}
					else if(sqtype==2)
					{
						omap =answerServiceImpl.getMultipleQuestionOptionAnswerByDepartmentMap(sqnum,department, questionOptionNum);
						
					}
		
			return SUCCESS;
		}
		//显示图表（分专业）
		public String showTableByMarjor() 
		{
			int sqtype=Integer.parseInt(request.getParameter("sqtype"));
			int sqnum = Integer.parseInt(request.getParameter("sqnum"));
			String depar =request.getParameter("marjor");
			String marjor=null;
			try {
				marjor = new String(depar.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
			
			int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
			if(sqtype==1)
			{
				omap = answerServiceImpl.getSingleAnswerOptionNumByMarjorMap(sqnum, questionOptionNum, marjor);
				
				
			}
			else if(sqtype==2)
			{
				omap =answerServiceImpl.getMultipleQuestionOptionAnswerByMarjorMap(sqnum,marjor, questionOptionNum);
				
			}
			
			return SUCCESS;
		}
		//显示图表（分省份）
		public String showTableByProvince() 
		{
			int sqtype=Integer.parseInt(request.getParameter("sqtype"));
			int sqnum = Integer.parseInt(request.getParameter("sqnum"));
			String depar =request.getParameter("province");
			String province=null;
			try {
				province = new String(depar.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
			
			int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
			if(sqtype==1)
			{
				omap = answerServiceImpl.getSingleAnswerOptionNumByProvinceMap(sqnum, questionOptionNum, province);
				
				
			}
			else if(sqtype==2)
			{
				omap =answerServiceImpl.getMultipleQuestionOptionAnswerByProvinceMap(sqnum,province, questionOptionNum);
				
			}
			
			return SUCCESS;
		}
	
}
