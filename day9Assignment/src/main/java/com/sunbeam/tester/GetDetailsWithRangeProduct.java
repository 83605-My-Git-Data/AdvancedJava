package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.pojos.Category;
import com.sunbeam.utils.HibernateUtils;

public class GetDetailsWithRangeProduct {
	
	public static void main(String[] args) {
		
		try(SessionFactory sessionFactory = HibernateUtils.getFactory();
				Scanner scanner = new Scanner(System.in);){
			
			ProductDao productDao = new ProductDaoImpl();
			System.out.println("enter start price and end price followed by category");
			
			productDao.getDetailsWithRange(scanner.nextInt(), scanner.nextInt(), Category.valueOf(scanner.next().toUpperCase())).forEach(System.out::println);;
			
			
		}
	}

	
}
