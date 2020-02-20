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
	String ip="192.168.1.29"; //67:���ؼ� 29:������
	int port = 5000;
	
	// UI ��������
	Frame frame = this;
	Dialog signUi;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension dim = kit.getScreenSize();
	int fW = 500;				// frameWidth
	int fH = 600;				// frameHeight
	int inTopY = 31;			// innerTop Y (����ǥ���� ����)
	int commH = 35;				// commonHeight (������Ʈ �⺻ ����)
	
	// ���� �޼����� �޴� ��
	Label sysMsg = new Label();			// �α��� â
	Label sysMsgSignIn = new Label();	// ȸ������ â
	
	// �α��� �ʵ�
	JTextField[] tfLogins = {
			new JTextField("ID �Է�"),			//	ID �Է�
			new JPasswordField("��й�ȣ �Է�")	// ��й�ȣ �Է�
	};
	JButton btnLogin = new JButton("�α���");
	JButton btnSignin = new JButton("ȸ�� ����");
	
	// ȸ������ �ʵ�
	String[] subject = {"���̵�", "��й�ȣ", "��й�ȣ Ȯ��", "�̸�", "��ȭ��ȣ"};
	JTextField[] tfSigns = {
			new JTextField(),		// ���̵�
			new JPasswordField(),	// ��й�ȣ
			new JPasswordField(),	// ��й�ȣ Ȯ��
			new JTextField(),		// �̸�
			new JTextField()		// ��ȭ��ȣ
	};
	JButton btnIdDup = new JButton("�ߺ�Ȯ��");
	JButton btnSubmit = new JButton("����ϱ�");
	// UI �������� ��
	
	
	
	OutputStream os = null;	
	Socket sock = null;
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader br = null;

	StringTokenizer token;
	
	// #UI �α��� �г�
	public Panel loginPanel() {
		int inW = 300;				// innerWidth
		int intCenX = (fW-inW)/2;	// innerCenter X (��� ����)
		
		Panel p = new Panel(null);
		p.setBounds(intCenX, inTopY, inW, 495);
		
		// �ΰ�
		Panel pLogo = new Panel(new BorderLayout());
		pLogo.setBounds(0, 0, inW, 300);
		Image img = kit.createImage("images\\ico_logo.png");
		Icon icon = new ImageIcon(img);
		JLabel logoImg = new JLabel(icon);
		pLogo.add(logoImg, BorderLayout.CENTER);
		
		// ���̵�/��й�ȣ �Է� �� �α��ι�ư
		Panel pLogin = new Panel(null);
		pLogin.setBounds(0, 300, inW, 140);
		
		tfLogins[0].setBounds(0, 0, inW, commH);
		tfLogins[1].setBounds(0, commH+10, inW, commH);
		
		btnLogin.setBounds(0, commH*2+30, inW, commH+5);
		btnLogin.setBackground(Color.white);
		
		tfLogins[0].addFocusListener(new FocusAdapter() {
			JTextField tf = tfLogins[0];
			public void focusGained(FocusEvent e) {
				if (tf.getText().equals("ID �Է�")) {
					tf.setText(" ");
					tf.setText("");
				}
			}
		});
		tfLogins[1].addFocusListener(new FocusAdapter() {
			JTextField tf = tfLogins[1];
			public void focusGained(FocusEvent e) {
				if (tf.getText().equals("��й�ȣ �Է�")) {
					tf.setText(" ");
					tf.setText("");
				}
			}
		});
		pLogin.add(tfLogins[0]);
		pLogin.add(tfLogins[1]);
		pLogin.add(btnLogin);
		
		// ȸ������ ��ư
		btnSignin.setBackground(Color.white);
		btnSignin.setBorderPainted(false);
		btnSignin.setBounds(0, 440+20, inW, commH);
		
		p.add(pLogo);
		p.add(pLogin);
		p.add(btnSignin);
		
		return p;
	}
	
	// #UI ȸ������ ���̾�α�
	public Dialog setSignUi() {
		final Dialog d = new Dialog(frame, true);
		int dW = 600;				// dialogWidth
		int dH = 400;				// dialogHeight
		int inW = 400;				// innerWidth
		int intCenX = (dW-inW)/2;	// innerCenter X (��� ����)
		
		d.setLayout(null);
		
		Panel pRegister = new Panel(null);
		pRegister.setBounds(intCenX-15, inTopY+35, inW, 261);
		Panel[] panels = new Panel[subject.length];
		Label[] labels = new Label[subject.length];
		
		// ���� �Է���
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
		
		// ���� â �ݱ�
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				d.dispose();
			}
		});
		
		return d;
	}
	
	// #UI �ý��� �г�
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
		
		// "�α���" ��ư
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = Member.LOGIN;
				for (int i=0; i<tfLogins.length; i++) {
					msg += "|"+tfLogins[i].getText();
				}
				if (msg.contains("||") || msg.endsWith("|")) {
					// �� �Է¶��� ���� ��� ������ ����
					sysMsg.setText("���̵�� ��й�ȣ�� ��Ȯ�� �Է����ּ���.");
				} else {
					submit(msg);
				}
			}
		});
		
		// "ȸ������" ��ư
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUi.setVisible(true);
			}
		});
		
		// ȸ������-�ߺ�Ȯ��
		tfSigns[0].addFocusListener(new FocusAdapter() {
			JTextField tf = tfSigns[0];
			String existText, newText;
			public void focusGained(FocusEvent e) {
				existText = tf.getText();
			}
			public void focusLost(FocusEvent e) {
				newText = tf.getText();
				if (!btnIdDup.isEnabled() && !existText.equals(newText)) {
					// �ߺ�Ȯ�� �� ���̵� �Է°��� �ٲ���ٸ�
					btnIdDup.setEnabled(true);
					btnIdDup.setText("�ߺ�Ȯ��");
					
				}
			}
		});
		btnIdDup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg;
				if (tfSigns[0].getText().equals("")) {
					sysMsgSignIn.setText("���̵� �Է����ּ���.");
				} else {
					msg = Member.ID_DUP + "|" + tfSigns[0].getText();
					submit(msg);
				}
			}
		});
		
		// ȸ������-"����ϱ�" ��ư
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInCheck();
			}
		});
		
		// â�ݱ� ��ư
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
		token = new StringTokenizer(msg, "|"); // ��ū ����
		String job = token.nextToken(); // ��ū�� ��Ʈ������ �и�
		System.out.println("msgParsing - Ŭ���̾�Ʈ�� ���� ������ : " + msg);
		boolean ret=false;
		switch (job) {
			case Member.ID_DUP: //���̵� �ߺ�Ȯ��
				idCheckResult();
				break;
			case Member.SIGNIN: //ȸ������
				signInResult();
				break;
			case Member.LOGIN: // #�α���
				loginResult();
				break;
		}
	}
	
	// #ȸ������ üũ (Ŭ���̾�Ʈ)
	public boolean signInCheck() {
		String msg = Member.SIGNIN;
		
		for(int i=0; i< tfSigns.length; i++){
			String tfs = tfSigns[i].getText();
			String pw = tfSigns[1].getText();
			String pwConfirm = tfSigns[2].getText();
			
			System.out.println(btnIdDup.isEnabled());
			
			// ��� �Է��ߴ��� üũ
			if (tfs.equals("")) {
				sysMsgSignIn.setText("�Է¶��� ��� �ۼ����ּ���.");
				return false;
			}
			// �ߺ�Ȯ�� ���� üũ
			if (btnIdDup.isEnabled()) {
				sysMsgSignIn.setText("����Ͻ� ID�� �ߺ�Ȯ���� �������ּ���.");
				return false;
			}
			// ��й�ȣ/��й�ȣȮ�� �� üũ
			if (pw.equals(pwConfirm) == false) {
				sysMsgSignIn.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				return false;
			}
			
			msg += "|"+tfSigns[i].getText();
		}
		
		submit(msg);
		return true;
	}
	
	// #ȸ������ #�ߺ�Ȯ�� ��� (���� ����)
	public void idCheckResult() {
		String result = token.nextToken();
		
		if (result.equals(Member.OK)) {
			sysMsgSignIn.setText(Member.MID00);
			btnIdDup.setText("��� ����");
			btnIdDup.setEnabled(false);
		} else {
			sysMsgSignIn.setText(Member.MID01);
		}
	}
	// #ȸ������ ��� (���� ����)
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
	
	// #�α��� ��� (���� ����)
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
