package com.peer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comment {
	
	
	@ManyToOne
	private User user;
	
	
/*	@ManyToOne
	private Blog blog;*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer comid;
	
	@NotNull
	private Date date;
	
	@Size(min=2,max=10)
	private String cdesc;
	
	
	
	
	/*public Blog getBlog() {
		return blog;
	}


	public void setBlog(Blog blog) {
		this.blog = blog;
	}*/


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	

	/*public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}*/


	public Integer getComid() {
		return comid;
	}


	public void setComid(Integer comid) {
		this.comid = comid;
	}


	public String getCdesc() {
		return cdesc;
	}


	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	

}
