package edu.xidian.research.dao.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;

public class AnswersTest extends TestCase{
	
	private AnswerServiceImpl answerServiceImpl;
	
	public void testgetanswernum()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("anserServiceImpl");
		long a =answerServiceImpl.getAnswersNum();
		System.out.println(a);
	}

}
