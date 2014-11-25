package edu.xidian.research.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import edu.xidian.research.dao.impl.PaperDAOImpl;
import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.PaperServiceImpl;
import edu.xidian.research.service.impl.StudentsServiceImpl;
import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;
import edu.xidian.research.vo.Students;


@Controller("studentsAction")
@Scope("prototype")
public class StudentsAction extends SuperAction implements ModelDriven<Students>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Students stu = new Students();
	
	private StudentsServiceImpl studentsServiceImpl;
	
	private PaperServiceImpl paperServiceImpl;
	
	private AnswerServiceImpl answerServiceImpl;
	public StudentsServiceImpl getStudentsServiceImpl() {
		return studentsServiceImpl;
	}
	@Resource
	public void setStudentsServiceImpl(StudentsServiceImpl studentsServiceImpl) {
		this.studentsServiceImpl = studentsServiceImpl;
	}
	
	

	public PaperServiceImpl getPaperServiceImpl() {
		return paperServiceImpl;
	}
	@Resource
	public void setPaperServiceImpl(PaperServiceImpl paperServiceImpl) {
		this.paperServiceImpl = paperServiceImpl;
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
		System.out.println("studentsloginaction执行————————————");
		
	
		if(studentsServiceImpl.stuLogin(stu))
		{
			if(answerServiceImpl.checkStudents(stu))
			{
				this.addActionMessage("请勿重复作答");
				return INPUT;
			}
			else
			{
			
			List<Question> sqsinlist = paperServiceImpl.getSelsinQuestion();
			List<Question> sqmullist = paperServiceImpl.getSelmulQuestion();
			List<Question> qtextlist = paperServiceImpl.getTextQuestion();
			List<Question> qlistlist = paperServiceImpl.getListQuestion();
			Map<Integer, List<SelSinOption>> qsinmap = paperServiceImpl.getSelSinOption();
			Map<Integer, List<SelMulOption>> qmulmap = paperServiceImpl.getSelMulOption();
			
			request.getSession().setAttribute("listlist", qlistlist);
			request.getSession().setAttribute("textlist", qtextlist);
			request.getSession().setAttribute("qsinmap", qsinmap);
			request.getSession().setAttribute("qmulmap", qmulmap);
			request.getSession().setAttribute("sqsinlist", sqsinlist);
			request.getSession().setAttribute("sqmullist", sqmullist);
			
			request.getSession().setAttribute("stuname", stu.getStuname());
			request.getSession().setAttribute("stunum", stu.getStunum());
			
	
			return SUCCESS;
			}
		}
		else{
			this.addActionMessage("姓名或学号错误");
			return INPUT;
		}
		
	}
	
	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return stu;
	}


}
