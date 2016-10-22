package com.peer.DAO;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.peer.model.Blog;
import com.peer.model.Comment;

@Repository("CommentDAO")
public class CommentDAOImpl implements CommentDAO  {
	
	private Comment comment;

	@Autowired
	private SessionFactory sf;
	
    @Transactional(propagation=Propagation.SUPPORTS)
	public void addcomment(Comment e) {
    	Session s=sf.getCurrentSession();
    	Transaction t=s.beginTransaction();
    	e.setDate(new Date());
    	s.saveOrUpdate(e);
    	t.commit();
	}
   @Transactional(propagation=Propagation.SUPPORTS)
	public void deletecomment(int id) {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Comment com1=(Comment)s.load(Comment.class,id);
		s.delete(com1);
		t.commit();
	}
   @Transactional(propagation=Propagation.SUPPORTS)
	public void updatecomment(Comment e) {
		 Session s=sf.getCurrentSession();
		 Transaction t=s.beginTransaction();
		 s.update(e);
		 t.commit();
	}
}
