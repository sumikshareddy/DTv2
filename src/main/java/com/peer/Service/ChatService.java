package com.peer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peer.DAO.ChatDAO;
import com.peer.model.Chat;

@Service("ChatService")
public class ChatService implements IChatService{
	
	@Autowired(required=true)
	private ChatDAO c;

	public void createChat(Chat chat)
	{
		c.createChat(chat);
	}

}
