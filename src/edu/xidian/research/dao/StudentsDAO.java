package edu.xidian.research.dao;

import edu.xidian.research.vo.Students;




public  interface StudentsDAO {
	
	
	public boolean stuLogin(Students stu);
	
	
	
	public boolean list();
	
	
	
	public boolean checkstu(Students stu);

}
