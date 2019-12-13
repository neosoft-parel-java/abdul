package com.mozoPizza.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mozoPizza.model.Order;
import com.mozoPizza.service.OrdererService;

@RestController
@RequestMapping("MoJoPizza")
@CrossOrigin(origins = "http://localhost:8089")
public class OrderController {

	@Autowired
	OrdererService orderService;	
	
	
	@PostMapping("/order")
	public ResponseEntity<String> orderAccept(@Valid @RequestBody Order order) {		
		
		String response = orderService.orderAccept(order);		
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);		
	}
	
	
	/*@PostMapping("/create")
	@Scheduled(fixedRate = 1000)
	public ResponseEntity<String> create(@Valid @RequestBody Order order) {				
		String response = orderService.create(order);				
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);		
	}
	*/

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Order order) {					
		String response = orderService.update(order);
		return new ResponseEntity<>(response, HttpStatus.OK);		
	}
	
}
