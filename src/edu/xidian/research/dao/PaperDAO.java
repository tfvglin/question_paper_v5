package edu.xidian.research.dao;

import java.util.List;
import java.util.Map;

import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;

public interface PaperDAO {
	
	//��õ�ѡ����Ŀ
	public List<Question> getSelsinQuestion();
	
	//��ö�ѡ����Ŀ
	public List<Question> getSelmulQuestion();
	
	//����ʴ�����Ŀ	
	public List<Question> getTextQuestion();
	
	//����о�����Ŀ
	public List<Question> getListQuestion();
	
	//���map<��ţ���ѡѡ��>����
	public Map<Integer,List<SelSinOption>> getSelSinOption();
	
	//���map<��ţ���ѡѡ��>����
	public Map<Integer,List<SelMulOption>> getSelMulOption();
	
	//����Ŀ���ͻ����Ŀ����
	public long getQuestionCount(int sqtype);

}
