package com.mozoPizza.service;

import org.springframework.http.ResponseEntity;

import com.mozoPizza.model.Order;



public interface OrdererService {

	ResponseEntity<String> create(Order order);



}
