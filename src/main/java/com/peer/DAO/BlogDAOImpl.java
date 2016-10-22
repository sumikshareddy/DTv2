package com.peer.DAO;

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

@Repository("BlogDAO")
public class BlogDAOImpl implements BlogDAO{

	private Blog blog;

	@Autowired
	private SessionFactory sf;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addblog(Blog b) {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("new blog");
		b.setDate(new Date());
		s.saveOrUpdate(b);
		System.out.println("bid");
		t.commit();
	}
   @Transactional(propagation=Propagation.SUPPORTS)
	public void deleteblog(int id) {
	    Session s=sf.getCurrentSession();
	    Transaction t=s.beginTransaction();
	    Blog b1=(Blog) s.load(Blog.class,id);
	    s.delete(b1);
	    t.commit();
	}
    @Transactional(propagation=Propagation.SUPPORTS)
	public void updateblog(Blog b) {
    	Session s=sf.getCurrentSession();
    	Transaction t=s.beginTransaction();
    	System.out.println("update+id");
    	s.update(b);
    	t.commit();
    }
    @Transactional(propagation=Propagation.SUPPORTS)
	public List<Blog> viewBlog() {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(Blog.class);
		List<Blog> b1=(List<Blog>)c.list();
		t.commit();
		return b1;
	}

}