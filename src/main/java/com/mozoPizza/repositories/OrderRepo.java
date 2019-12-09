package com.mozoPizza.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mozoPizza.model.Order;


@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

	void save(Optional<Order> dBorder);

}
