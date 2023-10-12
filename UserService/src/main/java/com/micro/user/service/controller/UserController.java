package com.micro.user.service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.user.service.entity.User;
import com.micro.user.service.services.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping
	User createUser(@RequestBody User user)
	{	
		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		User user1 = userServiceImpl.saveUser(user);
		return user1;
	}
	
	@GetMapping("/{userId}")
	User getUser(@PathVariable String userId)
	{
		return userServiceImpl.getUser(userId);
	}
	
	@GetMapping()
	List<User> getAllUser()
	{
		List<User> allUsers = userServiceImpl.getAllUser();
		return allUsers;
	}
	
	@DeleteMapping("/{userId}")
	String deleteUser(@PathVariable String userId) {
		userServiceImpl.deleteUser(userId);
		return "User with "+userId+" deleted";
		
	}

}
