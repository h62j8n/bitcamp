package com.bit.day22.cs03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BitServer extends Thread {
	Socket sock;											// 쓰레드(BitServer)에게 인스턴스필드 sock을 줌. (클라이언트에 뿌리는 소켓)
	
	public void run() {										// 쓰레드(BitServer)가 가진 run: 소켓을 생성하고 메세지를 받는다
		InputStream is = null;
		OutputStream os = null;
		
		PrintStream ps = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			is = sock.getInputStream();					// 1-1. 소켓으로 받은 것을
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			os = sock.getOutputStream();				// 2-2. 소켓을 통해 내보낸다.
			ps = new PrintStream(os);

			while (true) {
				String msg = br.readLine();				// 1-2. 읽어들인다.
				ps.println(msg);						// 2-1. 읽은 것을 받아서
				if (msg == null) break;
			}
			
		} catch (IOException e) {
		} finally {
			try {
				if (ps != null) ps.close();
				if (os != null) os.close();
				if (br != null) br.close();
				if (isr != null) isr.close();
				if (is != null) is.close();
				if (sock != null) sock.close();
			} catch (IOException e) {
			}
		}
	}
	
	public static void main(String[] args) {
		ServerSocket serve = null;
		
		try {
			serve = new ServerSocket(5000);
			
			while (true) {
				Socket sock = serve.accept();					// 다중연결
				InetAddress addr = sock.getInetAddress();
				System.out.println(addr.getHostAddress()+"님 접속하셨습니다.");
				
				BitServer thr = new BitServer();				// 쓰레드
				thr.sock = sock;							// 필드 sock. 쓰레드의 sock은 이 while문에 정의된 sock이다.
				thr.start();
			}
			
		} catch (IOException e) {
		} finally {
			try {
				if (serve != null) serve.close();
			} catch (IOException e) {
			}
		}
	}
}
