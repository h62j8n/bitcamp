package com.bit.day18;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;

public class Ex17 {
	public static void main(String[] args) {
		Frame f = new Frame("FRAME Sample");
		
		Panel p = new Panel();
		
		MenuBar mb = new MenuBar();
		Menu mn1 = new Menu("File");
		MenuItem mni11 = new CheckboxMenuItem("Mode", true);		// 다형성
		mn1.add(mni11);
		
		Menu mn2 = new Menu("Edit");
		Menu mn3 = new Menu("Source");
		
		Menu mn4 = new Menu("Window");
		MenuItem mni41 = new Menu("Show view");
		MenuItem mni411 = new Menu("Console");
		
		Menu mn5 = new Menu("Help");
		MenuItem mni51 = new MenuItem("Welcome");
		MenuItem mni52 = new MenuItem("About");
		mn5.add(mni51);
		mn5.addSeparator();					// 구분선
		mn5.add(mni52);
		
		mb.add(mn1);
		mb.add(mn2);
		mb.add(mn3);
		mb.add(mn4);
		mb.add(mn5);
		
		f.add(p);
		f.setMenuBar(mb);
		f.setBounds(5, 5, 400, 400);
		f.setVisible(true);
	}
}
