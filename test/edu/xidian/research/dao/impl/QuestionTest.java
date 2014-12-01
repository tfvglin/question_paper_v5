package edu.xidian.research.dao.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xidian.research.service.impl.AdminServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;
import junit.framework.TestCase;

public class QuestionTest extends TestCase{
	
	private QuestionServiceImpl questionServiceImpl ;
	
	public void testgetquestionnum()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		questionServiceImpl = (QuestionServiceImpl) context.getBean("questionServiceImpl");
		int a =questionServiceImpl.getquestionnum(1);
		System.out.println(a);
	}

}
