package com.bit.day22.cs01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BitSever {
	public static void main(String[] args) {
		ServerSocket serv = null;
		String msg = "Hello My Server";
		
		Socket sock = null;
		OutputStream os = null;
		try {
			serv = new ServerSocket(5000);
			System.out.println("Ŭ���̾�Ʈ ���� ��� ��...");
			sock = serv.accept();								// ���� ��� (scan.nextLine(); ó��.
			
			System.out.println("Ŭ���̾�Ʈ ���ӵ�");
			InetAddress addr = sock.getInetAddress();
			System.out.println(addr.getHostAddress());			// ���� �������� IP ��ȯ
			
			os = sock.getOutputStream();
			os.write(msg.getBytes());
			os.flush();
			System.out.println("���� ����");
			
		} catch (IOException e) {
		} finally {
			try {
				if (os != null) os.close();
				if (sock != null) sock.close();
				if (serv != null) serv.close();
			} catch (IOException e) {
			}
		}
		
		
		
	}
}
