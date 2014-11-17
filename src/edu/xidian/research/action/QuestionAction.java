package edu.xidian.research.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.research.service.impl.QuestionServiceImpl;
import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;


@Controller("questionAction")
@Scope("prototype")
public class QuestionAction extends SuperAction{
	
	private QuestionServiceImpl questionServiceImpl;
	

	public QuestionServiceImpl getQuestionServiceImpl() {
		return questionServiceImpl;
	}

	@Resource
	public void setQuestionServiceImpl(QuestionServiceImpl questionServiceImpl) {
		this.questionServiceImpl = questionServiceImpl;
	}

	public void add()
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
			//int optiontype = Integer.parseInt(request.getParameter("optiontype"));
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
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}
	

}
