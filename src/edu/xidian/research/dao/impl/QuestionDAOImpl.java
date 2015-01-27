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
	
	
	

	@Override
	public void delSelSinOption(SelSinOption so) {
		this.getHibernateTemplate().delete(so);
		
	}

	@Override
	public void delSelMulOption(SelMulOption so) {
		this.getHibernateTemplate().delete(so);
		
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

	@Override
	public int getSingleQuestionOptionNum(final int sqnum) {
		
		int sqonum = 0;
		try
		{
			
			final String hql = "select count(*) from SelSinOption where sqnum=:sqnum";
			sqonum =this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
				{
					Query query = session.createQuery(hql);
					query.setParameter("sqnum", sqnum);
					if( query.uniqueResult()!=null)
					{
						long a =(Long) query.uniqueResult();
						return (int)a;
					}
					else{
						return null;
					}
			
				}
			});
			return sqonum;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return sqonum;
		}
	}
	
	
	public int getQuestionOptionNum(final int sqnum,final int sqtype)
	{
		int sqonum = 0;
		String answertable = null;
		if(sqtype==1)
		{
			answertable="SelSinOption";
		}
		else if(sqtype==2)
		{
			answertable="SelMulOption";
		}
		try
		{
			
			final String hql = "select count(*) from "+answertable+" where sqnum=:sqnum";
			sqonum =this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
				{
					Query query = session.createQuery(hql);
					query.setParameter("sqnum", sqnum);
					if( query.uniqueResult()!=null)
					{
						long a =(Long) query.uniqueResult();
						return (int)a;
					}
					else{
						return null;
					}
			
				}
			});
			return sqonum;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return sqonum;
		}
	}

	@Override
	public Question getQuestion(int qid) {
		
		Question question = (Question)this.getHibernateTemplate().get(Question.class, qid);
		return question;
	}

	@Override
	public SelMulOption getSelMulOption(final int qnum, final char item) {
		SelMulOption selMulOption = null;
		final String hql = "from SelMulOption where sqnum=:sqnum and item=:item";
		try
		{
			selMulOption = this.getHibernateTemplate().execute(new HibernateCallback<SelMulOption>() {
				public SelMulOption doInHibernate(Session session)
				{
					Query query = session.createQuery(hql);
					query.setInteger("sqnum", qnum);
					query.setCharacter("item", item);
					if( query.uniqueResult()!=null)
					{
						return (SelMulOption) query.uniqueResult();
					}
					else{
						return null;
					}
				}
			});
			return selMulOption;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return selMulOption;
		}
		
	}

	@Override
	public SelSinOption getSelSinOption(final int qnum, final char item) {
		SelSinOption selSinOption = null;
		final String hql = "from SelSinOption where sqnum=:sqnum and item=:item";
		try
		{
			selSinOption = this.getHibernateTemplate().execute(new HibernateCallback<SelSinOption>() {
				public SelSinOption doInHibernate(Session session)
				{
					Query query = session.createQuery(hql);
					query.setInteger("sqnum", qnum);
					query.setCharacter("item", item);
					if( query.uniqueResult()!=null)
					{
						return (SelSinOption) query.uniqueResult();
					}
					else{
						return null;
					}
				}
			});
			return selSinOption;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return selSinOption;
		}
	}

	@Override
	public int getQuestionID(final int qnum,final int qtype) {
		int qID = 0;
		try
		{
			
			final String hql = "select sqID from Question where sqnum=:sqnum and sqtype=:sqtype";
			qID =this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
				{
					Query query = session.createQuery(hql);
					query.setParameter("sqnum", qnum);
					query.setParameter("sqtype", qtype);
					if( query.uniqueResult()!=null)
					{
						return (Integer) query.uniqueResult();
					}
					else{
						return null;
					}
			
				}
			});
			return qID;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return qID;
		}
	}

	@Override
	public void updateQuestion(Question q) {
		this.getHibernateTemplate().update(q);
		
	}


	
	
	
}
