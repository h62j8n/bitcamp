package com.bit.messenger.day02;
/**
 * 
 * @id : 중복체크 기능
 * @pw : 암호화 기능 (추후)
 * @phone: 휴대폰 번호 검증 관리 ( 자릿수 및 중간 특수문자('-') 제거후 관리
 *
 */
public class Member {
	private String id;
	private String pw;
	private String name;
	private String phone;
	
	
	public static final String LOGIN 	= "LI"; // 로그인
	public static final String LOGOUT 	= "LO"; // 로그아웃
	public static final String SIGNIN 	= "SI"; // 회원가입
	public static final String CHAT 	= "CH"; // 채팅
	public static final String FRIEND 	= "FR"; // 친구목록
	public static final String SEARCH 	= "SR"; // 친구검색
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
