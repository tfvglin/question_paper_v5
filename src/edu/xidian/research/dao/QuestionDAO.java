package edu.xidian.research.dao;

import java.util.List;

import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;

public interface QuestionDAO {
	
	public boolean addQuestion(Question t);
	
	public boolean addSelSinOption(SelSinOption so);
	
	public boolean addSelMulOption(SelMulOption so);
	
	public int getquestionnum(int sqtype);
	
	//由题号获得单选选项数
	public int getSingleQuestionOptionNum(int sqnum);
	
	//有题目类型和题号获得选择题选项数
	public int getQuestionOptionNum( int sqnum, int sqtype);
	


}
