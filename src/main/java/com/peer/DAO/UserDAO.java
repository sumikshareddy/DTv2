package com.peer.DAO;

import java.util.List;

import com.peer.model.User;

public interface UserDAO {
	public void adduser(User u);
	public User verifyuser(User u);
    public List<User> viewUser();
	public List<User> list();
	public User get();
	public void save(User user);
	
	}
