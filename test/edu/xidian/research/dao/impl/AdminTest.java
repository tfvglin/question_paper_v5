package edu.xidian.research.dao.impl;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xidian.research.service.impl.AdminServiceImpl;
import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.Students;

import junit.framework.TestCase;

public class AdminTest extends TestCase{
	
	private AdminServiceImpl asimpl;
	
	public void testaddAdmin()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		asimpl = (AdminServiceImpl) context.getBean("adminServiceImpl");
		Admin ad = new Admin();
		ad.setAdminname("��ɭ");
		ad.setAdminpassword("123");
		
		
	}
<<<<<<< HEAD:test/edu/xidian/research/dao/impl/AdminTest.java
}

=======
	
	
	public void testadminaddstu()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		asimpl = (AdminServiceImpl) context.getBean("adminServiceImpl");
		Students stu = new Students();
		stu.setID(13);
		stu.setCardid("120222");
		stu.setStudepartment("ͨ�Ź���ѧԺ");
		stu.setStuname("kkk");
		stu.setStunum("123");
		asimpl.addStudent(stu);
	}

}
>>>>>>> 0f9145965d41481705da22ae35b4abf323d22b1a:test/edu/xidian/research/sevice/impl/AdminTest.java
