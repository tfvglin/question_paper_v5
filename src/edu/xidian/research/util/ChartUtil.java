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
		//创建主题样式  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //设置标题字体  
		   standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		   //设置图例的字体  
		   standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		   //设置轴向的字体  
		   standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		   //应用主题样式  
		   ChartFactory.setChartTheme(standardChartTheme); 
		   
			int width = 100;     // 图像宽度

			int height = 75;      // 图像高度
		
		
		String qtitle=null;
		if(sqtype==1)
		{
			qtitle="单选";
		}
		else if(sqtype==2)
		{
			qtitle="多选";
		}
		
		String chartTitle = qtitle+"第"+sqnum+"题结果分析";     // 图表标题

		//String subtitle = "------统计时间：2008年";     // 副标题

		String xTitle = "选项";     // X轴标题

		String yTitle = "人数";     // Y轴标题

		
		
		String category[] = new String[ questionOptionNum] ;   // 统计种类
		int[] data = new int[ questionOptionNum];
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<questionOptionNum;i++)
		{
			char car = (char) (65+i);
			category[i]=String.valueOf(car) ;
			data[i]=olist.get(i);
			dataset.addValue(data[i], "",category[i] );
		}
		
	

		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle,     // 图表标题
			       xTitle,     // X轴标题
			       yTitle,     // Y轴标题
			       dataset,     // 绘图数据集
			       PlotOrientation.VERTICAL  ,  // 柱形图绘制方向
			       false,     // 显示图例
			       false,     // 显示图例名称
			       false     // 生成链接
			       );
		
		 CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
	        BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        //显示条目标签
	        renderer.setBaseItemLabelsVisible(true);
	        //设置条目标签生成器,在JFreeChart1.0.6之前可以通过renderer.setItemLabelGenerator(CategoryItemLabelGenerator generator)方法实现，但是从版本1.0.6开始有下面方法代替
	        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	        //设置条目标签显示的位置,outline表示在条目区域外,baseline_center表示基于基线且居中
	        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
	                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
        
	        return chart;   
	        
//		FileOutputStream fos_jpg = null;
//	     try {
//	    	 fos_jpg = new FileOutputStream("D:\\chart\\"+qtitle+"第"+sqnum+"题结果分析.jpg");
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
	
	public JFreeChart creatBarChartBySex(int sqtype,int sqnum,int questionOptionNum,List<Integer> olist,String sex )
	{	
		//创建主题样式  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //设置标题字体  
		   standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		   //设置图例的字体  
		   standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		   //设置轴向的字体  
		   standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		   //应用主题样式  
		   ChartFactory.setChartTheme(standardChartTheme); 
		   
			int width = 100;     // 图像宽度

			int height = 75;      // 图像高度
		
		
		String qtitle=null;
		String chartTitle=null;
		if(sqtype==1)
		{
			qtitle="单选";
		}
		else if(sqtype==2)
		{
			qtitle="多选";
		}
		if(sex.equals("1"))
		{
			chartTitle = qtitle+"第"+sqnum+"题结果分析"+"（男生）";   // 图表标题
		}	
		else
		{
			chartTitle = qtitle+"第"+sqnum+"题结果分析"+"（女生）";   // 图表标题
		}
			

		//String subtitle = "------统计时间：2008年";     // 副标题

		String xTitle = "选项";     // X轴标题

		String yTitle = "人数";     // Y轴标题

		
		
		String category[] = new String[ questionOptionNum] ;   // 统计种类
		int[] data = new int[ questionOptionNum];
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<questionOptionNum;i++)
		{
			char car = (char) (65+i);
			category[i]=String.valueOf(car) ;
			data[i]=olist.get(i);
			dataset.addValue(data[i], "",category[i] );
		}
		
	

		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle,     // 图表标题
			       xTitle,     // X轴标题
			       yTitle,     // Y轴标题
			       dataset,     // 绘图数据集
			       PlotOrientation.VERTICAL  ,  // 柱形图绘制方向
			       false,     // 显示图例
			       false,     // 显示图例名称
			       false     // 生成链接
			       );
		
		 CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
	        BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        //显示条目标签
	        renderer.setBaseItemLabelsVisible(true);
	        //设置条目标签生成器,在JFreeChart1.0.6之前可以通过renderer.setItemLabelGenerator(CategoryItemLabelGenerator generator)方法实现，但是从版本1.0.6开始有下面方法代替
	        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	        //设置条目标签显示的位置,outline表示在条目区域外,baseline_center表示基于基线且居中
	        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
	                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
		
        
	        
	        return chart;   
	        
