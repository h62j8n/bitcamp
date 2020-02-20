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

			sock = new DatagramSocket();											// ������ �������� ������ �ƴϴ�
			packet = new DatagramPacket(msg.getBytes(), msg.length(), addr, port);	// ������, �󸶳�, ��������, ���� �������� ���� ����
			sock.send(packet);
			
			msg = "12�ڴ����߼�";
			packet = new DatagramPacket(msg.getBytes(), 12, addr, port);
			sock.send(packet);
			
			msg = "���������";
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
