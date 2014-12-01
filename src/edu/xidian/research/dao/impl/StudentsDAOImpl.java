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
	
	
	
<<<<<<< HEAD
	public boolean stuLogin(final Students stu)
	{
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Students s  = new Students();
=======
	public Students stuLogin(Students stu)
	{
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Students student =null;
>>>>>>> 0f9145965d41481705da22ae35b4abf323d22b1a
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
<<<<<<< HEAD
			String hql = "from Students t where t.stuname=? and  t.stunum=? ";
			System.out.println(stu.getStuname());
			List<Students> s = this.getHibernateTemplate().find(hql, stu.getStuname(),stu.getStunum());
=======
			String hql = "from Students t where t.stuname=? and  t.cardid=? ";
			
			List<Students> s = this.getHibernateTemplate().find(hql, stu.getStuname(),stu.getCardid());
>>>>>>> 0f9145965d41481705da22ae35b4abf323d22b1a
			if(s.size()>0)
			{
				student = s.get(0);
				return student;
			}
			else
			{
				return student;
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
<<<<<<< HEAD
			return false;
		}*/
=======
			return student;
		}
>>>>>>> 0f9145965d41481705da22ae35b4abf323d22b1a
	}

	
	
	@Override
	public List<Students> list() {
		String hql="from Students";
		List<Students> list= new ArrayList<Students>();
		try
		{
			list=this.getHibernateTemplate().find(hql);
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return list;
		}
	}

	public boolean addStudent(Students stu) {
		// TODO Auto-generated method stub
		try
		{
			this.getHibernateTemplate().save(stu);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}



	@Override
	public String getStuDepartment(final Students stu) {
		String studepartment = null;
		try
		{
			
			final String hql = "select studepartment from Students where stuname=:stuname and cardid=:cardid";
			studepartment =this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
				{
					Query query = session.createQuery(hql);
					query.setParameter("stuname", stu.getStuname());
					query.setParameter("cardid", stu.getCardid());
					if( query.uniqueResult()!=null)
					{
						return (String) query.uniqueResult();
					}
					else{
						return null;
					}
			
				}
			});
			return studepartment;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return studepartment;
		}
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



