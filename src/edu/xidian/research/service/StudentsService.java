package edu.xidian.research.service;

import java.util.List;

import edu.xidian.research.vo.Students;




public  interface StudentsService {
	
	
	public Students stuLogin(Students stu);
	
	
	
	public List<Students> list();
	
	public String getStuDepartment( Students stu);
	

	

}
