package com.delivery.service;

import com.delivery.model.Order;

public interface DeliveryService {

	String deliver(Order order) throws InterruptedException;

	

}
