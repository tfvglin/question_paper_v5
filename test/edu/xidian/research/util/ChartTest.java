package edu.xidian.research.util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class ChartTest extends TestCase {
	
	private ChartUtil chartutil;
	
	public void testChart()
	{
		chartutil = new ChartUtil();
		List<Integer> olist = new ArrayList<Integer>();
		olist.add(2);
		olist.add(3);
		olist.add(2);
		olist.add(19);
		chartutil.creatBarChart(1, 1, 4, olist);
	}

}
