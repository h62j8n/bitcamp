package com.bit.messenger.day02;

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
	static ArrayList<Socket> list = new ArrayList<Socket>(); 
	//멤버리스트 관리
	private ArrayList<Member> memberArray = new ArrayList<Member>();

	OutputStream os = null;
	PrintStream ps=null;
	
	public MsgServer(){
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
				list.add(sock);
				

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
		msg+="\n";
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


	//쓰레드 연결되어 각 기능별로 분기를 하자!
	public void run() {
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
				char proc = msg.charAt(0);
				System.out.println(proc);
				os=sock.getOutputStream();
				ps=new PrintStream(os);
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
	}//end of run()
	
	public void sysMsg(String msg){
		taSysMsg.setText(taSysMsg.getText()+msg+"\n");
	}// end of sysMsg()
	
	public synchronized void msgParsing(String msg) {
		token = new StringTokenizer(msg, "|"); // 토큰 생성
		String job = token.nextToken(); // 토큰으로 분리된 스트링을 숫자로
		String id, pw, pwConfirm, name, phoneNo, rNum, nick, rName, talk;
		System.out.println("msgParsing - 서버가 받은 데이터 : " + msg);
		sysMsg("msgParsing() msg :"+msg);
		sysMsg("job :"+job);
		switch (job) {
			case Member.SIGNIN: //회원가입
				boolean ret = member();
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
	private boolean member(){
		String id, pw, pwConfirm, name, phoneNo ;
		id = token.nextToken();
		pw = token.nextToken();
		pwConfirm = token.nextToken();
		name = token.nextToken();
		phoneNo = token.nextToken();
		
		
//		Member newMb = new Member();
//		newMb.setId(id);
//		newMb.setPw(pw);
//		newMb.setName(name);
//		newMb.setPhone(phoneNo);
		
		String msg=Member.SIGNIN+"|"+"OK"+"|"+id;
		sysMsg(msg);
		response(msg);
		
		return true;//회원가입 성공시
	}
	
	private void login() {
		
	}
}//end of class MsgServer
