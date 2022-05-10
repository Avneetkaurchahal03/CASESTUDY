package com.avneet.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.avneet.admin.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, Integer> {
	
	Admin findByaEmail(String aEmail);

}
