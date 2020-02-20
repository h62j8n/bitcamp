package com.bit.day24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer2 extends Thread {
	Socket sock;			// 소켓 필드
	static String msg = "<h1>Hello My Web Site</h1>";
	
	public void run() {
		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			os = sock.getOutputStream();
			dos = new DataOutputStream(os);
		
			dos.writeBytes("HTTP/1.1 200 OK \r\n");
			dos.writeBytes("Content-type: text/html; charset=utf-8 \r\n");
			dos.writeBytes("\r\n");
			dos.writeBytes(msg);
			dos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) dos.close();
				if (os != null) os.close();
				if (sock != null) sock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ServerSocket serve = null;
		Socket sock = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		
		try {
			serve = new ServerSocket(80);
			
			while (true) {					// 영원히 접속 대기함
				MyWebServer2 my = new MyWebServer2();
				my.sock = serve.accept();	// 누군가의 접속정보를 소켓에 담음 (각 스레드는 각자의 소켓을 갖게 됨)
				my.start();					// 누군가 접속하면 스레드 생성
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serve != null) serve.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
