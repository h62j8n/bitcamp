package com.bit.messenger.v081;

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
	JScrollPane scrollTa = new JScrollPane(taSysMsg);
	//접속자 리스트 관리
	static ArrayList<Socket> List = new ArrayList<Socket>(); 
	//멤버 리스트 관리
	static ArrayList<Member> mbList = new ArrayList<Member>();
	//채팅방 리스트 관리
	static ArrayList<ChatRoom> chatList = new ArrayList<ChatRoom>();

	OutputStream os = null;
	PrintStream ps=null;
	
	int lastChatRoomNumber=0;
	public static ArrayList<Socket> getList(){
		return List;
	}
	
	static String[] btnTxt = {"전체 가입자수","전체 접속자수","오픈 채팅방수","오픈 채팅인원"};
	static Button[] btn=new Button[btnTxt.length];
	static Label[] lbl=new Label[btnTxt.length];
	
	public MsgServer(){
		//접속자 리스트 관리
//		List = new ArrayList<Socket>(); 
		//멤버리스트 관리
//		mbList = new ArrayList<Member>();
		
		
		
		// 테스트계정 생성
		Member mbTest1 =new Member("test1", "1111", "테스트계정1", "000-1111-1111");
		Member mbTest2 =new Member("test2", "2222", "테스트계정2", "000-2222-1111");
		Member mbTest3 =new Member("test3", "3333", "테스트계정3", "000-3333-1111");
		Member mbTest4 =new Member("grant", "1234", "박준서", "000-5555-1111");
		Member mbTest5 =new Member("hyejin", "1234", "조혜진", "000-8888-1111");
		Member mbTest6 =new Member("chohj", "1234", "조혜진", "000-9999-1111");
		Member mbTest7 =new Member("jooj7917", "1234", "한창희", "000-7777-1111");
		mbList.add(mbTest1);
		mbList.add(mbTest2);
		mbList.add(mbTest3);
		mbList.add(mbTest4);
		mbList.add(mbTest5);
		mbList.add(mbTest6);
		mbList.add(mbTest7);
		
		
		ArrayList<Member> frList = new ArrayList<Member>();
		frList.add(mbTest2);
		frList.add(mbTest3);
		mbList.get(0).setFrList(frList);
				
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
//		pNorth.add(taSysMsg,BorderLayout.CENTER);
		pNorth.add(scrollTa,BorderLayout.CENTER);
		
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
		
		for(int i=0; i<btnTxt.length; i++){
			btn[i] = new Button(btnTxt[i]);
			lbl[i] = new Label();
			pLeft.add(btn[i]);
			pRight.add(lbl[i]);
		}

		pSubStatus.add(pLeft);
		pSubStatus.add(pRight);
		
		pStatus.add(lblStatus,BorderLayout.NORTH);
		pStatus.add(pSubStatus,BorderLayout.CENTER);
		
		
		Label lblList = new Label("오픈채팅방 현황");
		String[] header = {"번호", "참여인원", "참여인원 정보"};
		String[][] listContents = {
				{"1", "2", "test1, hyejin"},
				{"2", "3", "grant, chohj, jooj7917"},
				{"3", "3", "grant, hyejin, jooj7917"},
				{"4", "7", "test1, test2, test3, grant, hyejin, jooj7917"},
				{"5", "1", "grant"},
				{"6", "2", "hyejin, chohj"}
		};
		
		JTable table = new JTable(listContents, header);
		JScrollPane scroll = new JScrollPane(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(345);
		
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
//				Thread thr1=new Thread(new Runnable(){
//					public void run(){
//						SvrStart();
//					}
//				});
				Thread thread = new Thread(svr);
				thread.start();
				detailedAction();
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
				detailedAction();
			}
		});
		
		// 전체 가입자수
		btn[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailedAction(0);
			}
		});
		// 전체 접속자수
		btn[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailedAction(1);
			}
		});
		// 오픈 채팅방수
		btn[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailedAction(2);
			}
		});
	}
	
	public static void detailedAction(int i) {
		int count = -1;
		switch (i) {
			case 0:
				count = mbList.size();
				break;
			case 1:
				count = List.size();
				break;
			case 2:
				count = chatList.size();
				break;
		}
		lbl[i].setText(String.format("%02d", count));
	}
	public static void detailedAction() {
		int count = 0;
		for (int i=0; i<btnTxt.length; i++) {
			switch (i) {
				case 0:
					count = mbList.size();
					break;
				case 1:
					count = List.size();
					break;
				case 2:
					count = chatList.size();
					break;
			}
			lbl[i].setText(String.format("%02d", count));
		}
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
				detailedAction(1);
				
				// socket에 대한 inputStream 생성 -> 최종 BufferedReader
				InputStream is=null;
				InputStreamReader isr=null;
				BufferedReader br=null;	
 				
				is=sock.getInputStream();
				isr=new InputStreamReader(is);
				br =new BufferedReader(isr);

				// socket에 대한 outputStream 생성 -> 최종 PrintStream
				OutputStream os = null;
				PrintStream ps=null;
				os=sock.getOutputStream();
				ps=new PrintStream(os);
				
				//가상의 멤버로 일단 등록해서 Thread로 넘겨주자!
				Member mb = new Member();
				mb.setPs(ps);
				mb.setBr(br);
				Thread thrCli = new Thread(new SvrThread(mb, taSysMsg, mbList, List, chatList, lastChatRoomNumber));
				thrCli.start();
				
			}// while socket 접속 받는 부분
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//쓰레드 연결되어 각 기능별로 분기를 하자!
	public void run() {
		SvrStart(); //소켓통신 가동 시킴!
	}//end of run()
	

	public void sysMsg(String msg){
//		taSysMsg.setText(taSysMsg.getText()+msg+"\n");
		taSysMsg.append(msg+"\n");
		scrollTa.getVerticalScrollBar().setValue(scrollTa.getVerticalScrollBar().getMaximum());
	}// end of sysMsg()
	
	
}//end of class MsgServer
