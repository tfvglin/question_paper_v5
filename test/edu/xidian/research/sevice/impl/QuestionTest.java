package edu.xidian.research.sevice.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import edu.xidian.research.service.impl.AdminServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;
import edu.xidian.research.vo.Admin;

public class QuestionTest extends TestCase{
	
	private QuestionServiceImpl questionServiceImpl;
	
	public void testgetquestionnum()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		questionServiceImpl = (QuestionServiceImpl) context.getBean("questionServiceImpl");

		int a = questionServiceImpl.getquestionnum(1);
		long b = questionServiceImpl.getSingleQuestionOptionNum(1);
		System.out.println(b);
	}

}