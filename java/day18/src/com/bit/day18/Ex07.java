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
		
		Label l1 = new Label("ȸ������");
		Label l2 = new Label("id");
		Label l3 = new Label("pw");
		Label l4 = new Label("�̸�");
		Label l5 = new Label("���");
		Label l6 = new Label("�з�");
		Label l7 = new Label("�ڱ�Ұ�");
		
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		
		CheckboxGroup cbg = new CheckboxGroup();
		Checkbox box1 = new Checkbox("�", cbg, true);
		Checkbox box2 = new Checkbox("����", cbg, false);
		Checkbox box3 = new Checkbox("����", cbg, false);
		
		Choice cho = new Choice();
		cho.add("����");
		cho.add("�ʴ���");
		cho.add("����");
		cho.add("���п�");
		
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
