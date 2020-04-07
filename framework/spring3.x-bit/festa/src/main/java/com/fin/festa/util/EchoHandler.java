package com.fin.festa.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fin.festa.model.entity.ProfileVo;

//에코서버
public class EchoHandler extends TextWebSocketHandler{

	List<WebSocketSession> sessions=new ArrayList<>();
	Map<String, WebSocketSession> userSessions = new HashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Connect");
		sessions.add(session);
//		String senderId=getId(session);
//		userSessions.put(senderId, session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session+":"+message);
		
		Map<String, Object> httpSession = session.getAttributes();
		ProfileVo login = (ProfileVo) httpSession.get("login");
		
		String senderId=login.getProid();
		String senderName=login.getProname();
		String senderPhoto=login.getProphoto();
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date today = new Date();
		String time=format.format(today);
		System.out.println (senderId+"|"+senderName+"|"+senderPhoto+"|"+message.getPayload()+"|"+time);

		for(WebSocketSession sess : sessions) {
			sess.sendMessage(new TextMessage(senderId+"|"+senderName+"|"+senderPhoto+"|"+message.getPayload()+"|"+time));
		}
	}
	

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("Closed");
	}
	
	
}
