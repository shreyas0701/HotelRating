package com.micro.user.service.services;

import java.util.List;

import com.micro.user.service.entity.User;

public interface UserService {
	
	
	//add user
	User saveUser(User user);
	
	
	//get user
	User getUser(String userId);
	
	
	//get all users
	List<User> getAllUser();
	
	//delete user
	void deleteUser(String userId);
	
	//TODO: update
}
