package com.bit.day24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer {
	public static void main(String[] args) {
		ServerSocket serve = null;
		Socket sock = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		
//		String msg = "Hello My Web Site";
		String msg = "<h1>Hello My Web Site</h1>";
		
		try {
			serve = new ServerSocket(80);
			sock = serve.accept();
			InetAddress addr = sock.getInetAddress();
			String ip = addr.getHostAddress();
			System.out.println(ip+"�� ���ӵǾ����ϴ�.");
			
			os = sock.getOutputStream();
			dos = new DataOutputStream(os);
//			dos.writeBytes("HTTP/1.1 404 Not Found \r\n");
//			dos.writeBytes("HTTP/1.1 500 Internal Server Error \r\n");
			dos.writeBytes("HTTP/1.1 200 ok \r\n");							// header (HTTP �����ڵ�)
//			dos.writeBytes("Content-type: text/plan; charset=utf-8 \r\n");	// header (������ Ÿ��)
			dos.writeBytes("Content-type: text/html; charset=utf-8 \r\n");
			dos.writeBytes("\r\n");		// header ������ content ������ �����ϴ� ����
			os.write(msg.getBytes());	// content
			os.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) dos.close();
				if (os != null) os.close();
				if (sock != null) sock.close();
				if (serve != null) serve.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
