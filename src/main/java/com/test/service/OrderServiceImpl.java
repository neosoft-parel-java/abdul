package com.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.exceptions.OrderNotFoundException;
import com.test.model.Order;
import com.test.repositories.KitchenRepo;
import com.test.repositories.OrderRepo;


@Service
public class OrderServiceImpl implements OrdererService {

	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	KitchenRepo kitchenRepo;

	@Override
	public String create(Order order) {	
				
		 orderRepo.save(order);
		
		 Order DbOrder = orderRepo.findById(order.getId())
				 .orElseThrow(() -> new OrderNotFoundException("No Order found"));
		
		if(DbOrder != null) {
								
			logger.info("Order recieved");
			
			
			
		}
		
		
		logger.info("Order saved successfully");
		
		return null;
	}

}
