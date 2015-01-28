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
		Integer Anum=0,Bnum=0,Cnum=0,Dnum=0,Enum=0,Fnum=0,Gnum=0;
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
		if(Anum!=0)
		{
			list.add(Anum);
		}
		if(Bnum!=0)
		{
			list.add(Bnum);
		}
		if(Cnum!=0)
		{
			list.add(Cnum);
		}
		if(Dnum!=0)
		{
			list.add(Dnum);
		}
		if(Enum!=0)
		{
			list.add(Enum);
		}
		if(Fnum!=0)
		{
			list.add(Fnum);
		}
		if(Gnum!=0)
		{
			list.add(Gnum);
		}

		return list;
	}

}
