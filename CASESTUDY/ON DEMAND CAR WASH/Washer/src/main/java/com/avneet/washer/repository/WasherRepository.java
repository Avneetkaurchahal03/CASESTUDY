package com.avneet.washer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avneet.washer.model.Washer;

@Repository
public interface WasherRepository extends MongoRepository<Washer, String> {
	
	Washer findBywEmail(String wEmail);

}
