package com.bit.day18;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class Ex06 extends Frame {
	public Ex06() {
		GridLayout mainLayout = new GridLayout(7, 1);
		GridLayout subLayout = new GridLayout(1, 2);
		GridLayout subLayout2 = new GridLayout(2, 1);
		
		String[] subject = {"회원가입", "id", "pw", "이름", "취미", "학력", "자기소개"};
		Panel[] line = new Panel[subject.length];
		Label[] tit = new Label[subject.length];
		
		for (int i=0; i<subject.length; i++) {
			tit[i] = new Label(subject[i]);
			line[i] = new Panel();
			line[i].setLayout(subLayout);
			line[i].add(tit[i]);
			add(line[i]);
		}
		
		TextField tf1 = new TextField(15);
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		
		line[1].add(tf1);
		line[2].add(tf2);
		line[3].add(tf3);
		
		CheckboxGroup hobby = new CheckboxGroup();
		Checkbox h1 = new Checkbox("운동", hobby, true);
		Checkbox h2 = new Checkbox("독서", hobby, false);
		Checkbox h3 = new Checkbox("게임", hobby, false);
		
		line[4].add(h1);
		line[4].add(h2);
		line[4].add(h3);
		
		Choice c = new Choice();
		c.addItem("학력을 선택하세요");
		c.addItem("고졸");
		c.addItem("초대졸");
		c.addItem("대졸");
		c.addItem("대학원");
		
		line[5].add(c);
		
		TextArea ta = new TextArea("", 10, 20, TextArea.SCROLLBARS_VERTICAL_ONLY);
		line[6].setLayout(subLayout2);
		line[6].add(ta);
		
		setLayout(mainLayout);
		setBounds(0, 0, 350, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex06();
	}
}
