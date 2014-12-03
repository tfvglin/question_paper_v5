package edu.xidian.research.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.research.dao.impl.AnswerDAOImpl;
import edu.xidian.research.service.AdminService;
import edu.xidian.research.service.AnswerService;
import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.ListAnswer;
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

	
	@Transactional
	public int getAnswersOptionNum(int qnum, String sans) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersOptionNum(qnum, sans);
	}

	
	
	@Override
	@Transactional
	public List<Integer> getSingleAnswerOptionNum(int qnum,
			int questionOptionNum) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getSingleAnswerOptionNum(qnum, questionOptionNum);
	}

	@Transactional
	public List<Integer> getAnswersOptionNumList(int sqtype, int qnum,
			int questionOptionNum) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersOptionNumList(sqtype, qnum, questionOptionNum);
	}

	
	
	//获得多选题选项答案并返回数组集合
	@Override
	@Transactional
	public List<String[]> getMultipleQuestionOptionAnswer(int sqnum) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		List<String[]> mulanslist = new ArrayList<String[]>();
	 	list = answerDAOImpl.getMultipleQuestionOptionAnswer(sqnum);
	 	Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			String str = it.next();
			String sig="[\\]\\[\\s]";
			str=str.replaceAll(sig, "");
			String[] strl = str.split(",");
			mulanslist.add(strl);
			
		}
		return mulanslist;
	}

	
	
	
	@Override
	@Transactional
	public List<SingleAnswer> getSingleQuestionAnswer(int pID) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getSingleQuestionAnswer(pID);
	}

	@Override
	@Transactional
	public List<MultipleAnswer> getMultipleQuestionAnswer(int pID) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getMultipleQuestionAnswer(pID);
	}

	@Override
	@Transactional
	public List<TextAnswer> getTextQuestionAnswer(int pID) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getTextQuestionAnswer(pID);
	}

	@Override
	@Transactional
	public List<ListAnswer> getListQuestionAnswer(int pID) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getListQuestionAnswer(pID);
	}

	@Override
	@Transactional
	public boolean checkStudents(Students stu) {
		// TODO Auto-generated method stub
		return answerDAOImpl.checkStudents(stu);
	}

	
}
