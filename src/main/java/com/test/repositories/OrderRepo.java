package com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

}
