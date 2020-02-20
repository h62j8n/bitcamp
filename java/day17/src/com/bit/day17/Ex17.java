package com.bit.day17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class Ex17 extends Frame {		// 상속을 통해 내 클래스를 Frame으로 사용 가능
	public Ex17() {
//		FlowLayout layout = new FlowLayout();
//		GridLayout layout = new GridLayout(2, 2);	// (행, 열)
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		Button btn1 = new Button();
		btn1.setLabel("Button1");
		this.add(btn1, BorderLayout.NORTH);
		Button btn2 = new Button("Button2");
		this.add(btn2, BorderLayout.CENTER);
		Button btn3 = new Button("Button3");
		this.add(btn3, BorderLayout.SOUTH);
		Button btn4 = new Button("Button4");
//		this.add(btn4, BorderLayout.WEST);
		Button btn5 = new Button("Button5");
		this.add(btn5, BorderLayout.EAST);
//		Button btn6 = new Button("Button6");
//		Button btn7 = new Button("Button7");
//		
//		Panel p1 = new Panel();
//		p1.setLayout(layout);			// Panel default layout : FlowLayout()
//		p1.add(btn4);
//		p1.add(btn5);
//		p1.add(btn6);
//		p1.add(btn7);
//		
//		this.add(p1);
		this.setLocation(150, 150);
		this.setSize(400, 250);
		this.setVisible(true);			// 생성자를 통해 객체 생성 시 바로 창을 띄우도록 할 수 있다.
	}
	public static void main(String[] args) {
		Ex17 me = new Ex17();
//		me.setVisible(true);
	}
}
