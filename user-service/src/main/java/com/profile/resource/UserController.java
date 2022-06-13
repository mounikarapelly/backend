package com.profile.resource;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profile.exception.CatalogRequestException;
import com.profile.model.User;
import com.profile.repo.UserRepo;
import com.profile.service.ProfileService;

@CrossOrigin("http://localhost:3000")

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	ProfileService service;

	
	
	@Autowired
	UserRepo repository;

  
    
    @GetMapping("/home")
    public void welcomeMsg()
    {
    	service.greet();
    }

    @PostMapping("/join")
    public String joinMyGroup(@RequestBody User user) {
      service.addUser(user);
        return "Hi " + user.getemail() + " welcome to group !";
    }
   

   

    @GetMapping("/findall")
    public List<User> loadMyUsers() {
        return service.getUsers();
    }

   
   
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateuser(@PathVariable String id,  @RequestBody User user )
	 {
		 return service.updateuser(id,user);
	 	
	 }
    
    @DeleteMapping("/delete/{id}")
   public ResponseEntity<Object> deleteMyUserById(@PathVariable("id") String id)
    {
    	return service.deleteById(id);
    	
    }
    
    @GetMapping("/user/{id}")
   public Optional<User> getuser(@PathVariable String id)
	 		throws CatalogRequestException
	 {
		 return service.getuser(id);
		
	 }
    
 
    
    
    
}