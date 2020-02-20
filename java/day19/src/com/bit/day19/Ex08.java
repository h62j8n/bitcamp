package com.bit.day19;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ex08 extends Frame implements KeyListener {
	public Ex08() {
		final double LIMIT_X;
		final double LIMIT_Y;
		
		Panel p = new Panel();
		Button btn = new Button("¡ß");
		
		btn.setLocation(0, 0);
		btn.setSize(20, 20);
		btn.addKeyListener(this);
		
		p.add(btn);
		add(p);
		
		setBounds(0, 0, 500, 500);
		setVisible(true);
		
		Dimension ps = p.getSize();
		LIMIT_X = ps.getWidth()-btn.getWidth();
		LIMIT_Y = ps.getHeight()-btn.getHeight();
	}
	public static void main(String[] args) {
		new Ex08();
	}
	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		Button target = (Button)e.getSource();
		int x = target.getX();
		int y = target.getY();
		if (e.getKeyChar() == 'd' || e.getKeyCode() == 39) {
			x+=10;
		} else if (e.getKeyChar() == 's' || e.getKeyCode() == 40) {
			y+=10;
		} else if (e.getKeyChar() == 'a' || e.getKeyCode() == 37) {
			x-=10;
		} else if (e.getKeyChar() == 'w' || e.getKeyCode() == 38) {
			y-=10;
		}
		
		target.setLocation(x, y);
	}
}
