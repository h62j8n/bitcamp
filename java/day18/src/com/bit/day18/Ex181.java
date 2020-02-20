package com.bit.day18;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;

public class Ex181 {
	public static void main(String[] args) {
		Frame f = new Frame("Frame Notepad");
		
		MenuBar menuBar = new MenuBar();
		String[][] menuList = {
				{
					"����", "���� �����", "�� â", "����", "�ٸ� �̸����� ����",
					null, "������ ����", "�μ�", null, "������"
				},
				{
					"����", "���� ���", null, "�߶󳻱�", "����",
					"�ٿ��ֱ�", "����", null, "Bing���� �˻�", "ã��",
					"���� ã��", "���� ã��", "�ٲٱ�", "�̵�", null,
					"��� ����", "�ð�/��¥"
				},
				{"����", "�ڵ� �� �ٲ�", "�۲�"},
				{"����", "Ȯ���ϱ�/����ϱ�", "���� ǥ����"},
				{"����", "���� ����", "�ǵ�� ������", null, "�޸��� ����"}
		};
		String[] moreList = {"Ȯ���ϱ�/����ϱ�", "Ȯ��", "���", "Ȯ���ϱ�/����ϱ� �⺻�� ����"};
		
		MenuItem[] moreMenu = new MenuItem[moreList.length];
		for (int i=0; i<moreList.length; i++) {
			moreMenu[i] = new Menu(moreList[i]);
		}
		
		Menu[] mainMenu = new Menu[menuList.length];
		
		for (int i=0; i<menuList.length; i++) {
			MenuItem[][] subMenu = new MenuItem[menuList.length][menuList[i].length];
			
			for (int j=0; j<menuList[i].length; j++) {
				String target = menuList[i][j];
				if (j == 0) {
					mainMenu[i] = new Menu(target);
					
				} else {
					if (menuList[i][j] == null) {
						mainMenu[i].addSeparator();
						
					} else {
						if (target.equals("Ȯ���ϱ�/����ϱ�")) {
							subMenu[i][j] = new Menu(target);
							for (int k=0; k<moreMenu.length; k++) {
								((Menu) subMenu[i][j]).add(moreMenu[i]);
								
							}
						} else if (target.equals("�ڵ� �� �ٲ�") || target.equals("���� ǥ����") ) {
							subMenu[i][j] = new CheckboxMenuItem(target, true);
						} else {
							subMenu[i][j] = new MenuItem(target);
						}
						mainMenu[i].add(subMenu[i][j]);
					}
				}
			}
			menuBar.add(mainMenu[i]);
			
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
