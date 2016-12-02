package com.peer.DAO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.peer.model.Blog;
import com.peer.model.Event;


@Repository("EventDAO")
public class EventDAOImpl implements EventDAO {
	@Autowired
	private SessionFactory sf;
	private Event event;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addevent(Event e) {
		System.out.println("event added");
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
		e.setDate(new Date());
		e.setCreationdate(new Date());
		System.out.println("added into event list");
		s.save(e);
		t.commit();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Event> viewEvent() {
		System.out.println("list of events");
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Event> l1 = (List<Event>) sf.getCurrentSession().createCriteria(Event.class).list();
		System.out.println("contents events");
		t.commit();
		return l1;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void deleteevent(int id) {
		System.out.println("delete event");
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Event e1=(Event)s.load(Event.class,id);
		s.delete(e1);
		t.commit();
	}

}
    

