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
					"파일", "새로 만들기", "새 창", "저장", "다른 이름으로 저장",
					null, "페이지 설정", "인쇄", null, "끝내기"
				},
				{
					"편집", "실행 취소", null, "잘라내기", "복사",
					"붙여넣기", "삭제", null, "Bing으로 검색", "찾기",
					"다음 찾기", "이전 찾기", "바꾸기", "이동", null,
					"모두 선택", "시간/날짜"
				},
				{"서식", "자동 줄 바꿈", "글꼴"},
				{"보기", "확대하기/축소하기", "상태 표시줄"},
				{"도움말", "도움말 보기", "피드백 보내기", null, "메모장 정보"}
		};
		String[] moreList = {"확대하기/축소하기", "확대", "축소", "확대하기/축소하기 기본값 복원"};
		
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
						if (target.equals("확대하기/축소하기")) {
							subMenu[i][j] = new Menu(target);
							for (int k=0; k<moreMenu.length; k++) {
								((Menu) subMenu[i][j]).add(moreMenu[i]);
								
							}
						} else if (target.equals("자동 줄 바꿈") || target.equals("상태 표시줄") ) {
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
