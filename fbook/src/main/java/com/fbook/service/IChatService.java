package com.fbook.service;

import java.util.List;

import com.fbook.models.Chat;

public interface IChatService {
	void addChat(Chat c);
	public List<Chat> getMessages(int fromUserId,int toUserId);
}
