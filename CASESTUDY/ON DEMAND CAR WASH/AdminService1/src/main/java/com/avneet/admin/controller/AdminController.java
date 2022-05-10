package com.avneet.admin.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.avneet.admin.model.Admin;
import com.avneet.admin.model.Order;
import com.avneet.admin.model.adminAuthResponse;
import com.avneet.admin.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private RestTemplate  restTemplate;
	
	@Autowired
	private AuthenticationManager  authenticationManager;
	
	//Adding Admin
	/*
	 * @PostMapping("/addadmin") public String saveAdmin(@RequestBody Admin admin) {
	 * adminRepository.save(admin) ; return "Admin Saved Successfully with id:"
	 * +admin.getaId();
	 * 
	 * }
	 */
	
	@PostMapping("/addadmin")
	private ResponseEntity<?> saveAdmin(@RequestBody Admin admin){
		
		String email = admin.getaEmail();
		String password = admin.getaPassword();
		Admin admin1 = new Admin();
		admin1.setaEmail(email);
		admin1.setaPassword(password);
		try {
			adminRepository.save(admin);
			
		} catch (Exception e) {
			return ResponseEntity.ok(new adminAuthResponse("Error creating admin "+ email));
		}
		return ResponseEntity.ok(new adminAuthResponse("Successfully created admin "+ email));
		
		
	}
	//authenticating washer
	@PostMapping("/auth")
	private ResponseEntity<?> authAdmin(@RequestBody Admin admin){
		String email = admin.getaEmail();
		String password = admin.getaPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			
		} catch (Exception e) {
			
			return ResponseEntity.ok(new adminAuthResponse("Error during  admin Authentication"+ email));
		}
		return ResponseEntity.ok(new adminAuthResponse("Successfully Authenticated admin"+ email));
		
	}
	
	
	
	
	//Reading All admin 
	@GetMapping("/alladmins")
	public List<Admin> getallAdmins(){
		return adminRepository.findAll();
		
	}
	
	//Reading Admin by ID
	
	
	@GetMapping("/alladmins/{id}")
	public Optional<Admin> getadminbyId(@PathVariable int id){
		return adminRepository.findById(id);
		
	}
	
	//Reading orders  By id
	@GetMapping("/getallorders/{id}") 
	public Order getOrderById (@PathVariable("id") String id) 
	{
	  return restTemplate.getForObject("http://order-service/order/orders/" +id , Order.class);
	  
	  }
	
	
	//Reading All orders 
	@GetMapping("/getallorders") 
	public String getallOrder() 
	{
	   return restTemplate.getForObject("http://order-service/order/allorders", String.class);
	  
	  }
	
	
	//Reading All orders by status
		@GetMapping("/getorderbystatus/{status}") 
		public String getOrderByStatus(@PathVariable ("status") String status) 
		{
		   return restTemplate.getForObject("http://order-service/order/findOrderByStatus/" + status, String.class);
		  
		  }
		
		
		//Updating All orders by id
		
		
		@PutMapping("/updateorder/{id}")
		public String updateorder(@PathVariable("id") String id, @RequestBody Order order) {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<Order> entity = new HttpEntity<Order>(order, headers);

			return restTemplate.exchange("http://order-service/order/update/" + id, HttpMethod.PUT, entity, String.class)
					.getBody();
		}

}