package edu.xidian.research.dao.impl;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xidian.research.service.impl.StudentsServiceImpl;
import edu.xidian.research.vo.Students;

public class StudentsTest extends TestCase{
	
	
	StudentsServiceImpl studentsServiceImpl = new StudentsServiceImpl();
	
	public void teststudentslogin()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		studentsServiceImpl = (StudentsServiceImpl) context.getBean("studentsServiceImpl");
		Students stu = new Students();
		stu.setStuname("ажи╜");
		stu.setStunum("123");
		assertEquals(true, studentsServiceImpl.stuLogin(stu)) ;
	}
}
