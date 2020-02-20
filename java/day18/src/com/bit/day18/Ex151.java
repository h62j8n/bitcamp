package com.bit.day18;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;

public class Ex151 extends Frame {
	
	public Ex151() {
		Panel p = new Panel();
		GridBagLayout l = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		p.setLayout(l);
		
		String[] keys = {
				"Num", "/", "*", "-",
				"7", "8", "9", "+",
				"4", "5", "6",
				"1", "2", "3", "Ent",
				"0", "."
		};
		Button[] btns = new Button[keys.length];
		for (int i=0; i<btns.length; i++) {
			btns[i] = new Button(""+keys[i]);
		}
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		l.addLayoutComponent(btns[0], gbc);
		gbc.gridx = 1;
		l.addLayoutComponent(btns[1], gbc);
		gbc.gridx = 2;
		l.addLayoutComponent(btns[2], gbc);
		gbc.gridx = 3;
		l.addLayoutComponent(btns[3], gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		l.addLayoutComponent(btns[4], gbc);
		gbc.gridx = 1;
		l.addLayoutComponent(btns[5], gbc);
		gbc.gridx = 2;
		l.addLayoutComponent(btns[6], gbc);
		gbc.gridx = 3;
		gbc.gridheight = 2;
		l.addLayoutComponent(btns[7], gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		l.addLayoutComponent(btns[8], gbc);
		gbc.gridx = 1;
		l.addLayoutComponent(btns[9], gbc);
		gbc.gridx = 2;
		l.addLayoutComponent(btns[10], gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		l.addLayoutComponent(btns[11], gbc);
		gbc.gridx = 1;
		l.addLayoutComponent(btns[12], gbc);
		gbc.gridx = 2;
		l.addLayoutComponent(btns[13], gbc);
		gbc.gridx = 3;
		gbc.gridheight = 2;
		l.addLayoutComponent(btns[14], gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		l.addLayoutComponent(btns[15], gbc);
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		l.addLayoutComponent(btns[16], gbc);
		
		for (int i=0; i<btns.length; i++) {
			p.add(btns[i]);
		}
		
		add(p);
		setBounds(0, 0, 280, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex151();
	}
}
