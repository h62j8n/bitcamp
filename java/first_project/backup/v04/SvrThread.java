package com.bit.messenger.v04;

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
//				logout();  // Ŭ���̾�Ʈ�� ó���ص� �ɵ�.
				break;
			case Member.FR_LIST: //ģ�� ���
				friendList(); // Ŭ���̾�Ʈ�� ó���ص� �ɵ�.
				break;
			case Member.SEARCH: //ģ�� ã��
				findFriend();
				break;
			case Member.FR_ADD: //ģ�� ���
				findFriend();
				break;
			case Member.CHAT_CR: //ä�÷� �����
				chatCreate();
				break;
		}//end of switch(job)
	}

	// #ȸ������ #�ߺ�Ȯ��
	private boolean idCheck(){
		String id;
		id = token.nextToken();
		//���� ���̵� Ȯ������! 
		for(int i=0; i<mbList.size(); i++){
			if(id.equals(mbList.get(i).getId())==true){
				//���� ���̵� ������.
				String msg = Member.ID_DUP+"|"+Member.FAIL;
				sysMsg("�������̵� ������"+msg);
				response(msg);
				return false;
			}
		}
		
		sysMsg("ID �ߺ�Ȯ�� �Ϸ�");
		String msg = Member.ID_DUP+"|"+Member.OK;
		response(msg);
		return true;
	}
	//ȸ������ 
	private boolean member(){
		String id, pw, pwConfirm, name, phoneNo;
		id = token.nextToken();
		pw = token.nextToken();
		pwConfirm = token.nextToken();
		name = token.nextToken();
		phoneNo = token.nextToken();
		
		Member newMb = new Member();
		newMb.setId(id);
		newMb.setPw(pw);
		newMb.setName(name);
		newMb.setPhone(phoneNo);
		
		//���� ���̵� Ȯ������! 
		for(int i=0; i<mbList.size(); i++){
			if(id.equals(mbList.get(i).getId())==true){
				//���� ���̵� ������.
				String msg=Member.SIGNIN+"|"+Member.FAIL+"|"+Member.MSI02;
				sysMsg("�������̵� ������"+msg);
				response(msg);
				return false;
			}
		}
		//�н������ �н����� Ȯ�ΰ� ���Ͽ��� üũ����! 
		if(pw.equals(pwConfirm)==false){
			String msg=Member.SIGNIN+"|"+Member.FAIL+"|"+Member.MSI02;
			sysMsg("�н����� Ȯ�ΰ��� ���� Ʋ��"+msg);
			response(msg);
			return false;			
		}
		
		mbList.add(newMb); //member�� ArrayList mbList�� ����.
		sysMsg("��� ����Ϸ�");
		
		String msg=Member.SIGNIN+"|"+Member.OK+"|"+Member.MSI00;
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
		
		System.out.println("���� �޼��� "+id+", "+pw);
		String msg = Member.LOGIN+"|"+Member.FAIL;		// id/pw üũ�Ͽ� true ��ȯ
		
		// id/pw üũ
		for(int i=0; i < mbList.size(); i++){
			Member mb = mbList.get(i);
			if(id.equals(mb.getId()) == true){			// 1> id�� ����Ʈ�� �ִٸ�
				if (pw.equals(mb.getPw()) == true) {	// 2> pw�� ����Ʈ�� �ִ��� üũ
					result = true;
					msg = Member.LOGIN+"|"+Member.OK+"|"+mb.getId()+"|"+mb.getName();	// 3> idüũ, pwüũ�� �����ϸ� true ��ȯ
					break;
				}
			}
		}
		
		response(msg);
		return result;
	}
	
	
	
	// #ģ��ã��
	// ����: id �Ǵ� ��ȭ��ȣ �Ǵ� �̸� ���� �˻�
	// input : search �ʵ� �ϳ��� �ʿ�
	// output: JOB|RESULT|ã�������|���̵�|����|��ȭ��ȣ)
	private boolean findFriend() {
		boolean result = false;
		String search = token.nextToken();
		String searchList = "";
		int searchCnt =0;
		//ArrayList<Member> searchList = new ArrayList<Member>();
		for(int i=0; i<mbList.size(); i++){
			Member mb = mbList.get(i);
			if(search.equals(mb.getName()) ||
  			   search.equals(mb.getId()) ||
			   search.equals(mb.getPhone())){
				Member findMb = mb;
				searchList += "|"+mb.getId()+"|"+mb.getName()+"|"+mb.getPhone();
				searchCnt++;
			}
		}
		String msg="";
		if(searchCnt>0)
		{
			msg=Member.SEARCH+"|"+Member.OK+"|"+searchCnt+searchList;
			response(msg);
			return true;
		}
		else
		{
			msg=Member.SEARCH+"|"+Member.FAIL+"|"+searchCnt;
			response(msg);
			return false;
		}
	}

	// #Ư���� ���� ���
	// ����: id�� �˻��Ͽ� �ش� member������ �����Ѵ�.
	// input : search �ʵ� �ϳ��� �ʿ�
	// output: Member ��ü ���� ����
	private Member getInfoMember(String searchId) {
		Member findMb=null;
		for(int i=0; i<mbList.size(); i++){
			Member mb = mbList.get(i);
			if(searchId.equals(mb.getId())){
				findMb = mb;
			}
		}
		return findMb;
	}//end of getInfoFriend()

	
	
	
	
	// #ģ�����
	// ����: �ش� ���̵��� ģ���� �˻�
	// input : id
	// output: frId
	private boolean friendList() {
		String id = token.nextToken();
		String msg = Member.FR_LIST;
		ArrayList<Member> tempList = new ArrayList<Member>();
		for(int i=0; i<mbList.size();i++){			// mbList���� ã��
			if(id.equals(mbList.get(i).getId())){
				tempList = mbList.get(i).getFrList();
				break;
			}
		}
//		System.out.println(tempList.size());
		if (tempList == null) {
			msg += "|"+Member.FAIL;
		} else {
			msg += "|"+Member.OK;
			for(int i=0;i<tempList.size();i++){			// mbList���� ã�� id�� ģ�����
				msg += "|"+tempList.get(i).getId()+"|"+tempList.get(i).getName();
			}
		}
		response(msg);
		return true;
	}
	// #ģ�����
	// ����: ģ������� �޾Ƽ� ���
	// input : ����id|ģ��id|ģ��2id..... |ģ��nid
	// output: JOB|RESULT|
	private boolean friendAdd() {
		String id = token.nextToken();

		for(int i=0; i<mbList.size(); i++){
			//����id�� mbList�� member��ü�� ã��
			if(id.equals(mbList.get(i).getId())){
				ArrayList<Member> frList = mbList.get(i).getFrList();
				while(token.hasMoreTokens()){
					String frId = token.nextToken();
					Member frMb = new Member();
					frMb.setId(frId);
					//�ش� ��ü ������ ��������. 
					frMb.setName(getInfoMember(id).getName());
					frMb.setPhone(getInfoMember(id).getPhone());
					frList.add(frMb);
				}
				mbList.get(i).setFrList(frList);
			}
		}
		String msg=Member.FR_ADD+"|"+Member.OK;
		response(msg);
		return true;
	}	
	
	// #LOGOUT
	// �ش� ��� Ư���� ���� �ʿ� ������.... Ŭ���̾�Ʈ���� ó���ϴ� �ɷ�
	// input : 
	// output: 
	private boolean logout(){
		return true;
	}

	// #ä�ù� ����ȭ ó��
	// ���ȣ�� �޽����� �޾Ƽ� ����ȭ ��������.
	// input : chatNo|�ű�message 
	// output: 
	private boolean chatCreate(){
		String chatNo;
		chatNo = token.nextToken();
		
		
		
		
		
		return true;
	}
	

} //end of svrThread class 
