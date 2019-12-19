package com.bit.day19;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ex09 extends Frame implements ItemListener {
	Label l;
	public Ex09() {
		Panel p = new Panel();
		
		Choice c = new Choice();
		c.add("item1");
		c.add("item2");
		c.add("item3");
		c.add("item4");
		
		c.addItemListener(this);
		p.add(c);
		
		l = new Label(" ", 10);
		List list = new List();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");
		list.addItemListener(this);
		
		p.add(l);
		add(p);
		
		setBounds(0,0,300,300);
		setVisible(true);
		
		System.out.println(c.getSelectedIndex());
		System.out.println(c.getSelectedItem());
//		class Ex implements ItemListener {} 로컬클래스 방식
		
	}
	public static void main(String[] args) {
		new Ex09();
	}
	public void itemStateChanged(ItemEvent e) {
		Object ojb = e.getSource();
//		if (obj == cho) {
//			
//		}
//		l.setText(ojb.getSelectedItem());
	}
}
