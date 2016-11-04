package com.peer.DAO;

import java.util.List;

import com.peer.model.Chat;

public interface ChatDAO {
	
	public void addChat(Chat chat);
	public List<Chat> viewChat(Integer fromUser,Integer toUser);
 
	
	}
