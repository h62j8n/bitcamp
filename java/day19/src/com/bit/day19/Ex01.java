package com.bit.day19;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;

public class Ex01 {
	public static void main(String[] args) {
		Frame f = new Frame("�θ� â");
		
		f.setBounds(0, 0, 400, 400);
		f.setVisible(true);
		
//		Dialog dia = new Dialog(f, true);
		FileDialog fdia = new FileDialog(f, "���� ����", FileDialog.SAVE);
		System.out.println(fdia.getDirectory());
		System.out.println(fdia.getFile());
		
		fdia.setLocation(150, 150);
		fdia.setSize(200, 200);
		fdia.setVisible(true);
		
		
		
//		f.dispose();			// ������ ����
//		dia.dispose();
	}
}
