package com.javawebtutor.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_TABLE")
public class Product  implements Serializable {
	@Id @GeneratedValue
    private Long id;
	private String name;
	private String description;
	
	private float   price;
	private int stock;
	
	private float  aproxPrice;
	public Product(){
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getAproxPrice() {
		return aproxPrice;
	}
	public void setAproxPrice(float aproxPrice) {
		this.aproxPrice = aproxPrice;
	}
	public Product(Long id, String name, String description, float price,
			int stock, float aproxPrice) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.aproxPrice = aproxPrice;
	}
	public Product(String name, String description, float price, int stock,
			float aproxPrice) {

		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.aproxPrice = aproxPrice;
	}
	
	
	
	
	
	
}
