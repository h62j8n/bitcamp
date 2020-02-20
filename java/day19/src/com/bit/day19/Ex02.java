package com.bit.day19;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

public class Ex02 extends Frame {
	public Ex02() {
		Color color = new Color(255, 0, 0);
		Panel p = new Panel();
		Label la = new Label("¹®ÀÚ¿­\r\nabcd\t1234");
		la.setBackground(color);
		
		p.add(la);
		add(p);
		setBounds(0, 0, 400, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex02();
	}
}
