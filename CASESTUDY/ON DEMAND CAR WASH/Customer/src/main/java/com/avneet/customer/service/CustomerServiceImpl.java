package com.avneet.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.avneet.customer.model.Customer;
import com.avneet.customer.repository.CustomerRepository;
import com.avneet.customer.service.CustomerServiceImp;

@Service
public class CustomerServiceImpl implements CustomerServiceImp, UserDetailsService{

	@Autowired
	private CustomerRepository customerRepository;
	

	//For CREATING/ADDING  Customer 
	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	
     //For getting All Customers
	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers =customerRepository.findAll();
		System.out.println("Getting Customers from DB" + customers);
		return customers;
	}
	
	
	 //For getting  Customers by
	
	public Optional<Customer> findById(String id) {
		return customerRepository.findById(id);
		
		
	}
	
	//For updating By Id
	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
		
	}

	//For deleting By Id
	@Override
	public void deleteById(String id) {
		customerRepository.deleteById(id);
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer foundedCustomer = customerRepository.findBycEmail(username);
		
		if  (foundedCustomer ==null) return null;
		String cEmail = foundedCustomer.getcEmail();
		String cPassword = foundedCustomer.getcPassword();
		return new User(cEmail, cPassword, new ArrayList<>());
	}
	
	
	
	
	
}