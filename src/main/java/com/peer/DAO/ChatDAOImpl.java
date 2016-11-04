package com.peer.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.peer.model.Chat;

@Repository("ChatDAO")
public class ChatDAOImpl implements ChatDAO {
	
	@Autowired(required=true)
	private SessionFactory sf;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addChat(Chat chat)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		chat.setDate(new Date());
		System.out.println("store");
		s.saveOrUpdate(chat);
		System.out.println("added new chat......");
		t.commit();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Chat> viewChat(Integer fromUser,Integer toUser){
		System.out.println("sum");
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(Chat.class);
		List<Integer> users=new ArrayList<Integer>(2);
		System.out.println("list chat");
		users.add(new Integer(fromUser));
		users.add(new Integer(toUser)); 
		c.add(Restrictions.and(Restrictions.in("fromUser",users),Restrictions.in("toUser",users)));
		System.out.println("qwertyu");
	    c.addOrder(Order.asc("chatid"));
	    System.out.println("hello...");
		System.out.println("efhddh");
		System.out.print(c.list().size());
		List<Chat> msgs=c.list();
		System.out.println("qwedfghjuygf");
		t.commit();
		return msgs;
		
	}
	
	

}
