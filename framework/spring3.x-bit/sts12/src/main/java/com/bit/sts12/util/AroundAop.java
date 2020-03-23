package com.bit.sts12.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class AroundAop {
//	@Around("execution(* com.bit.sts12.service.EmpService.deleteOne(..))")
	public void arround(ProceedingJoinPoint join) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
		try {
			join.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
}
