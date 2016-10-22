package com.peer.DAO;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.peer.model.Chat;

@Repository("ChatDAO")
public class ChatDAOImpl implements ChatDAO
{
	private Chat c;
	
	@Autowired(required=true)
	private SessionFactory sf;

	@Transactional(propagation=Propagation.SUPPORTS)
	public void createChat(Chat chat)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("chat creation");
		s.saveOrUpdate(chat);
		t.commit();
	}

	
	
}

	

