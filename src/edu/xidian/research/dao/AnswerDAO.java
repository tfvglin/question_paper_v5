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
	
	//��ô𰸼���
	public List<AnswersPaper> getAnswersPaper();
	
	//��ô���������
	public long getAnswersNum();
	
	//��ô�������by�Ա�
	public long getAnswersNumBySex(String sex);
	
	//��ô�������by����
	public long getAnswersNumByHukou(String hukou);
	
	//��ô�������byʡ��
	public long getAnswersNumByProvince(String province);
	
	//��ô�������byѧԺ
	public long getAnswersNumByDepartment(String department);
	
	//����ź�ѡ��õ�ѡ���ѡ�������
	public int getAnswersOptionNum(int qnum,String sans);
	
	//�ɵ�ѡ��ŵõ������ѡ������list
	public List<Integer> getSingleAnswerOptionNum(int qnum,int questionOptionNum);
	
	//��ָ��pid�͵�ѡ��ŵõ������ѡ������list
	public List<Integer> getSingleAnserOptionNumByPID(int qnum,int questionOptionNum,String pIDstr);
	
	//��ѡ��ѡ�ϲ��õ��������
	public List<Integer> getAnswersOptionNumList(int sqtype,int qnum,int questionOptionNum);
	
	
	
	//�õ���ѡѡ������
	List<String> getMultipleQuestionOptionAnswer(int sqnum);
	
	//��ָ��pid�Ͷ�ѡ��ŵõ������ѡ������
	List<String> getMultipleQuestionOptionAnswerByPID(int sqnum,String pIDstr);
	
	//�õ���ѡ�����
	List<SingleAnswer> getSingleQuestionAnswer(int pID);
	
	//�õ���ѡ�����
	List<MultipleAnswer> getMultipleQuestionAnswer(int pID);
	
	//�õ��ʴ�����
	List<TextAnswer> getTextQuestionAnswer(int pID);
	
	//�õ��оٽ����
	List<ListAnswer> getListQuestionAnswer(int pID);

	//����С�Ů��������pID
	List<Integer> getAnswerpaperPidBySex(String sex);
	
	//��ó���ũ�������pid
	List<Integer> getAnswerpaperPidByHukou(String hukou);
	
	//���ѧԺ������pid
	List<Integer> getAnswerpaperPidByDepartment(String department);
	
	//���רҵ������pid
	List<Integer> getAnswerpaperPidByMarjor(String marjor);
	
	//���ʡ�ݴ�����pid
	List<Integer> getAnswerpaperPidByProvince(String province);
	
	//�����СpID
	Integer getMinPID();
	
	//������PID
	Integer getMaxPID();
	
	//��PIDstr��ý��list
	List<AnswersPaper> getAnswersPaperByPidstr(String pidstr);
	
	//���answerpaper�����в�ͬ��department
	List<String> getAnswersPaperDepartment();
	
	//���answerpaper�����в�ͬ��marjor
	List<String> getAnswersPaperMarjor();
	
	//���answerpaper�����в�ͬ��province
	List<String> getAnswersPaperProvince();

	
	//
	
	public boolean checkStudents(Students stu);

	

}
