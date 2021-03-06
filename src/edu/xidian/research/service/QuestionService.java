package edu.xidian.research.service;

import java.util.List;

import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;

public interface QuestionService {
	
	public boolean addQuestion(Question t);
	
	public boolean addSelSinOption(SelSinOption so);
	
	public boolean addSelMulOption(SelMulOption so);
	
	public void delSelSinOption(SelSinOption so);
	
	public void delSelMulOption(SelMulOption so);	
	
	public void updateQuestion(Question q);
	
	public boolean updateSelSinOption(SelSinOption so);
	
	public boolean updateSelMulOption(SelMulOption so);
	
	public int getquestionnum(int sqtype);
	
	public int getSingleQuestionOptionNum(final int sqnum);
	
	public int getQuestionOptionNum(final int sqnum,final int sqtype);
	
	public SelMulOption getSelMulOption(int qnum,char item);
	
	public SelSinOption getSelSinOption(int qnum,char item);

}
