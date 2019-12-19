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
	// MsgServer�� ���� �޾Ƶ��ͼ� ������� ������ �̾ �͵� ����
	private ArrayList<Socket> List; 
	private ArrayList<Member> mbList;
	Member mb;
	TextArea taSysMsg;
	
	BufferedReader br;  //�Է½�Ʈ�� ����ó��
	PrintStream ps;		//��½�Ʈ�� ����ó�� 
	///////////////////////////////////////////
	StringTokenizer token;
	
	
	
	
	//������
	SvrThread(Member mb, TextArea taSysMsg, ArrayList<Member> mbList, ArrayList<Socket> list){
		this.List = list;
		this.mbList = mbList;
		this.mb = mb;
		this.taSysMsg = taSysMsg;
		br = mb.getBr();
		ps = mb.getPs();
		
		System.out.println("������ ���� "+mb.getBr());
		System.out.println("������ ���� "+mb.getPs());
		System.out.println("taSysMsg"+taSysMsg.getText());
		System.out.println("������ ���� "+mbList.size());
	}

	@Override
	public void run() {
		runService();


	}
	public void runService(){
		br = mb.getBr(); // �Է½�Ʈ���� ��������.		
		sysMsg("svrThread class ������ run() �����մϴ�.");
		try {
			while(true){
				String msg=br.readLine();
				sysMsg("msg >>>"+msg);
				if(msg==null)break;
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
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}					
		}//end of try catch
	}//end of runService()
	
	public void sysMsg(String msg){
		taSysMsg.setText(taSysMsg.getText()+msg+"\n");
	}// end of sysMsg()
	
	//Client���� ȸ�� ������!!!
	public void response(String msg){
		//msg+="\n";
		sysMsg("response() msg:"+msg);
		ps.println(msg);
	}
		
	public synchronized void msgParsing(String msg) {
		token = new StringTokenizer(msg, "|"); // ��ū ����
		String job = token.nextToken(); // ��ū���� �и��� ��Ʈ���� ���ڷ�
		String id, pw, pwConfirm, name, phoneNo, rNum, nick, rName, talk;
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
			case Member.LOGIN: //�α���
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
		
		System.out.println("���� �޼��� "+id+", "+pw);
		String msg = Member.LOGIN+"|"+Member.FAIL;		// id/pw üũ�Ͽ� true ��ȯ
		
		// id/pw üũ
		for(int i=0; i < mbList.size(); i++){
			Member mb = mbList.get(i);
			System.out.println(mb.getId());
			if(id.equals(mb.getId()) == true){			// 1> id�� ����Ʈ�� �ִٸ�
				if (pw.equals(mb.getPw()) == true) {	// 2> pw�� ����Ʈ�� �ִ��� üũ
					result = true;
					name = mb.getName();
					msg = Member.LOGIN+"|"+Member.OK+"|"+id+"|"+name;	// 3> idüũ, pwüũ�� �����ϸ� true ��ȯ
					break;
				}
			}
		}
		
		response(msg);
		return result;
	}
	
	
	
} //end of svrThread class 
