package edu.xidian.research.service.impl;

import java.util.List;

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
	public Students stuLogin(Students stu) {
		// TODO Auto-generated method stub
		return studentsDAOImpl.stuLogin(stu);
	}

	@Override
	@Transactional
	public List<Students> list() {
		// TODO Auto-generated method stub
		return studentsDAOImpl.list();
	}

	@Override
	@Transactional
	public String getStuDepartment(Students stu) {
		// TODO Auto-generated method stub
		return studentsDAOImpl.getStuDepartment(stu);
	}


	
}
