package com.bit.day24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer2 extends Thread {
	Socket sock;			// ���� �ʵ�
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
			
			while (true) {					// ������ ���� �����
				MyWebServer2 my = new MyWebServer2();
				my.sock = serve.accept();	// �������� ���������� ���Ͽ� ���� (�� ������� ������ ������ ���� ��)
				my.start();					// ������ �����ϸ� ������ ����
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
