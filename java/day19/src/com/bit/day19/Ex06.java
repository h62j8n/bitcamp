package com.bit.day19;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Ex06 implements MouseMotionListener {
	static Label target = new Label("бу");
	
	public static void main(String[] args) {
		Ex06 me = new Ex06();
		Frame f = new Frame();
		Panel p = new Panel();
		p.setLayout(null);
		target.setBounds(10, 10, 20, 20);
		target.addMouseMotionListener(me);
		p.addMouseMotionListener(me);
		p.add(target);
		f.add(p);
		f.setBounds(0, 0, 500, 500);
		f.setVisible(true);
	}

	public void mouseDragged(MouseEvent e) {
//		System.out.println(e);
//		System.out.println(e.getXOnScreen()+" , "+e.getYOnScreen());
		target.setLocation(e.getX(), e.getY());
	}

	public void mouseMoved(MouseEvent e) {
	}
}
