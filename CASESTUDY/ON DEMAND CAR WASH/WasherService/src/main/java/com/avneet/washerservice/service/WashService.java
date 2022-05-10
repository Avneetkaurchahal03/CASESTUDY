package com.avneet.washerservice.service;

import java.util.List;

import com.avneet.washerservice.model.Washerdetails;

public interface WashService {
	
	public Washerdetails addWasher(Washerdetails washer);

	public List<Washerdetails> getwashers();

	public List<Washerdetails> getwasherbylocation(String location);

	public void deletewasher(Washerdetails washer);

	public int getSequenceNumber(String sequenceName); 

}


