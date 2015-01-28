package edu.xidian.research.sevice.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xidian.research.dao.impl.PaperDAOImpl;
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
	
	

	
	public void testgetPIDbySex()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		List<Integer> list =answerServiceImpl.getAnswerpaperPidBySex("1");
		Iterator it = list.iterator();
		//while(it.hasNext())
	//	{
			//System.out.println(it.next().toString());
		//}
		String pIDstr = list.toString();
		pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
		System.out.println(pIDstr);
		
		
	}
	
	public void testgetansoptionnumbysex()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		
		List<Integer> list =answerServiceImpl.getSingleAnswerOptionNumBySex(1, 5, "0");
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}

	
	public void testgetanspapernum()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		
//		System.out.println(answerServiceImpl.getAnswersNumByProvince("陕西"));
		System.out.println(answerServiceImpl.getAnswersNumByHukou("1"));
		
	}
	
	public void  testSingleAnswerOptionNumByDepartment()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		
		List<Integer> list =answerServiceImpl.getSingleAnswerOptionNumByDepartment(1, 5, "电子工程");
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}	
	}
	public void  testSingleAnswerOptionNumByMarjor()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
				"applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		
		List<Integer> list =answerServiceImpl.getSingleAnswerOptionNumByMarjor(1, 5, "通信工程");
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}	
	}
	
	public void  testgetDepartmentMap()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		
		Map<String,String> dmap =answerServiceImpl.getAnswersPaperDepartment();
		Set<String> set=dmap.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String key = it.next();
			System.out.println(key);
			System.out.println("--------------");
			System.out.println(dmap.get(key));
		}
		
		
	}
	public void  testgetmutipleoptionMap()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
				"applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
		
		Map<Character,Integer> dmap =answerServiceImpl.getMultipleQuestionOptionAnswerMap(1, 3);
		Set<Character> set=dmap.keySet();
		Iterator<Character> it = set.iterator();
		while(it.hasNext())
		{
			Character key = it.next();
			System.out.println(key);
			System.out.println("--------------");
			System.out.println(dmap.get(key));
		}
		
		
	}
	public void testgetmutipleoptionlist()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
				"applicationContext.xml");  
		answerServiceImpl = (AnswerServiceImpl) context.getBean("answerServiceImpl");
	
		List<Integer> list = answerServiceImpl.getMultipleQuestionOptionAnswer(1, 4);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