//		FileOutputStream fos_jpg = null;
//	     try {
//	    	 fos_jpg = new FileOutputStream("D:\\chart\\"+qtitle+"第"+sqnum+"题结果分析.jpg");
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
	
	
	public JFreeChart creatBarChartByHukou(int sqtype,int sqnum,int questionOptionNum,List<Integer> olist,String hukou )
	{	
		//创建主题样式  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //设置标题字体  
		   standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		   //设置图例的字体  
		   standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		   //设置轴向的字体  
		   standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		   //应用主题样式  
		   ChartFactory.setChartTheme(standardChartTheme); 
		   
			int width = 100;     // 图像宽度

			int height = 75;      // 图像高度
		
		
		String qtitle=null;
		String chartTitle=null;
		if(sqtype==1)
		{
			qtitle="单选";
		}
		else if(sqtype==2)
		{
			qtitle="多选";
		}
		if(hukou.equals("1"))
		{
			chartTitle = qtitle+"第"+sqnum+"题结果分析"+"（城镇）";   // 图表标题
		}	
		else
		{
			chartTitle = qtitle+"第"+sqnum+"题结果分析"+"（农村）";   // 图表标题
		}
			

		//String subtitle = "------统计时间：2008年";     // 副标题

		String xTitle = "选项";     // X轴标题

		String yTitle = "人数";     // Y轴标题

		
		
		String category[] = new String[ questionOptionNum] ;   // 统计种类
		int[] data = new int[ questionOptionNum];
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<questionOptionNum;i++)
		{
			char car = (char) (65+i);
			category[i]=String.valueOf(car) ;
			data[i]=olist.get(i);
			dataset.addValue(data[i], "",category[i] );
		}
	
	

		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle,     // 图表标题
			       xTitle,     // X轴标题
			       yTitle,     // Y轴标题
			       dataset,     // 绘图数据集
			       PlotOrientation.VERTICAL  ,  // 柱形图绘制方向
			       false,     // 显示图例
			       false,     // 显示图例名称
			       false     // 生成链接
			       );
		
		 CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
	        BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        //显示条目标签
	        renderer.setBaseItemLabelsVisible(true);
	        //设置条目标签生成器,在JFreeChart1.0.6之前可以通过renderer.setItemLabelGenerator(CategoryItemLabelGenerator generator)方法实现，但是从版本1.0.6开始有下面方法代替
	        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	        //设置条目标签显示的位置,outline表示在条目区域外,baseline_center表示基于基线且居中
	        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
	                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
    
	        return chart;   
	        
//		FileOutputStream fos_jpg = null;
//	     try {
//	    	 fos_jpg = new FileOutputStream("D:\\chart\\"+qtitle+"第"+sqnum+"题结果分析.jpg");
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

	//学院图表
	public JFreeChart creatBarChartByDepartment(int sqtype,int sqnum,int questionOptionNum,List<Integer> olist,String department )
	{	
		//创建主题样式  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //设置标题字体  
		   standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		   //设置图例的字体  
		   standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		   //设置轴向的字体  
		   standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		   //应用主题样式  
		   ChartFactory.setChartTheme(standardChartTheme); 
		   
			int width = 100;     // 图像宽度

			int height = 75;      // 图像高度
		
		
		String qtitle=null;
		String chartTitle=null;
		if(sqtype==1)
		{
			qtitle="单选";
		}
		else if(sqtype==2)
		{
			qtitle="多选";
		}
		chartTitle = qtitle+"第"+sqnum+"题结果分析"+"（"+department+"）";   // 图表标题
	
			

		//String subtitle = "------统计时间：2008年";     // 副标题

		String xTitle = "选项";     // X轴标题

		String yTitle = "人数";     // Y轴标题

		
		
		String category[] = new String[ questionOptionNum] ;   // 统计种类
		int[] data = new int[ questionOptionNum];
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<questionOptionNum;i++)
		{
			char car = (char) (65+i);
			category[i]=String.valueOf(car) ;
			data[i]=olist.get(i);
			dataset.addValue(data[i], "",category[i] );
		}
	
	

		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle,     // 图表标题
			       xTitle,     // X轴标题
			       yTitle,     // Y轴标题
			       dataset,     // 绘图数据集
			       PlotOrientation.VERTICAL  ,  // 柱形图绘制方向
			       false,     // 显示图例
			       false,     // 显示图例名称
			       false     // 生成链接
			       );
		
		 CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
	        BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        //显示条目标签
	        renderer.setBaseItemLabelsVisible(true);
	        //设置条目标签生成器,在JFreeChart1.0.6之前可以通过renderer.setItemLabelGenerator(CategoryItemLabelGenerator generator)方法实现，但是从版本1.0.6开始有下面方法代替
	        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	        //设置条目标签显示的位置,outline表示在条目区域外,baseline_center表示基于基线且居中
	        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
	                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
        
	        return chart;   
	        
