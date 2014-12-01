package edu.xidian.research.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component("pagerUtil")
public class PagerUtil {
	private List bigList;                        //大的集合
	private int curentPageIndex = 1 ;            //当前页号
	private int countPerpage = 50 ;              //每页条数
	private List smallList;                      //小的集合
	private int pageCount;						//页数
	private int recordCount;					//记录条数
	private int prePageIndex;					//上一页序号
	private int nextPageIndex;					//下一页序号
	private boolean firstPage;					//是否是第一页
	private boolean lastPage;					//是否是最后一页

	
	public void setCurentPageIndex(int curentPageIndex)
	{
		this.curentPageIndex = curentPageIndex;
		
		prePageIndex = curentPageIndex - 1 ;
		nextPageIndex = curentPageIndex +1 ;
		if(curentPageIndex == 1)
		{
			firstPage = true ;
		}
		else
		{
			firstPage = false;
		}
		if(curentPageIndex == pageCount)
		{
			lastPage = true ;
		}
		else
		{
			lastPage = false;
		}
		
		smallList = new ArrayList();
		 for(int i=(curentPageIndex-1)*countPerpage; i<curentPageIndex*countPerpage&&i<recordCount; i++)
		{
			smallList.add(bigList.get(i));
		}
	}
	public List getBigList() {
		return bigList;
	}
	public void setBigList(List bigList) {
		this.bigList = bigList;
		recordCount = bigList.size();
		if(recordCount%countPerpage==0)
		{
			pageCount = recordCount / countPerpage;
		}
		else
		{
			pageCount = recordCount / countPerpage + 1;
		}
	}
	public int getCurentPageIndex() {
		return curentPageIndex;
	}

	public int getCountperpage() {
		return countPerpage;
	}
	public void setCountperpage(int countperpage) {
		this.countPerpage = countperpage;
	}
	public List getSmallList() {
		return smallList;
	}
	public void setSmallList(List smallList) {
		this.smallList = smallList;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPrePageIndex() {
		return prePageIndex;
	}
	public void setPrePageIndex(int prePageIndex) {
		this.prePageIndex = prePageIndex;
	}
	public int getNextPageIndex() {
		return nextPageIndex;
	}
	public void setNextPageIndex(int nextPageIndex) {
		this.nextPageIndex = nextPageIndex;
	}
	public boolean isFirstPage() {
		return firstPage;
	}
	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
	

}
