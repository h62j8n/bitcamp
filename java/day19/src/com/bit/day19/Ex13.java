package com.bit.day19;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex13 extends Frame implements ActionListener {
	public Ex13() {
		Panel p = new Panel();
		
		TextField tf = new TextField(10);
		Checkbox box = new Checkbox();
		Choice cho = new Choice();
		cho.add("item1");
		cho.add("item2");
		List list = new List();
		list.add("list1");
		list.add("list2");
		Button btn = new Button("Button");
		
		tf.addActionListener(this);
//		box.addActionListener(this);
//		cho.addActionListener(this);
		list.addActionListener(this);
		btn.addActionListener(this);
		
		p.add(tf);
		p.add(box);
		p.add(list);
		p.add(btn);
		add(p);
		
		setBounds(0, 0, 400, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex13();
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("ผ๖วเ");
	}
}
