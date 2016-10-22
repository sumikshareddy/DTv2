package com.peer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peer.DAO.BlogDAO;
import com.peer.model.Blog;

@Service("BlogService")
public class BlogService  implements IBlogService{

	@Autowired(required=true)
	private BlogDAO bd;
	
	public void addblog(Blog b) {
		bd.addblog(b);
	}

	public void deleteblog(int id) {
		bd.deleteblog(id);
	}

	public void updateblog(Blog b) {
		bd.updateblog(b);
	}

	public List<Blog> viewBlog() {
		 return bd.viewBlog();
	}

}
