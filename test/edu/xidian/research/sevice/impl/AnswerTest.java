package edu.xidian.research.sevice.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xidian.research.service.impl.AnswerServiceImpl;

public class AnswerTest extends TestCase{
	
	private AnswerServiceImpl answerServiceImpl;
	
	public void testgetansnum()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		
		int a =answerServiceImpl.getAnswersOptionNum(1, String.valueOf(65+0));
		System.out.println(a);
		System.out.println(String.valueOf((char)(65+0)));
		
	}
	
	public void testgetnumlist()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		List<Integer> list = new ArrayList<Integer>();
		list = answerServiceImpl.getAnswersOptionNumList(2, 1, 4);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}