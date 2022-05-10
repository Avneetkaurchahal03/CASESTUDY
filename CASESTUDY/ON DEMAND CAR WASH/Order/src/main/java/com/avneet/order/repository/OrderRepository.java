package com.avneet.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.avneet.order.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
	
	
	//The @Query annotation declares finder queries directly on repository methods.Spring Data JPA @Query annotation is used on Repository interface.
	//This frees the domain classes from persistence specific information, which is a good thing.
	@Query("{cId:?0}")
	List<Order> findByCustomerId(long cId);
	
	@Query("{wId:?0}")
	List<Order> findByWasherId(long wId);

	@Query("{ status : { $regex : ?0 } }")
	List<Order> findOrderByStatus(String status);

}
