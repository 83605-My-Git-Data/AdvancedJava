package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

import utils.HibernateUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Long categoryId, Product newProduct) {
		
		String message= "Adding product failed";
		// 1. get session from SF (getCurrentSession)
				Session session=HibernateUtils.getFactory().getCurrentSession();
				//2. Begin a Tx
				Transaction tx=session.beginTransaction();
				try {
					
//					session.persist(newProduct); //will throw expception of foreign key
					
					// get category from its id;
					
					Category category = session.get(Category.class, categoryId);
					
					if(category != null) {
						//vallid category
						//part of l1 cache
						
						//now establish bi direction asssociation between cateogry and product
						
						category.addProduct(newProduct);//state of category is changed
						//now session.persist(newProduct) is not required since cascade likha hai
						message ="added the product !";
					}
					
					tx.commit();
					
					//session.flush() ->dirty chceking ->category modified->new product entity added 
					//hibernate will automatically fire insert query
				} catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					//re throw the exc to the caller
					throw e;
				}
				
				return message;
	}

	@Override
	public Product getProductDetails(Long productId) {
		
		Product product = null;
		// 1. get session from SF (getCurrentSession)
				Session session= HibernateUtils.getFactory().getCurrentSession();
				//2. Begin a Tx
				Transaction tx=session.beginTransaction();
				try {
					
					 product = session.get(Product.class, productId);
					
					tx.commit();
				} catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					//re throw the exc to the caller
					throw e;
				}
				
				return product;
	}

	@Override
	public void purchaseProduct(Long productId,int quantity) {
		
		
		// 1. get session from SF (getCurrentSession)
				Session session=HibernateUtils.getFactory().getCurrentSession();
				//2. Begin a Tx
				Transaction tx=session.beginTransaction();
				try {
					
					
					String jsql = "update Product p set p.availableQty = p.availableQty - :qt where p.id = :id";
					
					session.createQuery(jsql).setParameter("qt", quantity).setParameter("id", productId).executeUpdate();
					
					
					
					tx.commit();
					
					
					
					
					
				} catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					//re throw the exc to the caller
					throw e;
				}
				
		
	}
	
	

}
