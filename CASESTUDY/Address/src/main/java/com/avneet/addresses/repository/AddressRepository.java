package com.avneet.addresses.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.avneet.addresses.model.Address;

public interface AddressRepository extends MongoRepository<Address, Long> {

}
