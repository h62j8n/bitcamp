package com.bit.messenger.v04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TalkUI extends Frame implements ActionListener,WindowListener{

	public TalkUI() {
		BorderLayout blay=new BorderLayout();
		Panel p1=new Panel();
		Panel p2=new Panel();
		Panel p3=new Panel();
		TextArea ta1=new TextArea();
		TextArea ta2=new TextArea();
		JButton btn1=new JButton("��������");
		JButton btn2=new JButton("��������");
		JButton btn3=new JButton("������");
		
		addWindowListener(this); // �޽���â ����
		btn1.addActionListener(this); // ��������
		btn2.addActionListener(this); // ��������
		
		add(ta1,BorderLayout.NORTH); // �Է¹��� �޼��� ��µǴ� â
//		p3.add(ta1);
		p2.add(ta2); // �޼��� �Է�â
		p2.add(btn3); // ������ ��ư
		p1.add(btn1); // �������� ��ư
		p1.add(btn2); // �������� ��ư
		
//		add(p3,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER); // �߰� �޴�����
		add(p1,BorderLayout.SOUTH); // �ϴ� �޴�����
		
		

		ta2.setPreferredSize(new Dimension(300, 60)); // �޼��� �Է�â ũ�� ����
		btn3.setPreferredSize(new Dimension(100, 60)); // ��ưũ�� ����
		
		btn1.setPreferredSize(new Dimension(100, 50)); // �������� ũ�� ����
		btn2.setPreferredSize(new Dimension(100, 50)); // �������� ũ�� ����

		
		setBounds(500,300,430,340);
		setVisible(true);
	}
	
	public static void main(String[] args) {
//		new TalkUI();
		
		

	}

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent e) {
		dispose();
		
	}

	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn1=(JButton)e.getSource();
		String msg=btn1.getLabel();
		if(msg.equals("��������")){
			FileDialog fdl=new FileDialog(this);
			fdl.setVisible(true);						
			
			
		}else if(msg.equals("��������")){
			FileDialog fdl=new FileDialog(this);
			fdl.setVisible(true);
		}
		
		
	}

}
