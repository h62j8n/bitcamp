package com.bit.day14;

import java.util.Stack;

public class Ex09 {
	public static void main(String[] args) {
		Stack stack;
		stack = new Stack();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		
		System.out.println(stack.search("5"));		// �ڿ��������� �ε��� �ѹ�
		
		while (!stack.empty()) {
			System.out.print(stack.pop()+" ");
		}
	}
}
