package com.mozoPizza.service;

import com.mozoPizza.model.Order;



public interface OrdererService {

	String create(Order order);

	String update(Order order);



}
