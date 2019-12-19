package com.bit.day17;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex181 {
	public static void main(String[] args) {
		final Frame f = new Frame();
//		FlowLayout layout = new FlowLayout();
//		GridLayout layout = new GridLayout(2, 2);
		final CardLayout layout = new CardLayout();
		f.setLayout(layout);
		
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		
		Button[] btns = new Button[4];
		for (int i=0; i<btns.length; i++) {
			btns[i] = new Button("Button"+(i+1));
			btns[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					layout.next(f);
				}
			});
		}
		
		p1.add(btns[0]);
		p2.add(btns[1]);
		p3.add(btns[2]);
		p4.add(btns[3]);
		
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		
		f.setSize(300, 200);
		f.setLocation(0, 0);
		f.setVisible(true);
		
//		for (int i=0; i<3; i++) {		// CardLayoutÀÇ È°¿ë
			layout.next(f);
//		}
	}
}
