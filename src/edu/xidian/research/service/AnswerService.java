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
	
	//得到单选结果集
	List<SingleAnswer> getSingleQuestionAnswer(int pID);
	
	//得到多选结果集
	List<MultipleAnswer> getMultipleQuestionAnswer(int pID);
	
	//得到问答结果集
	List<TextAnswer> getTextQuestionAnswer(int pID);
	
	//得到列举结果集
	List<ListAnswer> getListQuestionAnswer(int pID);
	
	public boolean checkStudents(Students stu);

}
