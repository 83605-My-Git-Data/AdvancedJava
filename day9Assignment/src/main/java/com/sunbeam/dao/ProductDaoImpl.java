package com.sunbeam.dao;


import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional.TxType;

import org.hibernate.*;

import com.sunbeam.pojos.Category;
import com.sunbeam.pojos.Products;
import com.sunbeam.utils.HibernateUtils;
import com.sunbeam.utils.HibernateUtils.*;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void insertProduct(Products products) {
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		
		try {
			Serializable serializable = session.save(products);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null)
				transaction.rollback();
			
			throw e;
		}
		
		
	
		
	}

	@Override
	public Products getDetailsById(Long id) {
		
		Products products = null;
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		try {
			products = session.get(Products.class, id);
			transaction.commit();
		}
		catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
				throw e;
			}
			
		}
		return products;
		
		
	}

	@Override
	public List<Products> getDetailsWithRange(int startPrice, int endPrice, Category category) {
		
		List<Products> list = null;
		
		String jspl = "select p from Products p where p.price between :start and :end and p.category = :cat";
		
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		try {
			list = session.createQuery(jspl, Products.class).setParameter("start", startPrice)
					.setParameter("end", endPrice)
					.setParameter("cat", category)
					.getResultList();
			
			transaction.commit();
			
		}
		catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
				throw e;
			}
		}
		
		return list;
		
	}

	@Override
	public String applyProductDiscount(int discount, Category category) {
		int count =  Integer.MIN_VALUE;
		
		String jspl = 
		"update Products p set p.price = p.price- :disc where p.category = :cat";
		
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		try {
			count = session.createQuery(jspl).setParameter("disc", discount)
					.setParameter("cat", category)
					.executeUpdate();
			
			transaction.commit();
		}
		catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return "Discount given to total of "+count+"products";
		
		
	}

	@Override
	public String purchaseProduct(Long id, int quantity) {
		
		Products product = null;
		String message = "";
		int count = 0;
		
		
		Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		try {
			product =  session.get(Products.class, id);
			
			if(product.getAvailableQuantity()<quantity) {
				message += "Not sufficient stock...";
			}
			else if(product.getAvailableQuantity()>quantity){
				String jspl =
				"update Products p set p.availableQuantity = p.availableQuantity - :qt where p.id = :id";
				
			count = 	session.createQuery(jspl).setParameter("id", id)
				.setParameter("qt", quantity)
				.executeUpdate();
			
			message += "Purchase successful";
			
			transaction.commit();
			
				
			}
		}
		catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return message;
		
	}

	@Override
	public String deleteProductByName(String productName) {
		
      Session session = HibernateUtils.getFactory().getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		Products product = null;
		
		String messageString ="";
	
		
        
		
		String jspl = "select p from Products p where productName = :name ";
		
		
		try {
			product = session.createQuery(jspl, Products.class)
					.setParameter("name", productName).getSingleResult();
			
			session.delete(product);
			 messageString = "Successfully deleted product";
			
			transaction.commit();
			
			
			
		}
		catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			throw e;
		}
		
		return messageString;
		
		
	}
	
	
	

}
