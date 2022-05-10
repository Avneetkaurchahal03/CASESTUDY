package com.avneet.customer.service;

import java.util.List;
import java.util.Optional;

import com.avneet.customer.model.Customer;

public interface CustomerServiceImp {
	
	public Customer addCustomer(Customer customer);
	
	
     //For getting All Customers
	public List<Customer> getCustomers() ;
	
	
	 //For getting  Customers by
	
	public Optional<Customer> findById(String id);
	
	//For updating By Id
	public void save(Customer customer);

	//For deleting By Id
	public void deleteById(String id);

}
