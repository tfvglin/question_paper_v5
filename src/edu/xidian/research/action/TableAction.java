package edu.xidian.research.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.research.service.impl.AnswerServiceImpl;
import edu.xidian.research.service.impl.QuestionServiceImpl;
import edu.xidian.research.util.ChartUtil;
import edu.xidian.research.util.CountUtil;
@Controller("tableAction")
@Scope("prototype") 
public class TableAction extends SuperAction {
	
	private CountUtil countUtil;
	private ChartUtil chartUtil;
	private QuestionServiceImpl questionServiceImpl;
	private AnswerServiceImpl answerServiceImpl;
	
	Map<Character,Integer> omap2 = new HashMap<>();
	Map<Character,Integer> omap = new HashMap<>();
	@JSON(serialize=false)
	public CountUtil getCountUtil() {
		return countUtil;
	}
	@Resource
	public void setCountUtil(CountUtil countUtil) {
		this.countUtil = countUtil;
	}
	@JSON(serialize=false)
	public ChartUtil getChartUtil() {
		return chartUtil;
	}
	@Resource
	public void setChartUtil(ChartUtil chartUtil) {
		this.chartUtil = chartUtil;
	}
	
	

	@JSON(serialize=false)
	public QuestionServiceImpl getQuestionServiceImpl() {
		return questionServiceImpl;
	}
	@Resource
	public void setQuestionServiceImpl(QuestionServiceImpl questionServiceImpl) {
		this.questionServiceImpl = questionServiceImpl;
	}
	@JSON(serialize=false)
	public AnswerServiceImpl getAnswerServiceImpl() {
		return answerServiceImpl;
	}
	@Resource
	public void setAnswerServiceImpl(AnswerServiceImpl answerServiceImpl) {
		this.answerServiceImpl = answerServiceImpl;
	}
	
	public Map<Character, Integer> getOmap() {
		return omap;
	}
	public void setOmap(Map<Character, Integer> omap) {
		this.omap = omap;
	}
	
	
	public Map<Character, Integer> getOmap2() {
		return omap2;
	}
	public void setOmap2(Map<Character, Integer> omap2) {
		this.omap2 = omap2;
	}
	//显示统计表
	public String showTable()
	{
		int sqtype=Integer.parseInt(request.getParameter("sqtype"));
		
		int sqnum = Integer.parseInt(request.getParameter("sqnum"));
		
		int questionOptionNum=questionServiceImpl.getQuestionOptionNum(sqnum, sqtype);
		
				if(sqtype==1)
				{
					omap=answerServiceImpl.getSingleAnswerOptionNumMap(sqnum, questionOptionNum);
				
			
				}
				else if(sqtype==2)
				{
//					List<String[]> list =answerServiceImpl.getMultipleQuestionOptionAnswer(sqnum);
//					olist=countUtil.multipleAnswerOptionNum(list, questionOptionNum);
//					
				}
	
		return SUCCESS;
		
	}
}
