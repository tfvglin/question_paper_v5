package edu.xidian.research.dao;

import java.util.List;

import edu.xidian.research.vo.Students;




public  interface StudentsDAO {
	
	
	public Students stuLogin(Students stu);
	
	public String getStuDepartment(Students stu);
	
	public List<Students> list();
	
	public boolean addStudent(Students stu);
	
	

}
