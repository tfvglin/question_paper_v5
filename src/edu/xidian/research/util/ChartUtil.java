package edu.xidian.research.util;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;
import org.springframework.stereotype.Component;

@Component("chartUtil")
public class ChartUtil {
	
	public JFreeChart creatBarChart(int sqtype,int sqnum,int questionOptionNum,List<Integer> olist )
	{	
		//����������ʽ  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //���ñ�������  
		   standardChartTheme.setExtraLargeFont(new Font("����",Font.BOLD,20));  
		   //����ͼ��������  
		   standardChartTheme.setRegularFont(new Font("����",Font.PLAIN,15));  
		   //�������������  
		   standardChartTheme.setLargeFont(new Font("����",Font.PLAIN,15));  
		   //Ӧ��������ʽ  
		   ChartFactory.setChartTheme(standardChartTheme); 
		   
			int width = 100;     // ͼ����

			int height = 75;      // ͼ��߶�
		
		
		String qtitle=null;
		if(sqtype==1)
		{
			qtitle="��ѡ";
		}
		else if(sqtype==2)
		{
			qtitle="��ѡ";
		}
		
		String chartTitle = qtitle+"��"+sqnum+"��������";     // ͼ�����

		//String subtitle = "------ͳ��ʱ�䣺2008��";     // ������

		String xTitle = "ѡ��";     // X�����

		String yTitle = "����";     // Y�����

		System.out.println(questionOptionNum);
		
		String category[] = new String[ questionOptionNum] ;   // ͳ������
		int[] data = new int[ questionOptionNum];
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<questionOptionNum;i++)
		{
			char car = (char) (65+i);
			category[i]=String.valueOf(car) ;
			data[i]=olist.get(i);
			dataset.addValue(data[i], "",category[i] );
		}
		System.out.println(category[0]);
	

		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle,     // ͼ�����
			       xTitle,     // X�����
			       yTitle,     // Y�����
			       dataset,     // ��ͼ���ݼ�
			       PlotOrientation.VERTICAL  ,  // ����ͼ���Ʒ���
			       false,     // ��ʾͼ��
			       false,     // ��ʾͼ������
			       false     // ��������
			       );
		
		 CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
	        BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        //��ʾ��Ŀ��ǩ
	        renderer.setBaseItemLabelsVisible(true);
	        //������Ŀ��ǩ������,��JFreeChart1.0.6֮ǰ����ͨ��renderer.setItemLabelGenerator(CategoryItemLabelGenerator generator)����ʵ�֣����ǴӰ汾1.0.6��ʼ�����淽������
	        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	        //������Ŀ��ǩ��ʾ��λ��,outline��ʾ����Ŀ������,baseline_center��ʾ���ڻ����Ҿ���
	        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
	                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
		
	     return chart;   
	        
//		FileOutputStream fos_jpg = null;
//	     try {
//	    	 fos_jpg = new FileOutputStream("D:\\chart\\"+qtitle+"��"+sqnum+"��������.jpg");
//	         ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 400, 300,null);
//	     } catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//	         try {
//	             fos_jpg.close();
//	         } catch (Exception e) {
//	         }
//	     }

		
	
			
		
		
	}

}
