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
	
	
	//得到单选结果的选项统计
	public List<Integer> getSingleAnswerOptionNum( int qnum, int questionOptionNum);
	
	//得到单选结果的选项统计by性别
	public List<Integer> getSingleAnswerOptionNumBySex(int qnum, int questionOptionNum,String sex);
	
	//得到单选结果的选项统计By户口
	public List<Integer> getSingleAnswerOptionNumByHukou(int qnum, int questionOptionNum,String hukou);
	
	public List<Integer> getAnswersOptionNumList(int sqtype,  int qnum, int questionOptionNum);
	
	//获得全部多选题答案选项并返回数组集合
	public List<String[]> getMultipleQuestionOptionAnswer(int sqnum);
	
	//获得多选题答案选项并返回数组集合By性别
	public List<String[]> getMultipleQuestionOptionAnswerBySex(int sqnum,String sex);
	
	//获得多选题答案选项并返回数组集合By户口
	public List<String[]> getMultipleQuestionOptionAnswerByHukou(int sqnum,String hukou);
	
	//得到单选结果集
	List<SingleAnswer> getSingleQuestionAnswer(int pID);
	

	
	//得到多选结果集
	List<MultipleAnswer> getMultipleQuestionAnswer(int pID);
	
	//得到问答结果集
	List<TextAnswer> getTextQuestionAnswer(int pID);
	
	//得到列举结果集
	List<ListAnswer> getListQuestionAnswer(int pID);
	
	//得到PID结果集By性别
	List<Integer> getAnswerpaperPidBySex(String sex);
	
	//得到PID结果集By户口
	List<Integer> getAnswerpaperPidByHukou(String hukou);
	
	public boolean checkStudents(Students stu);

}
