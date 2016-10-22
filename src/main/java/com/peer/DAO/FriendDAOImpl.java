package com.peer.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.peer.model.Friend;
import com.peer.model.Friends;
import com.peer.model.User;

@Repository("FriendDAO")
public class FriendDAOImpl implements FriendDAO {
	@Autowired
	private SessionFactory sf;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Friends> viewAllFriends() {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(Friends.class);
		List<Friends> f=(List<Friends>)c.list();
		t.commit();
		return f;
	}
	
    @Transactional(propagation=Propagation.SUPPORTS)
	public void addFriend(User user, Integer fndid) {
    	System.out.println("add friend DAO");
		Session s=sf.getCurrentSession();
    	Transaction t=s.beginTransaction();
    	
    	System.out.println("Transactio started");
    	System.out.println(user.getFirstname());
    	Friends userFriends=new Friends();
    	userFriends.setStatus("Requested");
    	Friend friend=new Friend();
    	System.out.println("frdzzzz");
    	friend.setUser(user);
    	friend.setUserFriend(fndid);
    	System.out.println("fnd");
    	userFriends.setFriend(friend);
		s.save(userFriends);
		t.commit();
		
	}
    @Transactional(propagation=Propagation.SUPPORTS)
	public void updateFriend(int reqId) {
    	Session s=sf.openSession();
    	Transaction t=s.beginTransaction();
    	Criteria c=sf.getCurrentSession().createCriteria(Friends.class);
    	c.add(Restrictions.eq("Reqid", reqId));
    	Friends f=(Friends)c.uniqueResult();
    	f.setStatus("Accepted");
    	s.update(f);
    	t.commit();

    }
    
    @Transactional(propagation=Propagation.SUPPORTS)
	public List<Friends> viewAllRequest(int fndid) {
    	Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("reddy");
		Criteria c=sf.getCurrentSession().createCriteria(Friends.class);
		c.add(Restrictions.eq("status","Requested"));
		List<Friends> f=(List<Friends>)c.list();
		t.commit();
		return f;
	}
    @Transactional(propagation=Propagation.SUPPORTS)
	public User retriveFriend(int fndid) 
	{
    	Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("friend retrived");
		Criteria c=sf.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("userid", fndid));
		User u=(User)c.uniqueResult();
		t.commit();
		return u;
	
	}
}			
	
    
  