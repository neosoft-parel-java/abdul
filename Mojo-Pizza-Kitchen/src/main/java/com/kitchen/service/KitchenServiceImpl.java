package com.kitchen.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kitchen.model.Order;



@Service
public class KitchenServiceImpl implements KitchenService{


	RestTemplate template = new RestTemplate();
		
	@Override
	public String create(Order order) throws InterruptedException {	
		
		Thread.sleep(5000L);
		
		
	HttpEntity<Order> request = new HttpEntity<>(order);
		
	 ResponseEntity<String> response = template.exchange("http://localhost:8089/delivery/deliver", HttpMethod.POST, request, String.class);
			
			
		return response.getBody() ;
	}

}
