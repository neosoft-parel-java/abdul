package com.kitchen.service;

import com.kitchen.model.Order;

public interface KitchenService {

	String create(Order order) throws InterruptedException;
	

}
