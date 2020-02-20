package com.bit.messenger.day03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JScrollPane;
import javax.swing.JTable;


public class MsgServer extends Frame implements Runnable {
	Member mb;
	StringTokenizer token;
	
	Thread thr = new Thread(this);
	Socket sock; //Static 붙이면 안됨.
	TextArea taSysMsg = new TextArea();
	//접속자 리스트 관리
	static ArrayList<Socket> List = new ArrayList<Socket>(); 
	//멤버리스트 관리
	private ArrayList<Member> mbList = new ArrayList<Member>();
	
	OutputStream os = null;
	PrintStream ps=null;
	
	public MsgServer(){
		// 테스트계정 생성
		mbList.add(new Member("test1", "1111", "테스트계정1"));
		mbList.add(new Member("test2", "!@qw", "테스트계정2"));
		mbList.add(new Member("test3", "abdc", "테스트계정3"));
		
		this.setTitle("메시저 서버 관리자 화면");
		setLayout(new BorderLayout());
		Panel pNorth = new Panel();
		Panel pCenter = new Panel();
		
		pNorth.setLayout(new BorderLayout());
		Panel pNorthSub = new Panel();
		String[] ActBtnTxt = {"서버 시작","서버 종료","메시지 클리어","전체 현황갱신"};
		Button[] ActBtn = new Button[ActBtnTxt.length];
		for(int i=0; i<ActBtnTxt.length; i++){
			ActBtn[i] = new Button(ActBtnTxt[i]);
			pNorthSub.add(ActBtn[i]);
		}
		
		pNorth.add(pNorthSub,BorderLayout.NORTH);
		taSysMsg.setSize(450, 180);
		pNorth.add(taSysMsg,BorderLayout.CENTER);
		
		pCenter.setLayout(new GridLayout(2,1));
		Panel pStatus = new Panel();
		Panel pList = new Panel();
		
		Panel pSubStatus = new Panel();
		pStatus.setLayout(new BorderLayout());
		
		pSubStatus.setLayout(new GridLayout(1,2));
		Label lblStatus = new Label("서버 종합현황");
		Panel pLeft = new Panel();
		Panel pRight = new Panel();
		pLeft.setLayout(new GridLayout(5,1));
		pRight.setLayout(new GridLayout(5,1));
		String[] btnTxt = {"전체 가입자수","전체 접속자수","오픈 채팅방수","오픈 채팅인원","금일 접속자수"};
		Button[] btn=new Button[btnTxt.length];
		Label[] lbl=new Label[btnTxt.length];
		for(int i=0; i<btnTxt.length; i++){
			btn[i] = new Button(btnTxt[i]);
			pLeft.add(btn[i]);
			lbl[i] = new Label("00");
			pRight.add(lbl[i]);
		}

		pSubStatus.add(pLeft);
		pSubStatus.add(pRight);
		
		pStatus.add(lblStatus,BorderLayout.NORTH);
		pStatus.add(pSubStatus,BorderLayout.CENTER);
		
		
		Label lblList = new Label("오픈채팅 접속자 현황");
		//List list = new List(5);
		
		String[] header = {"ID","성명","성별","전화번호","IP","접속시간"};
		String[][] listContents ={
				{"grant","박준서","남","01054318155","198.168.1.67","2019.11.20 10:03:23"},
				{"king ","조혜진","여","01012345678","198.168.1.37","2019.11.20 11:13:33"},
				{"chang","한창희","남","01088772580","198.168.1.33","2019.11.20 10:00:13"},
		};
		JTable table = new JTable(listContents,header);
		JScrollPane scroll = new JScrollPane(table);
		
		pList.setLayout(new BorderLayout());
		pList.add(lblList,BorderLayout.NORTH);
		pList.add(scroll,BorderLayout.CENTER);
		
		pCenter.add(pStatus);
		pCenter.add(pList);
		
		add(pNorth,BorderLayout.NORTH);
		add(pCenter,BorderLayout.CENTER);
		setBounds(100,100,500,500);
		setVisible(true);
		
		///////////////////
		// 이벤트 처리 
		/////////////////
		// 윈도우 닫기 버튼 클릭시
		final MsgServer svr = this;
		svr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("svr window addWindowListenr() event occur");
				/**
				 * 해당 io stream close를 여기서 하자!   
				 */
				ioAllclose();
				svr.dispose();
			}
		});
		// 서버시작 버튼 클릭시
		ActBtn[0].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sysMsg("서버시작 버튼 클릭하셨습니다.");
				SvrStart();
			}
		});
		// 서버닫기 버튼 클릭시
		ActBtn[1].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//io.닫자 
				sysMsg("서버닫기 버튼 클릭하셨습니다.");
				ioAllclose();
			}
		});
		// TextArea 클리어 버튼 클릭시
		ActBtn[2].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//io.닫자 
				taSysMsg.setText(" ");
				taSysMsg.setText("");
			}
		});
		// 전체현황 갱신 버튼 클릭시
		ActBtn[3].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sysMsg("갱신 버튼 클릭하셨습니다.");
			}
		});

		
		
	}
	public static void main(String[] args) {
		new MsgServer();
		
	}//end of main()

	public void ioAllclose(){
		try {
//			if(br!=null)br.close();
//			if(isr!=null)isr.close();
//			if(is!=null)is.close();
			
			if(ps!=null)ps.close();
			if(os!=null)os.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	
	
	public void SvrStart(){
		ServerSocket serv=null;
		
		try {
			serv=new ServerSocket(5000);
			System.out.println("서버 소켓 생성되었습니다.");
			sysMsg("서버 소켓 생성되었습니다.");
			while(true){
				Socket sock=serv.accept();
				InetAddress addr = sock.getInetAddress();
				System.out.println(addr.getHostAddress()+"님이 접속하셨습니다.");
				sysMsg(addr.getHostAddress()+"님이 접속하셨습니다.");
				List.add(sock);
				

//				MsgServer thr=new MsgServer();
//				thr.currentThread()
				final MsgServer me = this;
				thr=new Thread(me);
				me.sock = sock;
				thr.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Client에게 회신 보내기!!!
	public void response(String msg){
		sysMsg("response() msg:"+msg);
		try {
			os=sock.getOutputStream();
			ps=new PrintStream(os);
			ps.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//run()에서 수행되는 내용을 분리해서 이메소드에서 진행시켜보자
	public void runService(){
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;	
		
		sysMsg("쓰레드 run() 시작합니다.");
		try {
			is=sock.getInputStream();
			isr=new InputStreamReader(is);
			br=new BufferedReader(isr);
			while(true){
				String msg=br.readLine();
				sysMsg("msg >>>"+msg);
				if(msg==null)break;
//				os=sock.getOutputStream();
//				ps=new PrintStream(os);
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
				if(isr!=null)isr.close();
				if(is!=null)is.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}					
		}
	}

	//쓰레드 연결되어 각 기능별로 분기를 하자!
	public void run() {
		runService();
	}//end of run()
	

	
	public void sysMsg(String msg){
		taSysMsg.setText(taSysMsg.getText()+msg+"\n");
	}// end of sysMsg()
	
	public synchronized void msgParsing(String msg) {
		token = new StringTokenizer(msg, "|"); // 토큰 생성
		String job = token.nextToken(); // 토큰을 스트링으로 분리
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
			case Member.LOGIN: // #로그인
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
		
		String msg = Member.LOGIN+"|"+Member.FAIL;		// id/pw 체크하여 true 반환
		
		// id/pw 체크
		for(int i=0; i < mbList.size(); i++){
			Member mb = mbList.get(i);
			if(id.equals(mb.getId()) == true){			// 1> id가 리스트에 있다면
				if (pw.equals(mb.getPw()) == true) {	// 2> pw도 리스트에 있는지 체크
					result = true;
					name = mb.getName();
					msg = Member.LOGIN+"|"+Member.OK+id+name;	// 3> id체크, pw체크가 성공하면 true 반환
				}
			}
		}
		
		response(msg);
		return result;
	}
}//end of class MsgServer
