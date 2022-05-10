package com.avneet.washerservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.avneet.washerservice.model.Washerdetails;

public interface WasherRepository extends MongoRepository<Washerdetails, Integer> 
{

	List<Washerdetails> findBylocation(String location);
	
	Washerdetails findByName(String name);

	boolean save(int id);

	void deleteById(Long id);

	boolean existsById(Long id);
	
}
