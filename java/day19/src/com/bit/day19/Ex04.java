package com.bit.day19;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ex04 extends Frame implements WindowListener {
	public Ex04() {
		
		setBounds(0, 0, 300, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex04();
	}

	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
//		System.exit(0);
		this.dispose();
	}
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}
	public void windowIconified(WindowEvent e) {
		System.out.println("â �ּ�ȭ");
	}
	public void windowDeiconified(WindowEvent e) {
		System.out.println("â ���ּ�ȭ");
	}
	public void windowActivated(WindowEvent e) {
		System.out.println("â Ȱ��ȭ");
	}
	public void windowDeactivated(WindowEvent e) {
		System.out.println("â ��Ȱ��ȭ");
	}
}
