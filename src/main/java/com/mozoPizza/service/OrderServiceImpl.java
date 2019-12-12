package com.mozoPizza.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mozoPizza.exceptions.BadRequestException;
import com.mozoPizza.exceptions.GlobalExceptionHandler;
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
		
		new Thread(
				() -> orderRepo.save(order)
				).start();
		
		logger.info("Order saved successfully");

	/*	Order dbOrder = orderRepo.findById(order.getId()).orElseThrow(() -> new BadRequestException("No Order found"));
		if (dbOrder != null)
			logger.info("Order recieved");
		logger.info("Notification to Kitchen ");*/
		
		HttpEntity<Order> request = new HttpEntity<>(order);
		
		new Thread(
				() -> orderRepo.save(order)
				).start();
	
		ResponseEntity<String> response  = template.exchange("http://localhost:8081/kitchen/create", HttpMethod.POST,
						request, String.class);				
				
		return response.getBody();

	}

	public String update(Order order) {

		Order dbOrder = orderRepo.findById(order.getId()).orElseThrow(() -> new BadRequestException("No Order found"));
		if (dbOrder != null) {

			dbOrder.setStatus("Delivered");
			orderRepo.save(dbOrder);		}

		return "Delivery is Successfull for order "+dbOrder.getId();
	}

}
