package com.bit.day18;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class Ex07 extends Frame {
	public Ex07() {
		BorderLayout layout1 = new BorderLayout();
		BorderLayout layout2 = new BorderLayout();
		GridLayout layout3 = new GridLayout(6, 1);
		GridLayout layout4 = new GridLayout(6, 1);
		setLayout(layout1);
		
		Panel center = new Panel();
		Panel center1 = new Panel();
		Panel center2 = new Panel();
		
		center.setLayout(layout2);
		center1.setLayout(layout3);
		center2.setLayout(layout4);
		
		Label l1 = new Label("회원가입");
		Label l2 = new Label("id");
		Label l3 = new Label("pw");
		Label l4 = new Label("이름");
		Label l5 = new Label("취미");
		Label l6 = new Label("학력");
		Label l7 = new Label("자기소개");
		
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox box1 = new Checkbox("운동", cbg, true);
		Checkbox box2 = new Checkbox("독서", cbg, false);
		Checkbox box3 = new Checkbox("게임", cbg, false);
		
		Choice cho = new Choice();
		cho.add("고졸");
		cho.add("초대졸");
		cho.add("대졸");
		cho.add("대학원");
		
		TextArea ta = new TextArea();
		
		center1.add(l2);
		center1.add(l3);
		center1.add(l4);
		center1.add(l5);
		center1.add(l6);
		center1.add(l7);
		
		center2.add(tf1);
		center2.add(tf2);
		center2.add(tf3);
		
		Panel radio = new Panel();
		radio.add(box1);
		radio.add(box2);
		radio.add(box3);
		
		center2.add(radio);
		center2.add(cho);
		
		center.add(center1, BorderLayout.WEST);
		center.add(center2, BorderLayout.CENTER);
		
		add(l1, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		add(ta, BorderLayout.SOUTH);
		
		setBounds(0, 0, 400, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex07();
	}
}
