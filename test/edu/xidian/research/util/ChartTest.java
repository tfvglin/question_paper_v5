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
	
	

	
	public void testmulchart()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml"); 
		
		questionServiceImpl = (QuestionServiceImpl) context.getBean("questionServiceImpl");
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		
		
	}
	
	


}
