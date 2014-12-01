package edu.xidian.research.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.xidian.research.service.impl.AnswerServiceImpl;

@Component("countUtil")
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
		int Anum=0,Bnum=0,Cnum=0,Dnum=0,Enum=0,Fnum=0,Gnum=0;
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
					Anum++;
					break;
				case "B":
					Bnum++;
					break;
				case "C":
					Cnum++;
					break;
				case "D":
					Dnum++;
					break;
				case "E":
					Enum++;
					break;
				case "F":
					Fnum++;
					break;
				case "G":
					Gnum++;
					break;
					
				default:
					break;
				}
			}
			
		}
		list.add(Anum);
		list.add(Bnum);
		list.add(Cnum);
		list.add(Dnum);
		list.add(Enum);
		list.add(Fnum);
		list.add(Gnum);
		return list;
	}

}
