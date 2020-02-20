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
	Socket sock; //Static ���̸� �ȵ�.
	TextArea taSysMsg = new TextArea();
	//������ ����Ʈ ����
	static ArrayList<Socket> List = new ArrayList<Socket>(); 
	//�������Ʈ ����
	private ArrayList<Member> mbList = new ArrayList<Member>();
	
	OutputStream os = null;
	PrintStream ps=null;
	
	public MsgServer(){
		// �׽�Ʈ���� ����
		mbList.add(new Member("test1", "1111", "�׽�Ʈ����1"));
		mbList.add(new Member("test2", "!@qw", "�׽�Ʈ����2"));
		mbList.add(new Member("test3", "abdc", "�׽�Ʈ����3"));
		
		this.setTitle("�޽��� ���� ������ ȭ��");
		setLayout(new BorderLayout());
		Panel pNorth = new Panel();
		Panel pCenter = new Panel();
		
		pNorth.setLayout(new BorderLayout());
		Panel pNorthSub = new Panel();
		String[] ActBtnTxt = {"���� ����","���� ����","�޽��� Ŭ����","��ü ��Ȳ����"};
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
		Label lblStatus = new Label("���� ������Ȳ");
		Panel pLeft = new Panel();
		Panel pRight = new Panel();
		pLeft.setLayout(new GridLayout(5,1));
		pRight.setLayout(new GridLayout(5,1));
		String[] btnTxt = {"��ü �����ڼ�","��ü �����ڼ�","���� ä�ù��","���� ä���ο�","���� �����ڼ�"};
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
		
		
		Label lblList = new Label("����ä�� ������ ��Ȳ");
		//List list = new List(5);
		
		String[] header = {"ID","����","����","��ȭ��ȣ","IP","���ӽð�"};
		String[][] listContents ={
				{"grant","���ؼ�","��","01054318155","198.168.1.67","2019.11.20 10:03:23"},
				{"king ","������","��","01012345678","198.168.1.37","2019.11.20 11:13:33"},
				{"chang","��â��","��","01088772580","198.168.1.33","2019.11.20 10:00:13"},
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
		// �̺�Ʈ ó�� 
		/////////////////
		// ������ �ݱ� ��ư Ŭ����
		final MsgServer svr = this;
		svr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("svr window addWindowListenr() event occur");
				/**
				 * �ش� io stream close�� ���⼭ ����!   
				 */
				ioAllclose();
				svr.dispose();
			}
		});
		// �������� ��ư Ŭ����
		ActBtn[0].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sysMsg("�������� ��ư Ŭ���ϼ̽��ϴ�.");
				SvrStart();
			}
		});
		// �����ݱ� ��ư Ŭ����
		ActBtn[1].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//io.���� 
				sysMsg("�����ݱ� ��ư Ŭ���ϼ̽��ϴ�.");
				ioAllclose();
			}
		});
		// TextArea Ŭ���� ��ư Ŭ����
		ActBtn[2].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//io.���� 
				taSysMsg.setText(" ");
				taSysMsg.setText("");
			}
		});
		// ��ü��Ȳ ���� ��ư Ŭ����
		ActBtn[3].addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sysMsg("���� ��ư Ŭ���ϼ̽��ϴ�.");
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
			System.out.println("���� ���� �����Ǿ����ϴ�.");
			sysMsg("���� ���� �����Ǿ����ϴ�.");
			while(true){
				Socket sock=serv.accept();
				InetAddress addr = sock.getInetAddress();
				System.out.println(addr.getHostAddress()+"���� �����ϼ̽��ϴ�.");
				sysMsg(addr.getHostAddress()+"���� �����ϼ̽��ϴ�.");
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
	
	//Client���� ȸ�� ������!!!
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
	//run()���� ����Ǵ� ������ �и��ؼ� �̸޼ҵ忡�� ������Ѻ���
	public void runService(){
		InputStream is=null;
		InputStreamReader isr=null;
		BufferedReader br=null;	
		
		sysMsg("������ run() �����մϴ�.");
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
				sysMsg("["+msg+"]�� �� �޾ҽ��ϴ�.");
				//���� �޽��� �ؼ� �� �� ���� �����Ű�� msgParsing���� �б�
				msgParsing(msg);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				sysMsg("�Է� ��Ʈ���� ��� �ݽ��ϴ�.");
				if(br!=null)br.close();
				if(isr!=null)isr.close();
				if(is!=null)is.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}					
		}
	}

	//������ ����Ǿ� �� ��ɺ��� �б⸦ ����!
	public void run() {
		runService();
	}//end of run()
	

	
	public void sysMsg(String msg){
		taSysMsg.setText(taSysMsg.getText()+msg+"\n");
	}// end of sysMsg()
	
	public synchronized void msgParsing(String msg) {
		token = new StringTokenizer(msg, "|"); // ��ū ����
		String job = token.nextToken(); // ��ū�� ��Ʈ������ �и�
		System.out.println("msgParsing - ������ ���� ������ : " + msg);
		sysMsg("msgParsing() msg :"+msg);
		sysMsg("job :"+job);
		boolean ret=false;
		switch (job) {
			case Member.ID_DUP: //���̵� �ߺ�Ȯ��
				ret = idCheck();
				break;
			case Member.SIGNIN: //ȸ������
				ret = member();
				break;
			case Member.LOGIN: // #�α���
				login();
				break;
			case Member.LOGOUT: //�α׾ƿ�
				break;
			case Member.FRIEND: //ģ�� ���
				break;
			case Member.SEARCH: //ģ�� ã��
				break;
			case Member.CHAT: //ä��
				break;
		}//end of switch(job)
	}

	//ȸ������ 
	private boolean idCheck(){
		String id;
		id = token.nextToken();
		//���� ���̵� Ȯ������! 
		for(int i=0; i<mbList.size(); i++){
			if(id.equals(mbList.get(i).getId())==true){
				//���� ���̵� ������.
				String msg=Member.ID_DUP+"|"+"FAIL"+"|"+id;
				sysMsg("�������̵� ������"+msg);
				response(msg);
				return false;
			}
		}
		sysMsg("��� ����Ϸ�");
		String msg=Member.ID_DUP+"|"+Member.OK+"|"+id;
		sysMsg(msg);
		return true;
	}
	
	//ȸ������ 
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
		
		//���� ���̵� Ȯ������! 
		for(int i=0; i<mbList.size(); i++){
			if(id.equals(mbList.get(i).getId())==true){
				//���� ���̵� ������.
				String msg=Member.SIGNIN+"|"+Member.FAIL+"|"+id;
				sysMsg("�������̵� ������"+msg);
				response(msg);
				return false;
			}
		}
		//�н������ �н����� Ȯ�ΰ� ���Ͽ��� üũ����! 
		if(pw.equals(pwConfirm)==false){
			String msg=Member.SIGNIN+"|"+Member.FAIL+"|"+id;
			sysMsg("�н����� Ȯ�ΰ��� ���� Ʋ��"+msg);
			response(msg);
			return false;			
		}
		
		mbList.add(newMb); //member�� ArrayList mbList�� ����.
		
		sysMsg("��� ����Ϸ�");
		
		String msg=Member.SIGNIN+"|"+Member.OK+"|"+id;
		
		sysMsg(msg);
		response(msg);
		
		return true;//ȸ������ ������
	}
	
	// #�α���
	private boolean login() {
		boolean result = false;
		String id, pw;
		id = token.nextToken();
		pw = token.nextToken();
		String name = null;
		
		String msg = Member.LOGIN+"|"+Member.FAIL;		// id/pw üũ�Ͽ� true ��ȯ
		
		// id/pw üũ
		for(int i=0; i < mbList.size(); i++){
			Member mb = mbList.get(i);
			if(id.equals(mb.getId()) == true){			// 1> id�� ����Ʈ�� �ִٸ�
				if (pw.equals(mb.getPw()) == true) {	// 2> pw�� ����Ʈ�� �ִ��� üũ
					result = true;
					name = mb.getName();
					msg = Member.LOGIN+"|"+Member.OK+id+name;	// 3> idüũ, pwüũ�� �����ϸ� true ��ȯ
				}
			}
		}
		
		response(msg);
		return result;
	}
}//end of class MsgServer
