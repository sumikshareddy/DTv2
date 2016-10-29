package com.peer.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
	public List<Friends> viewAllFriends(User u) {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(Friends.class);
		c.add(Restrictions.disjunction()
				.add(Restrictions.eq("friend.userFriend.uid",u.getUid()))
				.add(Restrictions.eq("friend.user.uid",u.getUid())));
		c.add(Restrictions.eq("status", "Accepted"));
		List<Friends> f=(List<Friends>)c.list();
		System.out.println(u.getUid()+" "+c.list().size());
		t.commit();
		return f;
	}
	
    @Transactional(propagation=Propagation.SUPPORTS)
	public void addFriend(User user, Integer fndid) {
    	System.out.println("add friend DAO");
		Session s=sf.getCurrentSession();
    	
    	System.out.println("Transactio started");
    	System.out.println(user.getFirstname());
    	Friends userFriends=new Friends();
    	System.out.println("poppy");
    	userFriends.setStatus("Requested");
    	Friend friend=new Friend();
    	System.out.println("frdzzzz");
    	friend.setUser(user);
    	User frnd=retriveFriend(fndid);
    	friend.setUserFriend(frnd);
    	System.out.println("fnd");
    	userFriends.setFriend(friend);
    	Query query = s.createSQLQuery("SELECT * FROM FRIENDS where USER_UID ="+user.getUid()+" and USERFRIEND_UID ="+fndid)
				.addEntity(Friends.class);
				List result = query.list();
				System.out.println(result.size());
    	Transaction t=s.beginTransaction();
    	if(result.size()<1){
    		s.save(userFriends);
    	}
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
		Criteria c=s.createCriteria(Friends.class);
		c.add(Restrictions.eq("friend.userFriend.uid",fndid));
		System.out.println("sumiksha");
		c.add(Restrictions.eq("status","Requested"));
		List<Friends> f=(List<Friends>)c.list();
		System.out.println("bh");
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
		c.add(Restrictions.eq("uid", fndid));
		User u=(User)c.uniqueResult();
		t.commit();
		return u;
	
	}
}			
	
    
  