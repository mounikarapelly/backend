package com.profile;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.profile.model.User;
import com.profile.repo.UserRepo;
import com.profile.service.ProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProfileManagementMicroserviceApplicationTests {

	@Autowired
	ProfileService service;
	
	@MockBean
	UserRepo repo;
	
	
	@Test
	public void addUserTest() {
		User user = new User( "mounika","mounika965",678344673L,"female");
		when(repo.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}
	
	@Test
	  public void findAllTest()
	  {
	  when(repo.findAll()).thenReturn(Stream.of
	    (new User("swetha","swethasree",978344673L,"female"),new User("andrea","singer",878344673L,"female"))
	    .collect(Collectors.toList()));
	  assertEquals(2,service.getUsers().size());
	  }

	@Test
	public void greetTest()
	{
		String greet = "welcome to our home";
	   assertEquals(greet,service.greet());
		
	}
	

}