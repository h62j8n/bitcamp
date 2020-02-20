package com.bit.day18;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ex18 extends Frame {
	public Ex18() {
		Toolkit kit = Toolkit.getDefaultToolkit();		// 객체 생성 불가
//		kit.beep();
		Dimension dim = kit.getScreenSize();
		
		Image img = kit.createImage("snow.jpg");
		Icon icon = new ImageIcon(img);					// 조상인터페이스 타입의 자손객체 생성
		JButton btn = new JButton(icon);
		add(btn);
		
		setSize(400, 400);
		setLocation(dim.width/2-this.getWidth()/2, dim.height/2-this.getHeight()/2);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ex18();
	}
}
