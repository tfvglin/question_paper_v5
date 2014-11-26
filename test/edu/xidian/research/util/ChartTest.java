package edu.xidian.research.util;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;

public class ChartTest extends TestCase {
	
	private ChartUtil chartutil;
	private QuestionServiceImpl questionServiceImpl;
	private AnswerServiceImpl answerServiceImpl;
	
	
	public void testChart()
	{
		CountUtil countUtil = new CountUtil();
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml"); 
		
		questionServiceImpl = (QuestionServiceImpl) context.getBean("questionServiceImpl");
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		chartutil = new ChartUtil();
		int sqtype =2 ;
		int qnum=5 ;
		int questionOptionNum = questionServiceImpl.getSingleQuestionOptionNum(qnum);
		if(sqtype==1)
		{
			List<Integer> olist = answerServiceImpl.getSingleAnswerOptionNum(qnum, questionOptionNum);
			chartutil.creatBarChart(sqtype, qnum, questionOptionNum, olist);
	
		}
		else if(sqtype==2)
		{
			List<String[]> list =answerServiceImpl.getMultipleQuestionOptionAnswer(qnum);
			List<Integer> olist=countUtil.multipleAnswerOptionNum(list, questionOptionNum);
			chartutil.creatBarChart(sqtype, qnum, questionOptionNum, olist);
		}
		
	}
	
	public void testmulchart()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml"); 
		
		questionServiceImpl = (QuestionServiceImpl) context.getBean("questionServiceImpl");
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		
		
	}

}
