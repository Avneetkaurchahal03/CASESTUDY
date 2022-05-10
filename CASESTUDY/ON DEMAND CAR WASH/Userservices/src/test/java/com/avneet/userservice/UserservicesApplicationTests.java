package com.avneet.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.avneet.userservice.model.UserLogin;
import com.avneet.userservice.repository.userRepository;
import com.avneet.userservice.service.UserService;

@SpringBootTest
class UserservicesApplicationTests {

	 @Autowired
	   private UserService serv;
	   
	   @MockBean
	   private userRepository repo;
		
		
		
		  @Test 
		  public void getUsersTest() { 
		       when(repo.findAll()).thenReturn(Stream
					  .of(new UserLogin(1,"sai","S1234","S1234",12345423 ,"sai@1234"),
					            new  UserLogin(2, "jash","J2345","J2345",234123432,"jas@7865")).collect(Collectors.toList()));

					  assertEquals(2, serv.getuser().size());
					  }
		  
		  
		@Test
		public void saveuserTest() {
		UserLogin user = new  UserLogin(5, "jahn","J4567","J4567",612312421 ,"jahn@4321");
			when(repo.save(user)).thenReturn(user);
			assertEquals(user,serv.addUser(user));
		}


		
		
		  @Test 
		  public void deleteUserTest(){ 
		UserLogin user = new UserLogin(9, "jahn","J4567","J4567",612312421 ,"jahn@4321");
		  serv.deleteUser(user); verify(repo,times(1)).delete(user);
		  
		  
		  }
		 

	}


