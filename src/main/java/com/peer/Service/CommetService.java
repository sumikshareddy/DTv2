package com.peer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peer.DAO.CommentDAO;
import com.peer.model.Comment;

@Service("CommentService")
public class CommetService  implements ICommentService{
	@Autowired(required=true)
	private CommentDAO cd;

	public void addcomment(Comment e) {
		cd.addcomment(e);
	}

	}
