package edu.xidian.research.dao;

import java.util.List;

import edu.xidian.research.vo.Students;




public  interface StudentsDAO {
	
	//ѧ����֤
	public Students stuLogin(Students stu);
	
	//���ѧ��ѧԺ
	public String getStuDepartment(Students stu);
	
	//�������ѧ������
	public List<Students> list();
	
	public boolean addStudent(Students stu);
	
	

}
