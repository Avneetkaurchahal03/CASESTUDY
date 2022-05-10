package com.avneet.orderservice.service;

import java.util.List;

import com.avneet.orderservice.model.OrderData;

public interface OrderService {
	

	public List<OrderData> details();
	public void addOrder(OrderData order);
	
	

}
