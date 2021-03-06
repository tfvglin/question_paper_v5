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
	
	
	//学生登录
	public String login()
	{
	
		Students student =studentsServiceImpl.stuLogin(stu);
	
		if(student!=null)
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
			
			request.getSession().setAttribute("stuname", student.getStuname());
			request.getSession().setAttribute("cardid", student.getCardid());
			request.getSession().setAttribute("studepartment",student.getStudepartment());
			request.getSession().setAttribute("sex", student.getSex());
			request.getSession().setAttribute("province", student.getProvince());
			request.getSession().setAttribute("hukou", student.getHukou());
			request.getSession().setAttribute("stumarjor", student.getStumarjor());
			
			return SUCCESS;
			}
		}
		else{
			this.addActionMessage("姓名或身份证号错误");
			return "error";
		}
		
	}
	
	@Override
	public Students getModel() {
		// TODO Auto-generated method stub
		return stu;
	}


}
