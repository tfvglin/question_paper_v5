package edu.xidian.research.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;
import edu.xidian.research.util.ChartUtil;
import edu.xidian.research.util.CountUtil;

@Controller("chartAction")
@Scope("prototype") 
public class ChartAction extends SuperAction{
	private CountUtil countUtil;
	private ChartUtil chartUtil;
	private QuestionServiceImpl questionServiceImpl;
	private AnswerServiceImpl answerServiceImpl;
	
	Map<Character,Integer> omap = new HashMap<>();
	
	public CountUtil getCountUtil() {
		return countUtil;
	}
	@Resource
	public void setCountUtil(CountUtil countUtil) {
		this.countUtil = countUtil;
	}
	public ChartUtil getChartUtil() {
		return chartUtil;
	}
	@Resource
	public void setChartUtil(ChartUtil chartUtil) {
		this.chartUtil = chartUtil;
	}
	
	


	public QuestionServiceImpl getQuestionServiceImpl() {
		return questionServiceImpl;
	}
	@Resource
	public void setQuestionServiceImpl(QuestionServiceImpl questionServiceImpl) {
		this.questionServiceImpl = questionServiceImpl;
	}
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
	//显示图表
	public void showChart()
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		List<Integer> olist= new ArrayList<Integer>();
				if(sqtype==1)
				{
					olist = answerServiceImpl.getSingleAnswerOptionNum(sqnum, questionOptionNum);
				
			
				}
				else if(sqtype==2)
				{
					olist =answerServiceImpl.getMultipleQuestionOptionAnswer(sqnum,questionOptionNum);
					
				}
		JFreeChart chart =chartUtil.creatBarChart(sqtype, sqnum, questionOptionNum, olist);   //生成图表对象
	
