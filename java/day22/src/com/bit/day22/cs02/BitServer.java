package com.bit.day22.cs02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BitServer {
	public static void main(String[] args) {
		
		ServerSocket serv = null;
		Socket sock = null;
		InputStream is = null;
		OutputStream os = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		PrintStream ps = null;
		
		try {
			serv = new ServerSocket(5000);
			System.out.println("대기 중...");
			sock = serv.accept();
			InetAddress addr = sock.getInetAddress();
			System.out.println(addr.getHostAddress()+" 접속됨");
			
			is = sock.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			os = sock.getOutputStream();
			ps = new PrintStream(os);
			
			while (true) {
				String msg = br.readLine();
				if (msg == null) break;
				ps.println("> "+msg);					// flush() 없이도 밀어낸다
			}
			System.out.println("종료");
			
		} catch (IOException e) {
		} finally {
			try {
				if (ps != null) ps.close();
				if (isr != null) isr.close();
				if (br != null) br.close();
				if (os != null) os.close();
				if (is != null) is.close();
				if (sock != null) sock.close();
				if (serv != null) serv.close();
			} catch (IOException e) {
			}
		}
	}
}
