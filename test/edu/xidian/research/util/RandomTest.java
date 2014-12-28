package edu.xidian.research.util;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RandomTest extends TestCase{
	
	private RandomUtil randomUtil;
	
	public void testgetrandomint()
	{
	
		ApplicationContext context = new ClassPathXmlApplicationContext(  
	            "applicationContext.xml"); 
		
		randomUtil = (RandomUtil) context.getBean("randomUtil");
		
		List<String> num = randomUtil.getRandomPIDstr(5, 12, 1);
		System.out.println(num);
	}	

}
