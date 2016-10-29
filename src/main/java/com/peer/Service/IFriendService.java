package com.peer.Service;

import java.util.List;

import com.peer.model.Friends;
import com.peer.model.User;

public interface IFriendService {
	
	public void addFriend(User Uid,Integer fndid);
	public void updateFriend(int fndid);
	public List<Friends> viewAllFriends(User u);
	public List <Friends> viewAllRequest(int fndid);
	public User retriveFriend(int fndid);

}
