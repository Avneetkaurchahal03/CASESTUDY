package com.avneet.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.avneet.admin.model.Admin;
import com.avneet.admin.repository.AdminRepository;

@Service
public class AdminService implements UserDetailsService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin foundedAdmin = adminRepository.findByaEmail(username);
		
		if  (foundedAdmin ==null) return null;
		String aEmail = foundedAdmin.getaEmail();
		String aPassword = foundedAdmin.getaPassword();
		return new User(aEmail, aPassword, new ArrayList<>());
	}

}


