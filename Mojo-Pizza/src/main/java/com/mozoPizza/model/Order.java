package com.mozoPizza.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;



@Entity
@Table(name = "order_master")
public class Order {
	
	@Id
	@GeneratedValue
	private long id;

	@Min(value = 01, message = "Quantity should be atleast 1")
	private int quantity;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "location")
	private LocationEnum location = LocationEnum.BYCULLA;	
			
	private String name;	
	
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocationEnum getLocation() {
		return location;
	}

	public void setLocation(LocationEnum location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}  	
	
	
	

}
