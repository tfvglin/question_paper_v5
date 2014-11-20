package edu.xidian.research.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class StudentsAspect {
	
	
	 @Pointcut(value="execution(* edu.xidian.research.action.AnswerAction.add(..))")  
	 public void answerpointcut() {}  

	 @Pointcut(value="execution(* edu.xidian.research.action.StudentsAction.login(..))")
	 public void studentspointcut(){}
	 
	 
	@Around(value="answerpointcut()")
	public Object studentsLoginCheck(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("俳中峇佩！！！！！！！！！！！！");
		HttpServletRequest request = ServletActionContext.getRequest();
		//System.out.println(request.getParameter("stuname")+"----------");
		if(request.getSession().getAttribute("stuname")==null||request.getSession().getAttribute("stuname").equals(""))
		{
			System.out.println("侖兆葎腎！！！！！！！！！！！！！！！！");
			return "login";
		}
		else
		{
			return jp.proceed();
			
		}
	}
}
