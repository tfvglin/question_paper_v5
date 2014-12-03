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
	
	//����Ż�õ�ѡѡ����
	public int getSingleQuestionOptionNum(int sqnum);
	
	//����Ŀ���ͺ���Ż��ѡ����ѡ����
	public int getQuestionOptionNum( int sqnum, int sqtype);
	


}
