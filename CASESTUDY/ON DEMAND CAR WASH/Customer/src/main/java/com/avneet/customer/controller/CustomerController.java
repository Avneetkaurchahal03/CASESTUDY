package com.avneet.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.avneet.customer.exception.ApiRequestException;
import com.avneet.customer.model.Customer;
import com.avneet.customer.model.CustomerAuthResponse;
import com.avneet.customer.model.Order;
import com.avneet.customer.repository.CustomerRepository;
import com.avneet.customer.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins="http://localhost:3000")
public class CustomerController {

	

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CustomerServiceImpl customerService;

	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	
	
	

	// Creating/ADDING Customer
	
	 @PostMapping("/addcustomer") public Customer saveCustomer(@RequestBody
	  Customer customer) { return customerService.addCustomer(customer);
	  
	  }
	
	/*@PostMapping("/addcustomer")
	private ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
		
		String email = customer.getcEmail();
		String password = customer.getcPassword();
		Customer customer1 = new Customer();
		customer1.setcEmail(email);
		customer1.setcPassword(password);
		try {
			customerService.addCustomer(customer);
			
		} catch (Exception e) {
			return ResponseEntity.ok(new CustomerAuthResponse("Error creating customer "+ email));
		}
		return ResponseEntity.ok(new CustomerAuthResponse("Successfully created customer "+ email));
		
		
	}
	//authenticating customer
	@PostMapping("/auth")
	private ResponseEntity<?> authCustomer(@RequestBody Customer customer){
		String email = customer.getcEmail();
		String password = customer.getcPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			
		} catch (Exception e) {
			
			return ResponseEntity.ok(new CustomerAuthResponse("Error during  customer Authentication"+ email));
		}
		return ResponseEntity.ok(new CustomerAuthResponse("Successfully Authenticated customer "+ email));
		
	}*/
	
	

	// Reading all Customer
	@GetMapping("/allcustomers")
	public List<Customer> findAllCustomers() {
		return customerService.getCustomers();

	}

	// Reading Customer by ID
	@GetMapping("/allcustomers/{id}")
	public Optional<Customer> getCustomerById(@PathVariable String id) throws ApiRequestException {
		return Optional.of(customerService.findById(id)
				.orElseThrow(() -> new ApiRequestException("CUSTOMER NOT FOUND WITH THIS ID ::")));
	}

	// Updating Customer Data by Id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
		boolean isCustomerExist = customerRepository.existsById(id);
		if (isCustomerExist) {
			customerService.save(customer);
			return new ResponseEntity<Object>("user updated successfully with id " + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT UPDATE AS USER NOT FOUND WITH THIS ID ::");
		}

	}

	// Deleting Customer Data by Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable String id) {
		boolean isCustomerExist = customerRepository.existsById(id);
		if (isCustomerExist) {
			customerService.deleteById(id);
			return new ResponseEntity<Object>("user deleted with id" + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		}

	}

	/*
	 * * Below code is for the Customer for the order * Customer can AddOrder and
	 * Delete Order
	 */
	
	
	// For getting  Order by customer id
	
	@GetMapping("/getallorders/{cId}") 
	public Order getOrderById (@PathVariable("cId") String cId) 
	{
	  return restTemplate.getForObject("http://order-service/order/orders/" +cId , Order.class);
	  
	  }
	
	

	// For Adding Order

	@PostMapping("/addorder") 
	public String addOrder (@RequestBody Order order) 
	{
	  return restTemplate.postForObject("http://order-service/order/addorder", order , String.class);
	  
	  }
		

	

	// for Deleting Order

	@DeleteMapping("/cancelorder/{id}")
	public String deleteorder(@PathVariable("id") int id) 
	{
		restTemplate.delete("http://order-service/order/delete/" +id , String.class);
		return "Your Order is successfully Canceled " + id;
	}


}