package com.avneet.washer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.avneet.washer.model.Washer;
import com.avneet.washer.repository.WasherRepository;
import com.avneet.washer.service.WasherService;

@Service
public class WasherServiceImp implements WasherService, UserDetailsService {
	
	@Autowired
	private WasherRepository washerRepository;
    
	//For CREATING/ADDING  Customer 
		public Washer addwasher(Washer washer) {
			return washerRepository.save(washer);
			
		}
	
		
		
	//
	public List<Washer> getWashers() {
		List<Washer> washer= washerRepository.findAll();
		System.out.println("Getting Washer from DB" + washer);
		return washer;
	}
	
	
	
	public Optional<Washer> findById(String id) {
		return washerRepository.findById(id);
	}


	public void save(Washer washer) {
		// TODO Auto-generated method stub
		washerRepository.save(washer);
		
		
	}


	public void deleteById(String id) {
		washerRepository.deleteById(id);
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Washer foundedWasher = washerRepository.findBywEmail(username);
		
		if  (foundedWasher ==null) return null;
		String wEmail = foundedWasher.getwEmail();
		String wPassword = foundedWasher.getwPassword();
		return new User(wEmail, wPassword, new ArrayList<>());
	}


}
