package com.sunbeam.beans;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Product;

public class PurchaseBean {
	
	private Long id;
	private int quantity;
	 private ProductDao productDao;
	
	public PurchaseBean() {
		 productDao = new ProductDaoImpl();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public void purchaseProduct() {
		String msgString = "Product purchase failed";
	
		System.out.println("inside purchase"+id);
		Product product = productDao.getProductDetails(id);
		
		if(product.getAvailableQty()>= quantity) {
			productDao.purchaseProduct(id, quantity);
			msgString="Product purchased succssfully";
		}
		 
		System.out.println(msgString);
		
		
	}

}
