package edu.xidian.research.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.research.dao.impl.AnswerDAOImpl;
import edu.xidian.research.service.AdminService;
import edu.xidian.research.service.AnswerService;
import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.Students;
import edu.xidian.research.vo.TextAnswer;


@Service("answerServiceImpl")
public class AnswerServiceImpl implements AnswerService {

	private AnswerDAOImpl answerDAOImpl;
	
	
	
	
	
	public AnswerDAOImpl getAnswerDAOImpl() {
		return answerDAOImpl;
	}

	@Resource
	public void setAnswerDAOImpl(AnswerDAOImpl answerDAOImpl) {
		this.answerDAOImpl = answerDAOImpl;
	}

	@Override
	@Transactional
	public boolean addAnswerPaper(AnswersPaper ap) {
		// TODO Auto-generated method stub
		return answerDAOImpl.addAnswerPaper(ap);
	}

	@Override
	@Transactional
	public boolean addMultipleAnswer(MultipleAnswer ma) {
		// TODO Auto-generated method stub
		return answerDAOImpl.addMultipleAnswer(ma);
	}

	@Override
	@Transactional
	public boolean addSingleAnswer(SingleAnswer sa) {
		// TODO Auto-generated method stub
		return answerDAOImpl.addSingleAnswer(sa);
	}

	@Override
	@Transactional
	public boolean addTextAnswer(TextAnswer ta) {
		// TODO Auto-generated method stub
		return answerDAOImpl.addTextAnswer(ta);
	}

	@Override
	@Transactional
	public List<AnswersPaper> getAnswersPaper() {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersPaper();
	}

	@Override
	@Transactional
	public long getAnswersNum() {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersNum();
	}

	
	
	public int getAnswersOptionNum(int qnum, String sans) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersOptionNum(qnum, sans);
	}

	
	
	public List<Integer> getAnswersOptionNumList(int sqtype, int qnum,
			int questionOptionNum) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersOptionNumList(sqtype, qnum, questionOptionNum);
	}

	@Override
	public boolean checkStudents(Students stu) {
		// TODO Auto-generated method stub
		return answerDAOImpl.checkStudents(stu);
	}

}
