package edu.xidian.research.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import edu.xidian.research.service.impl.AdminServiceImpl;
import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;
import edu.xidian.research.util.ExcelUtil;
import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.AnswersPaper;


@Controller("adminAction")
@Scope("prototype") 
public class AdminAction extends SuperAction implements ModelDriven<Admin>{
	
	private Admin admin = new Admin();
	private AdminServiceImpl adminServiceImpl ;
	private QuestionServiceImpl questionServiceImpl;
	private AnswerServiceImpl answerServiceImpl;
	private ExcelUtil excelUtil;
	
	
	
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

	public ExcelUtil getExcelUtil() {
		return excelUtil;
	}
	@Resource
	public void setExcelUtil(ExcelUtil excelUtil) {
		this.excelUtil = excelUtil;
	}
	public String login()
	{
		request.getSession().setAttribute("c", answerServiceImpl.getAnswersNum());
		
		if(adminServiceImpl.adminLogin(admin))
		{
	
			
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


	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}

}
