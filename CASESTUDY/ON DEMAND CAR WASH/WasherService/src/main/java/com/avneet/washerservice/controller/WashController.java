package com.avneet.washerservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.avneet.washerservice.exception.ApiRequestException;
import com.avneet.washerservice.model.OrderData;
import com.avneet.washerservice.model.WasherRating;
import com.avneet.washerservice.model.Washerdetails;
import com.avneet.washerservice.repository.WasherRepository;
import com.avneet.washerservice.service.WashService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/wash")
public class WashController {
	
	@Autowired
	private WashService service;
	
   @Autowired
	private RestTemplate restTemplate;
   
   
   @Autowired
   private WasherRepository repo;
	
	@PostMapping(value = "/addwasher")
	//@ApiOperation(value="To add the washer")
	public Washerdetails saveWasher(@RequestBody Washerdetails washer) {
		//washer.setId(service.getSequenceNumber(washer.SEQUENCE_NAME));
		return service.addWasher(washer);
	}
	
	@GetMapping("/allwashers")
	//@ApiOperation(value="To get List of all washers")
	public List<Washerdetails> findAllwashers() {
		return service. getwashers();
	}

	@GetMapping("/allwashers/{location}")
	//@ApiOperation(value="To get List of all washers using location")
	public List<Washerdetails> findwasherByAddress(@PathVariable String location) {
		return service.getwasherbylocation(location);
	}

	@DeleteMapping(value="/delete")
	//@ApiOperation(value="To delete the user")
	public Washerdetails removeUser(@RequestBody Washerdetails washer) {
		service.deletewasher(washer);
		return washer;
	}
	
	

	@GetMapping("/allratings")
	public List<WasherRating> getallratings(){
	String baseurl="http://localhost:8081/admin/rating/allratings";
	WasherRating[] allratings=restTemplate.getForObject(baseurl,WasherRating[].class);

	return Arrays.asList(allratings);

	}
	
	@GetMapping("/allorders")
	public List<OrderData> getallorders(){
	String baseurl="http://localhost:8083/od/allorders";
	OrderData[] allorders=restTemplate.getForObject(baseurl, OrderData[].class);

	return Arrays.asList(allorders);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deletewasher(@RequestParam Long id)
	{
		boolean isUserExist=repo.existsById(id);
		if(isUserExist) {
			repo.deleteById(id);
			return new ResponseEntity<Object>("user deleted with id "+id,HttpStatus.OK);
		}
		else
		{
			throw new ApiRequestException("CAN NOT DELETE AS WASHER NOT FOUND WITH THIS ID ::");
		}
	}

}
