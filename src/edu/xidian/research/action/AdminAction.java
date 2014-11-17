package edu.xidian.research.action;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.opensymphony.xwork2.ModelDriven;

import edu.xidian.research.service.impl.AdminServiceImpl;
import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;
import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.ListAnswer;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.TextAnswer;


@Controller("adminAction")
@Scope("prototype") 
public class AdminAction extends SuperAction implements ModelDriven<Admin>{
	
	private Admin admin = new Admin();
	private AdminServiceImpl adminServiceImpl ;
	private QuestionServiceImpl questionServiceImpl;
	private AnswerServiceImpl answerServiceImpl;
	
	
	
	
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

	public String login()
	{
		request.getSession().setAttribute("c", answerServiceImpl.getAnswersNum());
		
		if(adminServiceImpl.adminLogin(admin))
		{
	
			
			return SUCCESS;
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
	
	
	public String addquestion()
	{
		return "addtiles";
	}
	public String resultquestion()
	{
		return "resulttiles";
	}
	public String creatExcel()
	{
		
		List<AnswersPaper> aplist = answerServiceImpl.getAnswersPaper();
		int singlecount = questionServiceImpl.getquestionnum(1);
		int multiplecount = questionServiceImpl.getquestionnum(2);
		int textcount = questionServiceImpl.getquestionnum(3);
		int listcount = questionServiceImpl.getquestionnum(4);
		 try {
			
			 WritableWorkbook wb = Workbook.createWorkbook(new File("D:/answer.xls"));
			 WritableSheet st = wb.createSheet("调查结果", 0);

			
			 st.addCell(new Label(0,0,"stuname"));
			 st.addCell(new Label(1,0,"stunum"));
			 st.addCell(new Label(2,0,"phone"));
			 st.addCell(new Label(3,0,"time"));
			 int j=4;
			  for(int i=1;i<=singlecount;i++)
			 {

				 st.addCell(new Label(j++,0,"sx"+i));
				 st.addCell(new Label(j++,0,"sxqt"+i));
			 }
			 
			  for(int i=1;i<=multiplecount;i++)
			  {
				  st.addCell(new Label(j++,0,"mx"+i));
				  st.addCell(new Label(j++,0,"mxqt"+i));
			  }
			  for(int i=1;i<=textcount;i++)
			  {
				  st.addCell(new Label(j++,0,"jd"+i));
				  
			  }
			  for(int i=1;i<=listcount;i++)
			  {
				  st.addCell(new Label(j++,0,"lj"+i));
			  }
			 
			 
			 Iterator<AnswersPaper> apit = aplist.iterator();
			int l=1;
			 while(apit.hasNext())
			 {
				 AnswersPaper ap = apit.next();
				 List<SingleAnswer> salist=ap.getSingleanswer();
				 List<MultipleAnswer> malist = ap.getMultipleanswer();
				 List<TextAnswer> talist = ap.getTextanswer();
				 List<ListAnswer> lalist = ap.getListanswer();
				 int n=0;
				
				 
					 st.addCell(new Label(n++,l,ap.getStuname()));
					 st.addCell(new Label(n++,l,ap.getStunum()));
					 st.addCell(new Label(n++,l,ap.getPhone()));
					 st.addCell(new Label(n++,l,ap.getTime()));
					
					 for(int i=0;i<singlecount;i++)
					 {
						
						 st.addCell(new Label(n++,l,salist.get(i).getSans()));
						 st.addCell(new Label(n++,l,salist.get(i).getOther()));
					 }
					 for(int i=0;i<multiplecount;i++)
					 {
						
						 st.addCell(new Label(n++,l,malist.get(i).getMans()));
						 st.addCell(new Label(n++,l,malist.get(i).getOther()));
					 }
					 for(int i=0;i<textcount;i++)
					 {
						 st.addCell(new Label(n++,l,talist.get(i).getTans()));
					 }
					 for(int i=0;i<listcount;i++)
					 {
						 st.addCell(new Label(n++,l,lalist.get(i).getLans()));
					 }
				 l++;
			 }
			 
		
			wb.write();
            wb.close();
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
