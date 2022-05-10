package com.avneet.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avneet.customer.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
	
	   Customer findBycEmail(String cEmail);

}

