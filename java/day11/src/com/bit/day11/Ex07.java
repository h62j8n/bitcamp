package com.bit.day11;
import java.util.StringTokenizer;

public class Ex07 {
	public static void main(String[] args) {
		String target = "java     DB web Spring android";
//		StringTokenizer stk = new StringTokenizer(target, ",");
		StringTokenizer stk = new StringTokenizer(target);			// ����� �ڵ����� �߶���
		
		int cnt = stk.countTokens();
		System.out.println(cnt);
		
		while (stk.hasMoreElements()) {
			System.out.println(stk.nextElement());
		}
	}
}
