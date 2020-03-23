package com.bit.sts12.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class AfterAop {
	
//	@After("execution(* com.bit.sts12.service.EmpService.*One(int))")
	public void after() {
		System.out.println("Aop after 시점");
	}
}
