package com.bit.messenger.v02;

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
	JScrollPane scrollTa = new JScrollPane(taSysMsg);
	//������ ����Ʈ ����
	ArrayList<Socket> List; 
	//�������Ʈ ����
	ArrayList<Member> mbList;

	OutputStream os = null;
	PrintStream ps=null;
	
	public MsgServer(){
		//������ ����Ʈ ����
		List = new ArrayList<Socket>(); 
		//�������Ʈ ����
		mbList = new ArrayList<Member>();
		
		// �׽�Ʈ���� ����
		Member mbTest1 =new Member("test1", "1111", "�׽�Ʈ����1");
		Member mbTest2 =new Member("test2", "2222", "�׽�Ʈ����2");
		Member mbTest3 =new Member("test3", "3333", "�׽�Ʈ����3");
		mbList.add(mbTest1);
		mbList.add(mbTest2);
		mbList.add(mbTest3);

		ArrayList<Member> frList = new ArrayList<Member>();
		frList.add(mbTest2);
		frList.add(mbTest3);
		mbList.get(0).setFrList(frList);
				
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
//		pNorth.add(taSysMsg,BorderLayout.CENTER);
		pNorth.add(scrollTa,BorderLayout.CENTER);
		
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
//				Thread thr1=new Thread(new Runnable(){
//					public void run(){
//						SvrStart();
//					}
//				});
				Thread thread = new Thread(svr);
				thread.start();
				
				
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
				
				// socket�� ���� inputStream ���� -> ���� BufferedReader
				InputStream is=null;
				InputStreamReader isr=null;
				BufferedReader br=null;	
 				
				is=sock.getInputStream();
				isr=new InputStreamReader(is);
				br =new BufferedReader(isr);

				// socket�� ���� outputStream ���� -> ���� PrintStream
				OutputStream os = null;
				PrintStream ps=null;
				os=sock.getOutputStream();
				ps=new PrintStream(os);
				
				//������ ����� �ϴ� ����ؼ� Thread�� �Ѱ�����!
				Member mb = new Member();
				mb.setPs(ps);
				mb.setBr(br);
				Thread thrCli = new Thread(new SvrThread(mb, taSysMsg, mbList, List));
				thrCli.start();
				
			}// while socket ���� �޴� �κ�
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//������ ����Ǿ� �� ��ɺ��� �б⸦ ����!
	public void run() {
		SvrStart(); //������� ���� ��Ŵ!
	}//end of run()
	

	public void sysMsg(String msg){
		taSysMsg.setText(taSysMsg.getText()+msg+"\n");
		scrollTa.getVerticalScrollBar().setValue(scrollTa.getVerticalScrollBar().getMaximum());
	}// end of sysMsg()
	
	
}//end of class MsgServer
