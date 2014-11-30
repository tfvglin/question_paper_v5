package edu.xidian.research.service;

import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.Students;

public interface AdminService {
	public boolean adminLogin(Admin ad);
	
	public boolean addAdmin(Admin ad);
	
	public boolean addStudent(Students stu);
}
