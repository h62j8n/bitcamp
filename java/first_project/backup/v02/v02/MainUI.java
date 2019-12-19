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
	
	int uiWidth = 300;				// ���� ���� ������
	int uiLeft = 42;				// ���� ���� ����
	int uiHeight = 35;				// �������� bar ��Ÿ���� ����� ���̰�
	
	// �˻� �� ����
	public void setSearchBar(Panel p) {
		final JTextField tfSearch = new JTextField("ģ�� �˻�");
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
	
	// ���� ������ ����
	public void setMyProfile(Panel p) {
		Image img = kit.createImage("images\\ico_gear.png");
		Icon icon = new ImageIcon(img);
		
		Label myInform = new Label("�����");
		JButton editBtn = new JButton(icon);
		
		myInform.setBounds(0, 0, 260, uiHeight);
		editBtn.setBounds(265, 0, uiHeight, uiHeight);
		editBtn.setBackground(Color.white);
		
		p.add(myInform);
		p.add(editBtn);
	}
	
	// ģ����� ����
	public void setFriends(Panel p) {
		List friendList = new List();
		for (int i=0; i<10; i++) {
			friendList.add("�� ģ��"+(i+1));
		}
		
		friendList.setBounds(0, 0, uiWidth, 150);
		p.add(friendList);
		
		// ����Ʈ �̺�Ʈ
		friendList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TalkUI();
			}
		});
	}
	
	public MainUI() {
		setLayout(null);
		
		Panel pSearch = new Panel(null);			// ��� �˻���
		Panel pProfile = new Panel(null);			// �� ������
		Panel pFriends = new Panel(null);			// ģ�����
		
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
