package com.avneet.orderservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orders")
public class OrderData {
	
	@Id
	private int orderId;
    private String carName;
    private String carModel;
	private String washerName;
	private int washpackId;
	private String date;
	private Long contactno;
	private String address;
	
	
	
	public OrderData() {
		super();
	}
	
	//constructor
	public OrderData(int orderId, String carName, String carModel, String washerName, int washpackId, String date,
			Long contactno, String address) {
		super();
		this.orderId = orderId;
		this.carName = carName;
		this.carModel = carModel;
		this.washerName = washerName;
		this.washpackId = washpackId;
		this.date = date;
		this.contactno = contactno;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OrderData [orderId=" + orderId + ", carName=" + carName + ", carModel=" + carModel + ", washerName="
				+ washerName + ", washpackId=" + washpackId + ", date=" + date + ", contactno=" + contactno
				+ ", address=" + address + "]";
	}
	
	
	
	

}
