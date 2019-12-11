package com.mozoPizza.service;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mozoPizza.exceptions.OrderNotFoundException;
import com.mozoPizza.model.Order;
import com.mozoPizza.repositories.OrderRepo;

@Service
public class OrderServiceImpl implements OrdererService {

	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	private RestTemplate template;

	@Override
	public String create(Order order) {

		order.setStatus("Inprocess");
		orderRepo.save(order);
		logger.info("Order saved successfully");

		Order dbOrder = orderRepo.findById(order.getId())
				.orElseThrow(() -> new OrderNotFoundException("No Order found"));
		if (dbOrder != null)
			logger.info("Order recieved");
		logger.info("Notification to Kitchen ");

		
		HttpEntity<Order> request = new HttpEntity<>(order);
		
		ResponseEntity<Order> response = template
				  .exchange("http://localhost:8081/kitchen/create", HttpMethod.POST, request, Order.class);
		
		/*Order  response = template.postForEntity("http://localhost:8081/kitchen/create", request,
				Order.class);*/
		
		return response.toString();

	}

	public String update(Order order) {

		Order dbOrder = orderRepo.findById(order.getId())
				.orElseThrow(() -> new OrderNotFoundException("No Order found"));
		if (dbOrder != null) {

			order.setStatus("Delivered");
			orderRepo.save(order);
		}

		return null;
	}

}
