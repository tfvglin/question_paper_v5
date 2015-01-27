package edu.xidian.research.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
//����Ա������
public class AdminAspect {
	
	
	 @Pointcut("execution(* edu.xidian.research.action.AdminAction.*(..))")  
	 public void adminpointcut() {}  

	 @Pointcut(value="execution(* edu.xidian.research.action.StudentsAction.login(..))")
	 public void studentspointcut(){}
	 
	 
	 //��Ӵ�ǰ��֤ѧ���Ƿ�����֤ͨ��״̬����ֹ�ύ�ɹ�������ظ��ύ
	 @Around(value="execution(* edu.xidian.research.action.AdminAction.login(..)) && execution(* edu.xidian.research.action.AdminAction.drawPaper(..)) ")
	public String AdminCheck(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("���ص���");
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getSession().getAttribute("adminname")==null||request.getSession().getAttribute("adminname").equals(""))
		{
			return "login";
		}
		else
		{
			return (String) jp.proceed();
			
		}
	}
}
