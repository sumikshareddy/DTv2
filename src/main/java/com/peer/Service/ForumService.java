package com.peer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peer.DAO.ForumDAO;
import com.peer.model.Forum;

@Service("ForumService")
public class ForumService implements IForumService {
	@Autowired(required=true)
	private ForumDAO fd;

	public void addquestion(Forum f) {
		fd.addquestion(f);
	}

	public void deletequestion(int id) {
		fd.deletequestion(id);
	}

	public void getquestion(int id) {
		return;
	}

	public List<Forum> viewForum() {
		
		return fd.viewForum();
	}

}
