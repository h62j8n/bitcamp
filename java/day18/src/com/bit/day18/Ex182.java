package com.bit.day18;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.List;

public class Ex182 {
	public static void main(String[] args) {
		Frame f = new Frame("Frame Notepad");
		
		MenuBar menuBar = new MenuBar();
		
		String[] mainList = {"����", "����", "����", "����", "����"};
		Menu[] mainMenu = new Menu[mainList.length];

		for (int i=0; i<mainList.length; i++) {
			mainMenu[i] = new Menu(mainList[i]);
			menuBar.add(mainMenu[i]);
		}
		
		String[][] menuList = {
			{"���� �����", "�� â", "����", "�ٸ� �̸����� ����", null, "������ ����", "�μ�", null, "������"},
			{"���� ���", null, "�߶󳻱�", "����", "�ٿ��ֱ�", "����", null, "Bing���� �˻�", "ã��", "���� ã��", "���� ã��", "�ٲٱ�", "�̵�", null, "��� ����", "�ð�/��¥"},
			{"�ڵ� �� �ٲ�", "�۲�"},
			{"Ȯ���ϱ�/����ϱ�", "���� ǥ����"},
			{"���� ����", "�ǵ�� ������", null, "�޸��� ����"}
		};
		MenuItem[][] subMenu = new MenuItem[menuList.length][];
		for (int i=0; i<menuList.length; i++) {
			subMenu[i] = new MenuItem[menuList[i].length];
			for (int j=0; j<menuList[i].length; j++) {
				String tit = menuList[i][j];
				
				if (tit == null) {
					mainMenu[i].addSeparator();
				} else {
					subMenu[i][j] = new MenuItem(tit);
					mainMenu[i].add(subMenu[i][j]);
				}
			}
		}
		
		String[] moreList = {"Ȯ��", "���", "Ȯ���ϱ�/����ϱ� �⺻�� ����"};
		MenuItem[] moreMenu = new MenuItem[moreList.length];
		for (int i=0; i<moreList.length; i++) {
			moreMenu[i] = new Menu(moreList[i]);
		}
		
		

		
		Panel p = new Panel();
		p.setLayout(null);
		
		TextArea ta = new TextArea("", 10, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setSize(384, 341);
		
		p.add(ta);
		
		f.setMenuBar(menuBar);
		f.add(p);
		f.setBounds(5, 5, 400, 400);
		f.setVisible(true);
		
		System.out.println(p.getWidth()+", "+p.getHeight());
	}
}
