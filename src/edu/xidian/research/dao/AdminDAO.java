package edu.xidian.research.dao;

import edu.xidian.research.vo.Admin;

public interface AdminDAO {
	public boolean adminLogin(Admin ad);
	
	public boolean addAdmin(Admin ad);
}
