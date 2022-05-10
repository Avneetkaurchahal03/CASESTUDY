package com.avneet.washerservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Washdetails")
public class Washerdetails {

	@Id
	private Long id;
	private String name;
	private String location;
	
	//default constructor
	public Washerdetails() {
		super();
	}
	
	
	//parametrised constructor
	public Washerdetails(Long id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	

	//getters&setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
