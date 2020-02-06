package com.bit.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter1 implements Filter {
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("before doFilter");
		chain.doFilter(req, res);
		System.out.println("atfer doFilter");
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter init");
	}

	@Override
	public void destroy() {
		System.out.println("Filter destroy");
	}
}
