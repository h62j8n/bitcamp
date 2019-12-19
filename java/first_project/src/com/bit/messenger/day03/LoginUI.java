package com.bit.messenger.day03;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
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
	String ip="192.168.1.29";
	int port = 5000;
	
	// UI
	final Frame frame = this;
	final Dialog dRegister = new Dialog(frame, false);
	
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension dim = kit.getScreenSize();
	
	int uiWidth = 300;				// ���� ������
	int uiLeft = 42;				// ���� ���� ����
	int uiHeight = 35;
	
	Label sysMsg = new Label();		// �����κ��� ���� �޴� ��
	
	OutputStream os=null;	
	Socket sock = null;
	InputStream is=null;
	InputStreamReader isr=null;
	BufferedReader br=null;
	
	Member mb;
	StringTokenizer token;
	
	// ȸ����� �ʵ�
	String[] subject = {"���̵�", "��й�ȣ", "��й�ȣ Ȯ��", "�̸�"};
	Panel[] panels = new Panel[subject.length];
	Label[] labels = new Label[subject.length];
	JTextField[] fields = new JTextField[subject.length];
	
	JButton btnId = new JButton("�ߺ�Ȯ��");
	JButton btnSubmit = new JButton("����ϱ�");
	
	// �߾� �ΰ� ����
	public void setTitle(Panel p) {
		Image img = kit.createImage("images\\ico_logo.png");
		Icon icon = new ImageIcon(img);
		JLabel logo = new JLabel(icon);
		
		logo.setBounds(0, 0, uiWidth, 100);
		p.add(logo);
	}
	
	// ���̵�/��й�ȣ �Է� �� �α��ι�ư ����
	public void setLogin(Panel p) {
		final JTextField tfId = new JTextField("ID �Է�");
		final JTextField tfPw = new JPasswordField("��й�ȣ �Է�");
		JButton btnLogin = new JButton("�α���");
		
		tfId.setBounds(0, 0, uiWidth, uiHeight);
		int idHeight = tfId.getHeight();
		
		tfPw.setBounds(0, idHeight+10, uiWidth, uiHeight);
		
		int pwHeight = tfPw.getHeight();
		btnLogin.setBounds(0, idHeight+pwHeight+10+15, uiWidth, uiHeight+5);
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
		
		// "�α���" ��ư �̺�Ʈ
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = Member.LOGIN;
				msg += "|"+tfId.getText()+"|"+tfPw.getText();
				submit(msg);
			}
		});
		
		p.add(tfId);
		p.add(tfPw);
		p.add(btnLogin);
	}
	
	// ȸ������/���̵�ã�� ��ư ����
	public void setAccount(Panel p) {
		JButton btnJoin = new JButton("ȸ�� ����");
		btnJoin.setBackground(Color.white);
		
		// "ȸ������" ��ư �̺�Ʈ 
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dRegister.setVisible(true);
			}
		});
		
		p.add(btnJoin);
	}
	
	// ȸ������ (�� â)
	public void setRegister(Dialog d) {
		d.setLayout(null);

		btnId.setBackground(Color.white);
		btnSubmit.setBackground(Color.white);
		
		// ���� �Է���
		for (int i=0; i<subject.length; i++) {
			panels[i] = new Panel(null);
			
			labels[i] = new Label(""+subject[i]);
			labels[i].setBounds(0, 0, 80, uiHeight);
			labels[i].setAlignment(Label.RIGHT);
			
			if (i == 1 || i == 2) {
				fields[i] = new JPasswordField();
			} else {
				fields[i] = new JTextField();
			}
			
			fields[i].setBounds(100, 0, 300, uiHeight);
		}
		
		fields[0].setSize(200, uiHeight);
		btnId.setBounds(310, 0, 90, uiHeight-1);
		panels[0].add(btnId);
		
		for (int i=0; i<subject.length; i++) {
			panels[i].setBounds(uiLeft, 31+(uiHeight*i)+(10*i), uiWidth+100, uiHeight);
			panels[i].add(labels[i]);
			panels[i].add(fields[i]);
			
			d.add(panels[i]);
		}
		
		Panel pSubmit = new Panel();
		int pnsLength = panels.length;
		pSubmit.setBounds(uiLeft, 31+(uiHeight*pnsLength)+50, uiWidth+100, uiHeight);
		pSubmit.add(btnSubmit);
		
		d.add(pSubmit);
		d.add(systemPanel(277, 492));
		
		d.setBackground(Color.white);
		d.setBounds(dim.width-500, 0, 500, 310);
		
		// "����ϱ�" ��ư �̺�Ʈ
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("����ϱ� ��ư Ŭ�� (���� ��)");
				String msg = Member.SIGNIN;
				for(int i=0; i< fields.length; i++){
					msg += "|"+fields[i].getText();
				}
				submit(msg);
				System.out.println("����ϱ� ��ư Ŭ�� (���� ��)");
				
				dRegister.dispose();
			}
		});
		
		// ���� â �ݱ�
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dRegister.dispose();
			}
		});
	}
	
	public Panel systemPanel(int y, int w) {
		Panel p = new Panel(null);
		Color sysColor = new Color(250, 250, 250);
		p.setBounds(8, y, w, 30);
		p.setBackground(sysColor);
		
		Label sysLine = new Label();
		sysLine.setBounds(0, 0, w, 1);
		sysLine.setBackground(Color.gray);
		sysMsg.setBounds(0, 1, w, 30);

		p.add(sysLine);
		p.add(sysMsg);
		
		return p;
	}
	
	public LoginUI() {
		setLayout(null);
		
		Panel pLogo = new Panel(null);			// �ΰ�
		Panel pLogin = new Panel(null);			// ID / PW �Է�â
		Panel pAccount = new Panel();			// ȸ������/ID, PW ã��
		
		pLogo.setBounds(uiLeft, 31, uiWidth, 100);
		
		int logoHeight = pLogo.getHeight();
		pLogin.setBounds(uiLeft, 31+logoHeight, uiWidth, 135);
		
		int logHeight = pLogin.getHeight();
		pAccount.setBounds(uiLeft, 31+logoHeight+logHeight+20, uiWidth, uiHeight);
		
		setTitle(pLogo);
		setLogin(pLogin);
		setAccount(pAccount);
		setRegister(dRegister);
		
		add(pLogo);
		add(pLogin);
		add(pAccount);
		add(systemPanel(348, 392));
		
		setBounds(dim.width-400, 0, 400, 380);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		try {
			sock=new Socket(ip,port);
			os=sock.getOutputStream();
			
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			
			while(true){
				String msg=br.readLine();
				msgParsing(msg);
//				sysMsg(msg);
//				tfRecv.setText(msg);
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
				break;
			case Member.SIGNIN: //ȸ������
				break;
			case Member.LOGIN: // #�α���
				login();
				break;
			case Member.LOGOUT: //�α׾ƿ�
				break;
			case Member.FRIEND: // #ģ�� ���
				break;
			case Member.SEARCH: //ģ�� ã��
				break;
			case Member.CHAT: //ä��
				break;
		}
	}
	
	public void login() {
		String result = token.nextToken();
		
		if (result.equals(Member.OK)) {
			sysMsg.setText(Member.MLI00);
			MainUI main = new MainUI();
			frame.dispose();
		} else {
			sysMsg.setText(Member.MLI01);
		}
	}
}
