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
	// MsgServer로 부터 받아들어와서 쓰레드로 동작을 이어갈 것들 정의
	private ArrayList<Socket> List; 
	private ArrayList<Member> mbList;
	private ArrayList<ChatRoom> chatList;
	Member mb;
	TextArea taSysMsg;
	
	BufferedReader br;  //입력스트림 최종처리
	PrintStream ps;		//출력스트림 최종처리 
	///////////////////////////////////////////
	StringTokenizer token;
	
	int lastChatRoomNumber; //마지막 방번호관리 안씀!!!
	
	
	//생성자
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
				logout();  
				break;
			case Member.FR_UPDATE: // 친구목록 업데이트
//				accessUpdate();
				break;
			case Member.FR_LIST: //친구 목록
				friendList(); // 클라이언트만 처리해도 될듯.
				break;
			case Member.SEARCH: //친구 찾기
				findFriend();
				break;
			case Member.FR_ADD: //친구 등록
				friendAdd();
				break;
			case Member.FR_REMOVE: //친구 삭제
				friendRemove();
				break;
			case Member.CHAT_CR: //채팅룸 만들기
				chatCreate();
				break;
			case Member.CHAT_IN: //채팅룸 사용자 추가하기
				chatAddMember();
				break;
			case Member.CHAT_OUT: //채팅룸 사용자 나가기
				chatRemoveMember();
				break;
			case Member.CHAT_SYNC: //채팅룸 대화내용 동기화
				String strChatNo = token.nextToken();
				String syncMsg = token.nextToken();
				chatSyncMsg(strChatNo,syncMsg);
				break;
		}//end of switch(job)
	}

	
	// #회원가입 #중복확인
	private boolean idCheck(){
		String id;
		id = token.nextToken();
		//동일 아이디 확인하자! 
		for(int i=0; i<mbList.size(); i++){
			if(id.equals(mbList.get(i).getId())==true){
				//기존 아이디 존재함.
				String msg = Member.ID_DUP+"|"+Member.FAIL;
				sysMsg("기존아이디 존재함"+msg);
				response(msg);
				return false;
			}
		}
		
		sysMsg("ID 중복확인 완료");
		String msg = Member.ID_DUP+"|"+Member.OK;
		response(msg);
		return true;
	}
	// #회원가입 
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
		
		//동일 아이디 확인하자! 
		for(int i=0; i<mbList.size(); i++){
			if(id.equals(mbList.get(i).getId())==true){
				//기존 아이디 존재함.
				String msg=Member.SIGNIN+"|"+Member.FAIL+"|"+Member.MSI02;
				sysMsg("기존아이디 존재함"+msg);
				response(msg);
				return false;
			}
		}
		//패스워드와 패스워드 확인값 동일여부 체크하자! 
		if(pw.equals(pwConfirm)==false){
			String msg=Member.SIGNIN+"|"+Member.FAIL+"|"+Member.MSI02;
			sysMsg("패스워드 확인값이 서로 틀림"+msg);
			response(msg);
			return false;			
		}
		
		mbList.add(newMb); //member형 ArrayList mbList에 담자.
		sysMsg("멤버 저장완료");
		
		String msg=Member.SIGNIN+"|"+Member.OK+"|"+Member.MSI00;
		sysMsg(msg);
		response(msg);
		MsgServer.detailedAction(0);
		return true;//회원가입 성공시
	}
	
	// #로그인
	private boolean login() {
		boolean result = false;
		String id, pw;
		id = token.nextToken();
		pw = token.nextToken();
		
		System.out.println("받은 메세지 "+id+", "+pw);
		String msg = Member.LOGIN+"|"+Member.FAIL;		// id/pw 체크하여 true 반환
		
		// id/pw 체크
		for(int i=0; i < mbList.size(); i++){
			Member mb = mbList.get(i);
			if(id.equals(mb.getId()) == true){			// 1> id가 리스트에 있다면
				if (pw.equals(mb.getPw()) == true) {	// 2> pw도 리스트에 있는지 체크
					//현재 사용하는 mb 필드에 가입정보를 셋팅해주자!
					this.mb.setId(mb.getId());
					this.mb.setName(mb.getName());
					this.mb.setPhone(mb.getPhone());
					this.mb.setOnline(true);
					//쓰레드생성하면 넘겨온 mb의 in,out stream을 Member List Array에도 저장을 해주자.
					mbList.get(i).setBr(this.mb.getBr());
					mbList.get(i).setPs(this.mb.getPs());
					mbList.get(i).setOnline(true);
					result = true;
					msg = Member.LOGIN+"|"+Member.OK+"|"+mb.getId()+"|"+mb.getName();	// 3> id체크, pw체크가 성공하면 true 반환
					break;
				}
			}
		}
		
		response(msg);
		accessUpdate(id);
		return result;
	}
	
	
	
	// #친구찾기
	// 구조: id 또는 전화번호 또는 이름 으로 검색
	// input : search 필드 하나만 필요
	// output: JOB|RESULT|찾은결과수|아이디|성명|전화번호)
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

	// #특정인 정보 얻기
	// 구조: id로 검색하여 해당 member정보를 리턴한다.
	// input : search 필드 하나만 필요
	// output: Member 객체 정보 리턴
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

	
	
	// #친구목록 업데이트 요청
	// 어느 사용자가 로그인/아웃 했을때 현재 로그인된 모든사람의 친구목록 업데이트 
	private boolean accessUpdate(String id) {
		String msg = Member.FR_UPDATE;
		
		for (int i=0; i<mbList.size(); i++) {
			if (mbList.get(i).isOnline()) {
				PrintStream ps = mbList.get(i).getPs();
				sysMsg("response() msg:"+msg);					// 메세지 전송
				ps.println(msg);
			}
		}
		
		/*
		Member changedMb = getInfoMember(id);							// 접속상태가 변경된 사람
		System.out.println("방금 접속한 사람 : "+changedMb.getId());
		
		ArrayList<Member> onList = new ArrayList<>();				// 현재 접속한 사람들
		for (int i=0; i<mbList.size(); i++) {
			if (mbList.get(i).isOnline()) {
				onList.add(mbList.get(i));
				System.out.println("이미 접속한 사람 : "+mbList.get(i).getId());
			}
		}
		for (int i=0; i<onList.size(); i++) {						// 현재 접속한 사람들 중에
			ArrayList<Member> frList = onList.get(i).getFrList();
			System.out.println(onList.get(i).getId()+"의 "+ "frList의 사이즈 : "+frList.size());
			for (int j=0; j<frList.size(); j++) {					// 친구목록에 접속상태가 변경된 사람이 있는 경우
				if (frList.get(j).equals(changedMb)) {
					System.out.println("로그인한 나를 추가한 사람 : "+onList.get(i).getId()+" "+onList.get(i).isOnline());
					PrintStream ps = onList.get(i).getPs();
					sysMsg("response() msg:"+msg);					// 메세지 전송
					ps.println(msg);
				}
			}
		}
		*/
		return true;
	}
	
	// #친구목록
	// 구조: 해당 아이디의 친구로 검색
	// input : id
	// output: frId
	private boolean friendList() {
		String id = token.nextToken();
		String msg = Member.FR_LIST;
		ArrayList<Member> tempList = new ArrayList<Member>();
		for(int i=0; i<mbList.size();i++){			// mbList에서 찾기
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
			for(int i=0;i<tempList.size();i++){			// mbList에서 찾은 id의 친구목록
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
	// #친구등록
	// 구조: 친구멤버를 받아서 등록
	// input : 본인id|친구id|친구2id..... |친구nid
	// output: JOB|RESULT|
	private boolean friendAdd() {
		String id = token.nextToken();

		for(int i=0; i<mbList.size(); i++){
			//본인id의 mbList의 member객체를 찾자
			if(id.equals(mbList.get(i).getId())){
				ArrayList<Member> frList = mbList.get(i).getFrList();
				while(token.hasMoreTokens()){
					String frId = token.nextToken();
					Member frMb = new Member();
					frMb.setId(frId);
					//해당 객체 정보를 가져오자. 
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
	
	// #친구삭제 TODO 실패할경우?
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
	// offline상태로 바꾸고, 사용자리스트도 업데이트, chatRoom도 업데이트 
	// input : 
	// output: 
	private void logout(){
		System.out.println("로그아웃");
		sysMsg(mb.getId()+"님이 로그아웃을 신청하셨습니다.");
		//오프라인 작업
		mb.setOnline(false);
		for(int i=0; i<mbList.size();i++){
			if(mb.getId().equals(mbList.get(i).getId())){
				mbList.get(i).setOnline(false);
			}
		}//end of for i
		//ToDo: 클라이언트에 해당 사용자에 대한 offline을 동기화 시키자.
		
		//ToDO:접속자 리스트에서 삭제하자. 
			
		//chatList에서 사용자 삭제하자.
		for(int i=0; i<chatList.size(); i++){
			for(int j=0; j<chatList.get(i).getRoomMemberList().size();j++){
				if(mb.getId().equals(chatList.get(i).getRoomMemberList().get(j).getId())){
					chatList.get(i).getRoomMemberList().remove(j);
					//사용자들에게 알려주자.. 연결된 대화창에 알려주자.
					String msg = mb.getId()+"님이 퇴장하셨습니다.";
					chatSyncMsg(chatList.get(i),msg);
				}
			}//end of for j
		}//end of for i
		sysMsg(mb.getId()+"님이 로그아웃하셨습니다.");
		
		//클라이언트 로그아웃 처리 시키자!!! 
		String msg = Member.LOGOUT+"|"+mb.getId()+"|"+Member.MLO00+"|";
		response(msg);
			
		
		try {
			mb.getBr().close();
			mb.getPs().close();
			mb = null;
			sysMsg("스트림 닫기가 완료되었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sysMsg("스트림 닫기가 실패하였습니다.");
		}
		
	}

	// #채팅방 만들기 처리
	// 방번호와 메시지를 받아서 동기화 시켜주자.
	// input : 만든이id 
	// output: Member.CHAT_CR+"|"+Member.OK+"|"+Member.MCC01+"|"+StrChatNo;
	private void chatCreate(){
		int chatNo = MsgServer.setLastChatRoomNumberPlus(); //방번호 증가시킨값을 리턴 받는다.
		ChatRoom chat = new ChatRoom();
		String id = token.nextToken();
//		System.out.println("만든이id:"+id+"  현재mb의 id:"+mb.getId());
		chat.setMaker(mb);
		chat.setRoomNum(chatNo);
		chat.getRoomMemberList().add(mb); //룸사용자리스트에 본인 추가 
		chatList.add(chat); //전체 채팅방리스트에 현재 채팅방 추가
		String noticeMsg = mb.getId()+"("+mb.getName()+")님이"+chatNo+"번 방을 만드셨습니다.";
		String StrChatNo = String.valueOf(chatNo); 

		String msg=Member.CHAT_CR+"|"+Member.OK+"|"+Member.MCC01+"|"+StrChatNo;
		response(msg);
		
		chatSyncMsg(StrChatNo, noticeMsg);
	}
	
	//채팅방 메시지 동기화 (채팅방 번호, 메시지)
	private void chatSyncMsg(String chatNo, String msg){
		for(int i=0; i<chatList.size(); i++){
			if(Integer.parseInt(chatNo) == chatList.get(i).getRoomNum()){
				chatSyncMsg(chatList.get(i),msg);
			}
		}
	}
	
	//채팅방 메시지 동기화 (채팅방 객체, 메시지)
	private void chatSyncMsg(ChatRoom chat, String msg){
		for(int i=0; i<chat.getRoomMemberList().size(); i++){
			String msg2 = Member.CHAT_SYNC+"|"+chat.getRoomNum()+"|"+msg;
//			System.out.println("chatSyncMsg>> chat.getRoomMemberList().get(i):"+ chat.getRoomMemberList().get(i));
//			System.out.println("chatSyncMsg>> chat.getRoomMemberList().get(i).getPs():"+ chat.getRoomMemberList().get(i).getPs());
			chat.getRoomMemberList().get(i).getPs().println(msg2);
			String msg3= chat.getRoomNum()+"번 채팅방의 메시지 ["+msg+"]가 " +chat.getRoomMemberList().size()+"개의 채팅창에 전달되었습니다.";
			sysMsg(msg3);
		}
	}
	
	// #채팅방에 멤버추가하기
	// 방번호와 대화방 추가 사용자들을 받아서 처리해주자.
	// input : chatNo|id1|id2..... |idn 
	// output: 
	private void chatAddMember(){
		String chatNo;
		chatNo = token.nextToken();
		System.out.println("chatNo: "+ chatNo);
		System.out.println("chatAddMember()>> chatList.size():"+chatList.size() );
		for(int i=0; i<chatList.size(); i++){
			//해당 방을 찾자!
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
					//해당 사용자가 온라인일 때만 대화에 참여가 가능함. 출력스트림 없기에.
					if(mbOnline(id)){
						sysMsg(id+"님은 현재 온라인 상태입니다.");
						//채팅방 초대자에게 채팅방을 열어주게 하자. 
						chatInvite(id, this.mb.getId(),chatNo); //초대된 사람, 초대한 사람, 초대방번호
					}else{
						sysMsg(id+"님은 현재 오프라인 상태입니다. 다음 추가 사용자를 확인합니다....");
						continue; // 온라인이 아니기때문에 다음 토큰을 받아보자. 
					}
					//입장완료 메시지를 보내자!						
					String msg = mb.getId()+"("+mb.getName()+")님이 입장하셨습니다.";
					System.out.println("mb.getId():"+mb.getId()+" chatList.get(i)"+chatList.get(i));
					chatSyncMsg(chatList.get(i), msg);
					sysMsg(msg);
				}//end of while(token)
				
			}//end of if(해당방번호에 대한 리스트)
		}//end of for(채팅방 리스트 전체)
		chatMemberList(chatNo);	// 채팅방 참여자목록 전송
		MsgServer.chatBoardUpdate(); //채팅방현황판 업데이트 치자
	}//end of chatAddMember()
	
	// #채팅방 참여자목록
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
	
	// #채팅방 열기 
	// 초대자에게 채팅방을 열어주자
	// input : id: 초대받은 사람,  CallId : 초대한 사함(본인)
	// output: Member.CHAT_CR+"|"+Member.id(초대자)+"|"+Member.MIV01+"|"+StrChatNo;
	private void chatInvite(String id, String CallId, String chatNo){
		String msg = Member.CHAT_INVITE;
		msg+="|"+id+"|"+Member.MIV01+"|"+chatNo;
		//여기서 해당 메시지를 초대된 id의 소켓을 통해서 입력해야 한다.!!! 
		//해당 id의 출력 스트림을 찾아오자.
		Member inviteMb = getInfoMember(id);
		PrintStream ps = inviteMb.getPs();
		sysMsg("response() msg:"+msg);
		ps.println(msg);
		System.out.println("초대된 멤버 id:"+id+" 해당ps:"+ps+" 초대한멤버는 CallID:"+CallId+" 해당ps:"+this.ps);
	}
	// login때 mbList에 저장했던 online 여부를 확인해서 처리하자.
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
	
	
	// #채팅방에 멤버 나가기
	// 해당 방번호와 채팅방에서 나가기를 한 사용자들을 받으면, 
	// input : Member.CHAT_OUT+"|"+chatNo+"|"+mb.getId();
	// output: 
	private void chatRemoveMember(){
		String chatNo = token.nextToken();
		String id = token.nextToken();
		for(int i=0; i<chatList.size(); i++){
			//해당 방번호를 찾자
			if(Integer.parseInt(chatNo)==chatList.get(i).getRoomNum()){
				for(int j=0;j<chatList.get(i).getRoomMemberList().size();j++){
					if(id.equals(chatList.get(i).getRoomMemberList().get(j).getId())){
						chatList.get(i).getRoomMemberList().remove(j);		
					}
				}
				//퇴장완료 메시지를 보내자! 
				String msg = mb.getName()+"("+mb.getName()+")님이 퇴장하셨습니다.";
				chatSyncMsg(chatNo, msg);
			}//end of if
		}//end of for
		chatMemberList(chatNo);
		MsgServer.chatBoardUpdate(); //채팅방현황판 업데이트 치자
	}//end of chatRemoveMember
	
} //end of svrThread class 
