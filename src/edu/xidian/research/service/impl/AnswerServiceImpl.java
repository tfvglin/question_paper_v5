package edu.xidian.research.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Iterables;

import edu.xidian.research.dao.impl.AnswerDAOImpl;
import edu.xidian.research.service.AdminService;
import edu.xidian.research.service.AnswerService;
import edu.xidian.research.util.CountUtil;
import edu.xidian.research.vo.Admin;
import edu.xidian.research.vo.AnswersPaper;
import edu.xidian.research.vo.ListAnswer;
import edu.xidian.research.vo.MultipleAnswer;
import edu.xidian.research.vo.SingleAnswer;
import edu.xidian.research.vo.Students;
import edu.xidian.research.vo.TextAnswer;


@Service("answerServiceImpl")
public class AnswerServiceImpl implements AnswerService {

	private AnswerDAOImpl answerDAOImpl;
	
	private CountUtil countUtil;
	
	
	
	public CountUtil getCountUtil() {
		return countUtil;
	}
	@Resource
	public void setCountUtil(CountUtil countUtil) {
		this.countUtil = countUtil;
	}

	public AnswerDAOImpl getAnswerDAOImpl() {
		return answerDAOImpl;
	}

	@Resource
	public void setAnswerDAOImpl(AnswerDAOImpl answerDAOImpl) {
		this.answerDAOImpl = answerDAOImpl;
	}

	@Override
	@Transactional
	public boolean addAnswerPaper(AnswersPaper ap) {
		// TODO Auto-generated method stub
		return answerDAOImpl.addAnswerPaper(ap);
	}

	@Override
	@Transactional
	public boolean addMultipleAnswer(MultipleAnswer ma) {
		// TODO Auto-generated method stub
		return answerDAOImpl.addMultipleAnswer(ma);
	}

	@Override
	@Transactional
	public boolean addSingleAnswer(SingleAnswer sa) {
		// TODO Auto-generated method stub
		return answerDAOImpl.addSingleAnswer(sa);
	}

	@Override
	@Transactional
	public boolean addTextAnswer(TextAnswer ta) {
		// TODO Auto-generated method stub
		return answerDAOImpl.addTextAnswer(ta);
	}

	@Override
	@Transactional
	public List<AnswersPaper> getAnswersPaper() {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersPaper();
	}

