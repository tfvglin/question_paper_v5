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
//ѧ��������
public class StudentsAspect {
	
	
	 @Pointcut(value="execution(* edu.xidian.research.action.AnswerAction.add(..))")  
	 public void answerpointcut() {}  

	 @Pointcut(value="execution(* edu.xidian.research.action.StudentsAction.login(..))")
	 public void studentspointcut(){}
	 
	 
	 //��Ӵ�ǰ��֤ѧ���Ƿ�����֤ͨ��״̬����ֹ�ύ�ɹ�������ظ��ύ
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
