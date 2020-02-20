package com.bit.messenger.v06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class ChatUI extends Frame {
	private Member mb;
	private ChatRoom chat;
	
	// UI ��������
	Frame frame = this;
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension dim = kit.getScreenSize();
	int inTopY = 31;			// innerTop Y (����ǥ���� ����)
	int commH = 35;				// commonHeight (������Ʈ �⺻ ����)
	// UI �������� ��
	
	public JTextArea ta1;	// �Է¹��� �޼��� ��µǴ� â
	public JTextField ta2;	// �޼��� �Է�â
	public JButton btn2;	// �������� ��ư
	public JButton btn3;	// ������ ��ư
	
	// #UI �޼����г�
	public Panel ChatPanel(int fW, int fH) {
		int inW = fW-16-20;
		
		Panel p = new Panel(null);
		p.setBounds(18, (fH-245)/2, inW, 245);
		
		ta1=new JTextArea();
		ta1.setEditable(false);
		JPanel pScreen = new JPanel(new BorderLayout());
		JScrollPane ta1Scr = new JScrollPane(ta1);
		ta1Scr.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		pScreen.setBounds(0, 0, inW, 200);
		pScreen.add(ta1Scr, BorderLayout.CENTER);
		
		ta2 = new JTextField();
		ta2.setBounds(commH+10, 0, 230, commH);
		Image imgUpload = kit.createImage("images\\ico_upload.png");
		Icon iconUpload = new ImageIcon(imgUpload);
		btn2 = new JButton(iconUpload);
		btn3=new JButton("������");
		btn2.setBackground(Color.WHITE);
		btn3.setBackground(Color.WHITE);
		btn2.setBounds(0, 0, commH, commH);
		btn3.setBounds(inW-80, 0, 80, commH);
		Panel pTools = new Panel(null);
		pTools.setBounds(0, 200+10, inW, commH);
		pTools.add(ta2);
		pTools.add(btn2);
		pTools.add(btn3);
		
		p.add(pScreen);
		p.add(pTools);
		
		return p;
	}
//	public ChatUI(Member mb, ChatRoom chat) {
	public ChatUI() {
		this.mb = mb;
		this.chat = chat;
		
		int fW = 400;		// frameWidth
		int fH = 320;		// frameHeight
		
		setTitle("��ȭ");
		setLayout(null);
		add(ChatPanel(fW, fH));
		setBounds(500, 250, fW, fH);
		setVisible(true);
		
		// "��������" ��ư
		btn2.addActionListener(new ActionListener() {
			String title = btn2.getText();
			public void actionPerformed(ActionEvent e) {
				FileDialog fdl = new FileDialog(frame, title, FileDialog.LOAD);
				fdl.setVisible(true);
			}
		});
		// â �ݱ�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	public static void main(String[] args) {
		new ChatUI();
	}
}
