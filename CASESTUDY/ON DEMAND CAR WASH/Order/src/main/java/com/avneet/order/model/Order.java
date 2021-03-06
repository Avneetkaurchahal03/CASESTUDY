package com.avneet.order.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {
	
	@Min(value = 1, message = "User ID Invalid")
	private long cId;

	@Valid
	private String address;

	
	@Field
	private String status="Placed";


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date serviceDate;


	@NotNull
	private String carName;

	@NotNull
	private String carModel;

	@NotNull
	private int washPackId;
	
	private int price;

	public void setStatus(String status2) {
		// TODO Auto-generated method stub
		
	}


}
