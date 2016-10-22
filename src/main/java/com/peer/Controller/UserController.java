/*package com.peer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.peer.DAO.UserDAO;
import com.peer.model.User;
import com.peer.model.UserRole;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.header.Header;

@Controller

public class UserController {
	
	@Autowired
	User user;
	@Autowired
	UserDAO userDao;
	@Autowired
	UserRole userRole;
	
	@GetMapping("/User/")
	public ResponseEntity<List<User>> viewUser() {
		List<User> user=userDao.viewUser();
		if (User.isEmpty() ){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		    return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}
	@GetMapping("/User/{Uid}")
	public ResponseEntity<User> getUser(@RequestParam("Uid") User Uid){
		User user=userDao.adduser(Uid);
		if (user==null){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			}
		    return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@PostMapping("/User/")
	public ResponseEntity<Void> createUser(@RequestBody User user,UriComponentsBuilder ucBuilder){
		System.out.println("create user");
		if(userDao.get(user.getUid()) != null){
			System.out.println("user exist with id"+ user.getUid());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		userRole.setRid("ROLE_USER");
		userRole.setAuthority("role");
		Set<UserRole> userRole= new HashSet<UserRole>();
		userRole.addAll(userRole);
		user.setUserRoles(userRole);
		userDao.save(user);
		
		HttpHeaders headers=new HttpHeaders();
		headers.setLocation(ucBuilder.path("/User/{id}").buildAndExpand(user.getUid()).toUri());
		System.out.println("create User");
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
	}
	@PutMapping("/User/{Uid}")
	public ResponseEntity<User> updateUser(@PathVariable("id")  String id,@RequestBody User user){
		System.out.println("updateUser");
		
		if(userDao.get(id)==null){
			System.out.println("User does not exist with id" +id);
			return  new ResponseEntity<User>(HttpStatus.ACCEPTED);
		}
		return null;
	}
}



*/