package com.avneet.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.avneet.userservice.model.UserLogin;

public interface userRepository extends MongoRepository<UserLogin, Integer>{
	
	boolean save(int id);
	UserLogin findByName(String name);

}