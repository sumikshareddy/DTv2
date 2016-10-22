package com.peer.Service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peer.DAO.MailDAO;
import com.peer.model.User;

@Service
public class MailService implements IMailService
{

	@Autowired(required=true)
	MailDAO md;
	
	public void send(User user, String subject, String body)throws MessagingException {
		md.send(user, subject, body);
	}

}
