package com.peer.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.peer.model.User;
import com.peer.model.UserRole;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {
	
	 @Autowired
	 private SessionFactory sf;
	 
	 private User user;
	 //
	 @Transactional(propagation=Propagation.SUPPORTS)
	 public void adduser(User u) {
		
		 Session s =sf.getCurrentSession();
		 Transaction t=s.beginTransaction();
		 System.out.println("new user");
		 u.setDate(new Date());
		 s.save(u);
		  t.commit();
	}
	 @Transactional(propagation=Propagation.SUPPORTS)
	public User verifyuser(User u) {
		//
		Session s =sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		//
		Criteria c=s.createCriteria(User.class);
		System.out.println("u.getMail");
		System.out.println("u.getPassword");
		c.add(Restrictions.eq("mail", u.getMail()));
		c.add(Restrictions.eq("password",u.getPassword()));
		//
		user=(User)c.uniqueResult();
		System.out.println("Login user : "+user.getFirstname());
		System.out.println(viewUser());
		t.commit();
		return user;
	}
	 @Transactional(propagation=Propagation.SUPPORTS)
		public List<User> viewUser() {
			Session s=sf.getCurrentSession();
			Transaction t=s.beginTransaction();
			Criteria c=s.createCriteria(User.class);
			//c.add(Restrictions.ne("Uid", ))
			List<User> l1=(List<User>)c.list();
			return l1;
		}
	
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public User get() {
		return user;
	}
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}
	 

}
