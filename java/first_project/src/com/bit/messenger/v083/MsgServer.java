package com.bit.messenger.v083;

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
import javax.swing.table.DefaultTableModel;

public class MsgServer extends Frame implements Runnable {
	Member mb;
	StringTokenizer token;
	
	static DefaultTableModel model;
	static JTable table;
	
	
	ServerSocket serv=null;
	Thread thread = new Thread(this);
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
	
	private static int lastChatRoomNumber=0; //전체 방 번호 관리용
	public static ArrayList<Socket> getList(){
		return List;
	}
	
	static String[] btnTxt = {"전체 가입자수","전체 접속자수","오픈 채팅방수","오픈 채팅인원"};
	static Button[] btn=new Button[btnTxt.length];
	static Label[] lbl=new Label[btnTxt.length];
	
	//현재까지 방번호 리턴
	public static int getLastChatRoomNumber(){
		return lastChatRoomNumber;
	}
	//방번호를 하나 증가시킨후 증가시킨 값 리턴
	public static int setLastChatRoomNumberPlus(){
		return ++lastChatRoomNumber;
	}
	
	public MsgServer(){
		//접속자 리스트 관리
//		List = new ArrayList<Socket>(); 
		//멤버리스트 관리
//		mbList = new ArrayList<Member>();
		
		
		
		// 테스트계정 생성
		Member mbTest1 = new Member("test1", "1111", "테스트계정1", "00011111111");
		Member mbTest2 = new Member("test2", "2222", "테스트계정", "00022221111");
		Member mbTest3 = new Member("test3", "3333", "테스트계정3", "00033331111");
		Member mbTest4 = new Member("grant", "1234", "박준서", "01011112222");
		Member mbTest5 = new Member("hyejin", "1234", "조혜진", "01011113333");
		Member mbTest6 = new Member("chohj", "1234", "조혜진", "00099991111");
		Member mbTest7 = new Member("jooj7917", "1234", "한창희", "01012129876");
		Member mbTest8 = new Member("leejs87", "1111", "이재설", "01000000000");
		Member mbTest9 = new Member("silverline", "1111", "최은선", "01000000000");
		Member mbTest10 = new Member("sungjae1201", "1111", "홍성재", "01000000000");
		Member mbTest11 = new Member("5_0_woo", "1111", "오영우", "01000000000");
		Member mbTest12 = new Member("jini_bae", "1111", "배진희", "01000000000");
		Member mbTest13 = new Member("zzanghyun_", "1111", "윤장현", "01000000000");
		Member mbTest14 = new Member("summerkim12", "1111", "김여름", "01000000000");
		Member mbTest15 = new Member("yull2", "1111", "장유리", "01000000000");
		Member mbTest16 = new Member("atttttack", "1111", "조윤택", "01000000000");
		Member mbTest17 = new Member("jmin9416", "1111", "김정민", "01074108520");
		Member mbTest18 = new Member("88realpark", "1111", "박건형", "01000000000");
		Member mbTest19 = new Member("hoihoi_99", "1111", "유예슬", "01000000000");
		Member mbTest20 = new Member("ericakim", "1111", "안지현", "01000000000");
		mbList.add(mbTest1);
		mbList.add(mbTest2);
		mbList.add(mbTest3);
		mbList.add(mbTest4);
		mbList.add(mbTest5);
		mbList.add(mbTest6);
		mbList.add(mbTest7);
		mbList.add(mbTest8);
		mbList.add(mbTest9);
		mbList.add(mbTest10);
		mbList.add(mbTest11);
		mbList.add(mbTest12);
		mbList.add(mbTest13);
		mbList.add(mbTest14);
		mbList.add(mbTest15);
		mbList.add(mbTest16);
		mbList.add(mbTest17);
		mbList.add(mbTest18);
		mbList.add(mbTest19);
		mbList.add(mbTest20);
		
		
		ArrayList<Member> frList = new ArrayList<Member>();
		ArrayList<Member> frList2 = new ArrayList<Member>();
		frList2.add(mbTest8);
		frList2.add(mbTest9);
		frList2.add(mbTest10);
		frList2.add(mbTest11);
		frList2.add(mbTest12);
		frList2.add(mbTest13);
		frList2.add(mbTest14);
		frList2.add(mbTest15);
		frList2.add(mbTest16);
		frList2.add(mbTest17);
		frList2.add(mbTest18);
		frList2.add(mbTest19);
		frList2.add(mbTest20);
		frList2.add(mbTest5);
		frList2.add(mbTest6);
		frList2.add(mbTest17);
		frList2.add(mbTest4);
		frList2.add(mbTest7);
//		frList.add(mbTest4);
//		frList.add(mbTest7);
//		mbList.get(1).setFrList(frList);
		mbList.get(0).setFrList(frList2);
				
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
		String[][] listContents = new String [0][header.length];
		model = new DefaultTableModel(listContents, header);
		table = new JTable(model);
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
//				Thread thread = new Thread(svr);
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
	      // 오픈 채팅방 인원수
		btn[3].addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	        	detailedAction(3);
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
	         case 3:
	             int cnt = 0;
	             for(int ii=0; ii<chatList.size(); ii++){
	                cnt += chatList.get(ii).getRoomMemberList().size();
	             }
	             count = cnt;
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
		         case 3:
		             int cnt = 0;
		             for(int ii=0; ii<chatList.size(); ii++){
		                cnt += chatList.get(ii).getRoomMemberList().size();
		             }
		             count = cnt;
		             break;
			}
			lbl[i].setText(String.format("%02d", count));
		}
		chatBoardUpdate(); //채팅방 현황을 보여준다. 
	}
	//채팅방 정보를 보여준다.
	public static void chatBoardUpdate(){

		model.setNumRows(0);
		for(int i=0; i<chatList.size(); i++){
			String[] chatBoard = new String[3];
			chatBoard[0] = String.valueOf(chatList.get(i).getRoomNum());
			chatBoard[1] = String.valueOf(chatList.get(i).getRoomMemberList().size());
			String tempStr="";
			for(int j=0; j<chatList.get(i).getRoomMemberList().size();j++){
				Member tempMb = chatList.get(i).getRoomMemberList().get(j);
				if(j!=0) tempStr += ", ";
				tempStr += tempMb.getId()+"("+tempMb.getName()+")";
			}
			chatBoard[2] = tempStr;
			model.addRow(chatBoard);
		}

	}
	public static void main(String[] args) {
		new MsgServer();
		
	}//end of main()

	public void ioAllclose(){
		sysMsg("ioAllclose() :소켓을 닫습니다.");
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
		
		sysMsg("ioAllclose() :소켓통신 쓰레드를 닫습니다.");
		thread.stop();
		
		sysMsg("ioAllclose() :소켓을 닫습니다.");
		try {
			serv.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void SvrStart(){
//		ServerSocket serv=null;
		
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
				mb.setSvrSock(sock); //서버측에서 관리할 멤버의 소켓 값 기억
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
