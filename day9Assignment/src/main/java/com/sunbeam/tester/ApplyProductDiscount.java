package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.pojos.Category;
import com.sunbeam.utils.HibernateUtils;

public class ApplyProductDiscount {
	public static void main(String[] args) {
		
		try(SessionFactory sessionFactory = HibernateUtils.getFactory();
				Scanner scanner = new Scanner(System.in);)
		{
			
			ProductDao productDao = new ProductDaoImpl();
			System.out.println("Enter discount and category to applied on it");
		String returnString =	productDao.applyProductDiscount(scanner.nextInt() ,Category.valueOf(scanner.next().toUpperCase()));
		System.out.println(returnString);
			
			
		}
		
	}

}
