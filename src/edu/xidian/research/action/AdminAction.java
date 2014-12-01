package edu.xidian.research.action;


import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import edu.xidian.research.service.impl.AdminServiceImpl;
import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.PaperServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;

import edu.xidian.research.util.ExcelUtil;

import edu.xidian.research.service.impl.StudentsServiceImpl;

import edu.xidian.research.util.PagerUtil;

import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.Students;


@Controller("adminAction")
@Scope("prototype") 
public class AdminAction extends SuperAction implements ModelDriven<Admin>{
	
	private Admin admin = new Admin();
	private AdminServiceImpl adminServiceImpl ;
	private QuestionServiceImpl questionServiceImpl;
	private AnswerServiceImpl answerServiceImpl;

	private ExcelUtil excelUtil;
	

	private PaperServiceImpl paperServiceImpl;
	private StudentsServiceImpl studentsServiceImpl;

	private PagerUtil pageUtil;

	
	
	public AdminServiceImpl getAdminServiceImpl() {
		return adminServiceImpl;
	}
	@Resource
	public void setAdminServiceImpl(AdminServiceImpl adminServiceImpl) {
		this.adminServiceImpl = adminServiceImpl;
	}

	public QuestionServiceImpl getQuestionServiceImpl() {
		return questionServiceImpl;
	}
	@Resource
	public void setQuestionServiceImpl(QuestionServiceImpl questionServiceImpl) {
		this.questionServiceImpl = questionServiceImpl;
	}

	public AnswerServiceImpl getAnswerServiceImpl() {
		return answerServiceImpl;
	}
	@Resource
	public void setAnswerServiceImpl(AnswerServiceImpl answerServiceImpl) {
		this.answerServiceImpl = answerServiceImpl;
	}
	
	
	public PaperServiceImpl getPaperServiceImpl() {
		return paperServiceImpl;
	}
	@Resource
	public void setPaperServiceImpl(PaperServiceImpl paperServiceImpl) {
		this.paperServiceImpl = paperServiceImpl;
	}


	public StudentsServiceImpl getStudentsServiceImpl() {
		return studentsServiceImpl;
	}
	@Resource
	public void setStudentsServiceImpl(StudentsServiceImpl studentsServiceImpl) {
		this.studentsServiceImpl = studentsServiceImpl;
	}

	public ExcelUtil getExcelUtil() {
		return excelUtil;
	}
	@Resource
	public void setExcelUtil(ExcelUtil excelUtil) {
		this.excelUtil = excelUtil;
	}

	
	public PagerUtil getPageUtil() {
		return pageUtil;
	}
	@Resource
	public void setPageUtil(PagerUtil pageUtil) {
		this.pageUtil = pageUtil;
	}

	public String login()
	{
		
		if(adminServiceImpl.adminLogin(admin))
		{
	
			request.getSession().setAttribute("c", answerServiceImpl.getAnswersNum());
//			List<Question> sqsinlist = paperServiceImpl.getSelsinQuestion();
//			List<Question> sqmullist = paperServiceImpl.getSelmulQuestion();
//			Map<Integer, List<SelSinOption>> qsinmap = paperServiceImpl.getSelSinOption();
//			Map<Integer, List<SelMulOption>> qmulmap = paperServiceImpl.getSelMulOption();
			request.getSession().setAttribute("qsinmap", paperServiceImpl.getSelSinOption());
			request.getSession().setAttribute("qmulmap", paperServiceImpl.getSelMulOption());
			request.getSession().setAttribute("sqsinlist", paperServiceImpl.getSelsinQuestion());
			request.getSession().setAttribute("sqmullist", paperServiceImpl.getSelmulQuestion());
			return "success";
		}
		else
		{
			this.addActionMessage("用户名或密码错误");
			return INPUT;
		}
	}
	
	public boolean add(Admin ad)
	{
		if(adminServiceImpl.addAdmin(ad))
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	

	public String creatExcel()
	{
		
		List<AnswersPaper> aplist = answerServiceImpl.getAnswersPaper();
		int singlecount = questionServiceImpl.getquestionnum(1);
		int multiplecount = questionServiceImpl.getquestionnum(2);
		int textcount = questionServiceImpl.getquestionnum(3);
		int listcount = questionServiceImpl.getquestionnum(4);
		 try {
			

			 excelUtil.creatExcel(singlecount, multiplecount, textcount, listcount, aplist);


            return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return INPUT;
		}
	}

	
public String showStudents()
{
	List<Students> stus=studentsServiceImpl.list();
	if(request.getSession().getAttribute("pager")==null)
	{
		
		request.getSession().setAttribute("pager", pageUtil);
	}
	pageUtil =(PagerUtil)request.getSession().getAttribute("pager");
	pageUtil.setBigList(stus);
	//System.out.println(request.getParameter("PageIndex")==null||request.getParameter("pageIndex").equals(""));
	if(request.getParameter("PageIndex")==null)
	{
		pageUtil.setCurentPageIndex(1);
//		System.out.println("aa-------------------");
//		List<Students> list = pageUtil.getSmallList();
//		Iterator<Students> it = list.iterator();
//		while(it.hasNext())
//		{
//			System.out.println(it.next().getStuname());
//		}
//		
	}
	else
	{
	//	System.out.println("bb-------------------");
		pageUtil.setCurentPageIndex(Integer.parseInt(request.getParameter("PageIndex")));
	}
	request.getSession().setAttribute("pager", pageUtil);
	return SUCCESS;
}

	public String showAnswerStudents()
	{
		
	}
	
	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}

}
