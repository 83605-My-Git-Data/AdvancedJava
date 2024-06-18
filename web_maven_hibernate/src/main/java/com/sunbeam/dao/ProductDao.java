package com.sunbeam.dao;

import com.sunbeam.entities.Product;

public interface ProductDao {
	
	String addProduct(Long categoryId,Product newProduct);
	Product getProductDetails(Long productId);
	void purchaseProduct(Long productId,int quantity);

}
