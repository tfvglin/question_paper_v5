package edu.xidian.research.service;

import java.util.List;

import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.ListAnswer;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.Students;
import edu.xidian.research.vo.TextAnswer;

public interface AnswerService {
	
	public boolean addAnswerPaper(AnswersPaper ap);
	
	public boolean addMultipleAnswer(MultipleAnswer ma);
	
	public boolean addSingleAnswer(SingleAnswer sa);
	
	public boolean addTextAnswer(TextAnswer ta);
	
	public List<AnswersPaper> getAnswersPaper();
	
	public long getAnswersNum();
	
	public int getAnswersOptionNum( int qnum, String sans );
	
	public List<Integer> getSingleAnswerOptionNum( int qnum, int questionOptionNum);
	
	public List<Integer> getAnswersOptionNumList(int sqtype,  int qnum, int questionOptionNum);
	
	
	public List<String[]> getMultipleQuestionOptionAnswer(int sqnum);
	
	//�õ���ѡ�����
	List<SingleAnswer> getSingleQuestionAnswer(int pID);
	
	//�õ���ѡ�����
	List<MultipleAnswer> getMultipleQuestionAnswer(int pID);
	
	//�õ��ʴ�����
	List<TextAnswer> getTextQuestionAnswer(int pID);
	
	//�õ��оٽ����
	List<ListAnswer> getListQuestionAnswer(int pID);
	
	public boolean checkStudents(Students stu);

}
