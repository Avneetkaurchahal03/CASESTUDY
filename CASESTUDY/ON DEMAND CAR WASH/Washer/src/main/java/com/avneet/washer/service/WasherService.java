package com.avneet.washer.service;

import java.util.List;
import java.util.Optional;

import com.avneet.washer.model.Washer;

public interface WasherService {
	
	public Washer addwasher(Washer washer);
	public List<Washer> getWashers() ;
	public Optional<Washer> findById(String id) ;
	public void save(Washer washer) ;
	public void deleteById(String id);
}
