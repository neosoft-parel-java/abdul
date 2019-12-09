package com.mozoPizza.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	RestTemplate template;

	@Override
	public ResponseEntity<String> create(Order order) {

		order.setStatus("Inprocess");
		orderRepo.save(order);
		logger.info("Order saved successfully");

		Order dbOrder = orderRepo.findById(order.getId())
				.orElseThrow(() -> new OrderNotFoundException("No Order found"));
		if (dbOrder != null)
			logger.info("Order recieved");
		logger.info("Notification to Kitchen ");

		ResponseEntity<String> response = template.postForEntity("http://localhost:8081/kitchen/create", order,
				String.class);
		
		return response;

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
