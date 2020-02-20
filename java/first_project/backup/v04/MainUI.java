package com.bit.messenger.v04;

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
	
	
	// UI ��������
	Frame frame = this;
	Dialog searchUi;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension dim = kit.getScreenSize();
	int inTopY = 31;			// innerTop Y (����ǥ���� ����)
	int commH = 35;				// commonHeight (������Ʈ �⺻ ����)
	
	// ���� �޼����� �޴� ��
	Label sysMsg = new Label();			// �α��� â
	Label sysMsgSearch = new Label();	// ģ���˻� â
	
	// ģ���˻� �ʵ�1 (����)
	JTextField tfMySearch = new JTextField("ģ�� �˻�");
	JButton btnMySearch = new JButton();	// ��ģ�� �˻���ư
	JButton btnPlus = new JButton();		// ��ģ��ã�� ��ư (���̾�α�)
	
	// ģ���˻� �ʵ�2 (���̾�α�)
	JTextField tfSearch = new JTextField("ģ�� �˻�");
	JButton btnSearch = new JButton();			// ��ģ�� �˻���ư
	List searchList = new List();				// ģ���˻���� ���
	JButton btnAdd = new JButton("ģ�� �߰�");	// ģ�� �߰� ��ư
	
	// ���� �ʵ�
	Label myInform = new Label();		// �� ����
	JButton btnEdit = new JButton();	// ������ư
	List friendList = new List();		// ģ�����
	JButton btnTalk = new JButton("��ȭ");
	JButton btnDel = new JButton("����");
	
	// #UI �˻��� (����)
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
	
	// #UI ģ����� (����)
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
	
	// #UI �����г�
	public Panel mainPanel(int fW, int fH) {
		int inW = 300;				// innerWidth
		int inCenX = (fW-inW)/2;	// innerCenter X (��� ����)
		
		Panel p = new Panel(null);
		p.setBounds(inCenX, (fH-305)/2, inW, 305);
		
		// ģ�� �˻���
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
		
		// �� ����
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
		
		// �� ģ�����
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
	
	// #UI �ý��� �г�
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
		p.add(sysMsg);
		
		return p;
	}
	
	// #UI ģ���˻� ���̾�α�
	public Dialog searchUi() {
		final Dialog d = new Dialog(frame, true);
		int dW = 400;		// frameWidth
		int dH = 400;		// frameHeight
		int inW = 300;				// innerWidth
		int inCenX = (dW-inW)/2;	// innerCenter X (��� ����)
		
		d.setTitle("ģ�� ã��");
		d.setLayout(null);
		
		Panel p = new Panel(null);
		p.setBounds(inCenX, (dW-300)/2, inW, 300);
		
		Panel pSearchBar = searchBar(inW, tfSearch, btnSearch);
		Panel pSearchList = frList(inW, searchList, btnAdd);
		pSearchList.setLocation(0, commH+10);
		btnAdd.setBounds(inW-90, 150+10, 90, commH);
		
		tfMySearch.addFocusListener(new FocusAdapter() {
			JTextField tf = tfMySearch;
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
		
		// ���� â �ݱ�
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				d.dispose();
			}
		});
		
		return d;
	}
	public MainUI(Member mb) {
		this.mb = mb;
		
		int fW = 500;		// frameWidth
		int fH = 400;		// frameHeight
		
		setTitle("�޽���");
		setLayout(null);
		
		searchUi = searchUi();
		add(mainPanel(fW, fH));
		add(systemPanel(fW, fH, sysMsg));
		
		setBounds(dim.width-fW, 0, fW, fH);
		setVisible(true);
		
		// "ģ���˻�" ��ư
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchUi.setVisible(true);
			}
		});
		// "ģ�����" ����Ʈ
		friendList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TalkUI();
			}
		});
		
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

	public void logout() {}
	public void friendList() {}
	public void findFriend() {}
	public void chatCreate() {}
}
