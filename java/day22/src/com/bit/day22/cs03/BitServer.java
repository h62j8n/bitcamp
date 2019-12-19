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
	Socket sock;											// ������(BitServer)���� �ν��Ͻ��ʵ� sock�� ��. (Ŭ���̾�Ʈ�� �Ѹ��� ����)
	
	public void run() {										// ������(BitServer)�� ���� run: ������ �����ϰ� �޼����� �޴´�
		InputStream is = null;
		OutputStream os = null;
		
		PrintStream ps = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			is = sock.getInputStream();					// 1-1. �������� ���� ����
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			os = sock.getOutputStream();				// 2-2. ������ ���� ��������.
			ps = new PrintStream(os);

			while (true) {
				String msg = br.readLine();				// 1-2. �о���δ�.
				ps.println(msg);						// 2-1. ���� ���� �޾Ƽ�
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
				Socket sock = serve.accept();					// ���߿���
				InetAddress addr = sock.getInetAddress();
				System.out.println(addr.getHostAddress()+"�� �����ϼ̽��ϴ�.");
				
				BitServer thr = new BitServer();				// ������
				thr.sock = sock;							// �ʵ� sock. �������� sock�� �� while���� ���ǵ� sock�̴�.
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
