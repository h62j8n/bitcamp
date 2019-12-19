package com.bit.day19;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Ex10 extends Frame implements ComponentListener {
	public Ex10() {
		
		Button btn = new Button();
		addComponentListener(this);
		
		setBounds(100, 100, 300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex10();
	}
	public void componentResized(ComponentEvent e) {
	}
	public void componentMoved(ComponentEvent e) {
	}
	public void componentShown(ComponentEvent e) {
	}
	public void componentHidden(ComponentEvent e) {
	}
}
