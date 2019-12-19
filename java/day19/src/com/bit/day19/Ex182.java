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
	static FileDialog fdia = new FileDialog(f, "열기", FileDialog.LOAD);
	static FileDialog fdia2 = new FileDialog(f, "저장", FileDialog.SAVE);
	static TextArea ta = new TextArea("", 10, 10, TextArea.SCROLLBARS_VERTICAL_ONLY);
	
	public static void main(String[] args) {
		MenuBar menuBar = new MenuBar();
		
		String[] mainList = {"파일", "편집", "서식", "보기", "도움말"};
		Menu[] mainMenu = new Menu[mainList.length];

		for (int i=0; i<mainList.length; i++) {
			mainMenu[i] = new Menu(""+mainList[i]);
			menuBar.add(mainMenu[i]);
		}
		
		String[][] menuList = {
			{"새로 만들기", "새 창", "열기", "저장", "다른 이름으로 저장", null, "페이지 설정", "인쇄", null, "끝내기"},
			{"실행 취소", null, "잘라내기", "복사", "붙여넣기", "삭제", null, "Bing으로 검색", "찾기", "다음 찾기", "이전 찾기", "바꾸기", "이동", null, "모두 선택", "시간/날짜"},
			{"자동 줄 바꿈", "글꼴"},
			{"확대하기/축소하기", "상태 표시줄"},
			{"도움말 보기", "피드백 보내기", null, "메모장 정보"}
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
				} else if (tit.equals("자동 줄 바꿈") || tit.equals("상태 표시줄")) {
					subMenu[i][j] = new CheckboxMenuItem(""+tit, true);
				} else if (tit.equals("확대하기/축소하기")) {
					subMenu[i][j] = new Menu(""+tit);
					moreI = i;
					moreJ = j;
				} else {
					subMenu[i][j] = new MenuItem(""+tit);
				}
				
			}
		}
		
		String[] moreList = {"확대", "축소", "확대하기/축소하기 기본값 복원"};
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
		
		// 새로만들기
		subMenu[0][0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				f.setVisible(true);
				ta.setText("");
			}
		});
		
		// 열기
		subMenu[0][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fdia.setVisible(true);
			}
		});
		
		// 저장
		subMenu[0][2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fdia2.setVisible(true);
			}
		});
		
		// 끝내기
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
