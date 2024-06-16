package com.sunbeam.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Refer - products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,product name(unique)  , price , available quantity

@Entity
@Table(name = "products")

public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Category category;
	@Column(length = 30,unique = true)
	private String productName;
	private int price;
	private int availableQuantity;
	
	
	public Products(Category category, String productName, int price, int availableQuantity) {
		
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}
	
	
	public Products() {
		
	}
	
	
	@Override
	public String toString() {
		return "Products [id=" + id + ", category=" + category + ", productName=" + productName + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + "]";
	}


	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
	
	

}
