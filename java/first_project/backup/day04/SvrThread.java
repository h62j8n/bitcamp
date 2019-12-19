package com.bit.messenger.day04;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.bit.messenger.day04.Member;

public class SvrThread implements Runnable{
	/////////////////////////////////////////////////
	// MsgServer로 부터 받아들어와서 쓰레드로 동작을 이어갈 것들 정의
	private ArrayList<Socket> List; 
	private ArrayList<Member> mbList;
	Member mb;
	TextArea taSysMsg;
	
	BufferedReader br;  //입력스트림 최종처리
	PrintStream ps;		//출력스트림 최종처리 
	///////////////////////////////////////////
	StringTokenizer token;
	
	
	
	
	//생성자
	SvrThread(Member mb, TextArea taSysMsg, ArrayList<Member> mbList, ArrayList<Socket> list){
		this.List = list;
		this.mbList = mbList;
		this.mb = mb;
		this.taSysMsg = taSysMsg;
		br = mb.getBr();
		ps = mb.getPs();
		
		System.out.println("스레드 내부 "+mb.getBr());
		System.out.println("스레드 내부 "+mb.getPs());
		System.out.println("taSysMsg"+taSysMsg.getText());
		System.out.println("스레드 내부 "+mbList.size());
	}

	@Override
	public void run() {
		runService();


	}
	public void runService(){
		br = mb.getBr(); // 입력스트림값 가져오자.		
		sysMsg("svrThread class 쓰레드 run() 시작합니다.");
		try {
			while(true){
				String msg=br.readLine();
				sysMsg("msg >>>"+msg);
				if(msg==null)break;
				sysMsg("["+msg+"]를 잘 받았습니다.");
				//받은 메시지 해석 및 각 역할 수행시키는 msgParsing으로 분기
				msgParsing(msg);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				sysMsg("입력 스트림을 모두 닫습니다.");
				if(br!=null)br.close();
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}					
		}//end of try catch
	}//end of runService()
	
	public void sysMsg(String msg){
		taSysMsg.setText(taSysMsg.getText()+msg+"\n");
	}// end of sysMsg()
	
	//Client에게 회신 보내기!!!
	public void response(String msg){
		//msg+="\n";
		sysMsg("response() msg:"+msg);
		ps.println(msg);
	}
		
	public synchronized void msgParsing(String msg) {
		token = new StringTokenizer(msg, "|"); // 토큰 생성
		String job = token.nextToken(); // 토큰으로 분리된 스트링을 숫자로
		String id, pw, pwConfirm, name, phoneNo, rNum, nick, rName, talk;
		System.out.println("msgParsing - 서버가 받은 데이터 : " + msg);
		sysMsg("msgParsing() msg :"+msg);
		sysMsg("job :"+job);
		boolean ret=false;
		switch (job) {
			case Member.ID_DUP: //아이디 중복확인
				ret = idCheck();
				break;
			case Member.SIGNIN: //회원가입
				ret = member();
				break;
			case Member.LOGIN: //로그인
				login();
				break;
			case Member.LOGOUT: //로그아웃
				break;
			case Member.FRIEND: //친구 목록
				break;
			case Member.SEARCH: //친구 찾기
				break;
			case Member.CHAT: //채팅
				break;
		}//end of switch(job)
	}

	//회원가입 
	private boolean idCheck(){
		String id;
		id = token.nextToken();
		//동일 아이디 확인하자! 
		for(int i=0; i<mbList.size(); i++){
			if(id.equals(mbList.get(i).getId())==true){
				//기존 아이디 존재함.
				String msg=Member.ID_DUP+"|"+"FAIL"+"|"+id;
				sysMsg("기존아이디 존재함"+msg);
				response(msg);
				return false;
			}
		}
		sysMsg("멤버 저장완료");
		String msg=Member.ID_DUP+"|"+Member.OK+"|"+id;
		sysMsg(msg);
		return true;
	}
	
	//회원가입 
	private boolean member(){
		String id, pw, pwConfirm, name, phoneNo ;
		id = token.nextToken();
		pw = token.nextToken();
		pwConfirm = token.nextToken();
		name = token.nextToken();
//		phoneNo = token.nextToken();
		
		
		Member newMb = new Member();
		newMb.setId(id);
		newMb.setPw(pw);
		newMb.setName(name);
//		newMb.setPhone(phoneNo);
		
		//동일 아이디 확인하자! 
		for(int i=0; i<mbList.size(); i++){
			if(id.equals(mbList.get(i).getId())==true){
				//기존 아이디 존재함.
				String msg=Member.SIGNIN+"|"+Member.FAIL+"|"+id;
				sysMsg("기존아이디 존재함"+msg);
				response(msg);
				return false;
			}
		}
		//패스워드와 패스워드 확인값 동일여부 체크하자! 
		if(pw.equals(pwConfirm)==false){
			String msg=Member.SIGNIN+"|"+Member.FAIL+"|"+id;
			sysMsg("패스워드 확인값이 서로 틀림"+msg);
			response(msg);
			return false;			
		}
		
		mbList.add(newMb); //member형 ArrayList mbList에 담자.
		
		sysMsg("멤버 저장완료");
		
		String msg=Member.SIGNIN+"|"+Member.OK+"|"+id;
		
		sysMsg(msg);
		response(msg);
		
		return true;//회원가입 성공시
	}
	
	// #로그인
	private boolean login() {
		boolean result = false;
		String id, pw;
		id = token.nextToken();
		pw = token.nextToken();
		String name = null;
		
		System.out.println("받은 메세지 "+id+", "+pw);
		String msg = Member.LOGIN+"|"+Member.FAIL;		// id/pw 체크하여 true 반환
		
		// id/pw 체크
		for(int i=0; i < mbList.size(); i++){
			Member mb = mbList.get(i);
			System.out.println(mb.getId());
			if(id.equals(mb.getId()) == true){			// 1> id가 리스트에 있다면
				if (pw.equals(mb.getPw()) == true) {	// 2> pw도 리스트에 있는지 체크
					result = true;
					name = mb.getName();
					msg = Member.LOGIN+"|"+Member.OK+"|"+id+"|"+name;	// 3> id체크, pw체크가 성공하면 true 반환
					break;
				}
			}
		}
		
		response(msg);
		return result;
	}
	
	
	
} //end of svrThread class 
