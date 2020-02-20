package com.bit.day19;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex14 extends Frame {
	public Ex14() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("´Ý±â");
			}
		});
		Button btn = new Button("Button");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btn);
		
		setBounds(0, 0, 300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex14();
	}
}
