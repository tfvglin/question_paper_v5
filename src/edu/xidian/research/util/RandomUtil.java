package edu.xidian.research.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import edu.xidian.research.service.impl.AnswerServiceImpl;

@Component("randomUtil")
public class RandomUtil {
	
	private AnswerServiceImpl answerServiceImpl;
	
	
	
	public int[] getRandomPID(int count,int maxpid , int minpid)
	{
		
		 int[] intRet = new int[count]; 
         int intRd = 0; 				//存放随机数
         int getcount = 0; 				//记录生成的随机数个数
         int flag = 0; 					//是否已经生成过标志
         while(getcount<count){
              Random rdm = new Random(System.currentTimeMillis());
              intRd = rdm.nextInt(maxpid)%(maxpid-minpid+1) + minpid;
              for(int i=0;i<getcount;i++){
                  if(intRet[i]==intRd){
                      flag = 1;
                      break;
                  }else{
                      flag = 0;
                  }
              }
              if(flag==0){
                  intRet[getcount] = intRd;
                  getcount++;
              }
         }
         	return intRet;
	}

	public List<String> getRandomPIDstr(int count,int maxpid , int minpid)
	{
		
		int[] intRet = new int[count]; 
		List<String>  PIDstr = new ArrayList<String>();
		int intRd = 0; 				//存放随机数
         int getcount = 0; 				//记录生成的随机数个数
         int flag = 0; 					//是否已经生成过标志
         while(getcount<count){
              Random rdm = new Random(System.currentTimeMillis());
              intRd = rdm.nextInt(maxpid)%(maxpid-minpid+1) + minpid;
              for(int i=0;i<getcount;i++){
                  if(intRet[i]==intRd){
                      flag = 1;
                      break;
                  }else{
                      flag = 0;
                  }
              }
              if(flag==0){
                  intRet[getcount] = intRd;
                  PIDstr.add( intRd+"");
                  getcount++;
              }
         }
         	return PIDstr;
	}
}
