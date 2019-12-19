package com.bit.messenger.v04;

import java.util.ArrayList;

public class ChatRoom {
	private int roonNum;
	private ArrayList<Member> roomMemberList; //채팅방 대화자 리스트
	private Member maker; //최초 채팅방 개설자
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
