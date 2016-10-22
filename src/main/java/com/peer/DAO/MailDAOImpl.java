package com.peer.DAO;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;

import com.peer.model.User;

@Repository("MailDAO")
public class MailDAOImpl implements MailDAO
{

	public static final String REPLY_TO_ADDRESS="support@peers.com";
	public static final String FROM_ADDRESS="wecare@peers.com";
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void send(User user,String subject,String body) throws MessagingException 
	{
		//javaMailSender =new JavaMailSenderImpl();
		System.out.println("Inside mail");
		MimeMessage mail=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mail,true);
		System.out.println("sending");
		helper.setTo(user.getMail());
		helper.setReplyTo(REPLY_TO_ADDRESS);
		helper.setFrom(FROM_ADDRESS);
		helper.setSubject(subject);
		helper.setText(body);
		helper.setText(body);
		helper.addBcc("sumikshareddy4@gmail.com");
		javaMailSender.send(mail);
	}

}
