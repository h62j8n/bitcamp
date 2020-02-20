package com.bit.messenger.day02;

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

public class HjClient implements ActionListener{
	OutputStream os = null;	
	Socket sock = null;
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	
	public HjClient(){
		String ip = "192.168.1.29";
		int port = 5000;
		
		new LoginUI();
		
		try {
			sock=new Socket(ip,port);
			os=sock.getOutputStream();
			
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			
			while(true){
				String msg=br.readLine();
//				sysMsg(msg);
//				tfRecv.setText(msg);
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
	/*
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
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HjClient();
	}

	/*
	public void sysMsg(String msg){
		ta.setText(ta.getText()+msg+"\n");
	}
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
