package com.fbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbook.dao.BlogDAO;
import com.fbook.dao.ChatDAO;
import com.fbook.models.Chat;
@Service("iChatService")
public class ChatService implements IChatService {

	@Autowired(required=true)
	ChatDAO md;
	
	public void addChat(Chat c) {
		// TODO Auto-generated method stub
		md.addChat(c);
	}

	public List<Chat> getMessages(int fromUserId,int toUserId) {
		// TODO Auto-generated method stub
		return md.getMessages(fromUserId, toUserId);
	}

}
