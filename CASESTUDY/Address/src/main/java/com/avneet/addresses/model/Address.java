package com.avneet.addresses.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="address")
public class Address {
	
	@Id
	@NotNull
	private long cId;
	private int houseNumber;
	@Size(max=20)
	private String streetName;
	private String colonyName;
	private String city;
	private String state;
	@NotNull
	private int pincode;
	
	//no-parameterised constructor
	public Address() {
		super();
	}
	
	
	//parameterised constructor
	public Address(long cId, int houseNumber, String streetName, String colonyName, String city, String state,
			int pincode) {
		super();
		this.cId = cId;
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.colonyName = colonyName;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	
	
	//getters&Setters
	public long getcId() {
		return cId;
	}
	public void setcId(long cId) {
		this.cId = cId;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getColonyName() {
		return colonyName;
	}
	public void setColonyName(String colonyName) {
		this.colonyName = colonyName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	

}
