package com.bit.day18;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;

public class Ex15 extends Frame {
	
	public Ex15() {
		Panel p = new Panel();
		GridBagLayout l = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		p.setLayout(l);
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		String[][] keys = {
				{"Num", "/", "*", "-"},
				{"7", "8", "9", "+"},
				{"4", "5", "6"},
				{"1", "2", "3", "Ent"},
				{"0", null, "."}
		};
		Button[][] btns = new Button[keys.length][];
		for (int i=0; i<keys.length; i++) {
			btns[i] = new Button[keys[i].length];
			for (int j=0; j<keys[i].length; j++) {
				if (keys[i][j] == null) {
					btns[i][j] = null;
				} else {
					btns[i][j] = new Button(keys[i][j]);
				}
			}
		}
		
		for (int i=0; i<btns.length; i++) {
			for (int j=0; j<btns[i].length; j++) {
				if (btns[i][j] == null) {continue;}			// 0 다음의 공백값 무시
				gbc.gridx = j;
				gbc.gridy = i;
				if (j == 3 && i == 1 || j == 3 && i == 3) {
					gbc.gridheight = 2;
				} else {
					gbc.gridheight = 1;
				}
				if (j == 0 && i == 4) {
					gbc.gridwidth = 2;
				} else {
					gbc.gridwidth = 1;
				}
				l.addLayoutComponent(btns[i][j], gbc);
				p.add(btns[i][j]);
			}
		}
		
		add(p);
		setBounds(0, 0, 280, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex15();
	}
}
