package edu.xidian.research.sevice.impl;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import edu.xidian.research.service.impl.AdminServiceImpl;
import edu.xidian.research.vo.Admin;

public class AdminTest extends TestCase{
	
	private AdminServiceImpl asimpl;
	
	public void testaddAdmin()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(  
                "applicationContext.xml");  
		asimpl = (AdminServiceImpl) context.getBean("adminServiceImpl");
		Admin ad = new Admin();
		ad.setAdminname("haha");
		ad.setAdminpassword("123");
		asimpl.addAdmin(ad);
		
	}

}
