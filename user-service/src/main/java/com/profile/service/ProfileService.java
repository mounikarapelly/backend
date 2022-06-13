package com.profile.service;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.profile.model.User;





public interface ProfileService {
	
public User addUser(User user);
	
	public List<User> getUsers();
	
	
	
	public ResponseEntity<Object> deleteById(String id);

	public ResponseEntity<Object> updateuser(String id, User user);

	public Optional<User> getuser(String id);
	

	
	public String greet();

	 
	
		

}
