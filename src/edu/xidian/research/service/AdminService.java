package edu.xidian.research.service;

import java.util.List;

import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.Students;

public interface AdminService {
	public boolean adminLogin(Admin ad);
	
	public boolean addAdmin(Admin ad);
	
	public boolean addStudent(Students stu);
	
	public List<AnswersPaper> getDrawPaper(int count);
}
