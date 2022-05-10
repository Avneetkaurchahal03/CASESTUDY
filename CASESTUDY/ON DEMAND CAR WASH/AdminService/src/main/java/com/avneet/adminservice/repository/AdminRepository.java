package com.avneet.adminservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avneet.adminservice.model.AdminDetails;

@Repository
public interface AdminRepository extends MongoRepository<AdminDetails, Integer> {
	List<AdminDetails> findAll();

}
