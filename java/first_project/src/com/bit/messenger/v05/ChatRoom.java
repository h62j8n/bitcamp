package com.bit.messenger.v05;

import java.util.ArrayList;

public class ChatRoom {
	private int roonNum;
	private ArrayList<Member> roomMemberList; //ä�ù� ��ȭ�� ����Ʈ
	private Member maker; //���� ä�ù� ������
	
	//������
	public ChatRoom(){
		roomMemberList = new ArrayList<Member>();
	}
	public int getRoonNum() {
		return roonNum;
	}
	public void setRoonNum(int roonNum) {
		this.roonNum = roonNum;
	}
	public ArrayList<Member> getRoomMemberList() {
		return roomMemberList;
	}
	public void setRoomMemberList(ArrayList<Member> roomMemberList) {
		this.roomMemberList = roomMemberList;
	}
	public Member getMaker() {
		return maker;
	}
	public void setMaker(Member maker) {
		this.maker = maker;
	}

	
	
}
