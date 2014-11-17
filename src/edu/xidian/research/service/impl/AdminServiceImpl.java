package edu.xidian.research.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.research.dao.impl.AdminDAOImpl;
import edu.xidian.research.service.AdminService;
import edu.xidian.research.vo.Admin;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

	private AdminDAOImpl adminDAOImpl ;
	
	
	public AdminDAOImpl getAdminDAOImpl() {
		return adminDAOImpl;
	}

	@Resource
	public void setAdminDAOImpl(AdminDAOImpl adminDAOImpl) {
		this.adminDAOImpl = adminDAOImpl;
	}

	@Override
	@Transactional
	public boolean adminLogin(Admin ad) {
		// TODO Auto-generated method stub
		return adminDAOImpl.adminLogin(ad);
	}

	@Override
	@Transactional
	public boolean addAdmin(Admin ad) {
		// TODO Auto-generated method stub
		return adminDAOImpl.addAdmin(ad);
	}

}
