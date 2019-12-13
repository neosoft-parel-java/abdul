package com.kitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kitchen.model.Order;
import com.kitchen.service.KitchenService;

@RestController
@RequestMapping("/kitchen")
@CrossOrigin(origins = "http://localhost:8080")
public class KitchenController {
	
	@Autowired
	KitchenService  kichenService;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Order order) throws InterruptedException {		
		String response = kichenService.create(order);		
		return new ResponseEntity<>(response, HttpStatus.OK);		
	}
	

}
