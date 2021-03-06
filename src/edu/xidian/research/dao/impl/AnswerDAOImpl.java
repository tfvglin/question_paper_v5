package edu.xidian.research.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import edu.xidian.research.dao.AnswerDAO;
import edu.xidian.research.template.MyHibernateTemplate;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.ListAnswer;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.Students;
import edu.xidian.research.vo.TextAnswer;


@Repository("answerDAOImpl")
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
	
	
	
	@Override
	public long getAnswersNumBySex(String sex) {
		long answernum = 0;
		try
		{
			final String hql = "select count(*) from AnswersPaper where sex = "+sex;
		
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

	@Override
	public long getAnswersNumByHukou(String hukou) {
		long answernum = 0;
		try
		{
			final String hql = "select count(*) from AnswersPaper where hukou = "+hukou;
		
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

	@Override
	public long getAnswersNumByProvince(String province) {
		long answernum = 0;
		try
		{
			final String hql = "select count(*) from AnswersPaper where province = "+"'"+province+"'";
		
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

	
	
	@Override
	public long getAnswersNumByDepartment(String department) {
		long answernum = 0;
		try
		{
			final String hql = "select count(*) from AnswersPaper where studepartment = "+"'"+department+"'";
		
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

	public int getAnswersOptionNum(final int qnum,final String sans ) {
		int answeronum = 0;
		try
		{
			final String hql = "select count(*) from SingleAnswer where qnum=:qnum and sans=:sans";
		
			answeronum =  this.getHibernateTemplate().execute(
					new HibernateCallback(){
                        public Object doInHibernate(Session session)
                        {
                        	
                        	Query query = session.createQuery(hql);
                        	query.setParameter("qnum", qnum);
                        	query.setParameter("sans", sans);
                        	long a = (Long) query.uniqueResult();
                        	return (int)a;
                        }
					});
			
			return answeronum;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return answeronum;
		}
	}

	
	
	
	@Override
	public List<Integer> getSingleAnswerOptionNum(final int qnum,final int questionOptionNum) {
		
		final String hql = "select count(*) from  SingleAnswer  where qnum=:qnum and sans=:sans";
		List<Integer> numlist =new ArrayList<Integer>();
		try
		{
			
			
			return this.getHibernateTemplate().execute(
						new HibernateCallback(){
	                        public Object doInHibernate(Session session)
	                        {
	                        	List<Integer> list =new ArrayList<Integer>();
	                        	Query query = session.createQuery(hql);
	                        	query.setParameter("qnum", qnum);
	                        	for(int i=0;i<questionOptionNum;i++)
	                			{
	                        		query.setParameter("sans",String.valueOf((char)(65+i)));
	                        		//System.out.println(String.valueOf((char)(65+i)));
	                        		long a = (Long) query.uniqueResult();
	                        		//System.out.println(a);
	                        		list.add((int)a);
	                        		
	                			}
	                        	return list;
	                        }
						});	 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return numlist;
		}
	}

	
	
	@Override
	public List<Integer> getSingleAnserOptionNumByPID(final int qnum,
			final int questionOptionNum,String pIDstr) {
		final String hql = "select count(*) from  SingleAnswer  where qnum=:qnum and sans=:sans and pID in "+pIDstr;
		List<Integer> numlist =new ArrayList<Integer>();
		try
		{
			
			
			return this.getHibernateTemplate().execute(
						new HibernateCallback(){
	                        public Object doInHibernate(Session session)
	                        {
	                        	List<Integer> list =new ArrayList<Integer>();
	                        	Query query = session.createQuery(hql);
	                        	query.setParameter("qnum", qnum);
	                        	for(int i=0;i<questionOptionNum;i++)
	                			{
	                        		query.setParameter("sans",String.valueOf((char)(65+i)));
	                        		//System.out.println(String.valueOf((char)(65+i)));
	                        		long a = (Long) query.uniqueResult();
	                        		//System.out.println(a);
	                        		list.add((int)a);
	                        		
	                			}
	                        	return list;
	                        }
						});	 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return numlist;
		}
	}

	public List<Integer> getAnswersOptionNumList(int sqtype, final int qnum,final int questionOptionNum) {
		List<Integer> numlist =new ArrayList<Integer>();
		
		String answertable = null;
		if(sqtype==1)
		{
			answertable="SingleAnswer";
		}
		else if(sqtype==2)
		{
			answertable="MultipleAnswer";
		}
		final String hql = "select count(*) from "+answertable+" where qnum=:qnum and sans=:sans";
		
		try
		{
			
			
			return this.getHibernateTemplate().execute(
						new HibernateCallback(){
	                        public Object doInHibernate(Session session)
	                        {
	                        	List<Integer> list =new ArrayList<Integer>();
	                        	Query query = session.createQuery(hql);
	                        	query.setParameter("qnum", qnum);
	                        	for(int i=0;i<questionOptionNum;i++)
	                			{
	                        		query.setParameter("sans",String.valueOf((char)(65+i)));
	                        		System.out.println(String.valueOf((char)(65+i)));
	                        		long a = (Long) query.uniqueResult();
	                        		System.out.println(a);
	                        		list.add((int)a);
	                        		
	                			}
	                        	return list;
	                        }
						});	 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return numlist;
		}
	}

	@Override
	public List<String> getMultipleQuestionOptionAnswer(final int sqnum) {
		List<String> anslist = new ArrayList<String>();
		try
		{
			
			final String hql = "select mans from MultipleAnswer where qnum=:sqnum";
			anslist =this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
				{
					Query query = session.createQuery(hql);
					query.setParameter("sqnum", sqnum);
					return query.list();
			
				}
			});
			return anslist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return anslist;
		}
	}
	
	
	
	
	
	@Override
	public List<String> getMultipleQuestionOptionAnswerByPID(final int sqnum, String pIDstr) {
		List<String> anslist = new ArrayList<String>();
		try
		{
			
			final String hql = "select mans from MultipleAnswer where qnum=:sqnum and pID in "+pIDstr;
			anslist =this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
				{
					Query query = session.createQuery(hql);
					query.setParameter("sqnum", sqnum);
					return query.list();
			
				}
			});
			return anslist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return anslist;
		}
	}

	@Override
	public List<SingleAnswer> getSingleQuestionAnswer(int pID) {
		List<SingleAnswer> singlelist = new ArrayList<SingleAnswer>();
		try
		{
			String hql = "from SingleAnswer where pID=?";
			
			singlelist = this.getHibernateTemplate().find(hql,pID);
			
			return singlelist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return singlelist;
		}
	}

	@Override
	public List<MultipleAnswer> getMultipleQuestionAnswer(int pID) {
		List<MultipleAnswer> Multiplelist = new ArrayList<MultipleAnswer>();
		try
		{
			String hql = "from MultipleAnswer where pID=?";
			
			Multiplelist = this.getHibernateTemplate().find(hql,pID);
			
			return Multiplelist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return Multiplelist;
		}
	}

	@Override
	public List<TextAnswer> getTextQuestionAnswer(int pID) {
		List<TextAnswer> textlist = new ArrayList<TextAnswer>();
		try
		{
			String hql = "from TextAnswer where pID=?";
			
			textlist = this.getHibernateTemplate().find(hql,pID);
			
			return textlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return textlist;
		}
	}

	@Override
	public List<ListAnswer> getListQuestionAnswer(int pID) {
		List<ListAnswer> listlist = new ArrayList<ListAnswer>();
		try
		{
			String hql = "from ListAnswer where pID=?";
			
			listlist = this.getHibernateTemplate().find(hql,pID);
			
			return listlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return listlist;
		}
	}

	
	
	@Override
	public List<Integer> getAnswerpaperPidBySex(String sex) {
		
		List<Integer> pIDlist = new ArrayList<Integer>();
		try
		{
			String hql = "select pID from AnswersPaper where sex=?";
			
			pIDlist = this.getHibernateTemplate().find(hql,sex);
			
			return pIDlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return pIDlist;
		}
	}

	
	
	@Override
	public List<Integer> getAnswerpaperPidByHukou(String hukou) {
		List<Integer> pIDlist = new ArrayList<Integer>();
		try
		{
			String hql = "select pID from AnswersPaper where hukou=?";
			
			pIDlist = this.getHibernateTemplate().find(hql,hukou);
			
			return pIDlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return pIDlist;
		}
	}

	
	
	
	
	@Override
	public List<Integer> getAnswerpaperPidByDepartment(String department) {
		List<Integer> pIDlist = new ArrayList<Integer>();
		try
		{
			String hql = "select pID from AnswersPaper where studepartment=?";
			
			pIDlist = this.getHibernateTemplate().find(hql,department);
			
			return pIDlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return pIDlist;
		}
	}

	@Override
	public List<Integer> getAnswerpaperPidByMarjor(String marjor) {
		List<Integer> pIDlist = new ArrayList<Integer>();
		try
		{
			String hql = "select pID from AnswersPaper where stumarjor=?";
			
			pIDlist = this.getHibernateTemplate().find(hql,marjor);
			
			return pIDlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return pIDlist;
		}
	}
	public List<Integer> getAnswerpaperPidByProvince(String province) {
		List<Integer> pIDlist = new ArrayList<Integer>();
		try
		{
			String hql = "select pID from AnswersPaper where province=?";
			
			pIDlist = this.getHibernateTemplate().find(hql,province);
			
			return pIDlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
			return pIDlist;
		}
	}
	
	

	@Override
	public List<Integer> getAnswerpaperPidByCascade(String sql) {
		List<Integer> pIDlist = new ArrayList<Integer>();
		try
		{
			
			
			pIDlist = this.getHibernateTemplate().find(sql);
			
			return pIDlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
			return pIDlist;
		}
	}

	@Override
	public Integer getMinPID() {
		Integer minPid=null;
		try
		{
			String hql = "select min(pID) from AnswersPaper ";
			
			List<Integer> pid= this.getHibernateTemplate().find(hql);
			minPid=pid.get(0);
			return minPid;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return minPid;
		}
	}

	@Override
	public Integer getMaxPID() {
		Integer maxPid=null;
		try
		{
			String hql = "select max(pID) from AnswersPaper ";
			
			List<Integer> pid= this.getHibernateTemplate().find(hql);
			maxPid=pid.get(0);
			return maxPid;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return maxPid;
		}
	}

	
	
	
	@Override
	public List<AnswersPaper> getAnswersPaperByPidstr(String pidstr) {
		
		List<AnswersPaper> aplist = new ArrayList<AnswersPaper>();
		try
		{
			String hql = "from AnswersPaper where pID in "+pidstr;
			
			aplist = this.getHibernateTemplate().find(hql);
			
			return aplist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return aplist;
		}
	}

	
	
	
	@Override
	public List<String> getAnswersPaperDepartment() {
		List<String> departmentlist = new ArrayList<String>();
		try
		{
			final String hql = "select studepartment from AnswersPaper group by studepartment";
		
			departmentlist = this.getHibernateTemplate().find(hql);
			
			return departmentlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return departmentlist;
		}
	}

	@Override
	public List<String> getAnswersPaperMarjor() {
		List<String> marjorlist = new ArrayList<String>();
		try
		{
			String hql = "select stumarjor from AnswersPaper group by stumarjor";
		
			marjorlist = this.getHibernateTemplate().find(hql);
			
			return marjorlist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return marjorlist;
		}
	}

	@Override
	public List<String> getAnswersPaperProvince() {
		List<String> provincelist = new ArrayList<String>();
		try
		{
			String hql = "select province from AnswersPaper group by province";
			
			provincelist = this.getHibernateTemplate().find(hql);
			
			return provincelist;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		
			return provincelist;
		}
	}

	public boolean checkStudents(Students stu)
	{
		try
		{
			String hql ="from AnswersPaper where stuname=? and cardid=?";
			List<Students> stulist = this.getHibernateTemplate().find(hql,stu.getStuname(),stu.getCardid());
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
