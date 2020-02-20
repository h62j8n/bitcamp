package com.bit.messenger.v082;

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
	private ArrayList<ChatRoom> chatList;
	Member mb;
	TextArea taSysMsg;
	
	BufferedReader br;  //�Է½�Ʈ�� ����ó��
	PrintStream ps;		//��½�Ʈ�� ����ó�� 
	///////////////////////////////////////////
	StringTokenizer token;
	
	int lastChatRoomNumber; //������ ���ȣ���� �Ⱦ�!!!
	
	
	//������
	SvrThread(Member mb, TextArea taSysMsg, ArrayList<Member> mbList, ArrayList<Socket> list, ArrayList<ChatRoom> chatList, int lastChatRoomNumber){
		this.List = list;
		this.mbList = mbList;
		this.chatList = chatList;
		this.mb = mb;
		this.taSysMsg = taSysMsg;
		this.br = mb.getBr();
		this.ps = mb.getPs();
		this.lastChatRoomNumber = lastChatRoomNumber;
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
				logout();  
				break;
			case Member.FR_UPDATE: // ģ����� ������Ʈ
//				accessUpdate();
				break;
			case Member.FR_LIST: //ģ�� ���
				friendList(); // Ŭ���̾�Ʈ�� ó���ص� �ɵ�.
				break;
			case Member.SEARCH: //ģ�� ã��
				findFriend();
				break;
			case Member.FR_ADD: //ģ�� ���
				friendAdd();
				break;
			case Member.FR_REMOVE: //ģ�� ����
				friendRemove();
				break;
			case Member.CHAT_CR: //ä�÷� �����
				chatCreate();
				break;
			case Member.CHAT_IN: //ä�÷� ����� �߰��ϱ�
				chatAddMember();
				break;
			case Member.CHAT_OUT: //ä�÷� ����� ������
				chatRemoveMember();
				break;
			case Member.CHAT_SYNC: //ä�÷� ��ȭ���� ����ȭ
				String strChatNo = token.nextToken();
				String syncMsg = token.nextToken();
				chatSyncMsg(strChatNo,syncMsg);
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
	// #ȸ������ 
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
		MsgServer.detailedAction(0);
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
					//���� ����ϴ� mb �ʵ忡 ���������� ����������!
					this.mb.setId(mb.getId());
					this.mb.setName(mb.getName());
					this.mb.setPhone(mb.getPhone());
					this.mb.setOnline(true);
					//����������ϸ� �Ѱܿ� mb�� in,out stream�� Member List Array���� ������ ������.
					mbList.get(i).setBr(this.mb.getBr());
					mbList.get(i).setPs(this.mb.getPs());
					mbList.get(i).setOnline(true);
					result = true;
					msg = Member.LOGIN+"|"+Member.OK+"|"+mb.getId()+"|"+mb.getName();	// 3> idüũ, pwüũ�� �����ϸ� true ��ȯ
					break;
				}
			}
		}
		
		response(msg);
		accessUpdate(id);
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

	
	
	// #ģ����� ������Ʈ ��û
	// ��� ����ڰ� �α���/�ƿ� ������ ���� �α��ε� ������� ģ����� ������Ʈ 
	private boolean accessUpdate(String id) {
		String msg = Member.FR_UPDATE;
		
		for (int i=0; i<mbList.size(); i++) {
			if (mbList.get(i).isOnline()) {
				PrintStream ps = mbList.get(i).getPs();
				sysMsg("response() msg:"+msg);					// �޼��� ����
				ps.println(msg);
			}
		}
		
		/*
		Member changedMb = getInfoMember(id);							// ���ӻ��°� ����� ���
		System.out.println("��� ������ ��� : "+changedMb.getId());
		
		ArrayList<Member> onList = new ArrayList<>();				// ���� ������ �����
		for (int i=0; i<mbList.size(); i++) {
			if (mbList.get(i).isOnline()) {
				onList.add(mbList.get(i));
				System.out.println("�̹� ������ ��� : "+mbList.get(i).getId());
			}
		}
		for (int i=0; i<onList.size(); i++) {						// ���� ������ ����� �߿�
			ArrayList<Member> frList = onList.get(i).getFrList();
			System.out.println(onList.get(i).getId()+"�� "+ "frList�� ������ : "+frList.size());
			for (int j=0; j<frList.size(); j++) {					// ģ����Ͽ� ���ӻ��°� ����� ����� �ִ� ���
				if (frList.get(j).equals(changedMb)) {
					System.out.println("�α����� ���� �߰��� ��� : "+onList.get(i).getId()+" "+onList.get(i).isOnline());
					PrintStream ps = onList.get(i).getPs();
					sysMsg("response() msg:"+msg);					// �޼��� ����
					ps.println(msg);
				}
			}
		}
		*/
		return true;
	}
	
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
				String frId = tempList.get(i).getId();
				String frName = tempList.get(i).getName();
				String frPhone = tempList.get(i).getPhone();
				boolean frOnline = getInfoMember(tempList.get(i).getId()).isOnline();
				msg += "|"+frId+"|"+frName+"|"+frPhone+"|"+frOnline;
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
					frMb.setName(getInfoMember(frId).getName());
					frMb.setPhone(getInfoMember(frId).getPhone());
					frList.add(frMb);
				}
				mbList.get(i).setFrList(frList);
			}
		}
		String msg=Member.FR_ADD+"|"+Member.OK;
		response(msg);
		return true;
	}	
	
	// #ģ������ TODO �����Ұ��?
		public boolean friendRemove() {
			String id = token.nextToken();
			Member me = new Member();
			
			for (int i=0; i<mbList.size(); i++) {
				if(id.equals(mbList.get(i).getId())){
					me = mbList.get(i);
					break;
				}
			}
			while(token.hasMoreTokens()){
				String frId = token.nextToken();
				ArrayList<Member> myList = me.getFrList();
				for (int i=0; i<myList.size(); i++) {
					if (frId.equals(myList.get(i).getId())) {
						myList.remove(i);
					}
				}
			}
			String msg = Member.FR_REMOVE+"|"+Member.OK;
			response(msg);
			return true;
		}
	
	// #LOGOUT
	// offline���·� �ٲٰ�, ����ڸ���Ʈ�� ������Ʈ, chatRoom�� ������Ʈ 
	// input : 
	// output: 
	private void logout(){
		System.out.println("�α׾ƿ�");
		sysMsg(mb.getId()+"���� �α׾ƿ��� ��û�ϼ̽��ϴ�.");
		//�������� �۾�
		mb.setOnline(false);
		for(int i=0; i<mbList.size();i++){
			if(mb.getId().equals(mbList.get(i).getId())){
				mbList.get(i).setOnline(false);
			}
		}//end of for i
		//ToDo: Ŭ���̾�Ʈ�� �ش� ����ڿ� ���� offline�� ����ȭ ��Ű��.
		
		//ToDO:������ ����Ʈ���� ��������. 
			
		//chatList���� ����� ��������.
		for(int i=0; i<chatList.size(); i++){
			for(int j=0; j<chatList.get(i).getRoomMemberList().size();j++){
				if(mb.getId().equals(chatList.get(i).getRoomMemberList().get(j).getId())){
					chatList.get(i).getRoomMemberList().remove(j);
					//����ڵ鿡�� �˷�����.. ����� ��ȭâ�� �˷�����.
					String msg = mb.getId()+"���� �����ϼ̽��ϴ�.";
					chatSyncMsg(chatList.get(i),msg);
				}
			}//end of for j
		}//end of for i
		sysMsg(mb.getId()+"���� �α׾ƿ��ϼ̽��ϴ�.");
		
		//Ŭ���̾�Ʈ �α׾ƿ� ó�� ��Ű��!!! 
		String msg = Member.LOGOUT+"|"+mb.getId()+"|"+Member.MLO00+"|";
		response(msg);
			
		
		try {
			mb.getBr().close();
			mb.getPs().close();
			mb = null;
			sysMsg("��Ʈ�� �ݱⰡ �Ϸ�Ǿ����ϴ�.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sysMsg("��Ʈ�� �ݱⰡ �����Ͽ����ϴ�.");
		}
		
	}

	// #ä�ù� ����� ó��
	// ���ȣ�� �޽����� �޾Ƽ� ����ȭ ��������.
	// input : ������id 
	// output: Member.CHAT_CR+"|"+Member.OK+"|"+Member.MCC01+"|"+StrChatNo;
	private void chatCreate(){
		int chatNo = MsgServer.setLastChatRoomNumberPlus(); //���ȣ ������Ų���� ���� �޴´�.
		ChatRoom chat = new ChatRoom();
		String id = token.nextToken();
//		System.out.println("������id:"+id+"  ����mb�� id:"+mb.getId());
		chat.setMaker(mb);
		chat.setRoomNum(chatNo);
		chat.getRoomMemberList().add(mb); //�����ڸ���Ʈ�� ���� �߰� 
		chatList.add(chat); //��ü ä�ù渮��Ʈ�� ���� ä�ù� �߰�
		String noticeMsg = mb.getId()+"("+mb.getName()+")����"+chatNo+"�� ���� ����̽��ϴ�.";
		String StrChatNo = String.valueOf(chatNo); 

		String msg=Member.CHAT_CR+"|"+Member.OK+"|"+Member.MCC01+"|"+StrChatNo;
		response(msg);
		
		chatSyncMsg(StrChatNo, noticeMsg);
	}
	
	//ä�ù� �޽��� ����ȭ (ä�ù� ��ȣ, �޽���)
	private void chatSyncMsg(String chatNo, String msg){
		for(int i=0; i<chatList.size(); i++){
			if(Integer.parseInt(chatNo) == chatList.get(i).getRoomNum()){
				chatSyncMsg(chatList.get(i),msg);
			}
		}
	}
	
	//ä�ù� �޽��� ����ȭ (ä�ù� ��ü, �޽���)
	private void chatSyncMsg(ChatRoom chat, String msg){
		for(int i=0; i<chat.getRoomMemberList().size(); i++){
			String msg2 = Member.CHAT_SYNC+"|"+chat.getRoomNum()+"|"+msg;
//			System.out.println("chatSyncMsg>> chat.getRoomMemberList().get(i):"+ chat.getRoomMemberList().get(i));
//			System.out.println("chatSyncMsg>> chat.getRoomMemberList().get(i).getPs():"+ chat.getRoomMemberList().get(i).getPs());
			chat.getRoomMemberList().get(i).getPs().println(msg2);
			String msg3= chat.getRoomNum()+"�� ä�ù��� �޽��� ["+msg+"]�� " +chat.getRoomMemberList().size()+"���� ä��â�� ���޵Ǿ����ϴ�.";
			sysMsg(msg3);
		}
	}
	
	// #ä�ù濡 ����߰��ϱ�
	// ���ȣ�� ��ȭ�� �߰� ����ڵ��� �޾Ƽ� ó��������.
	// input : chatNo|id1|id2..... |idn 
	// output: 
	private void chatAddMember(){
		String chatNo;
		chatNo = token.nextToken();
		System.out.println("chatNo: "+ chatNo);
		System.out.println("chatAddMember()>> chatList.size():"+chatList.size() );
		for(int i=0; i<chatList.size(); i++){
			//�ش� ���� ã��!
			if(Integer.parseInt(chatNo) == chatList.get(i).getRoomNum()){
				while(token.hasMoreTokens()){
					String id = token.nextToken();
					Member mb = new Member();
					mb.setId(id);
					mb.setName(getInfoMember(id).getName());
					mb.setPhone(getInfoMember(id).getPhone());
					mb.setBr(getInfoMember(id).getBr());
					mb.setPs(getInfoMember(id).getPs());
//					mb.setBrCli(getInfoMember(id).getBrCli());
//					mb.setOsCli(getInfoMember(id).getOsCli());
					chatList.get(i).getRoomMemberList().add(mb);
					//�ش� ����ڰ� �¶����� ���� ��ȭ�� ������ ������. ��½�Ʈ�� ���⿡.
					if(mbOnline(id)){
						sysMsg(id+"���� ���� �¶��� �����Դϴ�.");
						//ä�ù� �ʴ��ڿ��� ä�ù��� �����ְ� ����. 
						chatInvite(id, this.mb.getId(),chatNo); //�ʴ�� ���, �ʴ��� ���, �ʴ���ȣ
					}else{
						sysMsg(id+"���� ���� �������� �����Դϴ�. ���� �߰� ����ڸ� Ȯ���մϴ�....");
						continue; // �¶����� �ƴϱ⶧���� ���� ��ū�� �޾ƺ���. 
					}
					//����Ϸ� �޽����� ������!						
					String msg = mb.getId()+"("+mb.getName()+")���� �����ϼ̽��ϴ�.";
					System.out.println("mb.getId():"+mb.getId()+" chatList.get(i)"+chatList.get(i));
					chatSyncMsg(chatList.get(i), msg);
					sysMsg(msg);
				}//end of while(token)
				
			}//end of if(�ش���ȣ�� ���� ����Ʈ)
		}//end of for(ä�ù� ����Ʈ ��ü)
		chatMemberList(chatNo);	// ä�ù� �����ڸ�� ����
		MsgServer.chatBoardUpdate(); //ä�ù���Ȳ�� ������Ʈ ġ��
	}//end of chatAddMember()
	
	// #ä�ù� �����ڸ��
		private void chatMemberList(String chatNo) {
			String msg = Member.CHAT_MEMBER+"|"+chatNo;
			ChatRoom room = new ChatRoom();
			Member chatMb = new Member();
			for (int i=0; i<chatList.size(); i++){
				if(Integer.parseInt(chatNo) == chatList.get(i).getRoomNum()){
					room = chatList.get(i);
				}
			}
			for (int i=0; i<room.getRoomMemberList().size(); i++) {
				chatMb = room.getRoomMemberList().get(i);
				msg += "|"+chatMb.getId()+"|"+chatMb.getName();
			}
			for (int i=0; i<room.getRoomMemberList().size(); i++) {
				chatMb = room.getRoomMemberList().get(i);
				Member inviteMb = getInfoMember(chatMb.getId());
				PrintStream ps = inviteMb.getPs();
				sysMsg("response() msg:"+msg);
				ps.println(msg);
			}
		}
	
	// #ä�ù� ���� 
	// �ʴ��ڿ��� ä�ù��� ��������
	// input : id: �ʴ���� ���,  CallId : �ʴ��� ����(����)
	// output: Member.CHAT_CR+"|"+Member.id(�ʴ���)+"|"+Member.MIV01+"|"+StrChatNo;
	private void chatInvite(String id, String CallId, String chatNo){
		String msg = Member.CHAT_INVITE;
		msg+="|"+id+"|"+Member.MIV01+"|"+chatNo;
		//���⼭ �ش� �޽����� �ʴ�� id�� ������ ���ؼ� �Է��ؾ� �Ѵ�.!!! 
		//�ش� id�� ��� ��Ʈ���� ã�ƿ���.
		Member inviteMb = getInfoMember(id);
		PrintStream ps = inviteMb.getPs();
		sysMsg("response() msg:"+msg);
		ps.println(msg);
		System.out.println("�ʴ�� ��� id:"+id+" �ش�ps:"+ps+" �ʴ��Ѹ���� CallID:"+CallId+" �ش�ps:"+this.ps);
	}
	// login�� mbList�� �����ߴ� online ���θ� Ȯ���ؼ� ó������.
	private boolean mbOnline(String id){
		boolean ret = false;
		for(int i=0; i<mbList.size(); i++){
			if(id.equals(mbList.get(i).getId())){
				ret = mbList.get(i).isOnline();
				break;
			}
		}
		System.out.println("mbOnline>>> ret:"+ret);
		return ret;
	}
	
	
	// #ä�ù濡 ��� ������
	// �ش� ���ȣ�� ä�ù濡�� �����⸦ �� ����ڵ��� ������, 
	// input : Member.CHAT_OUT+"|"+chatNo+"|"+mb.getId();
	// output: 
	private void chatRemoveMember(){
		String chatNo = token.nextToken();
		String id = token.nextToken();
		for(int i=0; i<chatList.size(); i++){
			//�ش� ���ȣ�� ã��
			if(Integer.parseInt(chatNo)==chatList.get(i).getRoomNum()){
				for(int j=0;j<chatList.get(i).getRoomMemberList().size();j++){
					if(id.equals(chatList.get(i).getRoomMemberList().get(j).getId())){
						chatList.get(i).getRoomMemberList().remove(j);		
					}
				}
				//����Ϸ� �޽����� ������! 
				String msg = mb.getName()+"("+mb.getName()+")���� �����ϼ̽��ϴ�.";
				chatSyncMsg(chatNo, msg);
			}//end of if
		}//end of for
		chatMemberList(chatNo);
		MsgServer.chatBoardUpdate(); //ä�ù���Ȳ�� ������Ʈ ġ��
	}//end of chatRemoveMember
	
} //end of svrThread class 
