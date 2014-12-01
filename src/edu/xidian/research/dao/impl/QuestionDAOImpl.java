package edu.xidian.research.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import edu.xidian.research.dao.QuestionDAO;
import edu.xidian.research.template.MyHibernateTemplate;
import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;


@Repository("questionDAOImpl")
public class QuestionDAOImpl extends MyHibernateTemplate implements QuestionDAO{
	

	
	
	public boolean addQuestion(Question t)
	{
		try
		{
			this.getHibernateTemplate().save(t);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}
	
	public boolean addSelSinOption(SelSinOption so)
	{
		try{
			this.getHibernateTemplate().save(so);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}
	
	public boolean addSelMulOption(SelMulOption so)
	{
		try{
			this.getHibernateTemplate().save(so);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

	}
	

	public int getquestionnum(final int sqtype)
	{
		int qnum = 0;
		try
		{
			
			final String hql = "select max(sqnum) from Question where sqtype=:sqtype";
			qnum =this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
				{
					Query query = session.createQuery(hql);
					query.setParameter("sqtype", sqtype);
					if( query.uniqueResult()!=null)
					{
						return (Integer) query.uniqueResult();
					}
					else{
						return null;
					}
			
				}
			});
			return qnum;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return qnum;
		}

	}
		
	
	}
