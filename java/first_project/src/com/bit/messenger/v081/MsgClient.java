package com.bit.messenger.v081;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MsgClient extends Frame implements ActionListener{
	TextField tf1;
	TextField tf2;
	TextField tfRecv;
	TextArea ta;
	OutputStream os=null;	
	Socket sock = null;
	InputStream is=null;
	InputStreamReader isr=null;
	BufferedReader br=null;
	
	public MsgClient(){
		setLayout(new GridLayout(5,2));
		Label lbl1=new Label("구분값");
		Label lbl2=new Label("입력값");
		Label lblRecv=new Label("받은값");
		Label lbl3=new Label("시스템메시지");
		Label lbl4=new Label();
		
		tf1=new TextField();
		tf2=new TextField();
		tfRecv=new TextField();
		ta=new TextArea();
		Button btn=new Button("보내기");
		
		add(lbl1);
		add(tf1);
		add(lbl2);
		add(tf2);
		add(lblRecv);
		add(tfRecv);
		add(lbl4);
		add(btn);
		add(lbl3);
		add(ta);
		setBounds(100,100,300,400);
		setVisible(true);
	
		//////////////////////
		// event handling!!!
		//////////////////
		final MsgClient cli = this;

		cli.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				sysMsg("윈도우 닫기를 클릭함...");
				System.out.println("windowsClosing ... ");
				ta.setText("윈도우 닫기 클릭함...");
				sysMsg("소켓을 모두 닫습니다...");
				ioAllClose();
				sysMsg("화면을 닫습니다...");
				cli.dispose();
			}
		});
		
	
		
		
		tf2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		
		
		
		String ip="192.168.1.67";
		int port = 5000;


		try {
			sock=new Socket(ip,port);
			os=sock.getOutputStream();
			
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			
			while(true){
				String msg=br.readLine();
				sysMsg(msg);
				tfRecv.setText(msg);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void ioAllClose(){
		try {
			if(os!=null)os.close();
			if(br!=null)br.close();
			if(isr!=null)isr.close();
			if(is!=null)is.close();
			if(sock!=null)sock.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void submit(){
		String msg=tf1.getText()+tf2.getText()+"\n";
		sysMsg("["+msg+"]를 전송하려고 합니다.");
		try {
			os.write(msg.getBytes());
			sysMsg("["+msg+"]를 bytes stream으로 전송하였습니다.");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MsgClient();
	}

	
	public void sysMsg(String msg){
		ta.setText(ta.getText()+msg+"\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
