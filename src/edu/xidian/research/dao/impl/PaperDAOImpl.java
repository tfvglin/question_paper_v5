package edu.xidian.research.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import edu.xidian.research.dao.PaperDAO;
import edu.xidian.research.template.MyHibernateTemplate;
import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;




@Repository("paperDAOImpl")
public class PaperDAOImpl extends MyHibernateTemplate implements PaperDAO {
	
	
	public List<Question> getSelsinQuestion()
	{
	
		List<Question> tlist = new ArrayList<Question>();
		try
		{
			String hql="from Question where sqtype =1";
			tlist=this.getHibernateTemplate().find(hql);
	
			return tlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
	
			return tlist;
		}

	}
	
	public List<Question> getSelmulQuestion()
	{

		List<Question> tlist = new ArrayList<Question>();
		try
		{
			String hql="from Question where sqtype =2";
			
			tlist=this.getHibernateTemplate().find(hql);
	
			return tlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return tlist;
		}

	}
	
	public List<Question> getTextQuestion()
	{
		
		List<Question> tlist = new ArrayList<Question>();
		try
		{
			String hql="from Question where sqtype =3";
			tlist=this.getHibernateTemplate().find(hql);
			Iterator<Question> it = tlist.iterator();
			return tlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return tlist;
		}

	}
	
	public List<Question> getListQuestion()
	{
		List<Question> tlist = new ArrayList<Question>();
		try
		{
			String hql="from Question where sqtype =4";
			
			tlist=this.getHibernateTemplate().find(hql);
			return tlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return tlist;
		}

	}
	
	public Map<Integer,List<SelSinOption>> getSelSinOption()
	{
		List<Question> qlist = new ArrayList<Question>();
		Map<Integer,List<SelSinOption>> qMap = new HashMap<Integer, List<SelSinOption>>();
		List<SelSinOption> olist;
		try
		{
			String hql = "from Question where sqtype = 1";
			qlist = this.getHibernateTemplate().find(hql);
		
			Iterator<Question> it = qlist.iterator();
			while(it.hasNext())
			{
				Question sq = it.next();
				Integer sqnum = sq.getSqnum();
				
				hql = " from SelSinOption  where sqnum=?";
			
				olist =this.getHibernateTemplate().find(hql,sqnum);
				qMap.put(sqnum, olist);
			}
			return qMap;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return qMap;
		}

	}
	
	public Map<Integer,List<SelMulOption>> getSelMulOption()
	{
		List<Question> qlist = new ArrayList<Question>();
		Map<Integer,List<SelMulOption>> qMap = new HashMap<Integer, List<SelMulOption>>();
		List<SelMulOption> olist;
		try
		{
			String hql = "from Question where sqtype =2 ";
			qlist = this.getHibernateTemplate().find(hql);
		
			Iterator<Question> it = qlist.iterator();
			while(it.hasNext())
			{
				Question sq = it.next();
				Integer sqnum = sq.getSqnum();
				
				hql = " from SelMulOption  where sqnum=?";
				olist =this.getHibernateTemplate().find(hql,sqnum);
				qMap.put(sqnum, olist);
			}
			return qMap;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return qMap;
		}

	}
	
	
	
	public long getQuestionCount(final int sqtype)
	{
		
		long count=0 ;
		try{
			final String sql = "select count(*) from Question where sqtype =:sqtype";
			count =  this.getHibernateTemplate().execute(
					new HibernateCallback()
					{
						public Object  doInHibernate(Session session)
						{
							Query query = session.createQuery(sql);
							query.setParameter("sqtype", sqtype);
							return query.uniqueResult();
						}
					
			});
			return count;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return count;
		}
	}
	
	/*public Map<Integer, List<SelectOption>> getSelectOption(int pID)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<String> qlist = getSelectQuestion(pID);
		for(String q:qlist)
		{
			List<SelectOption> olist = new ArrayList<SelectOption>();
			String hql ="from selectoption s where s.s_qnum=:s_qnum";
			Query query = session.createQuery(hql);
			query.setParameter("s_qnum", pID);
		}
		
	}*/
	
	
}
