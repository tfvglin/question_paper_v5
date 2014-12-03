package edu.xidian.research.dao;

import java.util.List;

import edu.xidian.research.vo.Students;




public  interface StudentsDAO {
	
	//学生认证
	public Students stuLogin(Students stu);
	
	//获得学生学院
	public String getStuDepartment(Students stu);
	
	//获得所有学生集合
	public List<Students> list();
	
	public boolean addStudent(Students stu);
	
	

}
