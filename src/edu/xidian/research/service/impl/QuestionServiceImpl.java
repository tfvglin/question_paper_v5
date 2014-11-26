package edu.xidian.research.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.research.dao.impl.QuestionDAOImpl;
import edu.xidian.research.service.QuestionService;
import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;


@Service("questionServiceImpl")
public class QuestionServiceImpl implements QuestionService {

	private QuestionDAOImpl questionDAOImpl;
	
	
	public QuestionDAOImpl getQuestionDAOImpl() {
		return questionDAOImpl;
	}

	@Resource
	public void setQuestionDAOImpl(QuestionDAOImpl questionDAOImpl) {
		this.questionDAOImpl = questionDAOImpl;
	}

	@Override
	@Transactional
	public boolean addQuestion(Question t) {
		// TODO Auto-generated method stub
		return questionDAOImpl.addQuestion(t);
	}

	@Override
	@Transactional
	public boolean addSelSinOption(SelSinOption so) {
		// TODO Auto-generated method stub
		return questionDAOImpl.addSelSinOption(so);
	}

	@Override
	@Transactional
	public boolean addSelMulOption(SelMulOption so) {
		// TODO Auto-generated method stub
		return questionDAOImpl.addSelMulOption(so);
	}

	@Override
	@Transactional
	public int getquestionnum(int sqtype) {
		// TODO Auto-generated method stub
		return questionDAOImpl.getquestionnum(sqtype);
	}

	public int getSingleQuestionOptionNum(int sqnum) {
		// TODO Auto-generated method stub
		return questionDAOImpl.getSingleQuestionOptionNum(sqnum);
	}

	public int getQuestionOptionNum(int sqnum, int sqtype) {
		// TODO Auto-generated method stub
		return questionDAOImpl.getQuestionOptionNum(sqnum, sqtype);
	}
	
	
	
	
	

}
