package com.bit.day22.cs01;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class BitClient {
	public static void main(String[] args) {
		String ip = "192.168.1.29";
		int port = 5000;
		
		Socket sock = null;
		InputStream is = null;
		
		try {
			sock = new Socket(ip, port);			// 나의 ip로 해당 서버(port)에 접속
			is = sock.getInputStream();
			
			while (true) {
				int num = is.read();
				if (num == -1) {break;}
				System.out.write(num);
				System.out.flush();
			}
			
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (is != null) is.close();
				if (sock != null) sock.close();
			} catch (IOException e) {
			}
		}
	}
}
