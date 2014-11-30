package edu.xidian.research.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.research.dao.impl.AdminDAOImpl;
import edu.xidian.research.dao.impl.StudentsDAOImpl;
import edu.xidian.research.service.AdminService;
import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.Students;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

	private AdminDAOImpl adminDAOImpl ;
	private StudentsDAOImpl studentsDAOImpl;
	
	public AdminDAOImpl getAdminDAOImpl() {
		return adminDAOImpl;
	}

	@Resource
	public void setAdminDAOImpl(AdminDAOImpl adminDAOImpl) {
		this.adminDAOImpl = adminDAOImpl;
	}

	
	
	public StudentsDAOImpl getStudentsDAOImpl() {
		return studentsDAOImpl;
	}
	@Resource
	public void setStudentsDAOImpl(StudentsDAOImpl studentsDAOImpl) {
		this.studentsDAOImpl = studentsDAOImpl;
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

	@Override
	public boolean addStudent(Students stu) {
		// TODO Auto-generated method stub
		return studentsDAOImpl.addStudent(stu);
	}
	
	

}
