package edu.xidian.research.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import edu.xidian.research.dao.AdminDAO;
import edu.xidian.research.template.MyHibernateTemplate;
import edu.xidian.research.vo.Admin;


@Repository("adminDAOImpl")
public class AdminDAOImpl extends MyHibernateTemplate implements AdminDAO{
	
	public boolean adminLogin(Admin ad)
	{
		
		String hql="from Admin where adminname=? and adminpassword=?";
		try
		{
		
			List<Admin> admin = this.getHibernateTemplate().find(hql, ad.getAdminname(),ad.getAdminpassword());
			
			if(admin.size()<=0)
			{
				return false;
				
			}
			else
			{
				return true;
			}
		}
		catch(Exception ex)
		{
				ex.printStackTrace();
				return false;
		}

		
	}
	
	public boolean addAdmin(Admin ad)
	{
		
		
		try
		{
			
			this.getHibernateTemplate().save(ad);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
			return false;
		}

	}


}
