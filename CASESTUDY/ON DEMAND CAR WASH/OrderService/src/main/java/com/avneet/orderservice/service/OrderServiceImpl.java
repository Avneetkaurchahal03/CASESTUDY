package com.avneet.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avneet.orderservice.model.OrderData;
import com.avneet.orderservice.repository.orderRepo;

@Service
public class OrderServiceImpl implements OrderService {

		@Autowired
		private orderRepo repo;

		

		@Override
		public void addOrder(OrderData order) {
			// TODO Auto-generated method stub
			repo.save(order);
		}


		public void deleteById(int id) {
			// TODO Auto-generated method stub
			repo.deleteById(id);;
		}



		@Override
		public List<OrderData> details() {
			// TODO Auto-generated method stub
			return repo.findAll();
		}
}


