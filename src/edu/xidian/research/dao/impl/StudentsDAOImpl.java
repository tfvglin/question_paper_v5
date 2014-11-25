package edu.xidian.research.dao.impl;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import edu.xidian.research.dao.StudentsDAO;
import edu.xidian.research.template.MyHibernateTemplate;
import edu.xidian.research.vo.Students;


@Repository("studentsDAOImpl")
public class StudentsDAOImpl extends MyHibernateTemplate implements StudentsDAO  {
	
	
	
	public boolean stuLogin(final Students stu)
	{
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Students s  = new Students();
		try
		{
			 final String hql = "from Students t where t.stuname=:stuname and  t.stunum=:stunum ";
		
			s =  this.getHibernateTemplate().execute(
					new HibernateCallback(){
                        public Object doInHibernate(Session session)
                        {
                        	Query query = session.createQuery(hql);
                        	query.setParameter("stuname", stu.getStuname());
                        	query.setParameter("stunum", stu.getStunum());
                        	return query.uniqueResult();
                        }
					});
			
			if(s != null)
			{
			
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}

/*		try
		{
			//System.out.println(stu.getStuname()+stu.getStunum());
			String hql = "from Students t where t.stuname=? and  t.stunum=? ";
			System.out.println(stu.getStuname());
			List<Students> s = this.getHibernateTemplate().find(hql, stu.getStuname(),stu.getStunum());
			if(s.size()>0)
			{
			
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}*/
	}

	@Override
	public boolean list() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkstu(Students stu) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*public boolean list()
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Students> stus = new ArrayList<Students>();
	
		  try{

			  String hql = "from Students t where t.stunum=123 ";
			  Query query = session.createQuery(hql);
			
				Students s = (Students)query.uniqueResult();
				
				tx.commit();
				if(s!=null)
				{
					return true;
				}
				else
				{
					return false;
				}
			  
			  

			  
		  }
		  catch(Exception ex)
		  {
			 ex.printStackTrace();
			 tx.rollback();
			return false;
		  }
		
	}


	public boolean checkstu(Students stu)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			String hql="from AnswersPaper where stuname=:stuname and stunum=:stunum";
			Query query = session.createQuery(hql);
			query.setParameter("stuname", stu.getStuname());
			query.setParameter("stunum",stu.getStunum());
			Object ap =  query.uniqueResult();
			tx.commit();
			if(ap!=null)
			{
				return true;
			}
			else
			{
				return false;
			}
			
					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
			return false;
		}
	
	}*/
}