//		FileOutputStream fos_jpg = null;
//	     try {
//	    	 fos_jpg = new FileOutputStream("D:\\chart\\"+qtitle+"第"+sqnum+"题结果分析.jpg");
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
	
	
	//专业图表
	public JFreeChart creatBarChartByMarjor(int sqtype,int sqnum,int questionOptionNum,List<Integer> olist,String marjor )
	{	
		//创建主题样式  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //设置标题字体  
		   standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		   //设置图例的字体  
		   standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		   //设置轴向的字体  
		   standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		   //应用主题样式  
		   ChartFactory.setChartTheme(standardChartTheme); 
		   
			int width = 100;     // 图像宽度

			int height = 75;      // 图像高度
		
		
		String qtitle=null;
		String chartTitle=null;
		if(sqtype==1)
		{
			qtitle="单选";
		}
		else if(sqtype==2)
		{
			qtitle="多选";
		}
		chartTitle = qtitle+"第"+sqnum+"题结果分析"+"（"+marjor+"）";   // 图表标题
	
			

		//String subtitle = "------统计时间：2008年";     // 副标题

		String xTitle = "选项";     // X轴标题

		String yTitle = "人数";     // Y轴标题

		
		
		String category[] = new String[ questionOptionNum] ;   // 统计种类
		int[] data = new int[ questionOptionNum];
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<questionOptionNum;i++)
		{
			char car = (char) (65+i);
			category[i]=String.valueOf(car) ;
			data[i]=olist.get(i);
			dataset.addValue(data[i], "",category[i] );
		}
	
	

		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle,     // 图表标题
			       xTitle,     // X轴标题
			       yTitle,     // Y轴标题
			       dataset,     // 绘图数据集
			       PlotOrientation.VERTICAL  ,  // 柱形图绘制方向
			       false,     // 显示图例
			       false,     // 显示图例名称
			       false     // 生成链接
			       );
		
		 CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
	        BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        //显示条目标签
	        renderer.setBaseItemLabelsVisible(true);
	        //设置条目标签生成器,在JFreeChart1.0.6之前可以通过renderer.setItemLabelGenerator(CategoryItemLabelGenerator generator)方法实现，但是从版本1.0.6开始有下面方法代替
	        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	        //设置条目标签显示的位置,outline表示在条目区域外,baseline_center表示基于基线且居中
	        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
	                ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
	        return chart;  
	   
/*	        FileOutputStream fos_jpg = null;
		     try {
		    	 fos_jpg = new FileOutputStream("D:\\chart\\"+qtitle+"第"+sqnum+"题结果分析.jpg");
		         ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 400, 300,null);
		     } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		         try {
		             fos_jpg.close();
		         } catch (Exception e) {
		         }
		     }
	        
	  */      
	        
	        
//		FileOutputStream fos_jpg = null;
//	     try {
//	    	 fos_jpg = new FileOutputStream("D:\\chart\\"+qtitle+"第"+sqnum+"题结果分析.jpg");
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
	//省份图表
	public JFreeChart creatBarChartByProvince(int sqtype,int sqnum,int questionOptionNum,List<Integer> olist,String province )
	{	
		//创建主题样式  
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		//设置标题字体  
		standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		//设置图例的字体  
		standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		//设置轴向的字体  
		standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
		//应用主题样式  
		ChartFactory.setChartTheme(standardChartTheme); 
		
		int width = 100;     // 图像宽度
		
		int height = 75;      // 图像高度
		
		
		String qtitle=null;
		String chartTitle=null;
		if(sqtype==1)
		{
			qtitle="单选";
		}
		else if(sqtype==2)
		{
			qtitle="多选";
		}
		chartTitle = qtitle+"第"+sqnum+"题结果分析"+"（"+province+"）";   // 图表标题
		
		
		
		//String subtitle = "------统计时间：2008年";     // 副标题
		
		String xTitle = "选项";     // X轴标题
		
		String yTitle = "人数";     // Y轴标题
		
		
		
		String category[] = new String[ questionOptionNum] ;   // 统计种类
		int[] data = new int[ questionOptionNum];
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<questionOptionNum;i++)
		{
			char car = (char) (65+i);
			category[i]=String.valueOf(car) ;
			data[i]=olist.get(i);
			dataset.addValue(data[i], "",category[i] );
		}
		
		
		
		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle,     // 图表标题
				xTitle,     // X轴标题
				yTitle,     // Y轴标题
				dataset,     // 绘图数据集
				PlotOrientation.VERTICAL  ,  // 柱形图绘制方向
				false,     // 显示图例
				false,     // 显示图例名称
				false     // 生成链接
				);
		
		CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		//显示条目标签
		renderer.setBaseItemLabelsVisible(true);
		//设置条目标签生成器,在JFreeChart1.0.6之前可以通过renderer.setItemLabelGenerator(CategoryItemLabelGenerator generator)方法实现，但是从版本1.0.6开始有下面方法代替
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		//设置条目标签显示的位置,outline表示在条目区域外,baseline_center表示基于基线且居中
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
	
		return chart;   
		
//		FileOutputStream fos_jpg = null;
//	     try {
//	    	 fos_jpg = new FileOutputStream("D:\\chart\\"+qtitle+"第"+sqnum+"题结果分析.jpg");
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
