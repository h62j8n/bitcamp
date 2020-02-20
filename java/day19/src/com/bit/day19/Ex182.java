package com.bit.day19;

import java.awt.CheckboxMenuItem;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class Ex182 {
	static Frame f = new Frame("Frame Notepad");
	static FileDialog fdia = new FileDialog(f, "����", FileDialog.LOAD);
	static FileDialog fdia2 = new FileDialog(f, "����", FileDialog.SAVE);
	static TextArea ta = new TextArea("", 10, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
	
	public static void main(String[] args) {
		MenuBar menuBar = new MenuBar();
		
		String[] mainList = {"����", "����", "����", "����", "����"};
		Menu[] mainMenu = new Menu[mainList.length];

		for (int i=0; i<mainList.length; i++) {
			mainMenu[i] = new Menu(""+mainList[i]);
			menuBar.add(mainMenu[i]);
		}
		
		String[][] menuList = {
			{"���� �����", "�� â", "����", "����", "�ٸ� �̸����� ����", null, "������ ����", "�μ�", null, "������"},
			{"���� ���", null, "�߶󳻱�", "����", "�ٿ��ֱ�", "����", null, "Bing���� �˻�", "ã��", "���� ã��", "���� ã��", "�ٲٱ�", "�̵�", null, "��� ����", "�ð�/��¥"},
			{"�ڵ� �� �ٲ�", "�۲�"},
			{"Ȯ���ϱ�/����ϱ�", "���� ǥ����"},
			{"���� ����", "�ǵ�� ������", null, "�޸��� ����"}
		};
		MenuItem[][] subMenu = new MenuItem[menuList.length][];
		
		int moreI = -1;
		int moreJ = -1;
		for (int i=0; i<menuList.length; i++) {
			subMenu[i] = new MenuItem[menuList[i].length];
			for (int j=0; j<menuList[i].length; j++) {
				String tit = menuList[i][j];
				
				if (tit == null) {
					continue;
				} else if (tit.equals("�ڵ� �� �ٲ�") || tit.equals("���� ǥ����")) {
					subMenu[i][j] = new CheckboxMenuItem(""+tit, true);
				} else if (tit.equals("Ȯ���ϱ�/����ϱ�")) {
					subMenu[i][j] = new Menu(""+tit);
					moreI = i;
					moreJ = j;
				} else {
					subMenu[i][j] = new MenuItem(""+tit);
				}
				
			}
		}
		
		String[] moreList = {"Ȯ��", "���", "Ȯ���ϱ�/����ϱ� �⺻�� ����"};
		for (int i=0; i<moreList.length; i++) {
			MenuItem more = new MenuItem(moreList[i]);
			((Menu)subMenu[moreI][moreJ]).add(more);
		}
		
		for (int i=0; i<subMenu.length; i++) {
			for (int j=0; j<subMenu[i].length; j++) {
				if (subMenu[i][j] == null) {
					mainMenu[i].addSeparator();
				} else {
					mainMenu[i].add(subMenu[i][j]);
				}
			}
		}
		
		Panel p = new Panel();
		p.setLayout(null);
		
		
		ta.setSize(384, 341);
		
		// ���θ����
		subMenu[0][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				f.setVisible(true);
				ta.setText("");
			}
		});
		
		// ����
		subMenu[0][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fdia.setVisible(true);
			}
		});
		
		// ����
		subMenu[0][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fdia2.setVisible(true);
			}
		});
		
		// ������
		subMenu[0][9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		
		p.add(ta);
		
		f.setMenuBar(menuBar);
		f.add(p);
		f.setBounds(5, 5, 400, 400);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	}
}
