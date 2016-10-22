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
	
	
    @Transactional(propagation=Propagation.SUPPORTS)
	public void addevent(Event e) {
		Session s=sf.getCurrentSession();
    	Transaction t=s.beginTransaction();
    	e.setDate(new Date());
    	e.setCreationdate(new Date());
    	s.saveOrUpdate(e);
    	t.commit();
	}
    @Transactional(propagation=Propagation.SUPPORTS)
	public void deleteevent(int id) {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Event e1=(Event)s.load(Event.class,id);
		s.delete(e1);
		t.commit();
	}
	
    @Transactional(propagation=Propagation.SUPPORTS)
	public List<Event> viewEvent() {
	Session s=sf.getCurrentSession();
	Transaction t=s.beginTransaction();
	Criteria c=sf.getCurrentSession().createCriteria(Event.class);
	List<Event> e1 =(List<Event>)c.list();
	t.commit();
	return e1;
			}
	
	}
    

