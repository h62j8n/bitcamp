package com.bit.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter2 implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0
			, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("���ο� ���� before");
		System.out.println("���ο� ���� �۵�");
		chain.doFilter(arg0, arg1);
		System.out.println("���ο� ���� after");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}