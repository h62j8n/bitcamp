package com.bit.messenger.v083;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ChatUI extends Frame {
	private Member mb;
	private ChatRoom chat;
	BufferedReader br;
	OutputStream os;
	
	// UI 전역변수
	Frame frame = this;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension dim = kit.getScreenSize();
	int inTopY = 31;			// innerTop Y (제목표시줄 이후)
	int commH = 35;				// commonHeight (컴포넌트 기본 높이)
	// UI 전역변수 끝
	
	
	Label sysMsg = new Label();	// 서버 메세지를 받는 라벨
	public JTextArea ta1;		// 입력받은 메세지 출력되는 창
	public JTextField ta2;		// 메세지 입력창
//	public JButton btn2;		// 파일전송 버튼
	public JButton btn3;		// 보내기 버튼
//	public JButton btnAddChat;	// 대화상대 추가버튼
//	JButton btnExit;			// 나가기 버튼
	List chatMbList = new List();
	
	// #UI 메세지 패널
	public Panel ChatPanel(int fW, int fH) {
		int inW = fW-16-20;
		
		Panel p = new Panel(null);
		p.setBounds(18, fH-245-commH-10, inW, 245);
		
		ta1=new JTextArea();
		ta1.setEditable(false);
		JPanel pScreen = new JPanel(new BorderLayout());
		JScrollPane ta1Scr = new JScrollPane(ta1);
		ta1Scr.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		pScreen.setBounds(0, 0, 320, 200);
		pScreen.add(ta1Scr, BorderLayout.CENTER);
		
		Panel pTools = new Panel(null);
		pTools.setBounds(0, 200+10, 320, commH);
		ta2 = new JTextField();
		ta2.setBounds(0, 0, 275, commH);
		Image imgSend = kit.createImage("images\\ico_send.png");
		Icon iconSend = new ImageIcon(imgSend);
		btn3 = new JButton(iconSend);
		btn3.setBackground(Color.WHITE);
		btn3.setBounds(pTools.getWidth()-commH, 0, commH, commH);
		pTools.add(ta2);
		pTools.add(btn3);
//		Image imgFile = kit.createImage("images\\ico_file.png");
//		Icon iconFile = new ImageIcon(imgFile);
//		btn2 = new JButton(iconFile);
//		btn2.setBackground(Color.WHITE);
//		btn2.setBounds(275+commH+19, 0, commH, commH);
//		Image imgAdd = kit.createImage("images\\ico_add.png");
//		Icon iconAdd = new ImageIcon(imgAdd);
//		btnAddChat = new JButton(iconAdd);
//		btnAddChat.setBackground(Color.WHITE);
//		btnAddChat.setBounds(275+(commH*2)+29, 0, commH, commH);
//		Image imgExit = kit.createImage("images\\ico_exit.png");
//		Icon iconExit = new ImageIcon(imgExit);
//		btnExit = new JButton(iconExit);
//		btnExit.setBackground(Color.WHITE);
//		btnExit.setBounds(275+(commH*3)+39, 0, commH, commH);
//		pTools.add(btn2);
//		pTools.add(btnAddChat);
//		pTools.add(btnExit);
		
		Panel pList = new Panel(null);
		Label listTit = new Label("대화 상대");
		listTit.setAlignment(Label.CENTER);
		chatMbList = new List();
		chatMbList.setMultipleMode(true);
		pList.setBounds(inW-125, 0, 125, p.getHeight());
		listTit.setBounds(0, 5, pList.getWidth(), 20);
		chatMbList.setBounds(0, 25, pList.getWidth(), pList.getHeight()-25);
		pList.add(chatMbList);
		pList.add(listTit);
		
		p.add(pScreen);
		p.add(pTools);
		p.add(pList);
		
		ta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myMassage();
			}
		});
		
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
	
	public ChatUI(Member mb, ChatRoom chat) {
		this.mb = mb;
		this.chat = chat;
		this.os = mb.getOsCli();
		
		int fW = 490;		// frameWidth
		int fH = 325;		// frameHeight
		
		String title = mb.getName()+"("+mb.getId()+")";
		setTitle(title);
		setLayout(null);
		add(ChatPanel(fW, fH));
		add(systemPanel(fW, fH, sysMsg));
		setBounds(500, 250, fW, fH);
		setVisible(true);
		
		///////////////
		// event 처리하자!
		////////////////
		// "보내기" 버튼
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				myMassage();
			}
		});
		// "파일전송" 버튼
//		btn2.addActionListener(new ActionListener() {
//			String title = btn2.getText();
//			public void actionPerformed(ActionEvent e) {
//				FileDialog fdl = new FileDialog(frame, title, FileDialog.LOAD);
//				fdl.setVisible(true);
//			}
//		});
		// 창 닫기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//방퇴장 메시지 알리자
				submitChatOut();
				//화면닫기
				dispose();
			}
		});
	}
//	public static void main(String[] args) {
//		new ChatUI();
//	}
	//채팅방 나가기 액션을 알리자.
	public void submitChatOut(){
		int chatNo = chat.getRoomNum();
		String msg = Member.CHAT_OUT+"|"+chatNo+"|"+mb.getId();
		msg += "\n";
		try {
			os.write(msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void myMassage() {
		String msg = ta2.getText();
		ta2.setText(" ");
		ta2.setText("");
		submit(msg);
	}
	public void submit(String msg){
		int chatNo = chat.getRoomNum();
		msg = mb.getName()+" ("+mb.getId()+") : "+msg;
		String msg2 = Member.CHAT_SYNC+"|"+chatNo+"|"+msg;
		msg2 += "\n";
		try {
			os.write(msg2.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
