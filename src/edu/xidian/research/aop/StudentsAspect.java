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
//学生类切面
public class StudentsAspect {
	
	
	 @Pointcut(value="execution(* edu.xidian.research.action.AnswerAction.add(..))")  
	 public void answerpointcut() {}  

	 @Pointcut(value="execution(* edu.xidian.research.action.StudentsAction.login(..))")
	 public void studentspointcut(){}
	 
	 
	 //添加答案前验证学生是否处于认证通过状态，防止提交成功后回退重复提交
	@Around(value="answerpointcut()")
	public Object studentsLoginCheck(ProceedingJoinPoint jp) throws Throwable
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getSession().getAttribute("stuname")==null||request.getSession().getAttribute("stuname").equals(""))
		{
			return "login";
		}
		else
		{
			return jp.proceed();
			
		}
	}
}
