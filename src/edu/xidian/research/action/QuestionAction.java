package edu.xidian.research.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.research.service.impl.PaperServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;
import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;


@Controller("questionAction")
@Scope("prototype")
public class QuestionAction extends SuperAction{
	
	private QuestionServiceImpl questionServiceImpl;
	private PaperServiceImpl paperServiceImpl;

	public QuestionServiceImpl getQuestionServiceImpl() {
		return questionServiceImpl;
	}

	@Resource
	public void setQuestionServiceImpl(QuestionServiceImpl questionServiceImpl) {
		this.questionServiceImpl = questionServiceImpl;
	}

	
	
	public PaperServiceImpl getPaperServiceImpl() {
		return paperServiceImpl;
	}
	@Resource
	public void setPaperServiceImpl(PaperServiceImpl paperServiceImpl) {
		this.paperServiceImpl = paperServiceImpl;
	}

	//添加问题
	public String add()
	{
		int questiontype = Integer.parseInt(request.getParameter("questiontype"));
		Question q = new Question();
		int qnum = questionServiceImpl.getquestionnum(questiontype)+1;
		q.setSqnum(qnum);
		q.setSqtype(questiontype);
		q.setSque(request.getParameter("questioncontent"));
		questionServiceImpl.addQuestion(q);
		if( questiontype!=3 && questiontype!=4 )
		{
			int onum =Integer.parseInt(request.getParameter("optionnum"));
			if(questiontype==1)
			{
				for(int i=1;i<=onum;i++)
				{
					SelSinOption so = new SelSinOption();
					so.setItem((char)(64+i));
					so.setOptiontype(Integer.parseInt(request.getParameter("option"+i+"type")));
					so.setSqnum(qnum);
					so.setSqoption(request.getParameter("option"+i+"content"));
					questionServiceImpl.addSelSinOption(so);
				}
			}
			else
			{
				for(int i=1;i<=onum;i++)
				{
					SelMulOption mo = new SelMulOption();
					mo.setItem((char)(64+i));
					mo.setOptiontype(Integer.parseInt(request.getParameter("option"+i+"type")));
					mo.setSqnum(qnum);
					mo.setSqoption(request.getParameter("option"+i+"content"));
					questionServiceImpl.addSelMulOption(mo);
				}
				
			}
		}
		return SUCCESS;
	}

	public String updateQuestion()
	{
		int questiontype = Integer.parseInt(request.getParameter("questiontype"));
		int questionnum = Integer.parseInt(request.getParameter("questionnum"));
		int optioncount = Integer.parseInt(request.getParameter("optioncount"));
		int orgoptioncount = questionServiceImpl.getQuestionOptionNum(questionnum, questiontype);
		if(questiontype==1) //单选题
		{
			//题目
			if(request.getParameter("questiontitle")!=null)
			{
				Question question = new Question();
				question.setSqnum(questionnum);
				question.setSqtype(questiontype);
				question.setSque(request.getParameter("questiontitle"));
				questionServiceImpl.updateQuestion(question);
				
			}
			//选项
			for(int i=1;i<=optioncount;i++)
			{
				if(request.getParameter("option"+i)!=null)
				{
					SelSinOption selSinOption = questionServiceImpl.getSelSinOption(questionnum, (char)(64+i));
					
					selSinOption.setOptiontype(Integer.parseInt(request.getParameter("option"+i+"type")));
					selSinOption.setSqoption(request.getParameter("option"+i));
					questionServiceImpl.updateSelSinOption(selSinOption);
				}
			}
			
			if(orgoptioncount<optioncount)
				{
				
					for(int i=optioncount-orgoptioncount-1;i>=0;i--)
					{	
						int oc=optioncount-i;
						SelSinOption selSinOption = new SelSinOption();
						selSinOption.setOptiontype(Integer.parseInt(request.getParameter("option"+oc+"type")));
						selSinOption.setItem((char)(64+oc));
						selSinOption.setSqnum(questionnum);
						selSinOption.setSqoption(request.getParameter("option"+oc));
						questionServiceImpl.addSelSinOption(selSinOption);
					
					}
					
				}
			if(orgoptioncount>optioncount)
			{
				for(int i=0;i<orgoptioncount-optioncount;i++)
				{
					SelSinOption selSinOption= questionServiceImpl.getSelSinOption(questionnum, (char)(64+orgoptioncount-i));
					questionServiceImpl.delSelSinOption(selSinOption);
					
				}
			}
			request.getSession().setAttribute("qsinmap", paperServiceImpl.getSelSinOption());		//session中存入题目和相应选项
			request.getSession().setAttribute("sqsinlist", paperServiceImpl.getSelsinQuestion());
		
		}
		if(questiontype==2)//多选题
		{
			//题目
			if(request.getParameter("questiontitle")!=null)
			{
				Question question = new Question();
				question.setSqnum(questionnum);
				question.setSqtype(questiontype);
				question.setSque(request.getParameter("questiontitle"));
				questionServiceImpl.updateQuestion(question);
				
			}
			//选项
			for(int i=1;i<=optioncount;i++)
			{
				if(request.getParameter("option"+i)!=null)
				{
					SelMulOption selMulOption = questionServiceImpl.getSelMulOption(questionnum, (char)(64+i));
					selMulOption.setOptiontype(Integer.parseInt(request.getParameter("option"+i+"type")));
					selMulOption.setSqoption(request.getParameter("option"+i));
					questionServiceImpl.updateSelMulOption(selMulOption);
				}
			}
			if(orgoptioncount<optioncount)
			{
			
				for(int i=optioncount-orgoptioncount-1;i>=0;i--)
				{	
					int oc=optioncount-i;
					SelMulOption selMulOption = new SelMulOption();
					selMulOption.setOptiontype(Integer.parseInt(request.getParameter("option"+oc+"type")));
					selMulOption.setItem((char)(64+oc));
					selMulOption.setSqnum(questionnum);
					selMulOption.setSqoption(request.getParameter("option"+oc));
					questionServiceImpl.addSelMulOption(selMulOption);
					
				}
				
			}
			if(orgoptioncount>optioncount)
			{
				for(int i=0;i<orgoptioncount-optioncount;i++)
				{
					SelMulOption selMulOption= questionServiceImpl.getSelMulOption(questionnum, (char)(64+orgoptioncount-i));
					questionServiceImpl.delSelMulOption(selMulOption);
					
				}
			}
			request.getSession().setAttribute("qmulmap", paperServiceImpl.getSelMulOption());
			
			request.getSession().setAttribute("sqmullist", paperServiceImpl.getSelmulQuestion());
			
		}
		
		if(questiontype==3)
		{
			//简答题目
			if(request.getParameter("questiontitle")!=null)
			{
				Question question = new Question();
				question.setSqnum(questionnum);
				question.setSqtype(questiontype);
				question.setSque(request.getParameter("questiontitle"));
				questionServiceImpl.updateQuestion(question);
				
			}
			request.getSession().setAttribute("textlist", paperServiceImpl.getTextQuestion());
			
		}
		if(questiontype==4)
		{
			//列举题目
			if(request.getParameter("questiontitle")!=null)
			{
				Question question = new Question();
				question.setSqnum(questionnum);
				question.setSqtype(questiontype);
				question.setSque(request.getParameter("questiontitle"));
				questionServiceImpl.updateQuestion(question);
				
			}
			request.getSession().setAttribute("listlist", paperServiceImpl.getListQuestion());
			
		}
		return SUCCESS;
	}
	
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
	

}
