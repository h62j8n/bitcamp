package com.bit.messenger.v05;

import java.awt.Color;
import java.awt.Dialog;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MainUI extends Frame {
	BufferedReader br;
	OutputStream os;
	StringTokenizer token;
	
	Member mb;
	
	// UI 전역변수
	Frame frame = this;
	Dialog searchUi;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension dim = kit.getScreenSize();
	int inTopY = 31;			// innerTop Y (제목표시줄 이후)
	int commH = 35;				// commonHeight (컴포넌트 기본 높이)
	
	// 서버 메세지를 받는 라벨
	Label sysMsg = new Label();			// 로그인 창
	Label sysMsgSearch = new Label("");	// 친구검색 창
	
	// 친구검색 필드1 (메인)
	JTextField tfMySearch = new JTextField("친구 검색");
	JButton btnMySearch = new JButton();	// 내친구 검색버튼
	JButton btnPlus = new JButton();		// 새친구찾기 버튼 (다이얼로그)
	
	// 메인 필드
	Label myInform = new Label();		// 내 정보
	JButton btnEdit = new JButton();	// 편집버튼
	List friendList = new List();		// 친구목록
	JButton btnTalk = new JButton("대화");
	JButton btnDel = new JButton("삭제");
	
	// 친구검색 필드2 (다이얼로그)
	JTextField tfSearch = new JTextField("친구 검색");
	JButton btnSearch = new JButton();			// 새친구 검색버튼
	List searchList = new List();				// 친구검색결과 목록
	JButton btnAdd = new JButton("친구 추가");	// 친구 추가 버튼
	
	// #UI 검색바 (공통)
	public Panel searchBar(int w, JTextField tf, JButton btn) {
		Panel p = new Panel(null);
		p.setBounds(0, 0, w, commH);
		p.add(tf);
		p.add(btn);
		tf.setBounds(0, 0, 260, commH);
		btn.setBounds(260+5, 0, commH, commH);
		
		Image imgSearch = kit.createImage("images\\ico_search.png");
		Icon iconSearch = new ImageIcon(imgSearch);
		btn.setIcon(iconSearch);
		btn.setBackground(Color.WHITE);
		
		return p;
	}
	
	// #UI 친구목록 (공통)
	public Panel frList(int w, List list, JButton btn) {
		Panel p = new Panel(null);
		p.setSize(w, 195);
		list.setBounds(0, 0, w, 150);
		list.setMultipleMode(true);
		btn.setBounds(w-60, 150+10, 60, commH);
		btn.setBackground(Color.WHITE);
		p.add(list);
		p.add(btn);
		
		return p;
	}
	
	// #UI 메인패널
	public Panel mainPanel(int fW, int fH) {
		int inW = 300;				// innerWidth
		int inCenX = (fW-inW)/2;	// innerCenter X (가운데 정렬)
		
		Panel p = new Panel(null);
		p.setBounds(inCenX, (fH-305)/2, inW, 305);
		
		// 친구 검색바
		Panel pSearchBar = searchBar(inW, tfMySearch, btnMySearch);
		Image imgPlus = kit.createImage("images\\ico_plus.png");
		Icon iconPlus = new ImageIcon(imgPlus);
		btnPlus.setIcon(iconPlus);
		pSearchBar.add(btnPlus);
		btnPlus.setBackground(Color.WHITE);
		tfMySearch.setSize(220, commH);
		btnMySearch.setBounds(220+5, 0, commH, commH);
		btnPlus.setBounds(220+commH+10, 0, commH, commH);
		
		tfMySearch.addFocusListener(new FocusAdapter() {
			JTextField tf = tfMySearch;
			public void focusGained(FocusEvent e) {
				tf.setText(" ");
				tf.setText("");
			}
		});
		
		// 내 정보
		Panel pProfile = new Panel(null);
		pProfile.setBounds(0, commH+30, inW, commH);
		pProfile.add(myInform);
		pProfile.add(btnEdit);
		
		Image imgEdit = kit.createImage("images\\ico_edit.png");
		Icon iconEdit = new ImageIcon(imgEdit);
		btnEdit.setIcon(iconEdit);
		myInform.setBounds(0, 0, 260, commH);
		btnEdit.setBounds(265, 0, commH, commH);
		btnEdit.setBackground(Color.WHITE);
		
		// 내 친구목록
		Panel pFrList = frList(inW, friendList, btnDel);
		pFrList.setLocation(0, commH*2+30+10);
		btnTalk.setBackground(Color.WHITE);
		btnTalk.setBounds(inW-130, 150+10, 60, commH);
		pFrList.add(btnTalk);
		
		p.add(pSearchBar);
		p.add(pProfile);
		p.add(pFrList);
		
		return p;
	}
	
	// #UI 시스템 패널
	public Panel systemPanel(int w, int h, Label label) {
		Color bg = new Color(250, 250, 250);	// background
		Color bdt = new Color(200, 200, 200);	// border-top
		
		Panel p = new Panel(null);
		p.setBounds(8, h-inTopY-8, w-16, inTopY);
		
		Label sysLine = new Label();
		sysLine.setBounds(0, 0, w, 1);
		sysLine.setBackground(bdt);
		label.setBounds(0, 1, w, inTopY-1);
		label.setBackground(bg);
		
		p.add(sysLine);
		p.add(label);
		
		return p;
	}
	
	// #UI 친구검색 다이얼로그
	public Dialog searchUi() {
		final Dialog d = new Dialog(frame, true);
		int dW = 400;		// frameWidth
		int dH = 400;		// frameHeight
		int inW = 300;				// innerWidth
		int inCenX = (dW-inW)/2;	// innerCenter X (가운데 정렬)
		
		d.setTitle("친구 찾기");
		d.setLayout(null);
		
		Panel p = new Panel(null);
		p.setBounds(inCenX, (dW-300)/2, inW, 300);
		
		Panel pSearchBar = searchBar(inW, tfSearch, btnSearch);
		Panel pSearchList = frList(inW, searchList, btnAdd);
		pSearchList.setLocation(0, commH+10);
		btnAdd.setBounds(inW-90, 150+10, 90, commH);
		
		tfSearch.addFocusListener(new FocusAdapter() {
			JTextField tf = tfSearch;
			public void focusGained(FocusEvent e) {
				tf.setText(" ");
				tf.setText("");
			}
		});
		
		p.add(pSearchBar);
		p.add(pSearchList);
		
		d.add(p);
		d.add(systemPanel(dW, dH, sysMsgSearch));
		
		d.setBackground(Color.WHITE);
		d.setBounds(dim.width-dW, 0, dW, dH);
		
		// 가입 창 닫기
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				d.dispose();
			}
		});
		
		return d;
	}
	public MainUI(final Member mb) {
		this.mb = mb;
		os = mb.getOsCli();
		
		int fW = 500;		// frameWidth
		int fH = 400;		// frameHeight
		
		setTitle("메신저");
		setLayout(null);
		
		searchUi = searchUi();
		add(mainPanel(fW, fH));
		add(systemPanel(fW, fH, sysMsg));
		
		setBounds(dim.width-fW, 0, fW, fH);
		setVisible(true);
		
		// "내 친구목록" 리스트
		friendList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//채팅방 신설 요청!
				String msg = Member.CHAT_CR+"|"+mb.getId();
				submit(msg);
				System.out.println(msg);

				//채팅창 시작!
				new TalkUI(); 
				
				//sleep time을 준 후 작업을 한다. 
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//채팅방 입장 손님 요청! 
				String msg2 = Member.CHAT_IN;
				String[] list = searchList.getSelectedItems();
				//선택된 경우에만 작업한다.  아닌경우, 본인의 채팅창으로 작동함.
				if (list.length > 0) {
					for (int i=0; i<list.length; i++) {
						int strStart = list[i].indexOf("(");
						int strEnd = list[i].indexOf(")");
						String id = list[i].substring(strStart+1, strEnd);
						msg2 += "|"+id;
					}
					submit(msg2);
				}
				System.out.println(msg2);
			}
		});
		// "대화" 버튼
		btnTalk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TalkUI();
			}
		});
		
		// "내친구 검색" 버튼
		btnMySearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String input = tfMySearch.getText();
				if (input.equals("") || input.equals("친구 검색")) {
					sysMsg.setText("검색 정보를 입력해주세요. (아이디, 이름, 휴대폰번호 등)");
				} else {
					findMyFriend(input);
				}
			}
		});
		
		// "새친구 검색" 플러스버튼 (새창)
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchUi.setVisible(true);
			}
		});
		
		// "새 친구검색" 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = tfSearch.getText();
				if (input.equals("") || input.equals("친구 검색")) {
					sysMsgSearch.setText("검색 정보를 입력해주세요. (아이디, 이름, 휴대폰번호 등)");
				} else {
					submit(Member.SEARCH+"|"+input);
				}
			}
		});
		
		// "친구 추가" 버튼
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				friendAdd();
			}
		});
		// "새친구 검색목록" 리스트
		friendList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				friendAdd();
			}
		});
		
		// 창 닫기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	public void submit(String msg){
		msg += "\n";
		try {
			os.write(msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		MainUI frame = new MainUI();
//	}
	
	// #친구추가
	public void friendAdd() {
		String msg = Member.FR_ADD+"|"+mb.getId();
		String[] list = searchList.getSelectedItems();
		if (list.length == 0) {
			sysMsgSearch.setText("친구로 등록할 회원을 선택해주세요.");
		} else {
			for (int i=0; i<list.length; i++) {
				int strStart = list[i].indexOf("(");
				int strEnd = list[i].indexOf(")");
				String id = list[i].substring(strStart+1, strEnd);
				msg += "|"+id;
			}
			submit(msg);
		}
		System.out.println(msg);
	}
	
	// #내친구검색
	public void findMyFriend(String input) {
		String frItem = "";
		ArrayList<Member> frList = mb.getFrList();
		
		for (int i=0; i<frList.size(); i++) {
			Member fr = frList.get(i);
			if (input.equals(fr.getId()) ||
					input.equals(fr.getName()) ||
					input.equals(fr.getPhone())) {
				frItem = fr.getName()+" ("+fr.getId()+")";
				System.out.println(frItem);
				break;
			}
		}
		String[] list = friendList.getItems();
		int idx = -1;
		for (int i=0; i<list.length; i++) {
			if (list[i].equals(frItem)) {
				idx = i;
			}
		}
		if (idx == -1) {
			sysMsg.setText("등록된 친구 정보와 일치하는 회원이 없습니다.");
		} else {
			int selected = friendList.getSelectedIndex();
			friendList.deselect(selected);
			friendList.select(idx);
			sysMsg.setText("");
		}
		
	}
	public void logout() {}
	public void findFriend() {}
	public void chatCreate() {}
}
