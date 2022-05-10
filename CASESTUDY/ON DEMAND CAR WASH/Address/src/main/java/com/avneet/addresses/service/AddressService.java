package com.avneet.addresses.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avneet.addresses.model.Address;
import com.avneet.addresses.repository.AddressRepository;

@Service
public class AddressService {

	private AddressRepository addressRepository;
	
	public Address addAddress(Address address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}

	
	public List<Address> getAddresses() {
		// TODO Auto-generated method stub
		List<Address> address= addressRepository.findAll();
		System.out.println("Getting Address from DB" + address);
		return address;
	}

}
