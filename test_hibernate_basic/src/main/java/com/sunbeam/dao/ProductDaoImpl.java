package com.sunbeam.dao;


import java.io.Serializable;

import org.hibernate.*;

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
	
	
	

}
