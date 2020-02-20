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
	
	int uiWidth = 300;				// ���� ������
	int uiLeft = 42;				// ���� ���� ����
	int uiHeight = 35;
	
	// ù ȭ�� ��� �ΰ� ����
	public void setTitle(Panel p) {
		Image img = kit.createImage("images\\ico_logo.png");
		Icon icon = new ImageIcon(img);
		JLabel titleLogo = new JLabel(icon);
		
		p.add(titleLogo);
	}
	
	// ù ȭ�� ���̵�/��й�ȣ �Է� �� �α��� ��ư ����
	public void setLogin(Panel p) {
		p.setLayout(null);
		
		final JTextField tfId = new JTextField("ID �Է�");
		final JTextField tfPw = new JPasswordField("��й�ȣ �Է�");
		JButton btnLogin = new JButton("�α���");
		
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
		
		// "�α���" ��ư �̺�Ʈ
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.next(frame);
			}
		});
		
		p.add(tfId);
		p.add(tfPw);
		p.add(btnLogin);
	}
	
	// ù ȭ�� ȸ������/���̵�ã�� ��ư ����
	public void setAccount(Panel p) {
		JButton btnJoin = new JButton("ȸ�� ����");
		btnJoin.setBackground(Color.white);
		
		// "ȸ������" ��ư �̺�Ʈ 
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dJoin.setVisible(true);
			}
		});
		
		p.add(btnJoin);
	}
	
	// ȸ������ (�� â)
	public void setJoin(Dialog d) {
		final Dialog thisD = d;
		
		String[] subject = {"���̵�", "��й�ȣ", "��й�ȣ Ȯ��", "�̸�"};
		Panel[] panels = new Panel[subject.length];
		Label[] labels = new Label[subject.length];
		JTextField[] fields = new JTextField[subject.length];
		
		JButton btnId = new JButton("�ߺ�Ȯ��");
		JButton btnSubmit = new JButton("����ϱ�");
		btnId.setBackground(Color.white);
		btnSubmit.setBackground(Color.white);
		
		// ���� �Է���
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
		
		// "����ϱ�" ��ư �̺�Ʈ
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisD.dispose();
			}
		});
		
		// ���� â �ݱ�
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				thisD.dispose();
			}
		});
	}
	
	// Ȩ ȭ�� �˻� �� ����
	public void setSearchBar(Panel p) {
		p.setSize(0, uiHeight);
		
		JTextField tfSearch = new JTextField("ģ�� �˻�");
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
	
	// Ȩ ȭ�� ���� ������/ģ����� ����
	public void setMain(Panel pMain) {
		pMain.setLayout(null);
		
		Image img = kit.createImage("images\\ico_gear.png");
		Icon icon = new ImageIcon(img);
		
		Panel pProfile = new Panel(null);
		
		Label myInform = new Label("�����");
		JButton editBtn = new JButton(icon);
		editBtn.setBackground(Color.white);
		
		myInform.setBounds(0, 0, 260, uiHeight);
		editBtn.setBounds(265, 0, uiHeight, uiHeight);
		pProfile.add(myInform);
		pProfile.add(editBtn);
		
		List friendList = new List();
		for (int i=0; i<10; i++) {
			friendList.add("�� ģ��"+(i+1));
		}
		
		pProfile.setBounds(uiLeft, uiLeft/2, uiWidth, uiHeight);
		friendList.setBounds(uiLeft, 60, uiWidth, 100);
		pMain.add(pProfile);
		pMain.add(friendList);
	}
	
	public Home() {
		setLayout(card);
		
		Panel clientHome = new Panel(new BorderLayout());
		Panel pSearch = new Panel();			// ��� �˻���
		Panel pMain = new Panel();				// ���� (ģ�����)
		
		setSearchBar(pSearch);
		setMain(pMain);
		
		clientHome.add(pSearch, BorderLayout.NORTH);
		clientHome.add(pMain, BorderLayout.CENTER);
		
		Panel clientTitle = new Panel(new BorderLayout());
		Panel pLogo = new Panel();					// �ΰ�
		Panel pLogin = new Panel();					// ID / PW �Է�â
		Panel pAccount = new Panel();				// ȸ������/ID, PW ã��
		
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
