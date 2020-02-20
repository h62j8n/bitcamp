package com.bit.day22.cs04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class BitServer extends Thread {
	Socket sock;										// �����忡�� �ν��Ͻ��ʵ� sock�� ��.
	static ArrayList<Socket> list = new ArrayList<>();				// �������ϰ� ������ �ڷᱸ���� PrintStream�� ��Ƽ� �̾Ƽ� �ٷ� ���.
	
	public void sayAll(String msg) {
		OutputStream os = null;
		PrintStream ps = null;

		for (int i=0; i<list.size(); i++) {
			Socket temp = list.get(i);
			try {
				os = temp.getOutputStream();
				ps = new PrintStream(os);
				ps.println(msg);
				
			} catch (IOException e) {
			} finally {
				try {
					ps.close();
					os.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			is = sock.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			while (true) {
				String msg = br.readLine();
//				ps.println(msg);
				sayAll(msg);
				if (msg == null) break;
			}
			
		} catch (IOException e) {
		} finally {
			try {
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
				Socket sock = serve.accept();					// ���߿���
				InetAddress addr = sock.getInetAddress();
				System.out.println(addr.getHostAddress()+"�� �����ϼ̽��ϴ�.");
				
//				OutputStream os = null;
//				os = sock.getOutputStream();
				
				list.add(sock);
				
				BitServer thr = new BitServer();				// ������
				thr.sock = sock;						// �ʵ� sock. �������� sock�� �� while���� ���ǵ� sock�̴�.
				
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
