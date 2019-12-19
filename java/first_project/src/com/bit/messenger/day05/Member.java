package com.bit.messenger.day05;

import java.io.BufferedReader;
import java.io.PrintStream;

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

	private BufferedReader br; //사용자가 연결된 소켓의 최종 입력스트림 저장
	private PrintStream ps; //사용자가 연결된 소켓의 최종 출력스트림 저 
	
	public Member() {}
	public Member(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public BufferedReader getBr() {
		return br;
	}
	public void setBr(BufferedReader br) {
		this.br = br;
	}
	public PrintStream getPs() {
		return ps;
	}
	public void setPs(PrintStream ps) {
		this.ps = ps;
	}
	
	public static final String LOGIN 	= "LI"; // 로그인
	public static final String LOGOUT 	= "LO"; // 로그아웃
	public static final String SIGNIN 	= "SI"; // 회원가입
	public static final String CHAT 	= "CH"; // 채팅
	public static final String FRIEND 	= "FR"; // 친구목록
	public static final String SEARCH 	= "SR"; // 친구검색
	public static final String ID_DUP 	= "DU"; // ID중복검색
	
	// 작업결과 넣기
	public static final String OK 	= "OK"; // 작업성공
	public static final String FAIL = "FA"; // 작업실패
	
	// 메시지 정의 
	public static final String MSI00 = "회원가입이 완료되었습니다.";
	public static final String MSI01 = "회원가입이 실패하였습니다.";
	public static final String MSI02 = "비밀번호를 정확히 입력해주세요.";
	
	public static final String MID00 = "사용 가능한 아이디입니다.";
	public static final String MID01 = "이미 가입되어 있는 회원입니다.";
	
	public static final String MLI00 = "정상적으로 로그인 되었습니다.";
	public static final String MLI01 = "로그인이 실패했습니다. 아이디 또는 비밀번호를 다시 확인해주세요.";
	
	
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
