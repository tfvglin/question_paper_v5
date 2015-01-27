package edu.xidian.research.dao;

import java.util.List;

import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.ListAnswer;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.Students;
import edu.xidian.research.vo.TextAnswer;

public interface AnswerDAO {
	
	public boolean addAnswerPaper(AnswersPaper ap);
	
	public boolean addMultipleAnswer(MultipleAnswer ma);
	
	public boolean addSingleAnswer(SingleAnswer sa);
	
	public boolean addTextAnswer(TextAnswer ta);
	
	//获得答案集合
	public List<AnswersPaper> getAnswersPaper();
	
	//获得答题总人数
	public long getAnswersNum();
	
	//获得答题人数by性别
	public long getAnswersNumBySex(String sex);
	
	//获得答题人数by户口
	public long getAnswersNumByHukou(String hukou);
	
	//获得答题人数by省份
	public long getAnswersNumByProvince(String province);
	
	//获得答题人数by学院
	public long getAnswersNumByDepartment(String department);
	
	//由题号和选项得到选择该选项的人数
	public int getAnswersOptionNum(int qnum,String sans);
	
	//由单选题号得到该题各选项人数list
	public List<Integer> getSingleAnswerOptionNum(int qnum,int questionOptionNum);
	
	//由指定pid和单选题号得到该题各选项人数list
	public List<Integer> getSingleAnserOptionNumByPID(int qnum,int questionOptionNum,String pIDstr);
	
	//单选多选合并得到结果人数
	public List<Integer> getAnswersOptionNumList(int sqtype,int qnum,int questionOptionNum);
	
	
	
	//得到多选选项结果集
	List<String> getMultipleQuestionOptionAnswer(int sqnum);
	
	//由指定pid和多选题号得到该题各选项结果集
	List<String> getMultipleQuestionOptionAnswerByPID(int sqnum,String pIDstr);
	
	//得到单选结果集
	List<SingleAnswer> getSingleQuestionAnswer(int pID);
	
	//得到多选结果集
	List<MultipleAnswer> getMultipleQuestionAnswer(int pID);
	
	//得到问答结果集
	List<TextAnswer> getTextQuestionAnswer(int pID);
	
	//得到列举结果集
	List<ListAnswer> getListQuestionAnswer(int pID);

	//获得男、女生答题结果pID
	List<Integer> getAnswerpaperPidBySex(String sex);
	
	//获得城镇、农村答题结果pid
	List<Integer> getAnswerpaperPidByHukou(String hukou);
	
	//获得学院答题结果pid
	List<Integer> getAnswerpaperPidByDepartment(String department);
	
	//获得专业答题结果pid
	List<Integer> getAnswerpaperPidByMarjor(String marjor);
	
	//获得省份答题结果pid
	List<Integer> getAnswerpaperPidByProvince(String province);
	
	//获得最小pID
	Integer getMinPID();
	
	//获得最大PID
	Integer getMaxPID();
	
	//由PIDstr获得结果list
	List<AnswersPaper> getAnswersPaperByPidstr(String pidstr);
	
	//获得answerpaper中所有不同的department
	List<String> getAnswersPaperDepartment();
	
	//获得answerpaper中所有不同的marjor
	List<String> getAnswersPaperMarjor();
	
	//获得answerpaper中所有不同的province
	List<String> getAnswersPaperProvince();

	
	//
	
	public boolean checkStudents(Students stu);

	

}
