package com.peer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Friends implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Friend friend;
	
	@Column
	@NotNull
	private String status;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Reqid;

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getReqid() {
		return Reqid;
	}

	public void setReqid(Integer reqid) {
		Reqid = reqid;
	}

		

}
