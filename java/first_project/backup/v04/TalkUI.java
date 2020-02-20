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
		JButton btn1=new JButton("사진전송");
		JButton btn2=new JButton("파일전송");
		JButton btn3=new JButton("보내기");
		
		addWindowListener(this); // 메신저창 종료
		btn1.addActionListener(this); // 사진전송
		btn2.addActionListener(this); // 파일전송
		
		add(ta1,BorderLayout.NORTH); // 입력받은 메세지 출력되는 창
//		p3.add(ta1);
		p2.add(ta2); // 메세지 입력창
		p2.add(btn3); // 보내기 버튼
		p1.add(btn1); // 사진전송 버튼
		p1.add(btn2); // 파일전송 버튼
		
//		add(p3,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER); // 중간 메뉴생성
		add(p1,BorderLayout.SOUTH); // 하단 메뉴생성
		
		

		ta2.setPreferredSize(new Dimension(300, 60)); // 메세지 입력창 크기 조절
		btn3.setPreferredSize(new Dimension(100, 60)); // 버튼크기 조절
		
		btn1.setPreferredSize(new Dimension(100, 50)); // 사진전송 크기 조절
		btn2.setPreferredSize(new Dimension(100, 50)); // 파일전송 크기 조절

		
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
		if(msg.equals("사진전송")){
			FileDialog fdl=new FileDialog(this);
			fdl.setVisible(true);						
			
			
		}else if(msg.equals("파일전송")){
			FileDialog fdl=new FileDialog(this);
			fdl.setVisible(true);
		}
		
		
	}

}
