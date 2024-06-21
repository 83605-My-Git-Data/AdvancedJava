package com.sunbeam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Product;


@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Product> getProducts(double startPrice, double endPrice) {
		
		String jpql = "select p from Product p where p.price between :s and :e";
		
		return factory.getCurrentSession().createQuery(jpql, Product.class)
				.setParameter("s", startPrice)
				.setParameter("e", endPrice)
				.getResultList();
		
	}

}
