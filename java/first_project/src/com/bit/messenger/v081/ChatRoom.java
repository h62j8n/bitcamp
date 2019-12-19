package com.bit.messenger.v081;

import java.util.ArrayList;

public class ChatRoom {
	private int roomNum;
	private ArrayList<Member> roomMemberList; //ä�ù� ��ȭ�� ����Ʈ
	private Member maker; //���� ä�ù� ������
	private ChatUI chatUI; //ä�ù� UI 
	//������
	public ChatRoom(){
		roomMemberList = new ArrayList<Member>();
	}
	public int getRoomNum() {
		return roomNum;
	}
	public ChatUI getChatUI() {
		return chatUI;
	}
	public void setChatUI(ChatUI chatUI) {
		this.chatUI = chatUI;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
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
