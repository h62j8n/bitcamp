package com.bit.day22;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex04 {
	public static void main(String[] args) {
		String path = "http://www.seoul.go.kr/main/index.jsp";	// http://www.seoul.go.kr:80/main/index.jsp
		URL url = null;
		
		try {
			url = new URL(path);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort()+" or "+url.getDefaultPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
		} catch (MalformedURLException e) {
		}
	}
}
