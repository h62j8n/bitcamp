package com.bit.day19;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Ex11 extends Frame implements FocusListener {
	TextField tf1, tf2;
	public Ex11() {
		Panel p = new Panel();
		
		tf1 = new TextField("id �Է�");
		tf2 = new TextField("pw �Է�");
		tf2.setEchoChar('*');
		
		Button btn = new Button("����");
		
		tf1.addFocusListener(this);
		tf2.addFocusListener(this);
		p.add(tf1);
		p.add(tf2);
		p.add(btn);
		
		add(p);
		setBounds(0,0,300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex11();
	}
	public void focusGained(FocusEvent e) {
		tf1.setText("");
	}
	public void focusLost(FocusEvent e) {
		String msg = tf1.getText();
		if (msg.length() == 0) {
			tf1.setText("id �Է�");
		}
	}
}
