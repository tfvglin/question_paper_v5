package edu.xidian.research.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.research.dao.impl.PaperDAOImpl;
import edu.xidian.research.service.PaperService;
import edu.xidian.research.vo.Question;
import edu.xidian.research.vo.SelMulOption;
import edu.xidian.research.vo.SelSinOption;


@Service("paperServiceImpl")
public class PaperServiceImpl implements PaperService {

	private PaperDAOImpl paperDAOImpl;
	
	
	
	public PaperDAOImpl getPaperDAOImpl() {
		return paperDAOImpl;
	}
	@Resource
	public void setPaperDAOImpl(PaperDAOImpl paperDAOImpl) {
		this.paperDAOImpl = paperDAOImpl;
	}

	@Override
	@Transactional
	public List<Question> getSelsinQuestion() {
		// TODO Auto-generated method stub
		return paperDAOImpl.getSelsinQuestion();
	}

	@Override
	@Transactional
	public List<Question> getSelmulQuestion() {
		// TODO Auto-generated method stub
		return paperDAOImpl.getSelmulQuestion();
	}

	@Override
	@Transactional
	public List<Question> getTextQuestion() {
		// TODO Auto-generated method stub
		return paperDAOImpl.getTextQuestion();
	}

	@Override
	@Transactional
	public List<Question> getListQuestion() {
		// TODO Auto-generated method stub
		return paperDAOImpl.getListQuestion();
	}

	@Override
	@Transactional
	public Map<Integer, List<SelSinOption>> getSelSinOption() {
		// TODO Auto-generated method stub
		return paperDAOImpl.getSelSinOption();
	}

	@Override
	@Transactional
	public Map<Integer, List<SelMulOption>> getSelMulOption() {
		// TODO Auto-generated method stub
		return paperDAOImpl.getSelMulOption();
	}

	@Override
	@Transactional
	public long getQuestionCount(int sqtype) {
		// TODO Auto-generated method stub
		return paperDAOImpl.getQuestionCount(sqtype);
	}

}