	@Override
	@Transactional
	public long getAnswersNum() {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersNum();
	}

	
	
	
	@Override
	public long getAnswersNumBySex(String sex) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersNumBySex(sex);
	}

	@Override
	public long getAnswersNumByHukou(String hukou) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersNumByHukou(hukou);
	}

	@Override
	public long getAnswersNumByProvince(String province) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersNumByProvince(province);
	}

	
	
	
	
	

	@Override
	public Map<String, Long> getAnswersNumByDepartment() {
		Map<String,Long> apByDepartment = new HashMap<String, Long>();
		apByDepartment.put("电子工程", answerDAOImpl.getAnswersNumByDepartment("电子工程"));
		apByDepartment.put("通信工程", answerDAOImpl.getAnswersNumByDepartment("通信工程"));
		apByDepartment.put("计算机", answerDAOImpl.getAnswersNumByDepartment("计算机"));
		apByDepartment.put("机电工程", answerDAOImpl.getAnswersNumByDepartment("机电工程"));
		apByDepartment.put("物理与光电工程", answerDAOImpl.getAnswersNumByDepartment("物理与光电工程"));
		apByDepartment.put("微电子", answerDAOImpl.getAnswersNumByDepartment("微电子"));
		apByDepartment.put("国际教育", answerDAOImpl.getAnswersNumByDepartment("国际教育"));
		apByDepartment.put("软件", answerDAOImpl.getAnswersNumByDepartment("软件"));
		apByDepartment.put("经济与管理", answerDAOImpl.getAnswersNumByDepartment("经济与管理"));
		apByDepartment.put("空间科学与技术", answerDAOImpl.getAnswersNumByDepartment("空间科学与技术"));
		apByDepartment.put("人文", answerDAOImpl.getAnswersNumByDepartment("人文"));
		apByDepartment.put("数学与统计", answerDAOImpl.getAnswersNumByDepartment("数学与统计"));
		apByDepartment.put("先进材料与纳米科技", answerDAOImpl.getAnswersNumByDepartment("先进材料与纳米科技"));
		
		return apByDepartment;
	}

	@Transactional
	public int getAnswersOptionNum(int qnum, String sans) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersOptionNum(qnum, sans);
	}

	
	
	@Override
	@Transactional
	public List<Integer> getSingleAnswerOptionNum(int qnum,
			int questionOptionNum) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getSingleAnswerOptionNum(qnum, questionOptionNum);
	}

	
	
	
	@Override
	public Map<Character, Integer> getSingleAnswerOptionNumMap(int qnum,
			int questionOptionNum) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> olist = new ArrayList<>();
		olist = getSingleAnswerOptionNum(qnum, questionOptionNum);
		Iterator<Integer> it = olist.iterator();
		int i=0;
		while(it.hasNext())
		{
			omap.put((char)(65+i), it.next());
			i++;
		}
		return omap;
	}

	@Override
	public List<Integer> getSingleAnswerOptionNumBySex(int qnum,
			int questionOptionNum, String sex) {
		List<Integer> anspIDlist = new ArrayList<Integer>();
		anspIDlist = answerDAOImpl.getAnswerpaperPidBySex(sex);
		String pIDstr = anspIDlist.toString();
		
		pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
		return answerDAOImpl.getSingleAnserOptionNumByPID(qnum, questionOptionNum, pIDstr);
		
	}

	
	
	@Override
	public Map<Character, Integer> getSingleAnswerOptionNumBySexMap(int qnum,
			int questionOptionNum, String sex) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> olist = new ArrayList<>();
		olist = getSingleAnswerOptionNumBySex(qnum, questionOptionNum,sex);
		Iterator<Integer> it = olist.iterator();
		int i=0;
		while(it.hasNext())
		{
			omap.put((char)(65+i), it.next());
			i++;
		}
		return omap;
	}
	public List<Integer> getSingleAnswerOptionNumByHukou(int qnum,
			int questionOptionNum, String hukou) {
		List<Integer> anspIDlist = new ArrayList<Integer>();
		anspIDlist = answerDAOImpl.getAnswerpaperPidByHukou(hukou);
		String pIDstr = anspIDlist.toString();
		
		pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
		return answerDAOImpl.getSingleAnserOptionNumByPID(qnum, questionOptionNum, pIDstr);
		
	}
	
	@Override
	public Map<Character, Integer> getSingleAnswerOptionNumByHukouMap(int qnum,
			int questionOptionNum, String hukou) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> olist = new ArrayList<>();
		olist = getSingleAnswerOptionNumByHukou(qnum, questionOptionNum,hukou);
		Iterator<Integer> it = olist.iterator();
		int i=0;
		while(it.hasNext())
		{
			omap.put((char)(65+i), it.next());
			i++;
		}
		return omap;
	}
	
	
	
	@Override
	public List<Integer> getSingleAnswerOptionNumByDepartment(int qnum,
			int questionOptionNum, String department) {
		List<Integer> anspIDlist = new ArrayList<Integer>();
		anspIDlist = answerDAOImpl.getAnswerpaperPidByDepartment(department);
		String pIDstr = anspIDlist.toString();
		
		pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
		return answerDAOImpl.getSingleAnserOptionNumByPID(qnum, questionOptionNum, pIDstr);
	
	}

	@Override
	public Map<Character, Integer> getSingleAnswerOptionNumByDepartmentMap(int qnum,
			int questionOptionNum, String department) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> olist = new ArrayList<>();
		olist = getSingleAnswerOptionNumByDepartment(qnum, questionOptionNum,department);
		Iterator<Integer> it = olist.iterator();
		int i=0;
		while(it.hasNext())
		{
			omap.put((char)(65+i), it.next());
			i++;
		}
		return omap;
	}
	
	@Override
	public List<Integer> getSingleAnswerOptionNumByMarjor(int qnum,
			int questionOptionNum, String marjor) {
		List<Integer> anspIDlist = new ArrayList<Integer>();
		anspIDlist = answerDAOImpl.getAnswerpaperPidByMarjor(marjor);
		String pIDstr = anspIDlist.toString();
		
		pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
		return answerDAOImpl.getSingleAnserOptionNumByPID(qnum, questionOptionNum, pIDstr);
	
	}
	
	@Override
	public Map<Character, Integer> getSingleAnswerOptionNumByMarjorMap(int qnum,
			int questionOptionNum, String marjor) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> olist = new ArrayList<>();
		olist = getSingleAnswerOptionNumByMarjor(qnum, questionOptionNum,marjor);
		Iterator<Integer> it = olist.iterator();
		int i=0;
		while(it.hasNext())
		{
			omap.put((char)(65+i), it.next());
			i++;
		}
		return omap;
	}
	
	@Override
	public List<Integer> getSingleAnswerOptionNumByProvince(int qnum,
			int questionOptionNum, String province) {
		List<Integer> anspIDlist = new ArrayList<Integer>();
		anspIDlist = answerDAOImpl.getAnswerpaperPidByProvince(province);
		String pIDstr = anspIDlist.toString();
		
		pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
		return answerDAOImpl.getSingleAnserOptionNumByPID(qnum, questionOptionNum, pIDstr);
		
	}

	@Override
	public Map<Character, Integer> getSingleAnswerOptionNumByProvinceMap(int qnum,
			int questionOptionNum, String province) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> olist = new ArrayList<>();
		olist = getSingleAnswerOptionNumByProvince(qnum, questionOptionNum,province);
		Iterator<Integer> it = olist.iterator();
		int i=0;
		while(it.hasNext())
		{
			omap.put((char)(65+i), it.next());
			i++;
		}
		return omap;
	}
	
	
	

	//单选级联
	@Override
	public Map<Character, Integer> getSingleAnswerOptionNumByCascade(int qnum,
			int questionOptionNum, String sql) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> ansPIDList = new ArrayList<Integer>();
		List<Integer> olist = new ArrayList<>();
		ansPIDList = answerDAOImpl.getAnswerpaperPidByCascade(sql);
		if(!ansPIDList.isEmpty())
		{
		String pIDstr = ansPIDList.toString();
		pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
		olist = answerDAOImpl.getSingleAnserOptionNumByPID(qnum, questionOptionNum, pIDstr);
		Iterator<Integer> it = olist.iterator();
		int i=0;
		while(it.hasNext())
		{
			omap.put((char)(65+i), it.next());
			i++;
		}
		return omap;
		}
		else{
			return omap;
		}
	
	}
	
	
	
	
	@Transactional
	public List<Integer> getAnswersOptionNumList(int sqtype, int qnum,
			int questionOptionNum) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswersOptionNumList(sqtype, qnum, questionOptionNum);
	}

	
	//多选级联
	@Override
	public Map<Character, Integer> getMultipleAnswerOptionNumByCascade(
			int qnum, int questionOptionNum, String sql) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> olist = new ArrayList<>();
		List<String> list = new ArrayList<String>();
		List<String[]> mulanslist = new ArrayList<String[]>();
		
		List<Integer> anspIDlist = answerDAOImpl.getAnswerpaperPidByCascade(sql);
		if(!anspIDlist.isEmpty())
		{
			String pIDstr = anspIDlist.toString();
			
			pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
			list = answerDAOImpl.getMultipleQuestionOptionAnswerByPID(qnum,pIDstr);
		 	Iterator<String> it = list.iterator();
			while(it.hasNext())
			{
				String str = it.next();
				String sig="[\\]\\[\\s]";
				str=str.replaceAll(sig, "");
				String[] strl = str.split(",");
				mulanslist.add(strl);
				
			}
			olist = countUtil.multipleAnswerOptionNum(mulanslist, questionOptionNum);
			Iterator<Integer> iter = olist.iterator();
			int i=0;
			while(iter.hasNext())
			{
				omap.put((char)(65+i), iter.next());
				i++;
			}
			return omap;
		}
		else
			return omap;
	}
	
	//获得全部多选题选项答案并返回数组集合
	@Override
	@Transactional
	public List<Integer> getMultipleQuestionOptionAnswer(int sqnum,int questionOptionNum) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		List<String[]> mulanslist = new ArrayList<String[]>();
		//List<Integer>  mulansnumlist = new ArrayList<Integer>();
	 	list = answerDAOImpl.getMultipleQuestionOptionAnswer(sqnum);
	 	Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			String str = it.next();
		
			String sig="[\\]\\[\\s]";
			str=str.replaceAll(sig, "");
			String[] strl = str.split(",");
			mulanslist.add(strl);
			
		}
		return countUtil.multipleAnswerOptionNum(mulanslist, questionOptionNum);
	}


	
	@Override
	public Map<Character, Integer> getMultipleQuestionOptionAnswerMap(
			int sqnum, int questionOptionNum) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> olist = new ArrayList<>();
		olist = getMultipleQuestionOptionAnswer(sqnum, questionOptionNum);
		Iterator<Integer> it = olist.iterator();
		int i=0;
		while(it.hasNext())
		{
			omap.put((char)(65+i), it.next());
			i++;
		}
		return omap;
	}
	
		//获得多选题答案选项并返回数组集合BY性别
		public List<Integer> getMultipleQuestionOptionAnswerBySex(int sqnum, String sex,int questionOptionNum) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		List<String[]> mulanslist = new ArrayList<String[]>();
		List<Integer> anspIDlist = answerDAOImpl.getAnswerpaperPidBySex(sex);
		String pIDstr = anspIDlist.toString();
		
		pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
		list = answerDAOImpl.getMultipleQuestionOptionAnswerByPID(sqnum,pIDstr);
	 	Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			String str = it.next();
			String sig="[\\]\\[\\s]";
			str=str.replaceAll(sig, "");
			String[] strl = str.split(",");
			mulanslist.add(strl);
			
		}
		return countUtil.multipleAnswerOptionNum(mulanslist, questionOptionNum);
	}

		
	
		@Override
		public Map<Character, Integer> getMultipleQuestionOptionAnswerBySexMap(
				int sqnum,String sex, int questionOptionNum) {
			TreeMap<Character,Integer> omap = new TreeMap<>();
			List<Integer> olist = new ArrayList<>();
			olist = getMultipleQuestionOptionAnswerBySex(sqnum, sex,questionOptionNum);
			Iterator<Integer> it = olist.iterator();
			int i=0;
			while(it.hasNext())
			{
				omap.put((char)(65+i), it.next());
				i++;
			}
			return omap;
		}	
		
		//获得多选题答案选项并返回数组集合BY户口
	@Override
		public List<Integer> getMultipleQuestionOptionAnswerByHukou(int sqnum,
				String hukou,int questionOptionNum) {
			List<String> list = new ArrayList<String>();
			List<String[]> mulanslist = new ArrayList<String[]>();
			List<Integer> anspIDlist = answerDAOImpl.getAnswerpaperPidByHukou(hukou);
			String pIDstr = anspIDlist.toString();
			
			pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
			list = answerDAOImpl.getMultipleQuestionOptionAnswerByPID(sqnum,pIDstr);
		 	Iterator<String> it = list.iterator();
			while(it.hasNext())
			{
				String str = it.next();
				String sig="[\\]\\[\\s]";
				str=str.replaceAll(sig, "");
				String[] strl = str.split(",");
				mulanslist.add(strl);
				
			}
			return countUtil.multipleAnswerOptionNum(mulanslist, questionOptionNum);
		}
		
		
	@Override
	public Map<Character, Integer> getMultipleQuestionOptionAnswerByHukouMap(
			int sqnum,String hukou, int questionOptionNum) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> olist = new ArrayList<>();
		olist = getMultipleQuestionOptionAnswerByHukou(sqnum, hukou,questionOptionNum);
		Iterator<Integer> it = olist.iterator();
		int i=0;
		while(it.hasNext())
		{
			omap.put((char)(65+i), it.next());
			i++;
		}
		return omap;
	}
	
		//获得多选题答案选项并返回数组集合BY学院
		@Override
		public List<Integer> getMultipleQuestionOptionAnswerByDepartment(
				int sqnum, String department,int questionOptionNum) {
			List<String> list = new ArrayList<String>();
			List<String[]> mulanslist = new ArrayList<String[]>();
			List<Integer> anspIDlist = answerDAOImpl.getAnswerpaperPidByDepartment(department);
			String pIDstr = anspIDlist.toString();
			
			pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
			list = answerDAOImpl.getMultipleQuestionOptionAnswerByPID(sqnum,pIDstr);
		 	Iterator<String> it = list.iterator();
			while(it.hasNext())
			{
				String str = it.next();
				String sig="[\\]\\[\\s]";
				str=str.replaceAll(sig, "");
				String[] strl = str.split(",");
				mulanslist.add(strl);
				
			}
			return countUtil.multipleAnswerOptionNum(mulanslist, questionOptionNum);
		}

		
		@Override
		public Map<Character, Integer> getMultipleQuestionOptionAnswerByDepartmentMap(
				int sqnum,String department, int questionOptionNum) {
			TreeMap<Character,Integer> omap = new TreeMap<>();
			List<Integer> olist = new ArrayList<>();
			olist = getMultipleQuestionOptionAnswerByDepartment(sqnum, department,questionOptionNum);
			Iterator<Integer> it = olist.iterator();
			int i=0;
			while(it.hasNext())
			{
				omap.put((char)(65+i), it.next());
				i++;
			}
			return omap;
		}
		
	//获得多选题答案选项并返回数组集合BY专业
	@Override
		public List<Integer> getMultipleQuestionOptionAnswerByMarjor(int sqnum,
				String marjor,int questionOptionNum) {
			List<String> list = new ArrayList<String>();
			List<String[]> mulanslist = new ArrayList<String[]>();
			List<Integer> anspIDlist = answerDAOImpl.getAnswerpaperPidByMarjor(marjor);
			String pIDstr = anspIDlist.toString();
			
			pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
			list = answerDAOImpl.getMultipleQuestionOptionAnswerByPID(sqnum,pIDstr);
		 	Iterator<String> it = list.iterator();
			while(it.hasNext())
			{
				String str = it.next();
				String sig="[\\]\\[\\s]";
				str=str.replaceAll(sig, "");
				String[] strl = str.split(",");
				mulanslist.add(strl);
				
			}
			return countUtil.multipleAnswerOptionNum(mulanslist, questionOptionNum);
		}	
		
	
	@Override
	public Map<Character, Integer> getMultipleQuestionOptionAnswerByMarjorMap(
			int sqnum,String marjor, int questionOptionNum) {
		TreeMap<Character,Integer> omap = new TreeMap<>();
		List<Integer> olist = new ArrayList<>();
		olist = getMultipleQuestionOptionAnswerByMarjor(sqnum, marjor,questionOptionNum);
		Iterator<Integer> it = olist.iterator();
		int i=0;
		while(it.hasNext())
		{
			omap.put((char)(65+i), it.next());
			i++;
		}
		return omap;
	}
	
		//获得多选题答案选项并返回数组集合BY省份
		@Override
		public List<Integer> getMultipleQuestionOptionAnswerByProvince(int sqnum,
				String province,int questionOptionNum) {
			List<String> list = new ArrayList<String>();
			List<String[]> mulanslist = new ArrayList<String[]>();
			List<Integer> anspIDlist = answerDAOImpl.getAnswerpaperPidByProvince(province);
			String pIDstr = anspIDlist.toString();
			
			pIDstr=pIDstr.replaceAll("\\[", "(").replaceAll("\\]", ")");
			list = answerDAOImpl.getMultipleQuestionOptionAnswerByPID(sqnum,pIDstr);
			Iterator<String> it = list.iterator();
			while(it.hasNext())
			{
				String str = it.next();
				String sig="[\\]\\[\\s]";
				str=str.replaceAll(sig, "");
				String[] strl = str.split(",");
				mulanslist.add(strl);
				
			}
			return countUtil.multipleAnswerOptionNum(mulanslist, questionOptionNum);
		}	

		
		@Override
		public Map<Character, Integer> getMultipleQuestionOptionAnswerByProvinceMap(
				int sqnum,String province, int questionOptionNum) {
			TreeMap<Character,Integer> omap = new TreeMap<>();
			List<Integer> olist = new ArrayList<>();
			olist = getMultipleQuestionOptionAnswerByProvince(sqnum, province,questionOptionNum);
			Iterator<Integer> it = olist.iterator();
			int i=0;
			while(it.hasNext())
			{
				omap.put((char)(65+i), it.next());
				i++;
			}
			return omap;
		}

	@Override
	@Transactional
	public List<SingleAnswer> getSingleQuestionAnswer(int pID) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getSingleQuestionAnswer(pID);
	}

	@Override
	@Transactional
	public List<MultipleAnswer> getMultipleQuestionAnswer(int pID) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getMultipleQuestionAnswer(pID);
	}

	@Override
	@Transactional
	public List<TextAnswer> getTextQuestionAnswer(int pID) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getTextQuestionAnswer(pID);
	}

	@Override
	@Transactional
	public List<ListAnswer> getListQuestionAnswer(int pID) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getListQuestionAnswer(pID);
	}

	
	
	@Override
	public List<Integer> getAnswerpaperPidBySex(String sex) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswerpaperPidBySex(sex);
	}

	
	
	@Override
	public List<Integer> getAnswerpaperPidByHukou(String hukou) {
		// TODO Auto-generated method stub
		return answerDAOImpl.getAnswerpaperPidByHukou(hukou);
	}

	
	
	
	@Override
	public Map<String, String> getAnswersPaperDepartment() {
		Map<String,String> departmentMap = new HashMap<>();
		List<String> departlist =answerDAOImpl.getAnswersPaperDepartment();
		String department;
		Iterator<String> it = departlist.iterator();
		while(it.hasNext())
		{
			department = it.next();
			departmentMap.put(department,department );
		}
		return departmentMap;
	}

	@Override
	public Map<String, String> getAnswersPaperMarjor() {
		Map<String,String> marjorMap = new HashMap<>();
		List<String> departlist =answerDAOImpl.getAnswersPaperMarjor();
		String marjor;
		Iterator<String> it = departlist.iterator();
		while(it.hasNext())
		{
			marjor = it.next();
			marjorMap.put(marjor,marjor );
		}
		return marjorMap;
	}

	@Override
	public Map<String, String> getAnswersPaperProvince() {
		Map<String,String> provinceMap = new HashMap<>();
		List<String> departlist =answerDAOImpl.getAnswersPaperProvince();
		String province;
		Iterator<String> it = departlist.iterator();
		while(it.hasNext())
		{
			province = it.next();
			provinceMap.put(province,province );
		}
		return provinceMap;
	}

	@Override
	@Transactional
	public boolean checkStudents(Students stu) {
		// TODO Auto-generated method stub
		return answerDAOImpl.checkStudents(stu);
	}

	
}
