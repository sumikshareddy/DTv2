package com.peer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peer.DAO.FriendDAO;
import com.peer.model.Friends;
import com.peer.model.User;

@Service
public class FriendService implements IFriendService {

	@Autowired(required=true)
	private FriendDAO fn;
	
	public void addFriend(User Uid, Integer fndid) {
		System.out.println(Uid.getFirstname());
		fn.addFriend(Uid, fndid);
		}

	public void updateFriend(int fndid) {
		
		 fn.updateFriend(fndid);
		
	}

	public List<Friends> viewAllFriends(User u) {
		
		return fn.viewAllFriends(u);
	}

	public List<Friends> viewAllRequest(int fndid) {
		System.out.println("sai");
		return fn.viewAllRequest(fndid);
	}

	public User retriveFriend(int fndid) {
		
		return fn.retriveFriend(fndid);
	}

	

}
