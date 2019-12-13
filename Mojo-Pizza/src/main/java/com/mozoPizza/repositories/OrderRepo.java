package com.mozoPizza.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mozoPizza.model.Order;


@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

	void save(Optional<Order> dBorder);

	@Query(value ="SELECT * FROM order_master o WHERE o.status = ?1", nativeQuery = true)
	Collection<Order> findByStatus(String Inprocess);

}
