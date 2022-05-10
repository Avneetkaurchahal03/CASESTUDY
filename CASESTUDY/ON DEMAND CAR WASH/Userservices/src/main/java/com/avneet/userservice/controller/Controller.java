package com.avneet.userservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.avneet.userservice.exception.ApiRequestException;
import com.avneet.userservice.model.OrderData;
import com.avneet.userservice.model.UserLogin;
import com.avneet.userservice.model.WasherPackages;
import com.avneet.userservice.model.WasherRating;
import com.avneet.userservice.repository.userRepository;
import com.avneet.userservice.service.UserService;

//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/us")
public class Controller {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private userRepository repo;
	
	
	@PostMapping("/Signup")
	//@ApiOperation(value="Users to Signup")
	public UserLogin saveUser(@RequestBody UserLogin userLogin ) {
		userLogin.setId(service.getSequenceNumber(UserLogin .SEQUENCE_NAME));
		return service.addUser(userLogin );
	}

	@GetMapping("/allusers")
	//@ApiOperation(value="To get List of all users")
	public List<UserLogin > findAllUsers() {
		return service.getuser();
	}

	
	  @PutMapping("/updateUser")
	 // @ApiOperation(value="To update the user")
	  public String updateUser(@RequestBody UserLogin userLogin ) { 
		  String result = service.Updateuser(userLogin ); return result;
		  }
	 
	
	
	

	@GetMapping("/allusers/{id}")
	//@ApiOperation(value="To get List of all users using id")
	 public Optional<UserLogin > getuser(@RequestParam int id)
	 		throws ApiRequestException
	 {
		 return Optional.of(repo.findById(id)
				 .orElseThrow( () -> new ApiRequestException("USER NOT FOUND WITH THIS ID ::")));
	 }

	
	@DeleteMapping("/delete/{id}")
	//@ApiOperation(value="To delete the user using id")
	 public ResponseEntity<Object> deleteuser(@RequestParam int id)
	 {
		 boolean isUserExist=repo.existsById(id);
		 if(isUserExist) {
			 service.deleteById(id);
			 return new ResponseEntity<Object>("user deleted with id "+id,HttpStatus.OK);
		 }
		 else
		 {
		 	throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		 }
	 }
	

	  @GetMapping("/allpacks")
	  //@ApiOperation(value="To get List of all packages")
	  public List<WasherPackages> getwashpacks() { 
		  String baseurl ="http://localhost:8081/admin/allpacks";
		  WasherPackages[] wp =restTemplate.getForObject(baseurl, WasherPackages[].class);
	  
	  return Arrays.asList(wp); 
	  
	  }
	 
	 /* @GetMapping("/admin/allpacks")
	  //@ApiOperation(value="To get List of all packages")
	  public WasherPackages[] getwashpacks( WasherPackages[] wp) { 
		 return wp;
		
	  }*/
	
	  
	  @PostMapping("/addorder")
	  //@ApiOperation(value="To add the order")
	  public String addorder(@RequestBody OrderData order) {
	  HttpHeaders headers = new HttpHeaders();
	  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	  HttpEntity<OrderData> entity = new HttpEntity<OrderData>(order,headers);
	  return restTemplate.exchange(
	  "http://localhost:8083/od/addorder", HttpMethod.POST, entity, String.class).getBody();
	  }
	  
	  
	  
	  @DeleteMapping("/deleteorder")
	 // @ApiOperation(value="To delete the order")
	  public String deleteorder(@RequestParam int id){
	  String baseurl="http://localhost:8083/od/cancelorder";
	  OrderData order=restTemplate.getForObject(baseurl, OrderData.class);
	  return "Your Order is successfully Canceled "+order;
	  }
	  
	  
	 @PostMapping("/addratings")
	 // @ApiOperation(value="To add ratings")
		public String addrating(@RequestBody WasherRating rating) {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<WasherRating> entity = new HttpEntity<WasherRating>(rating, headers);

			return restTemplate.exchange("http://localhost:8082/admin/addratings", HttpMethod.POST, entity, String.class)
					.getBody();
		}	
	  
	 /* @PostMapping("/admin/addratings")
	  public WasherRating addrating(@RequestBody WasherRating rating) {
		  return rating;
		}
	  */
	  
	

}


