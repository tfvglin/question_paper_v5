package edu.xidian.research.action;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import edu.xidian.research.service.impl.AdminServiceImpl;
import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.PaperServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;
import edu.xidian.research.service.impl.StudentsServiceImpl;
import edu.xidian.research.util.ExcelUtil;
import edu.xidian.research.util.PagerUtil;
import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.ListAnswer;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.Students;
import edu.xidian.research.vo.TextAnswer;


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

	private PagerUtil pagerUtil;

	
	
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
		return pagerUtil;
	}
	@Resource
	public void setPageUtil(PagerUtil pageUtil) {
		this.pagerUtil = pageUtil;
	}

	//管理员登陆
	public String login()
	{
		
		if(adminServiceImpl.adminLogin(admin))
		{
	
			request.getSession().setAttribute("c", answerServiceImpl.getAnswersNum());           //session中存入答题人数
//			List<Question> sqsinlist = paperServiceImpl.getSelsinQuestion();
//			List<Question> sqmullist = paperServiceImpl.getSelmulQuestion();
//			Map<Integer, List<SelSinOption>> qsinmap = paperServiceImpl.getSelSinOption();
//			Map<Integer, List<SelMulOption>> qmulmap = paperServiceImpl.getSelMulOption();
			request.getSession().setAttribute("qsinmap", paperServiceImpl.getSelSinOption());		//session中存入题目和相应选项
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
	
	
	//添加管理员
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
	
	

	//生成excel
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

	//显示所有学生
public String showStudents()
{
	List<Students> stus=studentsServiceImpl.list();
	
	//加入分页程序
	if(request.getSession().getAttribute("pager")==null)
	{
		
		request.getSession().setAttribute("pager", pagerUtil);
	}
	pagerUtil =(PagerUtil)request.getSession().getAttribute("pager");
	pagerUtil.setBigList(stus);
	if(request.getParameter("PageIndex")==null)
	{
		pagerUtil.setCurentPageIndex(1);
	
	}
	else
	{
		pagerUtil.setCurentPageIndex(Integer.parseInt(request.getParameter("PageIndex")));
	}
	request.getSession().setAttribute("pager", pagerUtil);
	return SUCCESS;
}


	//显示答题的学生
	public String showAnswerStudents()
	{
		List<AnswersPaper> ansStudents = answerServiceImpl.getAnswersPaper();
		
		//加入分页程序
		if(request.getSession().getAttribute("pager")==null)
		{
			
			request.getSession().setAttribute("pager", pagerUtil);
		}
		pagerUtil =(PagerUtil)request.getSession().getAttribute("pager");
		pagerUtil.setBigList(ansStudents);
		if(request.getParameter("PageIndex")==null)
		{
			pagerUtil.setCurentPageIndex(1);
		
		}
		else
		{
			pagerUtil.setCurentPageIndex(Integer.parseInt(request.getParameter("PageIndex")));
		}
		request.getSession().setAttribute("pager", pagerUtil);
		return SUCCESS;
	}
	
	
	//查看学生提交的调查结果
	public String showStudentsAnswer()
	{
		int num =Integer.parseInt(request.getParameter("num")) ;
		pagerUtil = (PagerUtil) request.getSession().getAttribute("pager");
		List<AnswersPaper> smalllist=pagerUtil.getSmallList();					//获得当前页的学生集合
		request.getSession().setAttribute("studentcontent",smalllist.get(num));
		int pID = smalllist.get(num).getpID();
	
		//答案
		List<SingleAnswer> singlelist=answerServiceImpl.getSingleQuestionAnswer(pID);
		List<MultipleAnswer> multiplelist=answerServiceImpl.getMultipleQuestionAnswer(pID);
		List<TextAnswer> textlist=answerServiceImpl.getTextQuestionAnswer(pID);
		List<ListAnswer> listlist=answerServiceImpl.getListQuestionAnswer(pID);
		
		
		//题目
		List<Question> sqsinlist = paperServiceImpl.getSelsinQuestion();
		List<Question> sqmullist = paperServiceImpl.getSelmulQuestion();
		List<Question> qtextlist = paperServiceImpl.getTextQuestion();
		List<Question> qlistlist = paperServiceImpl.getListQuestion();
		
		request.getSession().setAttribute("listlist", qlistlist);
		request.getSession().setAttribute("textlist", qtextlist);
		request.getSession().setAttribute("sqsinlist", sqsinlist);
		request.getSession().setAttribute("sqmullist", sqmullist);
		
		//key=题号  value=答案 组成map对象
		Map<Integer,SingleAnswer> singlemap = new HashMap<>();
		Map<Integer,MultipleAnswer> multiplemap = new HashMap<>();
		Map<Integer,TextAnswer> textmap = new HashMap<>();
		Map<Integer,ListAnswer> listmap = new HashMap<>();
		
		for(int i=0;i<singlelist.size();i++)
		{
			
			singlemap.put(sqsinlist.get(i).getSqnum(), singlelist.get(i));
		}
		for(int i=0;i<multiplelist.size();i++)
		{
			multiplemap.put(sqmullist.get(i).getSqnum(), multiplelist.get(i));
		}
		for(int i=0;i<textlist.size();i++)
		{
			textmap.put(qtextlist.get(i).getSqnum(), textlist.get(i));
		}
		for(int i=0;i<listlist.size();i++)
		{
			listmap.put(qlistlist.get(i).getSqnum(), listlist.get(i));
		}
		
		//map<题号，答案>存入session
		request.getSession().setAttribute("singlemap", singlemap);
		request.getSession().setAttribute("multiplemap", multiplemap);
		request.getSession().setAttribute("textmap", textmap);
		request.getSession().setAttribute("listmap", listmap);
		
		
		return SUCCESS;
	}
	
	
	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}

}
