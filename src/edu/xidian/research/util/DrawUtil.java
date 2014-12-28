package edu.xidian.research.util;

import java.util.List;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.stereotype.Component;

import edu.xidian.research.service.impl.AdminServiceImpl;
import edu.xidian.research.vo.AnswersPaper;

@Component
public class DrawUtil {
	
	private List<AnswersPaper> aplist;

	private AdminServiceImpl adminServiceImpl;
	
	
	
	public AdminServiceImpl getAdminServiceImpl() {
		return adminServiceImpl;
	}
	@Resource
	public void setAdminServiceImpl(AdminServiceImpl adminServiceImpl) {
		this.adminServiceImpl = adminServiceImpl;
	}

	public List<AnswersPaper> getAplist() {
		return aplist;
	}


	
	

}
