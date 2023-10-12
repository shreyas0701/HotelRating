package com.micro.user.service.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.user.service.entity.User;
import com.micro.user.service.exception.ResourceNotFoundException;
import com.micro.user.service.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Resource not found"));
//		return userRepository.findById(userId);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}
	
	

}
