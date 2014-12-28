package edu.xidian.research.dao.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xidian.research.service.impl.AnswerServiceImpl;
import junit.framework.TestCase;

public class AnswerTest extends TestCase {
	
	private AnswerDAOImpl answerDAOImpl;


	
	
	
	public void testGetMaxPid()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerDAOImpl = (AnswerDAOImpl) context.getBean("answerDAOImpl");
		System.out.println(answerDAOImpl.getMaxPID());
		
	}

}
