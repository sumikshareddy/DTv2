package com.peer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peer.DAO.UserDAO;
import com.peer.model.User;

@Service
public class UserService implements IUserService{
	
	@Autowired(required=true)
	private UserDAO cd;
	
	public void adduser(User u) {
		System.out.println("blueclr service");
		cd.adduser(u);
	}

	public User verifyuser(User u) {
		
		return cd.verifyuser(u);
	}

	public List<User> viewUser() {
		
		return cd.viewUser();
	}

	public boolean emailIdCheck(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public void signUp(User user) {
		// TODO Auto-generated method stub
		
	}

	public void send(User user, String subject, String body) {
		// TODO Auto-generated method stub
		
	}

	public User get() {
		
		return cd.get();
	}

}
