package com.bit.sts12.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class BeforeAop {
	
//	@Before("execution(* com.bit.sts12.service.EmpServiceImpl.select*(..))")
	// 어드바이저 세팅. 
	// select* : select로 시작하는
	// (..) : 와일드카드
	public void before(JoinPoint join) {
		System.out.println("Aop before 시점");
		System.out.println(join.getClass());
		System.out.println(join.getTarget());
		System.out.println(Arrays.toString(join.getArgs()));
	}
}
