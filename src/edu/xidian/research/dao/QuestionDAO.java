package edu.xidian.research.dao;

import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;

public interface QuestionDAO {
	
	public boolean addQuestion(Question t);
	
	public boolean addSelSinOption(SelSinOption so);
	
	public boolean addSelMulOption(SelMulOption so);
	
	public int getquestionnum(int sqtype);
	
	public int getSingleQuestionOptionNum(int sqnum);
	
	public int getQuestionOptionNum(final int sqnum,final int sqtype);

}
