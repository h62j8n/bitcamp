package com.bit.messenger.v02;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MainUI extends Frame {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension dim = kit.getScreenSize();
	
	int uiWidth = 300;				// 내부 공통 사이즈
	int uiLeft = 42;				// 내부 왼쪽 여백
	int uiHeight = 35;				// 컨텐츠가 bar 스타일일 경우의 높이값
	
	// 검색 바 영역
	public void setSearchBar(Panel p) {
		final JTextField tfSearch = new JTextField("친구 검색");
		Image img = kit.createImage("images\\ico_search.png");
		Icon icon = new ImageIcon(img);
		JButton btnSearch = new JButton(icon);
		
		tfSearch.setBounds(0, 0, 260, uiHeight);
		btnSearch.setBounds(265, 0, uiHeight, uiHeight);
		btnSearch.setBackground(Color.white);
		
		p.add(tfSearch);
		p.add(btnSearch);
		
		tfSearch.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				tfSearch.setText(" ");
				tfSearch.setText("");
			}
		});
	}
	
	// 나의 프로필 영역
	public void setMyProfile(Panel p) {
		Image img = kit.createImage("images\\ico_gear.png");
		Icon icon = new ImageIcon(img);
		
		Label myInform = new Label("사용자");
		JButton editBtn = new JButton(icon);
		
		myInform.setBounds(0, 0, 260, uiHeight);
		editBtn.setBounds(265, 0, uiHeight, uiHeight);
		editBtn.setBackground(Color.white);
		
		p.add(myInform);
		p.add(editBtn);
	}
	
	// 친구목록 영역
	public void setFriends(Panel p) {
		List friendList = new List();
		for (int i=0; i<10; i++) {
			friendList.add("내 친구"+(i+1));
		}
		
		friendList.setBounds(0, 0, uiWidth, 150);
		p.add(friendList);
		
		// 리스트 이벤트
		friendList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TalkUI();
			}
		});
	}
	
	public MainUI() {
		setLayout(null);
		
		Panel pSearch = new Panel(null);			// 상단 검색바
		Panel pProfile = new Panel(null);			// 내 프로필
		Panel pFriends = new Panel(null);			// 친구목록
		
		pSearch.setBounds(uiLeft, 31, uiWidth, uiHeight);
		setSearchBar(pSearch);
		
		int schHeight = pSearch.getHeight();
		pProfile.setBounds(uiLeft, 31+schHeight+10, uiWidth, uiHeight);
		setMyProfile(pProfile);
		
		int pfHeight = pProfile.getHeight();
		pFriends.setBounds(uiLeft, 31+schHeight+pfHeight+10+10, uiWidth, 150);
		setFriends(pFriends);
		
		
		add(pSearch);
		add(pProfile);
		add(pFriends);
		
		setBounds(dim.width-400, 0, 400, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
//	public static void main(String[] args) {
//		MainUI frame = new MainUI();
//	}
}
