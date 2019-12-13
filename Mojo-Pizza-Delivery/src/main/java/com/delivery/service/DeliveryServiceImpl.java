package com.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.delivery.model.Order;






@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private RestTemplate template;

	@Override
	public String deliver(Order order) throws InterruptedException {

		Thread.sleep(5000L);
		
		HttpEntity<Order> request = new HttpEntity<>(order);
		
		ResponseEntity<String> response =  template.exchange("http://localhost:8080/MoJoPizza/update", HttpMethod.PUT, request, String.class);
		
		return response.getBody();
	}
	
}


