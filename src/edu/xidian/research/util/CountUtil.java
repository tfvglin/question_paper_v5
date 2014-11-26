package edu.xidian.research.util;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import edu.xidian.research.service.impl.AnswerServiceImpl;

public class CountUtil {
	
	private AnswerServiceImpl answerServiceImpl;

	public AnswerServiceImpl getAnswerServiceImpl() {
		return answerServiceImpl;
	}
	@Resource
	public void setAnswerServiceImpl(AnswerServiceImpl answerServiceImpl) {
		this.answerServiceImpl = answerServiceImpl;
	}
	
	public List<Integer> multipleAnswerOptionNum(List<String[]> maonlist,int questionoptionnum)
	{
		int[] maon= new  int[questionoptionnum];
		Iterator<String[]> it = maonlist.iterator();
		while(it.hasNext())
		{
			String[] mulanswer = it.next();
			
		}
	}

}
