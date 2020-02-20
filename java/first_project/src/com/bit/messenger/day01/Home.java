package com.bit.messenger.day01;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
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
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Home extends Frame {
	final Frame frame = this;
	final Dialog dJoin = new Dialog(frame, false);
	final CardLayout card = new CardLayout();
	
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension dim = kit.getScreenSize();
	
	int uiWidth = 300;				// 내부 사이즈
	int uiLeft = 42;				// 내부 왼쪽 여백
	int uiHeight = 35;
	
	// 첫 화면 상단 로고 영역
	public void setTitle(Panel p) {
		Image img = kit.createImage("images\\ico_logo.png");
		Icon icon = new ImageIcon(img);
		JLabel titleLogo = new JLabel(icon);
		
		p.add(titleLogo);
	}
	
	// 첫 화면 아이디/비밀번호 입력 및 로그인 버튼 영역
	public void setLogin(Panel p) {
		p.setLayout(null);
		
		final JTextField tfId = new JTextField("ID 입력");
		final JTextField tfPw = new JPasswordField("비밀번호 입력");
		JButton btnLogin = new JButton("로그인");
		
		tfId.setBounds(uiLeft, 15, uiWidth, uiHeight);
		tfPw.setBounds(uiLeft, 52, uiWidth, uiHeight);
		btnLogin.setBounds(uiLeft, 100, uiWidth, uiHeight+5);
		btnLogin.setBackground(Color.white);
		
		tfId.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				tfId.setText(" ");
				tfId.setText("");
			}
		});
		tfPw.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				tfPw.setText(" ");
				tfPw.setText("");
			}
		});
		
		// "로그인" 버튼 이벤트
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.next(frame);
			}
		});
		
		p.add(tfId);
		p.add(tfPw);
		p.add(btnLogin);
	}
	
	// 첫 화면 회원가입/아이디찾기 버튼 영역
	public void setAccount(Panel p) {
		JButton btnJoin = new JButton("회원 가입");
		btnJoin.setBackground(Color.white);
		
		// "회원가입" 버튼 이벤트 
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dJoin.setVisible(true);
			}
		});
		
		p.add(btnJoin);
	}
	
	// 회원가입 (새 창)
	public void setJoin(Dialog d) {
		final Dialog thisD = d;
		
		String[] subject = {"아이디", "비밀번호", "비밀번호 확인", "이름"};
		Panel[] panels = new Panel[subject.length];
		Label[] labels = new Label[subject.length];
		JTextField[] fields = new JTextField[subject.length];
		
		JButton btnId = new JButton("중복확인");
		JButton btnSubmit = new JButton("등록하기");
		btnId.setBackground(Color.white);
		btnSubmit.setBackground(Color.white);
		
		// 가입 입력폼
		for (int i=0; i<subject.length; i++) {
			panels[i] = new Panel(null);
			
			labels[i] = new Label(""+subject[i]);
			labels[i].setBounds(uiLeft, 0, 80, uiHeight);
			labels[i].setAlignment(Label.RIGHT);
			
			if (i == 1 || i == 2) {
				fields[i] = new JPasswordField();
			} else {
				fields[i] = new JTextField();
			}
			fields[i].setBounds(144, 0, 300, uiHeight);
		}
		
		fields[0].setSize(200, uiHeight);
		btnId.setBounds(353, 0, 90, uiHeight-1);
		panels[0].add(btnId);
		
		for (int i=0; i<subject.length; i++) {
			panels[i].add(labels[i]);
			panels[i].add(fields[i]);
			
			d.add(panels[i]);
		}
		
		Panel pSubmit = new Panel();
		pSubmit.add(btnSubmit);
		
		d.add(pSubmit);
		
		d.setLayout(new GridLayout(subject.length+1, 2));
		d.setBackground(Color.white);
		d.setBounds(dim.width-500, 0, 500, 400);
		
		// "등록하기" 버튼 이벤트
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisD.dispose();
			}
		});
		
		// 가입 창 닫기
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				thisD.dispose();
			}
		});
	}
	
	// 홈 화면 검색 바 영역
	public void setSearchBar(Panel p) {
		p.setSize(0, uiHeight);
		
		JTextField tfSearch = new JTextField("친구 검색");
		Image img = kit.createImage("images\\ico_search.png");
		Icon icon = new ImageIcon(img);
		JButton btnSearch = new JButton(icon);
		
		p.setLayout(null);
		tfSearch.setBounds(uiLeft, 0, 260, uiHeight);
		btnSearch.setBounds(307, 0, uiHeight, uiHeight);
		
		btnSearch.setBackground(Color.white);
		p.add(tfSearch);
		p.add(btnSearch);
	}
	
	// 홈 화면 본인 프로필/친구목록 영역
	public void setMain(Panel pMain) {
		pMain.setLayout(null);
		
		Image img = kit.createImage("images\\ico_gear.png");
		Icon icon = new ImageIcon(img);
		
		Panel pProfile = new Panel(null);
		
		Label myInform = new Label("사용자");
		JButton editBtn = new JButton(icon);
		editBtn.setBackground(Color.white);
		
		myInform.setBounds(0, 0, 260, uiHeight);
		editBtn.setBounds(265, 0, uiHeight, uiHeight);
		pProfile.add(myInform);
		pProfile.add(editBtn);
		
		List friendList = new List();
		for (int i=0; i<10; i++) {
			friendList.add("내 친구"+(i+1));
		}
		
		pProfile.setBounds(uiLeft, uiLeft/2, uiWidth, uiHeight);
		friendList.setBounds(uiLeft, 60, uiWidth, 100);
		pMain.add(pProfile);
		pMain.add(friendList);
	}
	
	public Home() {
		setLayout(card);
		
		Panel clientHome = new Panel(new BorderLayout());
		Panel pSearch = new Panel();			// 상단 검색바
		Panel pMain = new Panel();				// 메인 (친구목록)
		
		setSearchBar(pSearch);
		setMain(pMain);
		
		clientHome.add(pSearch, BorderLayout.NORTH);
		clientHome.add(pMain, BorderLayout.CENTER);
		
		Panel clientTitle = new Panel(new BorderLayout());
		Panel pLogo = new Panel();					// 로고
		Panel pLogin = new Panel();					// ID / PW 입력창
		Panel pAccount = new Panel();				// 회원가입/ID, PW 찾기
		
		setTitle(pLogo);
		setLogin(pLogin);
		setAccount(pAccount);
		setJoin(dJoin);
		
		clientTitle.add(pLogo, BorderLayout.NORTH);
		clientTitle.add(pLogin, BorderLayout.CENTER);
		clientTitle.add(pAccount, BorderLayout.SOUTH);
		
		add(clientTitle);
		add(clientHome);
		
		setBounds(dim.width-400, 0, 400, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		Home frame = new Home();
	}
}
