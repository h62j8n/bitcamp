package com.bit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class BitSender {
	public static void main(String[] args) {
		byte[] ip = {(byte)192, (byte)168, 1, 29};
		int port = 5000;
		String msg = "Hello UDP...";
		
		DatagramSocket sock = null;
		DatagramPacket packet = null;
		try {
			InetAddress addr = InetAddress.getByAddress(ip);

			sock = new DatagramSocket();											// 보내는 측이지만 서버는 아니다
			packet = new DatagramPacket(msg.getBytes(), msg.length(), addr, port);	// 무엇을, 얼마나, 누구에게, 어디로 보낼지에 대한 정보
			sock.send(packet);
			
			msg = "12자단위발송";
			packet = new DatagramPacket(msg.getBytes(), 12, addr, port);
			sock.send(packet);
			
			msg = "뭐라고보낼까";
			packet = new DatagramPacket(msg.getBytes(), 12, addr, port);
			sock.send(packet);
			
		} catch (SocketException e) {
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		} finally {
			if (sock != null) sock.close();
		}
	}
}
