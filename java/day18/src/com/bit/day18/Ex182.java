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
		
		String[] mainList = {"파일", "편집", "서식", "보기", "도움말"};
		Menu[] mainMenu = new Menu[mainList.length];

		for (int i=0; i<mainList.length; i++) {
			mainMenu[i] = new Menu(mainList[i]);
			menuBar.add(mainMenu[i]);
		}
		
		String[][] menuList = {
			{"새로 만들기", "새 창", "저장", "다른 이름으로 저장", null, "페이지 설정", "인쇄", null, "끝내기"},
			{"실행 취소", null, "잘라내기", "복사", "붙여넣기", "삭제", null, "Bing으로 검색", "찾기", "다음 찾기", "이전 찾기", "바꾸기", "이동", null, "모두 선택", "시간/날짜"},
			{"자동 줄 바꿈", "글꼴"},
			{"확대하기/축소하기", "상태 표시줄"},
			{"도움말 보기", "피드백 보내기", null, "메모장 정보"}
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
		
		String[] moreList = {"확대", "축소", "확대하기/축소하기 기본값 복원"};
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
