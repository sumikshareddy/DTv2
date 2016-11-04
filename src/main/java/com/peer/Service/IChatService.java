package com.peer.Service;

import java.util.List;

import com.peer.model.Chat;

public interface IChatService {

	public void addChat(Chat chat);
	public List<Chat> viewChat(Integer fromUser,Integer toUser);
}
