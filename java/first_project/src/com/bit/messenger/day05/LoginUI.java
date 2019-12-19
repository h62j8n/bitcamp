package com.bit.messenger.day05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI extends Frame {
	String ip="192.168.1.29"; //67:박준서 29:조혜진
	int port = 5000;
	
	// UI 전역변수
	Frame frame = this;
	Dialog signUi;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension dim = kit.getScreenSize();
	int fW = 500;				// frameWidth
	int fH = 600;				// frameHeight
	int inTopY = 31;			// innerTop Y (제목표시줄 이후)
	int commH = 35;				// commonHeight (컴포넌트 기본 높이)
	
	// 서버 메세지를 받는 라벨
	Label sysMsg = new Label();			// 로그인 창
	Label sysMsgSignIn = new Label();	// 회원가입 창
	
	// 로그인 필드
	JTextField[] tfLogins = {
			new JTextField("ID 입력"),			//	ID 입력
			new JPasswordField("비밀번호 입력")	// 비밀번호 입력
	};
	JButton btnLogin = new JButton("로그인");
	JButton btnSignin = new JButton("회원 가입");
	
	// 회원가입 필드
	String[] subject = {"아이디", "비밀번호", "비밀번호 확인", "이름", "전화번호"};
	JTextField[] tfSigns = {
			new JTextField(),		// 아이디
			new JPasswordField(),	// 비밀번호
			new JPasswordField(),	// 비밀번호 확인
			new JTextField(),		// 이름
			new JTextField()		// 전화번호
	};
	JButton btnIdDup = new JButton("중복확인");
	JButton btnSubmit = new JButton("등록하기");
	// UI 전역변수 끝
	
	
	
	OutputStream os = null;	
	Socket sock = null;
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader br = null;

	StringTokenizer token;
	
	// #UI 로그인 패널
	public Panel loginPanel() {
		int inW = 300;				// innerWidth
		int intCenX = (fW-inW)/2;	// innerCenter X (가운데 정렬)
		
		Panel p = new Panel(null);
		p.setBounds(intCenX, inTopY, inW, 495);
		
		// 로고
		Panel pLogo = new Panel(new BorderLayout());
		pLogo.setBounds(0, 0, inW, 300);
		Image img = kit.createImage("images\\ico_logo.png");
		Icon icon = new ImageIcon(img);
		JLabel logoImg = new JLabel(icon);
		pLogo.add(logoImg, BorderLayout.CENTER);
		
		// 아이디/비밀번호 입력 및 로그인버튼
		Panel pLogin = new Panel(null);
		pLogin.setBounds(0, 300, inW, 140);
		
		tfLogins[0].setBounds(0, 0, inW, commH);
		tfLogins[1].setBounds(0, commH+10, inW, commH);
		
		btnLogin.setBounds(0, commH*2+30, inW, commH+5);
		btnLogin.setBackground(Color.white);
		
		tfLogins[0].addFocusListener(new FocusAdapter() {
			JTextField tf = tfLogins[0];
			public void focusGained(FocusEvent e) {
				if (tf.getText().equals("ID 입력")) {
					tf.setText(" ");
					tf.setText("");
				}
			}
		});
		tfLogins[1].addFocusListener(new FocusAdapter() {
			JTextField tf = tfLogins[1];
			public void focusGained(FocusEvent e) {
				if (tf.getText().equals("비밀번호 입력")) {
					tf.setText(" ");
					tf.setText("");
				}
			}
		});
		pLogin.add(tfLogins[0]);
		pLogin.add(tfLogins[1]);
		pLogin.add(btnLogin);
		
		// 회원가입 버튼
		btnSignin.setBackground(Color.white);
		btnSignin.setBorderPainted(false);
		btnSignin.setBounds(0, 440+20, inW, commH);
		
		p.add(pLogo);
		p.add(pLogin);
		p.add(btnSignin);
		
		return p;
	}
	
	// #UI 회원가입 다이얼로그
	public Dialog setSignUi() {
		final Dialog d = new Dialog(frame, true);
		int dW = 600;				// dialogWidth
		int dH = 400;				// dialogHeight
		int inW = 400;				// innerWidth
		int intCenX = (dW-inW)/2;	// innerCenter X (가운데 정렬)
		
		d.setLayout(null);
		
		Panel pRegister = new Panel(null);
		pRegister.setBounds(intCenX-15, inTopY+35, inW, 261);
		Panel[] panels = new Panel[subject.length];
		Label[] labels = new Label[subject.length];
		
		// 가입 입력폼
		for (int i=0; i<subject.length; i++) {
			panels[i] = new Panel(null);
			labels[i] = new Label(""+subject[i]);
			labels[i].setBounds(0, 0, 80, commH);
			labels[i].setAlignment(Label.RIGHT);
			tfSigns[i].setBounds(100, 0, inW-100, commH);
		}
		
		tfSigns[0].setSize(200, commH);
		btnIdDup.setBounds(inW-90, 0, 90, commH-1);
		panels[0].add(btnIdDup);
		
		for (int i=0; i<subject.length; i++) {
			panels[i].setBounds(0, (commH*i)+(10*i), inW, commH);
			panels[i].add(labels[i]);
			panels[i].add(tfSigns[i]);
			
			pRegister.add(panels[i]);
		}
		
		btnIdDup.setBackground(Color.white);
		btnSubmit.setBackground(Color.white);
		btnSubmit.setBounds(0, inTopY+(commH*4)+50, inW, commH+5);
		pRegister.add (btnSubmit);
		
		Panel systemPanel = new Panel(null);
		systemPanel.setBounds(8, dH-inTopY-8, dW-16, inTopY);
		Color bg = new Color(250, 250, 250);	// background
		Color bdt = new Color(200, 200, 200);	// border-top
		Label sysLine = new Label();
		sysLine.setBounds(0, 0, dW, 1);
		sysLine.setBackground(bdt);
		sysMsgSignIn.setBounds(0, 1, dW, inTopY-1);
		sysMsgSignIn.setBackground(bg);
		systemPanel.add(sysLine);
		systemPanel.add(sysMsgSignIn);
		
		d.add(pRegister);
		d.add(systemPanel);
		
		d.setBackground(Color.white);
		d.setBounds(dim.width-dW, 0, dW, dH);
		
		// 가입 창 닫기
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				d.dispose();
			}
		});
		
		return d;
	}
	
	// #UI 시스템 패널
	public Panel systemPanel() {
		Color bg = new Color(250, 250, 250);	// background
		Color bdt = new Color(200, 200, 200);	// border-top
		
		Panel p = new Panel(null);
		p.setBounds(8, fH-inTopY-8, fW-16, inTopY);
		
		Label sysLine = new Label();
		sysLine.setBounds(0, 0, fW, 1);
		sysLine.setBackground(bdt);
		sysMsg.setBounds(0, 1, fW, inTopY-1);
		sysMsg.setBackground(bg);
		
		p.add(sysLine);
		p.add(sysMsg);
		
		return p;
	}
	
	public LoginUI() {
		setLayout(null);
		signUi = setSignUi();
		
		add(loginPanel());
		add(systemPanel());
		
		setBounds(dim.width-fW, 0, fW, fH);
		setVisible(true);
		
		// "로그인" 버튼
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = Member.LOGIN;
				for (int i=0; i<tfLogins.length; i++) {
					msg += "|"+tfLogins[i].getText();
				}
				if (msg.contains("||") || msg.endsWith("|")) {
					// 빈 입력란이 있을 경우 보내지 않음
					sysMsg.setText("아이디와 비밀번호를 정확히 입력해주세요.");
				} else {
					submit(msg);
				}
			}
		});
		
		// "회원가입" 버튼
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUi.setVisible(true);
			}
		});
		
		// 회원가입-중복확인
		tfSigns[0].addFocusListener(new FocusAdapter() {
			JTextField tf = tfSigns[0];
			String existText, newText;
			public void focusGained(FocusEvent e) {
				existText = tf.getText();
			}
			public void focusLost(FocusEvent e) {
				newText = tf.getText();
				if (!btnIdDup.isEnabled() && !existText.equals(newText)) {
					// 중복확인 후 아이디 입력값이 바뀌었다면
					btnIdDup.setEnabled(true);
					btnIdDup.setText("중복확인");
					
				}
			}
		});
		btnIdDup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg;
				if (tfSigns[0].getText().equals("")) {
					sysMsgSignIn.setText("아이디를 입력해주세요.");
				} else {
					msg = Member.ID_DUP + "|" + tfSigns[0].getText();
					submit(msg);
				}
			}
		});
		
		// 회원가입-"등록하기" 버튼
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInCheck();
			}
		});
		
		// 창닫기 버튼
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		try {
			sock = new Socket(ip,port);
			os = sock.getOutputStream();
			is = sock.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			while(true){
				String msg=br.readLine();
				msgParsing(msg);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new LoginUI();
	}
	
	public void submit(String msg){
		msg += "\n";
		try {
			os.write(msg.getBytes());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void msgParsing(String msg) {
		token = new StringTokenizer(msg, "|"); // 토큰 생성
		String job = token.nextToken(); // 토큰을 스트링으로 분리
		System.out.println("msgParsing - 클라이언트가 받은 데이터 : " + msg);
		boolean ret=false;
		switch (job) {
			case Member.ID_DUP: //아이디 중복확인
				idCheckResult();
				break;
			case Member.SIGNIN: //회원가입
				signInResult();
				break;
			case Member.LOGIN: // #로그인
				loginResult();
				break;
		}
	}
	
	// #회원가입 체크 (클라이언트)
	public boolean signInCheck() {
		String msg = Member.SIGNIN;
		
		for(int i=0; i< tfSigns.length; i++){
			String tfs = tfSigns[i].getText();
			String pw = tfSigns[1].getText();
			String pwConfirm = tfSigns[2].getText();
			
			System.out.println(btnIdDup.isEnabled());
			
			// 모두 입력했는지 체크
			if (tfs.equals("")) {
				sysMsgSignIn.setText("입력란을 모두 작성해주세요.");
				return false;
			}
			// 중복확인 여부 체크
			if (btnIdDup.isEnabled()) {
				sysMsgSignIn.setText("사용하실 ID의 중복확인을 진행해주세요.");
				return false;
			}
			// 비밀번호/비밀번호확인 값 체크
			if (pw.equals(pwConfirm) == false) {
				sysMsgSignIn.setText("비밀번호가 일치하지 않습니다.");
				return false;
			}
			
			msg += "|"+tfSigns[i].getText();
		}
		
		submit(msg);
		return true;
	}
	
	// #회원가입 #중복확인 결과 (서버 응답)
	public void idCheckResult() {
		String result = token.nextToken();
		
		if (result.equals(Member.OK)) {
			sysMsgSignIn.setText(Member.MID00);
			btnIdDup.setText("사용 가능");
			btnIdDup.setEnabled(false);
		} else {
			sysMsgSignIn.setText(Member.MID01);
		}
	}
	// #회원가입 결과 (서버 응답)
	public void signInResult() {
		String result = token.nextToken();
		String caustion = token.nextToken();
		
		if (result.equals(Member.OK)) {
			sysMsg.setText(Member.MSI00);
			sysMsgSignIn.setText(Member.MSI00);
			signUi.dispose();
		} else {
			sysMsgSignIn.setText(Member.MSI01+" "+caustion);
		}
	}
	
	// #로그인 결과 (서버 응답)
	public void loginResult() {
		String result = token.nextToken();
		
		if (result.equals(Member.OK)) {
			sysMsg.setText(Member.MLI00);
			new MainUI();
			frame.setVisible(false);
		} else {
			sysMsg.setText(Member.MLI01);
		}
	}
}
