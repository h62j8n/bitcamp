package com.bit.day18;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;

public class Ex16 extends Frame {

	public Ex16() {
		Panel p = new Panel();
		p.setLayout(null);			// 기본 레이아웃(FlowLayout) 제거
		
		Button btn1 = new Button("button1");
		btn1.setSize(100, 100);
		btn1.setLocation(384-100, 361-100);
		
		p.add(btn1);
		
		add(p);
		setBounds(0, 0, 400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex16();
	}
}
