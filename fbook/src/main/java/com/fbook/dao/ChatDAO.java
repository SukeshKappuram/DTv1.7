package com.fbook.dao;

import java.util.List;

import com.fbook.models.Chat;

public interface ChatDAO {
	void addChat(Chat c);
	List<Chat> getMessages(int fromUserId,int toUserId);
}
