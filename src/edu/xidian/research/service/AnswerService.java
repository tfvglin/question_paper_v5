package edu.xidian.research.service;

import java.util.List;
import java.util.Map;

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
	
	
	//获得答题人数by性别
	public long getAnswersNumBySex(String sex);
	
	//获得答题人数by户口
	public long getAnswersNumByHukou(String hukou);
	
	//获得答题人数by省份
	public long getAnswersNumByProvince(String province);
	
	//获得答题人数by学院
	public Map<String,Long> getAnswersNumByDepartment();
	
	public int getAnswersOptionNum( int qnum, String sans );
	
	
	//得到单选结果的选项统计
	public List<Integer> getSingleAnswerOptionNum( int qnum, int questionOptionNum);
	public Map<Character,Integer> getSingleAnswerOptionNumMap( int qnum, int questionOptionNum);
	//得到单选结果的选项统计by性别
	public List<Integer> getSingleAnswerOptionNumBySex(int qnum, int questionOptionNum,String sex);
	
	//得到单选结果的选项统计By户口
	public List<Integer> getSingleAnswerOptionNumByHukou(int qnum, int questionOptionNum,String hukou);
	
	//得到单选结果的选项统计by学院
	public List<Integer> getSingleAnswerOptionNumByDepartment(int qnum, int questionOptionNum,String department);
	
	//得到单选结果的选项统计by专业
	public List<Integer> getSingleAnswerOptionNumByMarjor(int qnum, int questionOptionNum,String marjor);
	
	//得到单选结果的选项统计by省份
	public List<Integer> getSingleAnswerOptionNumByProvince(int qnum, int questionOptionNum,String province);
	
	
	public List<Integer> getAnswersOptionNumList(int sqtype,  int qnum, int questionOptionNum);
	
	//获得全部多选题答案选项并返回数组集合
	public List<String[]> getMultipleQuestionOptionAnswer(int sqnum);
	
	//获得多选题答案选项并返回数组集合By性别
	public List<String[]> getMultipleQuestionOptionAnswerBySex(int sqnum,String sex);
	
	//获得多选题答案选项并返回数组集合By户口
	public List<String[]> getMultipleQuestionOptionAnswerByHukou(int sqnum,String hukou);
	
	//获得多选题答案选项并返回数组集合By学院
	public List<String[]> getMultipleQuestionOptionAnswerByDepartment(int sqnum,String department);
	
	//获得多选题答案选项并返回数组集合By专业
	public List<String[]> getMultipleQuestionOptionAnswerByMarjor(int sqnum,String marjor);

	//获得多选题答案选项并返回数组集合By专业
	public List<String[]> getMultipleQuestionOptionAnswerByProvince(int sqnum,String province);
	
	
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
	
	
	//获得answerpaper中所有不同的department
	Map<String,String> getAnswersPaperDepartment();
	
	//获得answerpaper中所有不同的marjor
	Map<String,String> getAnswersPaperMarjor();
	
	//获得answerpaper中所有不同的province
	Map<String,String> getAnswersPaperProvince();
	
	public boolean checkStudents(Students stu);

}
