package com.bit.day17;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class Ex19 {
	public static void main(String[] args) {
		Frame frame = new Frame();
		GridLayout mainLayout = new GridLayout(5, 1);
		GridLayout subLayout = new GridLayout();
		
		Button b0 = new Button("0");
		Button b1 = new Button("1");
		Button b2 = new Button("2");
		Button b3 = new Button("3");
		Button b4 = new Button("4");
		Button b5 = new Button("5");
		Button b6 = new Button("6");
		Button b7 = new Button("7");
		Button b8 = new Button("8");
		Button b9 = new Button("9");
		Button b01 = new Button("*");
		Button b02 = new Button("#");
		Button b03 = new Button();
		
		Panel p = new Panel();
		Panel p0 = new Panel();
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		
		p.add(b03);
		
		p0.add(b01);
		p0.add(b0);
		p0.add(b02);
		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		
		p3.add(b7);
		p3.add(b8);
		p3.add(b9);
		
		p.setLayout(subLayout);
		p0.setLayout(subLayout);
		p1.setLayout(subLayout);
		p2.setLayout(subLayout);
		p3.setLayout(subLayout);
		
		frame.add(p);
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p0);
		
		frame.setSize(220, 250);
		frame.setLayout(mainLayout);
		frame.setVisible(true);
	}
}
