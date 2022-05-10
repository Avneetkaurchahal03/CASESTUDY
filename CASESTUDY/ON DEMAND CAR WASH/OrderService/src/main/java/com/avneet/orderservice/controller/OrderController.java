package com.avneet.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avneet.orderservice.exception.ApiRequestException;
import com.avneet.orderservice.model.OrderData;
import com.avneet.orderservice.repository.orderRepo;
import com.avneet.orderservice.service.OrderServiceImpl;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/od")
public class OrderController {
	
	@Autowired
	private OrderServiceImpl service;
	
	
	@Autowired
	private orderRepo repo;
	
	 @PostMapping("/addorder") 
	//ApiOperation(value="To add order")
	  public String addOrder(@RequestBody OrderData order) {
		  service.addOrder(order); 
		 
		  return "order placed with washer and will be processed soon  " +order; }
	 
	 
	 @GetMapping("/allorders")
	// @ApiOperation(value="To get List of all orders")
	 public List<OrderData> getorder() {
	 return service.details();
	 }
	 
	
	 @DeleteMapping("/cancelorder")
	 //@ApiOperation(value="To cancel order")
	 public ResponseEntity<Object> deletorder(@RequestParam int id)
	 {
		 boolean isOrderExist=repo.existsById(id);
		 if(isOrderExist) {
			 service.deleteById(id);
			 return new ResponseEntity<Object>("Order deleted with id "+id,HttpStatus.OK);
		 }
		 else
		 {
			 throw new ApiRequestException("CAN NOT DELETE ORDER,AS ORDER NOT FOUND WITH THIS ID ::");
		 }
	 }
}

