package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.pojos.Category;
import com.sunbeam.pojos.Products;

public interface ProductDao {
	void insertProduct(Products products);
	Products getDetailsById(Long id);
	List<Products> getDetailsWithRange(int startPrice,int endPrice,Category category);
	String applyProductDiscount(int discount,Category category);
	String purchaseProduct(Long id,int quantity);
	String deleteProductByName(String productName);

}
