package com.bit.day14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex12 {
	public static void main(String[] args) {
		// �ζ� ��ȣ ������ (v0.1.0)
//		Set lotto = new HashSet();
		Set lotto = new TreeSet();
		while (lotto.size() < 6) {
			int num = (int)(Math.random()*45)+1;
			lotto.add(num);
		}
		Iterator note = lotto.iterator();
		while (note.hasNext()) {
			System.out.print(note.next()+" ");
		}
	}
}
