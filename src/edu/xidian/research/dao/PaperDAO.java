package edu.xidian.research.dao;

import java.util.List;
import java.util.Map;

import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;

public interface PaperDAO {
	
	//获得单选题题目
	public List<Question> getSelsinQuestion();
	
	//获得多选题题目
	public List<Question> getSelmulQuestion();
	
	//获得问答题题目	
	public List<Question> getTextQuestion();
	
	//获得列举题题目
	public List<Question> getListQuestion();
	
	//获得map<题号，单选选项>集合
	public Map<Integer,List<SelSinOption>> getSelSinOption();
	
	//获得map<题号，多选选项>集合
	public Map<Integer,List<SelMulOption>> getSelMulOption();
	
	//由题目类型获得题目总数
	public long getQuestionCount(int sqtype);

}
