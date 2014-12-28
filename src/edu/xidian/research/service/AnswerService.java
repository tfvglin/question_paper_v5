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
	
	
	//�õ���ѡ�����ѡ��ͳ��
	public List<Integer> getSingleAnswerOptionNum( int qnum, int questionOptionNum);
	
	//�õ���ѡ�����ѡ��ͳ��by�Ա�
	public List<Integer> getSingleAnswerOptionNumBySex(int qnum, int questionOptionNum,String sex);
	
	//�õ���ѡ�����ѡ��ͳ��By����
	public List<Integer> getSingleAnswerOptionNumByHukou(int qnum, int questionOptionNum,String hukou);
	
	public List<Integer> getAnswersOptionNumList(int sqtype,  int qnum, int questionOptionNum);
	
	//���ȫ����ѡ���ѡ��������鼯��
	public List<String[]> getMultipleQuestionOptionAnswer(int sqnum);
	
	//��ö�ѡ���ѡ��������鼯��By�Ա�
	public List<String[]> getMultipleQuestionOptionAnswerBySex(int sqnum,String sex);
	
	//��ö�ѡ���ѡ��������鼯��By����
	public List<String[]> getMultipleQuestionOptionAnswerByHukou(int sqnum,String hukou);
	
	//�õ���ѡ�����
	List<SingleAnswer> getSingleQuestionAnswer(int pID);
	

	
	//�õ���ѡ�����
	List<MultipleAnswer> getMultipleQuestionAnswer(int pID);
	
	//�õ��ʴ�����
	List<TextAnswer> getTextQuestionAnswer(int pID);
	
	//�õ��оٽ����
	List<ListAnswer> getListQuestionAnswer(int pID);
	
	//�õ�PID�����By�Ա�
	List<Integer> getAnswerpaperPidBySex(String sex);
	
	//�õ�PID�����By����
	List<Integer> getAnswerpaperPidByHukou(String hukou);
	
	public boolean checkStudents(Students stu);

}
