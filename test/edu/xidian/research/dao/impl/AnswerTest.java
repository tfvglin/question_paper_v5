package edu.xidian.research.dao.impl;

import java.util.Iterator;
import java.util.List;

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

	public void testGetapnumbydempartment()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerDAOImpl = (AnswerDAOImpl) context.getBean("answerDAOImpl");
		System.out.println(answerDAOImpl.getAnswersNumByDepartment("电子工程"));
		
	}
	
	public void testGetdempartment()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerDAOImpl = (AnswerDAOImpl) context.getBean("answerDAOImpl");
		List list = answerDAOImpl.getAnswersPaperDepartment();
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}
	public void testCascade()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
				"applicationContext.xml");  
		answerDAOImpl = (AnswerDAOImpl) context.getBean("answerDAOImpl");
		List list = answerDAOImpl.getAnswerpaperPidByCascade("select pID from AnswersPaper  where  sex=1 AND hukou=1  AND studepartment='电子工程' " );
		Iterator<Integer> it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}
}
