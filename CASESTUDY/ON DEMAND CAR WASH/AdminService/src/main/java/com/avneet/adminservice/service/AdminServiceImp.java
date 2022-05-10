package com.avneet.adminservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avneet.adminservice.model.AdminDetails;
import com.avneet.adminservice.model.WasherPackages;
import com.avneet.adminservice.model.WasherRating;
import com.avneet.adminservice.repository.AdminRepository;
import com.avneet.adminservice.repository.RatingRepository;
import com.avneet.adminservice.repository.WasherPackagesRepository;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired
	private AdminRepository repo;
	
	@Autowired
	private WasherPackagesRepository repo1;
	
	@Autowired
	private RatingRepository repo2;

	//Admin
	public List<AdminDetails> findAll() {
		return repo.findAll();
	}



	public void updateadmin(AdminDetails admin) {
		repo.save(admin);
	}

	public void deleteadmin(int id) {
		repo.deleteById(id);
	}

	
	public void addadmin(AdminDetails admin) {
		repo.save(admin);
	}


//washerPackages
	
	@Override
	public void save(WasherPackages wash) {
		// TODO Auto-generated method stub
		repo1.save(wash);
	}
		



	@Override
	public List<WasherPackages> getwashers() {
		// TODO Auto-generated method stub
		List<WasherPackages> washer =repo1.findAll();
		System.out.println("Getting data from DB :" +washer);
		return washer;
	}



	@Override
	public void deletepack(int id) {
		// TODO Auto-generated method stub
		repo1.deleteById(id);
		
	}



	@Override
	public void updatepacks(WasherPackages wash) {
		// TODO Auto-generated method stub
		repo1.save(wash);
		
	}


//Ratings
	@Override
	public void save(WasherRating ratings) {
		// TODO Auto-generated method stub
		repo2.save(ratings);
		
	}



	@Override
	public List<WasherRating> findAllRatings() {
		// TODO Auto-generated method stub
		return repo2.findAll();
	}
	
	
	
	
	
	
	

}
