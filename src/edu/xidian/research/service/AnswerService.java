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
	
	
	//��ô�������by�Ա�
	public long getAnswersNumBySex(String sex);
	
	//��ô�������by����
	public long getAnswersNumByHukou(String hukou);
	
	//��ô�������byʡ��
	public long getAnswersNumByProvince(String province);
	
	//��ô�������byѧԺ
	public Map<String,Long> getAnswersNumByDepartment();
	
	public int getAnswersOptionNum( int qnum, String sans );
	
	
	//�õ���ѡ�����ѡ��ͳ��
	public List<Integer> getSingleAnswerOptionNum( int qnum, int questionOptionNum);
	public Map<Character,Integer> getSingleAnswerOptionNumMap( int qnum, int questionOptionNum);
	//�õ���ѡ�����ѡ��ͳ��by�Ա�
	public List<Integer> getSingleAnswerOptionNumBySex(int qnum, int questionOptionNum,String sex);
	public Map<Character,Integer> getSingleAnswerOptionNumBySexMap(int qnum, int questionOptionNum,String sex);
	
	//�õ���ѡ�����ѡ��ͳ��By����
	public List<Integer> getSingleAnswerOptionNumByHukou(int qnum, int questionOptionNum,String hukou);
	public Map<Character,Integer> getSingleAnswerOptionNumByHukouMap(int qnum, int questionOptionNum,String hukou);
	
	//�õ���ѡ�����ѡ��ͳ��byѧԺ
	public List<Integer> getSingleAnswerOptionNumByDepartment(int qnum, int questionOptionNum,String department);
	public Map<Character,Integer> getSingleAnswerOptionNumByDepartmentMap(int qnum, int questionOptionNum,String department);
	
	//�õ���ѡ�����ѡ��ͳ��byרҵ
	public List<Integer> getSingleAnswerOptionNumByMarjor(int qnum, int questionOptionNum,String marjor);
	public Map<Character,Integer> getSingleAnswerOptionNumByMarjorMap(int qnum, int questionOptionNum,String marjor);
	
	//�õ���ѡ�����ѡ��ͳ��byʡ��
	public List<Integer> getSingleAnswerOptionNumByProvince(int qnum, int questionOptionNum,String province);
	public Map<Character,Integer> getSingleAnswerOptionNumByProvinceMap(int qnum, int questionOptionNum,String province);
	
	
	public List<Integer> getAnswersOptionNumList(int sqtype,  int qnum, int questionOptionNum);
	
	//���ȫ����ѡ���ѡ��������鼯��
	public List<Integer> getMultipleQuestionOptionAnswer(int sqnum,int questionOptionNum);
	public Map<Character,Integer> getMultipleQuestionOptionAnswerMap(int sqnum,int questionOptionNum);
	
	//��ö�ѡ���ѡ��������鼯��By�Ա�
	public List<Integer> getMultipleQuestionOptionAnswerBySex(int sqnum,String sex,int questionOptionNum);
	public Map<Character,Integer> getMultipleQuestionOptionAnswerBySexMap(int sqnum,String sex,int questionOptionNum);
	
	//��ö�ѡ���ѡ��������鼯��By����
	public List<Integer> getMultipleQuestionOptionAnswerByHukou(int sqnum,String hukou,int questionOptionNum);
	public Map<Character,Integer> getMultipleQuestionOptionAnswerByHukouMap(int sqnum,String hukou,int questionOptionNum);
	
	//��ö�ѡ���ѡ��������鼯��ByѧԺ
	public List<Integer> getMultipleQuestionOptionAnswerByDepartment(int sqnum,String department,int questionOptionNum);
	public Map<Character,Integer> getMultipleQuestionOptionAnswerByDepartmentMap(int sqnum,String department,int questionOptionNum);
	
	//��ö�ѡ���ѡ��������鼯��Byרҵ
	public List<Integer> getMultipleQuestionOptionAnswerByMarjor(int sqnum,String marjor,int questionOptionNum);
	public Map<Character,Integer> getMultipleQuestionOptionAnswerByMarjorMap(int sqnum,String marjor,int questionOptionNum);

	//��ö�ѡ���ѡ��������鼯��Byרҵ
	public List<Integer> getMultipleQuestionOptionAnswerByProvince(int sqnum,String province,int questionOptionNum);
	public Map<Character,Integer> getMultipleQuestionOptionAnswerByProvinceMap(int sqnum,String province,int questionOptionNum);
	
	
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
	
	
	//���answerpaper�����в�ͬ��department
	Map<String,String> getAnswersPaperDepartment();
	
	//���answerpaper�����в�ͬ��marjor
	Map<String,String> getAnswersPaperMarjor();
	
	//���answerpaper�����в�ͬ��province
	Map<String,String> getAnswersPaperProvince();
	
	public boolean checkStudents(Students stu);

}
