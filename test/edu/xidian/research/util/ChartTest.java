package edu.xidian.research.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;

public class ChartTest extends TestCase {
	
	private ChartUtil chartutil;
	private QuestionServiceImpl questionServiceImpl;
	private AnswerServiceImpl answerServiceImpl;
	
	public void testChart()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml"); 
		List<Integer> olist = new ArrayList<Integer>();
		questionServiceImpl = (QuestionServiceImpl) context.getBean("questionServiceImpl");
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		chartutil = new ChartUtil();
		int sqtype =1 ;
		int qnum=5 ;
		int questionOptionNum = questionServiceImpl.getSingleQuestionOptionNum(qnum);
		for(int i=0;i<questionOptionNum;i++)
		{
			String sans = String.valueOf((char)(65+i));
			olist.add(answerServiceImpl.getAnswersOptionNum(qnum, sans));
		}
		chartutil.creatBarChart(sqtype, qnum, questionOptionNum, olist);
	}

}
