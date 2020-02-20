package com.bit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class BitReceiver {
	public static void main(String[] args) {
		
		DatagramSocket sock = null;
		DatagramPacket dgp = null;
		byte[] buf = new byte[12];
		
		try {
			sock = new DatagramSocket(5000);
			dgp = new DatagramPacket(buf, 12);			// 데이터를 받을 버퍼와 받을 갯수
			sock.receive(dgp);							// 받은 정보를 내가 가진 DatagramPacket객체 dgp에 담음
			byte[] data = dgp.getData();
			System.out.println(Arrays.toString(data));
			System.out.println(new String(data));
			
			dgp = new DatagramPacket(buf, 12);
			sock.receive(dgp);
			data = dgp.getData();
			System.out.println(new String(data));
			
			dgp = new DatagramPacket(buf, 12);
			sock.receive(dgp);
			data = dgp.getData();
			System.out.println(new String(data));
			
		} catch (SocketException e) {
		} catch (IOException e) {
		} finally {
			if (sock != null) sock.close();
		}
	}
}
