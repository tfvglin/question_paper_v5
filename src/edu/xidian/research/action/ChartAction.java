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
	
	
	public void showChart()
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		System.out.println(sqtype);
		System.out.println(sqnum);
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		System.out.println(questionOptionNum);
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
		JFreeChart chart =chartUtil.creatBarChart(sqtype, sqnum, questionOptionNum, olist);
	
		 //BufferedImage buffImg = new BufferedImage();
		
		
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Cache-Control", "no-cache");
		 response.setDateHeader("Expires", 0);
		  
		  response.setContentType("image/jpeg");
		  
		  ServletOutputStream sos;
		try {
			sos = response.getOutputStream();
			ChartUtilities.writeChartAsJPEG(sos, 1.0f, chart, 500, 250,null);
			  //ImageIO.write(buffImg, "jpeg", sos);
		  sos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
