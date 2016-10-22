package com.peer.DAO;

import javax.mail.MessagingException;

import com.peer.model.User;

public interface MailDAO 
{
	public void send(User user,String subject,String body)throws MessagingException;
}
