package com.avneet.userservice.service;

import java.util.List;

import com.avneet.userservice.model.UserLogin;

public interface UserService {
	
	

	  public UserLogin addUser(UserLogin userLogin);
	  public List<UserLogin > getuser();
	  public String Updateuser(UserLogin update);
	  public String deleteById(Integer  id);
	  public String deleteUser(UserLogin  user);
	  public String deleteUser(Integer id);
	  public int getSequenceNumber(String sequenceName);
	


}
