package com.bit.day18;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;

public class Ex02 {
	public static void main(String[] args) {
		Frame frame = new Frame();
		Panel p1 = new Panel();
		
//		TextArea ta = new TextArea("기본값", 8, 20);
		TextArea ta = new TextArea("기본값", 8, 20, TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setRows(8);
		ta.setColumns(20);
		ta.setText("기본값");
//		tf.setEditable(false);
//		tf.setEnabled(false);
		p1.add(ta);
		
		frame.add(p1);
//		frame.setLocation(200, 200);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}
