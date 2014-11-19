package edu.xidian.research.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class StudentsAspect {

	@Around("execution(* edu.xidian.research.action.AnswerAction.add(..))")
	public Object studentsLoginCheck(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("俳中峇佩！！！！！！！！！！！！");
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getSession().getAttribute("stuname")==null)
		{
			return mapping.findForward("login");
		}
		else
		{
			return jp.proceed();
			
		}
	}
}
