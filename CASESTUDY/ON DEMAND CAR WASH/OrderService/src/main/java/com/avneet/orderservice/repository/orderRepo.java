package com.avneet.orderservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avneet.orderservice.model.OrderData;

@Repository
public interface orderRepo extends MongoRepository<OrderData,Integer> {
	
	boolean save(int id);
}

