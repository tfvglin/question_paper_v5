package edu.xidian.research.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.ListAnswer;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.TextAnswer;


@Component("excelUtil")
public class ExcelUtil {
	
	public void creatExcel(int singlecount,int multiplecount,int textcount,int listcount,List aplist)throws RowsExceededException, WriteException, IOException
	{
		 WritableWorkbook wb = Workbook.createWorkbook(new File("D:/answer.xls"));
		 WritableSheet st = wb.createSheet("调查结果", 0);

		
		 st.addCell(new Label(0,0,"stuname"));
		 st.addCell(new Label(1,0,"stunum"));
		 st.addCell(new Label(2,0,"phone"));
		 st.addCell(new Label(3,0,"time"));
		 int j=4;
		  for(int i=1;i<=singlecount;i++)
		 {

			 st.addCell(new Label(j++,0,"sx"+i));
			 st.addCell(new Label(j++,0,"sxqt"+i));
		 }
		 
		  for(int i=1;i<=multiplecount;i++)
		  {
			  st.addCell(new Label(j++,0,"mx"+i));
			  st.addCell(new Label(j++,0,"mxqt"+i));
		  }
		  for(int i=1;i<=textcount;i++)
		  {
			  st.addCell(new Label(j++,0,"jd"+i));
			  
		  }
		  for(int i=1;i<=listcount;i++)
		  {
			  st.addCell(new Label(j++,0,"lj"+i));
		  }
		 
		 
		 Iterator<AnswersPaper> apit = aplist.iterator();
		int l=1;
		 while(apit.hasNext())
		 {
			 AnswersPaper ap = apit.next();
			 List<SingleAnswer> salist=ap.getSingleanswer();
			 List<MultipleAnswer> malist = ap.getMultipleanswer();
			 List<TextAnswer> talist = ap.getTextanswer();
			 List<ListAnswer> lalist = ap.getListanswer();
			 int n=0;
			
			 
				 st.addCell(new Label(n++,l,ap.getStuname()));
				 st.addCell(new Label(n++,l,ap.getStunum()));
				 st.addCell(new Label(n++,l,ap.getPhone()));
				 st.addCell(new Label(n++,l,ap.getTime()));
				
				 for(int i=0;i<singlecount;i++)
				 {
					
					 st.addCell(new Label(n++,l,salist.get(i).getSans()));
					 st.addCell(new Label(n++,l,salist.get(i).getOther()));
				 }
				 for(int i=0;i<multiplecount;i++)
				 {
					
					 st.addCell(new Label(n++,l,malist.get(i).getMans()));
					 st.addCell(new Label(n++,l,malist.get(i).getOther()));
				 }
				 for(int i=0;i<textcount;i++)
				 {
					 st.addCell(new Label(n++,l,talist.get(i).getTans()));
				 }
				 for(int i=0;i<listcount;i++)
				 {
					 st.addCell(new Label(n++,l,lalist.get(i).getLans()));
				 }
			 l++;
		 }
		 
	
		wb.write();
        wb.close();
	}

}
