package com.peer.Service;

import javax.mail.MessagingException;

import com.peer.model.User;

public interface IMailService 
{
	public void send(User user,String subject,String body)throws MessagingException;
}
