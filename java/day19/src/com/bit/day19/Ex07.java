package com.bit.day19;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex07 extends Frame implements KeyListener {
	TextField tf = new TextField();

	public Ex07() {
		Panel p = new Panel();
		
		p.add(tf);
		tf.addKeyListener(this);
		
		add(p);
		setBounds(0, 0, 300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex07();
	}

	public void keyTyped(KeyEvent e) {
		System.out.println("KeyTyped : "+e.getKeyChar()+e.getKeyCode());
		TextField temp = (TextField)e.getSource();
		System.out.println(temp.getText());
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed : "+e.getKeyChar()+e.getKeyCode());
		System.out.println(tf.getText());
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased : "+e.getKeyChar()+e.getKeyCode());
		System.out.println(tf.getText());
	}
}
