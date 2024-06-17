package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.utils.HibernateUtils;

public class DeleteProductWithName {
	public static void main(String[] args) {
		
		try(SessionFactory sessionFactory = HibernateUtils.getFactory();
				Scanner scanner = new Scanner(System.in);)
		
		
		{
			ProductDao productDao = new ProductDaoImpl();
			System.out.println("Enter Product name to delete");
			
		String res	 =productDao.deleteProductByName(scanner.next());
		System.err.println(res);
			
		}

}
}
