package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.utils.HibernateUtils;

public class PurchaseProduct {
	public static void main(String[] args) {
		
		try(SessionFactory sessionFactory = HibernateUtils.getFactory();
				Scanner scanner = new Scanner(System.in);)
		
		
		{
			ProductDao productDao = new ProductDaoImpl();
			System.out.println("Enter id and quantity to purchase");
			
		String res	 =productDao.purchaseProduct(scanner.nextLong(), scanner.nextInt());
		System.err.println(res);
			
		}
	}

}
