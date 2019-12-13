package com.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.model.Order;
import com.delivery.service.DeliveryService;


@RestController
@RequestMapping("/delivery")
@CrossOrigin(origins = "http://localhost:8081")
public class DeliveryController {
	
	
	@Autowired
	DeliveryService deliveryService;	
	
	@PostMapping("/deliver")
	public String deliver(@RequestBody Order order) throws InterruptedException {		
		String response = deliveryService.deliver(order);		
		return response;		
	}

}
