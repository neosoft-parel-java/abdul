package com.mozoPizza.service;

import java.util.Collection;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mozoPizza.exceptions.BadRequestException;
import com.mozoPizza.model.Order;
import com.mozoPizza.repositories.OrderRepo;


@Configuration
@EnableScheduling
@Service
public class OrderServiceImpl implements OrdererService {

	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	private RestTemplate template;

	
	@Override
	public String orderAccept(@Valid Order order) {
		
		order.setStatus("orderIn");
		orderRepo.save(order);		
		
		return "Thanks for choosing MOJO Pizza, your Order has been accepted";
	}
	
	

	@Scheduled(fixedRate = 1000)
	public String create() {
		Order order = null;
		String status = "Inprocess";
		
		Collection<Order> dbOrder = orderRepo.findByStatus(status);
		
		System.out.println(dbOrder.size());
		if(dbOrder != null) {
						
			
		}
		
		
	//	 orderRepo.save(order);
		
		logger.info("Order saved successfully");	
		
		HttpEntity<Order> request = new HttpEntity<>(order);
			
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
