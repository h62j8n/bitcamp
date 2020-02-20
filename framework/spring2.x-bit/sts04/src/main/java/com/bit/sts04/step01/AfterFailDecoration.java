package com.bit.sts04.step01;

import org.springframework.aop.ThrowsAdvice;

public class AfterFailDecoration implements ThrowsAdvice{
	
	public void afterThrowing(Exception ex) {
		System.out.println("///////////////");
	}
}
