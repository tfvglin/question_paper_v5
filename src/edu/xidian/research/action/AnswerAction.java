package edu.xidian.research.action;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.research.dao.impl.PaperDAOImpl;
import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.PaperServiceImpl;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.ListAnswer;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.TextAnswer;


@Controller("answerAction")
@Scope("prototype")
public class AnswerAction extends SuperAction{
	
	private AnswerServiceImpl answerServiceImpl;
	private PaperServiceImpl paperServiceImpl;
	
	
	
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


	//��Ӵ�
	public String add()
	{
	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		
		int singlecount = (int) paperServiceImpl.getQuestionCount(1); //��õ�ѡ����Ŀ
		int mulcount = (int)paperServiceImpl.getQuestionCount(2);     //��ö�ѡ����Ŀ
		int textcount = (int)paperServiceImpl.getQuestionCount(3);    //��ü������Ŀ
		int listcount = (int)paperServiceImpl.getQuestionCount(4);
		//��ʼ��answerpaper
		AnswersPaper ap = new AnswersPaper();
		ap.setPhone(request.getParameter("phone"));
		ap.setStuname((String)request.getSession().getAttribute("stuname"));
		ap.setCardid((String)request.getSession().getAttribute("cardid"));
		ap.setStudepartment((String)request.getSession().getAttribute("studepartment"));
		ap.setTime(df.format(date));
		//��ӵ�ѡ����
		for(int i = 1 ; i<=singlecount ; i++)
		{
			SingleAnswer sa = new SingleAnswer();
			String other;
			//List<Question> questionlist =(List<Question>)request.getSession().getAttribute("sqsinlist");
			sa.setSans(request.getParameter("sinquestion"+i));
			other=request.getParameter("sinquestion"+i+"other");
			if(other==null || other.equals("��ע��..."))
			{
				sa.setOther("");
			}
			else
			{
				sa.setOther(other);
			}
			sa.setQnum(i);
			ap.getSingleanswer().add(sa);
		}
		
		//��Ӷ�ѡ����
		for(int i = 1 ; i<=mulcount ; i++)
		{
			String[] mulans = request.getParameterValues("mulquestion"+i);
			String mans;
			if(mulans==null)
			{
				mans="";
			}
			else
			{
				List<String> list = Arrays.asList(mulans);
				mans=list.toString();
			}
			
			MultipleAnswer ma = new MultipleAnswer();
			String other;
			//List<Question> questionlist =(List<Question>)request.getSession().getAttribute("sqsinlist");
			ma.setMans(mans);
			other=request.getParameter("mulquestion"+i+"other");
			if(other==null || other.equals("��ע��..."))
			{
				ma.setOther("");
			}
			else
			{
				ma.setOther(other);
			}
			ma.setQnum(i);
			ap.getMultipleanswer().add(ma);
		}
		
		
		//��Ӽ������
			for(int i = 1 ; i<=textcount ; i++)
		{
			TextAnswer ta = new TextAnswer();
			//List<Question> questionlist =(List<Question>)request.getSession().getAttribute("sqsinlist");
			
			String str =request.getParameter("textquestion"+i);
			System.out.println(str+"---------------");
			if(str.equals(null)||str.equals(""))
			{
				ta.setTans("��");
			}
			else
			{
				ta.setTans(str);
			}
			
			ta.setQnum(i);
			ap.getTextanswer().add(ta);
		}
		
		//����о�����	
		
		for(int i=1;i<=listcount;i++)
		{
			int strlength =Integer.parseInt(request.getParameter("optionnum")) ;
			//System.out.println(strlength);
			ListAnswer la = new ListAnswer();
			String[] listans=new String[strlength];
			String str = new String();
			for(int j=1;j<=strlength;j++)
			{
				
				str=request.getParameter("listquestion"+i+"_"+j);
				if(!(str.equals(null)&&str.equals("")) )
				{
					listans[j-1]=str;
				}
			}
			List<String> list = Arrays.asList(listans);
			String lans=list.toString();
			la.setLans(lans);
			la.setQnum(i);
			ap.getListanswer().add(la);
		}
		
		//��ӽ���ɹ���������session
		if(answerServiceImpl.addAnswerPaper(ap))
		{
			request.getSession().removeAttribute("stuname");
			request.getSession().removeAttribute("stunum");
			
			request.getSession().removeAttribute("listlist");
			request.getSession().removeAttribute("textlist");
			request.getSession().removeAttribute("qsinmap");
			request.getSession().removeAttribute("qmulmap");
			request.getSession().removeAttribute("sqsinlist");
			request.getSession().removeAttribute("sqmullist");
			request.getSession().removeAttribute("studepartment");
			return "addsuccess";
		}
		else
		{
			return "error";
		}
		
		
		
		
	}
	
	
}
