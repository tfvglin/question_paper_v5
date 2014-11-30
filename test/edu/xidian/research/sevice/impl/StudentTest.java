package edu.xidian.research.sevice.impl;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xidian.research.service.impl.StudentsServiceImpl;
import edu.xidian.research.vo.Students;

public class StudentTest extends TestCase{
	
	private StudentsServiceImpl studentsServiceImpl;
	
	public void testgetstudepartment()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		studentsServiceImpl = (StudentsServiceImpl) context.getBean("studentsServiceImpl");
		Students stu = new Students();
		stu.setStuname("jjj");
		stu.setCardid("120222");
		String a =studentsServiceImpl.getStuDepartment(stu);
		System.out.println(a);
	}
	

	public void teststulist()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		studentsServiceImpl = (StudentsServiceImpl) context.getBean("studentsServiceImpl");
		List<Students> stulist = studentsServiceImpl.list();
		Iterator<Students> it = stulist.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getStuname());
		}
	}
}
