package com.peer.DAO;

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
import com.peer.model.Forum;

@Repository("ForumDAO")
public class ForumDAOImpl implements ForumDAO{
	
	private Forum forum;

	@Autowired
	private SessionFactory sf;
    @Transactional(propagation=Propagation.SUPPORTS)
	public void addquestion(Forum f) {
    	Session s=sf.getCurrentSession();
    	System.out.println("rest");
    	Transaction t=s.beginTransaction();
    	s.saveOrUpdate(f);
    	t.commit();
	}
    @Transactional(propagation=Propagation.SUPPORTS)
	public void deletequestion(int id){
	Session s=sf.getCurrentSession();
	Transaction t=s.beginTransaction();
	 Forum f1=(Forum) s.load(Forum.class,id);
	s.saveOrUpdate(f1);
	t.commit();
			}
    @Transactional(propagation=Propagation.SUPPORTS)
	public void getquestion(int id) {
		// TODO Auto-generated method stub
		
	}
    @Transactional(propagation=Propagation.SUPPORTS)
	public List<Forum> viewForum() {
    	Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(Forum.class);
		List<Forum> f1=(List<Forum>)c.list();
		t.commit();
		return f1;
		
	}

}
