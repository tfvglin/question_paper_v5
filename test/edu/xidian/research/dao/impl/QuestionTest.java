package edu.xidian.research.dao.impl;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xidian.research.service.impl.QuestionServiceImpl;
import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;

public class QuestionTest extends TestCase{
	
	private QuestionServiceImpl questionServiceImpl ;
	private QuestionDAOImpl questionDAOImpl;
	public void testgetquestionnum()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		questionServiceImpl = (QuestionServiceImpl) context.getBean("questionServiceImpl");
		int a =questionServiceImpl.getquestionnum(1);
		System.out.println(a);
	}
	
	
	public void testgetquestion()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		questionDAOImpl = (QuestionDAOImpl) context.getBean("questionDAOImpl");
		Question q =questionDAOImpl.getQuestion(20);
		System.out.println(q.getSque());
	}

	public void testgetselmuloption()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		questionDAOImpl = (QuestionDAOImpl) context.getBean("questionDAOImpl");
		SelMulOption q =questionDAOImpl.getSelMulOption(1, 'A');
		System.out.println(q.getSqoption());
	}

	public void testgetsinquestionoption()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		questionDAOImpl = (QuestionDAOImpl) context.getBean("questionDAOImpl");
		Question q =questionDAOImpl.getQuestion(20);
		System.out.println(q.getSque());
	}

	public void testgetselsinoption()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		questionDAOImpl = (QuestionDAOImpl) context.getBean("questionDAOImpl");
		SelSinOption q =questionDAOImpl.getSelSinOption(1, 'A');
		System.out.println(q.getSqoption());
	}
}
