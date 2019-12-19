package com.bit.day18;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

public class Ex01 extends Frame {
	public Ex01() {
		Font font = new Font("SansSerif", 0, 20);
		font = new Font(Font.MONOSPACED, Font.BOLD, 20);
		
		setLayout(new BorderLayout());
		Panel top = new Panel();
		
//		TextField tf = new TextField("화면에 출력", 14);
		TextField tf = new TextField();
		tf.setFont(font);
		tf.setText("화면에 출력");
		tf.setColumns(14);
//		tf.setEditable(false);
//		tf.setEnabled(false);
		tf.setEchoChar('*');
		
		top.add(tf);
//		add(tf, BorderLayout.NORTH);				// 이것만 해도 충분
		add(top, BorderLayout.NORTH);
		
		Panel p1 = new Panel();
		GridLayout layout = new GridLayout(4, 3);
		p1.setLayout(layout);
		
		String[] nums = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "*", "0", "#"};
		Button[] btns = new Button[nums.length];
		for (int i=0; i<btns.length; i++) {
			btns[i] = new Button();
			btns[i].setLabel(nums[i]);
			btns[i].setFont(font);
			p1.add(btns[i]);
		}
		
		add(p1, BorderLayout.CENTER);				// this.add(p1)
		setLocation(200, 200);
		setSize(200, 250);
		setVisible(true);
	}
	public static void main(String[] args) {
		Ex01 frame = new Ex01();
	}
}
