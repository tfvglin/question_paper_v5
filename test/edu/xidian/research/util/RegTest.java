package edu.xidian.research.util;

import junit.framework.TestCase;

public class RegTest extends TestCase{
	
	public void testsplit()
	{
		String str ="[A, B, C, D, E, F]";
		String sig="[\\]\\[\\s]";
		str=str.replaceAll(sig, "");
		System.out.println(str);
		String[] strl = str.split(",");
		for(String a:strl)
		{
			System.out.println(a);
		
			
		}
	}

}