		//设置响应方式
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Cache-Control", "no-cache");
		 response.setDateHeader("Expires", 0);
		 response.setContentType("image/jpeg");
		  
		 
		try {
			 ServletOutputStream sos = response.getOutputStream();
			ChartUtilities.writeChartAsJPEG(sos, 1.0f, chart, 500, 250,null);
			  //ImageIO.write(buffImg, "jpeg", sos);
		  sos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//显示图表（分性别）
	public void showChartBySex()
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		String sex =request.getParameter("sex");
		
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		List<Integer> olist= new ArrayList<Integer>();
				if(sqtype==1)
				{
					olist = answerServiceImpl.getSingleAnswerOptionNumBySex(sqnum, questionOptionNum, sex);
				
			
				}
				else if(sqtype==2)
				{
					olist =answerServiceImpl.getMultipleQuestionOptionAnswerBySex(sqnum,sex, questionOptionNum);
						
				}
		JFreeChart chart =chartUtil.creatBarChartBySex(sqtype, sqnum, questionOptionNum, olist,sex);   //生成图表对象
	
		//设置响应方式
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Cache-Control", "no-cache");
		 response.setDateHeader("Expires", 0);
		 response.setContentType("image/jpeg");
		  
		 
		try {
			 ServletOutputStream sos = response.getOutputStream();
			ChartUtilities.writeChartAsJPEG(sos, 1.0f, chart, 330, 250,null);
			  //ImageIO.write(buffImg, "jpeg", sos);
		  sos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	//显示图表（分户口）
	public void showChartByHukou()
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		String hukou =request.getParameter("hukou");
		
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		List<Integer> olist= new ArrayList<Integer>();
				if(sqtype==1)
				{
					olist = answerServiceImpl.getSingleAnswerOptionNumByHukou(sqnum, questionOptionNum, hukou);
				
			
				}
				else if(sqtype==2)
				{
					olist =answerServiceImpl.getMultipleQuestionOptionAnswerByHukou(sqnum,hukou, questionOptionNum);
					
				}
		JFreeChart chart =chartUtil.creatBarChartByHukou(sqtype, sqnum, questionOptionNum, olist,hukou);   //生成图表对象
	
		//设置响应方式
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Cache-Control", "no-cache");
		 response.setDateHeader("Expires", 0);
		 response.setContentType("image/jpeg");
		  
		 
		try {
			 ServletOutputStream sos = response.getOutputStream();
			ChartUtilities.writeChartAsJPEG(sos, 1.0f, chart, 330, 250,null);
			  //ImageIO.write(buffImg, "jpeg", sos);
		  sos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//显示图表（分学院）
	public void showChartByDepartment() throws UnsupportedEncodingException
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		String depar =request.getParameter("department");
		String department = new String(depar.getBytes("ISO-8859-1"), "UTF-8");   
		
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		List<Integer> olist= new ArrayList<Integer>();
				if(sqtype==1)
				{
					olist = answerServiceImpl.getSingleAnswerOptionNumByDepartment(sqnum, questionOptionNum, department);
				
			
				}
				else if(sqtype==2)
				{
					olist =answerServiceImpl.getMultipleQuestionOptionAnswerByDepartment(sqnum,department, questionOptionNum);
					
				}
		JFreeChart chart =chartUtil.creatBarChartByDepartment(sqtype, sqnum, questionOptionNum, olist,department);   //生成图表对象
	
		//设置响应方式
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Cache-Control", "no-cache");
		 response.setDateHeader("Expires", 0);
		 response.setContentType("image/jpeg");
		  
		 
		try {
			 ServletOutputStream sos = response.getOutputStream();
			ChartUtilities.writeChartAsJPEG(sos, 1.0f, chart, 500, 250,null);
			  //ImageIO.write(buffImg, "jpeg", sos);
		  sos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//显示图表（分专业）
	public void showChartByMarjor() throws UnsupportedEncodingException
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		String mar =request.getParameter("marjor");
		String marjor = new String(mar.getBytes("ISO-8859-1"), "UTF-8");   
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		
		List<Integer> olist= new ArrayList<Integer>();
				if(sqtype==1)
				{
					olist = answerServiceImpl.getSingleAnswerOptionNumByMarjor(sqnum, questionOptionNum, marjor);
				
			
				}
				else if(sqtype==2)
				{
					olist =answerServiceImpl.getMultipleQuestionOptionAnswerByMarjor(sqnum,marjor, questionOptionNum);
					
				}
		JFreeChart chart =chartUtil.creatBarChartByMarjor(sqtype, sqnum, questionOptionNum, olist,marjor);   //生成图表对象
	
		//设置响应方式
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Cache-Control", "no-cache");
		 response.setDateHeader("Expires", 0);
		 response.setContentType("image/jpeg");
		  
		 
		try {
			 ServletOutputStream sos = response.getOutputStream();
			ChartUtilities.writeChartAsJPEG(sos, 1.0f, chart, 500, 250,null);
			  //ImageIO.write(buffImg, "jpeg", sos);
		  sos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//显示图表（分省份）
	public void showChartByProvince() throws UnsupportedEncodingException
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		String pro =request.getParameter("province");
		String province = new String(pro.getBytes("ISO-8859-1"), "UTF-8");   
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		//System.out.println(province);
		List<Integer> olist= new ArrayList<Integer>();
		if(sqtype==1)
		{
			olist = answerServiceImpl.getSingleAnswerOptionNumByProvince(sqnum, questionOptionNum, province);
			
			
		}
		else if(sqtype==2)
		{
			olist =answerServiceImpl.getMultipleQuestionOptionAnswerByProvince(sqnum,province, questionOptionNum);
			
		}
		JFreeChart chart =chartUtil.creatBarChartByProvince(sqtype, sqnum, questionOptionNum, olist,province);   //生成图表对象
		
		//设置响应方式
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		
		
		try {
			ServletOutputStream sos = response.getOutputStream();
			ChartUtilities.writeChartAsJPEG(sos, 1.0f, chart, 500, 250,null);
			//ImageIO.write(buffImg, "jpeg", sos);
			sos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
}
