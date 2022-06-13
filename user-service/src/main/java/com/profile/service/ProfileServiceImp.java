package com.profile.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.profile.exception.CatalogRequestException;
import com.profile.model.User;
import com.profile.repo.UserRepo;



@Service
public class ProfileServiceImp implements ProfileService {
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepo repository;

	@Override
	public User addUser(User user) {
		 
		System.out.println("Hi "+user.getemail()+" welcome to group!");
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}

	

	@Override
	public List<User> getUsers() {
	
		List<User> users = repository.findAll();
		System.out.println("retrieved all users : " + users);
		return users;
	}
	
	
	@Override
	public ResponseEntity<Object> updateuser(String id, User user) {
		
		
		boolean isUserExist=repository.existsById(id);
		 if(isUserExist) {
			 user.setPassword(passwordEncoder.encode(user.getPassword()));
		 	repository.save(user);
		    	return new ResponseEntity<Object>("user Updated Successfully with id "+id,HttpStatus.OK);
		 }
		 else
		 {
			 throw new CatalogRequestException("CAN NOT UPDATE AS USER NOT FOUND WITH THIS ID ::");
		 }
	}
		

	
	public ResponseEntity<Object> deleteById(String id)
	{
		boolean isUserExist=repository.existsById(id);
		 if(isUserExist) {
			 repository.deleteById(id);
			 return new ResponseEntity<Object>("user deleted with id "+id,HttpStatus.OK);
		 }
		 else
		 {
		 	throw new CatalogRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		 }
	}

	@Override
	public Optional<User> getuser(String id) {
		return Optional.of(repository.findById(id)
				 .orElseThrow( () -> new CatalogRequestException("CUSTOMER NOT FOUND WITH THIS ID ::")));
		
	}

	@Override
	public String greet()
	{
		return "welcome to our home";
	}



	
}
