package edu.xidian.research.service;

import java.util.List;
import java.util.Map;

import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;

public interface PaperService {
	
	
	public List<Question> getSelsinQuestion();
	
	public List<Question> getSelmulQuestion();
	
	public List<Question> getTextQuestion();
	
	public List<Question> getListQuestion();
	
	public Map<Integer,List<SelSinOption>> getSelSinOption();
	
	public Map<Integer,List<SelMulOption>> getSelMulOption();
	
	public long getQuestionCount(int sqtype);

}
