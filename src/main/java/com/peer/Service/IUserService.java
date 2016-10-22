package com.peer.Service;

import java.util.List;

import com.peer.model.User;

public interface IUserService {
	public void adduser(User u);
	public User verifyuser(User u);
    public List<User> viewUser();
    public User get();
}
