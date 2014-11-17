package edu.xidian.research.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.research.dao.impl.StudentsDAOImpl;
import edu.xidian.research.service.StudentsService;
import edu.xidian.research.vo.Students;


@Service("studentsServiceImpl")
public class StudentsServiceImpl implements StudentsService {

	private StudentsDAOImpl studentsDAOImpl;
	
	
	
	public StudentsDAOImpl getStudentsDAOImpl() {
		return studentsDAOImpl;
	}

	@Resource
	public void setStudentsDAOImpl(StudentsDAOImpl studentsDAOImpl) {
		this.studentsDAOImpl = studentsDAOImpl;
	}

	@Override
	@Transactional
	public boolean stuLogin(Students stu) {
		// TODO Auto-generated method stub
		return studentsDAOImpl.stuLogin(stu);
	}

	@Override
	@Transactional
	public boolean list() {
		// TODO Auto-generated method stub
		return studentsDAOImpl.list();
	}

	@Override
	@Transactional
	public boolean checkstu(Students stu) {
		// TODO Auto-generated method stub
		return studentsDAOImpl.checkstu(stu);
	}

}
