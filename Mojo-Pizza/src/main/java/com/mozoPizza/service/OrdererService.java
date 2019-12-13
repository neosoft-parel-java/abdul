package com.mozoPizza.service;

import javax.validation.Valid;

import com.mozoPizza.model.Order;



public interface OrdererService {

//	String create(Order order);

	String update(Order order);

	String orderAccept(@Valid Order order);



}
