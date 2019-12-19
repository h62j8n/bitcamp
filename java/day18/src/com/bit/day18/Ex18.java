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
		Toolkit kit = Toolkit.getDefaultToolkit();		// ��ü ���� �Ұ�
//		kit.beep();
		Dimension dim = kit.getScreenSize();
		
		Image img = kit.createImage("snow.jpg");
		Icon icon = new ImageIcon(img);					// �����������̽� Ÿ���� �ڼհ�ü ����
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
