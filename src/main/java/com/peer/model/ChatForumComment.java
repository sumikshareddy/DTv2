package com.peer.model;

import java.util.Date;

import javax.persistence.Column;

public class ChatForumComment {

	@Column
	private String uid;
	
	private String message;
	
	@Column
	private Date commentdate;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
	
	
}
