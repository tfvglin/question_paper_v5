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
//问题类切面
public class QuestionAspect {
	
	
	 @Pointcut(value="execution(* edu.xidian.research.action.QuestionAction.updateQuestion(..))")  
	 public void updateQuestionPointcut() {}  


	 
	 
	 //添加答案前验证学生是否处于认证通过状态，防止提交成功后回退重复提交
	@Around(value="updateQuestionPointcut()")
	public Object updateQuestionPointcutCheck(ProceedingJoinPoint jp) throws Throwable
	{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getSession().getAttribute("adminname")==null||request.getSession().getAttribute("adminname").equals(""))
		{
			return "adminlogin";
		}
		else
		{
			return jp.proceed();
			
		}
	}
}
