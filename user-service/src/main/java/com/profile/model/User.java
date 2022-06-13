package com.profile.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="users")
public class User {

	  @Id
	    private String id;
	  @Field
	    private String email;
	    private String password;
	    private long mobileNumber;
	    private String gender;
	    
	  
		
		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}



		public String getemail() {
			return email;
		}



		public void email(String userName) {
			this.email = email;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public long getMobileNumber() {
			return mobileNumber;
		}



		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}



		public String getGender() {
			return gender;
		}



		public void setGender(String gender) {
			this.gender = gender;
		}



		public User( String userName,String password, long mobileNumber, String gender) {
			super();
			
			this.email = email;
			this.password = password;
			this.mobileNumber = mobileNumber;
			this.gender = gender;
		}



		@Override
		public String toString() {
			return "Profile  [ email=" + email +"password ="+password+" mobile number = "+mobileNumber + " gender ="+gender+"]";
		}
	    
}
