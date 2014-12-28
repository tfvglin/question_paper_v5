package edu.xidian.research.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.research.dao.impl.AdminDAOImpl;
import edu.xidian.research.dao.impl.AnswerDAOImpl;
import edu.xidian.research.dao.impl.StudentsDAOImpl;
import edu.xidian.research.service.AdminService;
import edu.xidian.research.util.RandomUtil;
import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.Students;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

	private AdminDAOImpl adminDAOImpl ;
	private StudentsDAOImpl studentsDAOImpl;
	private AnswerDAOImpl answerDAOImpl;
	private RandomUtil randomUtil;
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

	
	
	public AnswerDAOImpl getAnswerDAOImpl() {
		return answerDAOImpl;
	}
	@Resource
	public void setAnswerDAOImpl(AnswerDAOImpl answerDAOImpl) {
		this.answerDAOImpl = answerDAOImpl;
	}

	
	
	public RandomUtil getRandomUtil() {
		return randomUtil;
	}
	@Resource
	public void setRandomUtil(RandomUtil randomUtil) {
		this.randomUtil = randomUtil;
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
	@Transactional
	public boolean addStudent(Students stu) {
		// TODO Auto-generated method stub
		return studentsDAOImpl.addStudent(stu);
	}

	@Override
	public List<AnswersPaper> getDrawPaper(int count) 
	{
		List<AnswersPaper> apList = new ArrayList<AnswersPaper>();
		Integer maxpid = answerDAOImpl.getMaxPID();
		Integer minpid = answerDAOImpl.getMinPID();
		List<String> pIDlist = randomUtil.getRandomPIDstr(count, maxpid, minpid);
		String pIDstr = pIDlist.toString().replaceAll("\\[", "(").replaceAll("\\]", ")");
		apList = answerDAOImpl.getAnswersPaperByPidstr(pIDstr);
		return apList;
	}
	
	
	

}
