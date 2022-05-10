package com.avneet.adminservice.service;

import java.util.List;

import com.avneet.adminservice.model.AdminDetails;
import com.avneet.adminservice.model.WasherPackages;
import com.avneet.adminservice.model.WasherRating;

public interface AdminService {
	
	//Admin
	public List<AdminDetails> findAll();
    public void updateadmin(AdminDetails admin);
    public void deleteadmin(int id);
    public void addadmin(AdminDetails admin);
    
    
    //WashPackage
    public void save(WasherPackages wash);
	public List<WasherPackages> getwashers();
	public void deletepack(int id);
	public void updatepacks(WasherPackages wash);
	
	
	//Rating
	public void save(WasherRating ratings);
	public List<WasherRating> findAllRatings();
	

    


}
