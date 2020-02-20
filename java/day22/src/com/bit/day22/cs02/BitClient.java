package com.bit.day22.cs02;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class BitClient {
	public static void main(String[] args) {
		String ip = "192.168.1.29";
		int port = 5000;
		File file = new File("penguin.png");
		
		Socket sock = null;
		OutputStream os = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		PrintStream ps = null;
		
		Scanner scan = new Scanner(System.in);
		try {
			sock = new Socket(ip, port);
			os = sock.getOutputStream();
			is = sock.getInputStream();
			
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			ps = new PrintStream(os);
			
			while (true) {
				String msg = scan.nextLine();
				if (msg.equals("/q")) break;

//				os.write(msg.getBytes());
				ps.println(msg);				// PrintStream을 사용하여 간편하게 출력할 수 있다.
				msg = br.readLine();
				System.out.println(msg);
			}
			
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		} finally {
			try {
				if (ps != null) ps.close();
				if (isr != null) isr.close();
				if (br != null) br.close();
				if (os != null) os.close();
				if (sock != null) sock.close();
			} catch (IOException e) {
			}
		}
	}
}
