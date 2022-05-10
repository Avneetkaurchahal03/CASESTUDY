package com.avneet.userservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ordersdetails")
public class OrderData {
	
	@Id
	private int orderId;
    private String carName;
    private String carModel;
	private String washerName;
	private int washpackId;
	private String date;
	private Long contactno;

	
	
	
	public OrderData() {
		super();
	}
	
	//constructor
	public OrderData(int orderId, String carName, String carModel, String washerName, int washpackId, String date,
			Long contactno) {
		super();
		this.orderId = orderId;
		this.carName = carName;
		this.carModel = carModel;
		this.washerName = washerName;
		this.washpackId = washpackId;
		this.date = date;
		this.contactno = contactno;
		
	}
	
	//Getter&Setter
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getWasherName() {
		return washerName;
	}
	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}
	public int getWashpackId() {
		return washpackId;
	}
	public void setWashpackId(int washpackId) {
		this.washpackId = washpackId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getContactno() {
		return contactno;
	}
	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}

	@Override
	public String toString() {
		return "OrderData [orderId=" + orderId + ", carName=" + carName + ", carModel=" + carModel + ", washerName="
				+ washerName + ", washpackId=" + washpackId + ", date=" + date + ", contactno=" + contactno + "]";
	}
	
	
	
	
	
	

}
