package com.bit.day18;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;

public class Ex13 extends Frame {
	public Ex13() {
		Panel main = new Panel();
		
		GridBagLayout gbl = new GridBagLayout();
		main.setLayout(gbl);
		
		Button btn1 = new Button("1");
		Button btn2 = new Button("2");
		Button btn3 = new Button("3");
		Button btn4 = new Button("4");
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbl.setConstraints(btn1, gbc);
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbl.setConstraints(btn2, gbc);
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbl.setConstraints(btn3, gbc);
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbl.setConstraints(btn4, gbc);
		
		main.add(btn1);
		main.add(btn2);
		main.add(btn3);
		main.add(btn4);
		
		add(main);
		setBounds(0, 0, 200, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ex13();
	}
}
