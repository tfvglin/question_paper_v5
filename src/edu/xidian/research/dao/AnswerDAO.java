package edu.xidian.research.dao;

import java.util.List;

import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.Students;
import edu.xidian.research.vo.TextAnswer;

public interface AnswerDAO {
	
	public boolean addAnswerPaper(AnswersPaper ap);
	
	public boolean addMultipleAnswer(MultipleAnswer ma);
	
	public boolean addSingleAnswer(SingleAnswer sa);
	
	public boolean addTextAnswer(TextAnswer ta);
	
	public List<AnswersPaper> getAnswersPaper();
	
	public long getAnswersNum();
	
	//由题号和选项得到选择该选项的人数
	public int getAnswersOptionNum(int qnum,String sans);
	
	//由单选题号得到该题各选项人数list
	public List<Integer> getSingleAnswerOptionNum(int qnum,int questionOptionNum);
	
	//单选多选合并得到结果人数
	public List<Integer> getAnswersOptionNumList(int sqtype,int qnum,int questionOptionNum);
	
	
	//得到多选结果集
	List<String> getMultipleQuestionOptionAnswer(int sqnum);
	
	public boolean checkStudents(Students stu);

	

}
