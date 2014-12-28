package edu.xidian.research.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
					List<String[]> list =answerServiceImpl.getMultipleQuestionOptionAnswer(sqnum);
					olist=countUtil.multipleAnswerOptionNum(list, questionOptionNum);
					
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
		System.out.println(sex+"----------");
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		List<Integer> olist= new ArrayList<Integer>();
				if(sqtype==1)
				{
					olist = answerServiceImpl.getSingleAnswerOptionNumBySex(sqnum, questionOptionNum, sex);
				
			
				}
				else if(sqtype==2)
				{
					List<String[]> list =answerServiceImpl.getMultipleQuestionOptionAnswerBySex(sqnum,sex);
					olist=countUtil.multipleAnswerOptionNum(list, questionOptionNum);
					
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
					List<String[]> list =answerServiceImpl.getMultipleQuestionOptionAnswerByHukou(sqnum,hukou);
					olist=countUtil.multipleAnswerOptionNum(list, questionOptionNum);
					
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
	
}
