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
			System.out.println("클라이언트 접속 대기 중...");
			sock = serv.accept();								// 접속 대기 (scan.nextLine(); 처럼.
			
			System.out.println("클라이언트 접속됨");
			InetAddress addr = sock.getInetAddress();
			System.out.println(addr.getHostAddress());			// 서버 접속자의 IP 반환
			
			os = sock.getOutputStream();
			os.write(msg.getBytes());
			os.flush();
			System.out.println("서버 종료");
			
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
