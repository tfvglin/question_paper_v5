package edu.xidian.research.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import edu.xidian.research.dao.AnswerDAO;
import edu.xidian.research.template.MyHibernateTemplate;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.Students;
import edu.xidian.research.vo.TextAnswer;


@Repository("anserDAOImpl")
public class AnswerDAOImpl extends MyHibernateTemplate implements AnswerDAO {
	
	public boolean addAnswerPaper(AnswersPaper ap)
	{
		
		try
		{
			this.getHibernateTemplate().save(ap);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
	
			return false;
		}

	}
	
	public boolean addMultipleAnswer(MultipleAnswer ma)
	{
		
		try
		{
			this.getHibernateTemplate().save(ma);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
	
			return false;
		}
	}
	
	public boolean addSingleAnswer(SingleAnswer sa)
	{
		
		try
		{
			this.getHibernateTemplate().save(sa);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return false;
		}

	}
	
	public boolean addTextAnswer(TextAnswer ta)
	{
		
		try
		{
			this.getHibernateTemplate().save(ta);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
	
			return false;
		}

	}
	
	
	public List<AnswersPaper> getAnswersPaper()
	{
		
		List<AnswersPaper> aplist = new ArrayList<AnswersPaper>();
		try
		{
			String hql = "from AnswersPaper";
			
			aplist = this.getHibernateTemplate().find(hql);
			
			return aplist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return aplist;
		}

	}
	
	
	public long getAnswersNum()
	{
	
		long answernum = 0;
		try
		{
			final String hql = "select count(*) from AnswersPaper";
		
			answernum =  this.getHibernateTemplate().execute(
					new HibernateCallback(){
                        public Object doInHibernate(Session session)
                        {
                        	Query query = session.createQuery(hql);
                        	return query.uniqueResult();
                        }
					});
			
			return answernum;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return answernum;
		}

	}
	
	
	public boolean checkStudents(Students stu)
	{
		try
		{
			String hql ="from AnswersPaper where stuname=? and stunum=?";
			List<Students> stulist = this.getHibernateTemplate().find(hql,stu.getStuname(),stu.getStunum());
			if(stulist.size()<=0)
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
			return true;
		}
	}
	

}
