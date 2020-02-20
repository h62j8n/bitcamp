package com.bit.day24;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer3 extends Thread {
	Socket sock;			// 소켓 필드
	
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		File file = new File(".\\www\\index.txt");
		OutputStream os = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		
		try {
			is = sock.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
//			System.out.println(br.readLine());			// 브라우저에서 요청하고 있는 정보를 확인할 수 있다
			String req = br.readLine();
			String[] reqs = req.split(" ");				// reqs = {GET, /main.txt, HTTP/1.1}
			req = reqs[1];								// req = "/main.txt";
			if (req.equals("/")) req = "/index.txt";	// ip만 입력하고 접속했을 경우 인덱스로 이동
			file = new File("www"+req);
			
			fis = new FileInputStream(file);
			os = sock.getOutputStream();
			dos = new DataOutputStream(os);
		
			dos.writeBytes("HTTP/1.1 200 OK \r\n");
			dos.writeBytes("Content-type: text/html; charset=utf-8 \r\n");
			dos.writeBytes("\r\n");
			
			while (true) {
				int num = fis.read();
				if (num == -1) break;
				
				dos.writeByte(num);
			}
			
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
			
			while (true) {
				MyWebServer3 my = new MyWebServer3();
				my.sock = serve.accept();
				my.start();
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
