package com.peer.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Embeddable
public class Friend implements Serializable {
	
	@ManyToOne
	private User user;
	
	private Integer userFriend;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUserFriend() {
		return userFriend;
	}

	public void setUserFriend(Integer userFriend) {
		this.userFriend = userFriend;
	}

	
	
}
	
	
	
	
	
	
