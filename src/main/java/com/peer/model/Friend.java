package com.peer.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
@Embeddable
public class Friend implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@NotNull
	private User user;  
	
	@ManyToOne
	@NotNull
	private User userFriend;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserFriend() {
		return userFriend;
	}

	public void setUserFriend(User userFriend) {
		this.userFriend = userFriend;
	}


	
	
}
	
	
	
	
	
	
