package com.peer.Service;

import org.springframework.stereotype.Service;

import com.peer.model.Chat;
@Service
public interface IChatService
{
	public void createChat(Chat chat);
}
