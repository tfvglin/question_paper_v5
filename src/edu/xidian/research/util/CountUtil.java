package edu.xidian.research.util;

import java.util.ArrayList;
import java.util.Arrays;
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
		List<Integer> list =new ArrayList<Integer>();
		int[] maon= new  int[questionoptionnum];
		Iterator<String[]> it = maonlist.iterator();
		while(it.hasNext())
		{
			String[] mulanswer = it.next();
			for(int i=0;i<mulanswer.length;i++)
			{
				switch (mulanswer[i]) {
				case "A":
					maon[0]++;
					break;
				case "B":
					maon[1]++;
					break;
				case "C":
					maon[2]++;
					break;
				case "D":
					maon[3]++;
					break;
				case "E":
					maon[4]++;
					break;
				case "F":
					maon[5]++;
					break;
				case "G":
					maon[6]++;
					break;
					
				default:
					break;
				}
			}
			
		}
		for(int num:maon)
		{
			list.add(num);
		}
		return list;
	}

}
