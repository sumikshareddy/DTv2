package com.peer.DAO;

import java.util.List;

import com.peer.model.Blog;
import com.peer.model.Forum;

public interface BlogDAO {
	public void addblog(Blog b);
	public void deleteblog(int id);
	public void updateblog(Blog b);
	public List<Blog> viewBlog();

}
