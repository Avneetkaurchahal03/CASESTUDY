package com.avneet.adminservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.avneet.adminservice.model.AdminAuthResponse;
import com.avneet.adminservice.model.AdminDetails;
import com.avneet.adminservice.model.OrderData;
import com.avneet.adminservice.model.WasherPackages;
import com.avneet.adminservice.model.WasherRating;
import com.avneet.adminservice.repository.AdminRepository;
import com.avneet.adminservice.service.AdminServiceImp;

//import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/admin")
public class Controller {
	
	@Autowired
	private AdminServiceImp service;
	
	
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private RestTemplate  restTemplate;
	
	//@Autowired
	//private AuthenticationManager  authenticationManager;
	
	
	Logger logger= LoggerFactory.getLogger(Controller.class);
	
	// Admin
	//Adding Admin
		@PostMapping("/addadmin")
		public String addadmin(@RequestBody AdminDetails admin) {
			//service.addadmin(admin); // User will save details
			return "Admin saved Successfully with id :" + admin.getId();
		}
		
	
		


		//Reading All admin 
		@GetMapping("/alladmins")
		public List<AdminDetails> getallAdmins(){
			logger.info("Getting all admi ");
				return adminRepository.findAll();
			
		}

		
		 
		/*  @GetMapping("/alladmins")
		 // @ApiOperation(value = "To Get all User Details")
		  public List<AdminDetails> findAll() {
		  return service.findAll();
		  }*/
		  
		
		//Reading Admin by ID
		@GetMapping("/alladmins/{id}")
		public Optional<AdminDetails> getadminbyId(@PathVariable int id){
			return adminRepository.findById(id);
			
		}
		
		@PutMapping("/update")
		public String updateDetails(@RequestBody AdminDetails admin) {
			service.updateadmin(admin);
			return "update Succesfully";

		}

		
		/*
		 * @GetMapping("/alladmins") public List<AdminDetails> getadmin() { return
		 * service.findAll(); }
		 */
		 

		  
		
		

		@DeleteMapping("/delete")
		public String deleteadmin(@RequestParam int id) {
			service.deleteadmin(id);
			return "delete Succesfully";
		}

		
		// Wash packs

		@PostMapping("/addpack")
		public String savepack(@RequestBody WasherPackages wash) {
			service.save(wash);// user will save his details
			return "pack added Succesfully";
		}

		/*
		 * @GetMapping("/allpacks") public List<Wash> findAllpacks() { return
		 * service.findAllpacks(); }
		 */
		
		@GetMapping("/allpacks")
		public List<WasherPackages> findAllwashers() {
			return service. getwashers();
		}
		
		
		
		
		
		@DeleteMapping("/packdelete")

		public String deletepack(@RequestBody WasherPackages wash, @RequestParam int id) {
			service.deletepack(id);
			return "deleted pack Succesfully";
		}

		@PutMapping("/packupdate")
		public String updatepacks(@RequestBody WasherPackages wash, @RequestParam int id) {
			service.updatepacks(wash);
			return "updated pack Succesfully";
		}

		// Ratings

		
		@PostMapping("/addratings")
		//@ApiOperation(value = "To Add rating Details")
		public String saveratings(@RequestBody WasherRating rating) {
		service.save(rating);
		return "Thanks for ur valuable feedback!!!";
		}



		@GetMapping("/rating/allratings")
		public List<WasherRating> findAllRatings() {
			return service.findAllRatings();
		}

		
		
		@GetMapping("/allorders")
		public List<OrderData> getallorders(){
		String baseurl="http://localhost:8083/od/allorders";
		OrderData[] allorders=restTemplate.getForObject(baseurl, OrderData[].class);

		return Arrays.asList(allorders);
		}
		@GetMapping("/allwashers")
		public List<WasherPackages> getallwashers(){
		String baseurl="http://localhost:8084/wash/allwashers";
		WasherPackages[] allwashers=restTemplate.getForObject(baseurl, WasherPackages[].class);

		return Arrays.asList(allwashers);




		}
		
		

		

}
