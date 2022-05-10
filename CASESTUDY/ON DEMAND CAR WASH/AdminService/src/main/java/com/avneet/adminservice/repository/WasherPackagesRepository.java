package com.avneet.adminservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.avneet.adminservice.model.WasherPackages;

@Repository
public interface WasherPackagesRepository extends MongoRepository<WasherPackages, Integer> {

}


