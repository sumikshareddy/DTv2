package com.peer.DAO;

import java.util.List;

import com.peer.model.Forum;
import com.peer.model.User;

public interface ForumDAO {
	public void addquestion(Forum f);
	public void deletequestion(int id);
	public void getquestion(int id);
	public List<Forum> viewForum();
	}

