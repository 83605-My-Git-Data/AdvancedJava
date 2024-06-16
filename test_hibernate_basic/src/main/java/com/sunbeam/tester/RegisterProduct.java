package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

import com.sunbeam.pojos.Category;
import com.sunbeam.pojos.Products;

public class RegisterProduct {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)
				) {
			//create dao instance
			ProductDao dao=new ProductDaoImpl();
			System.out.println("Enter product details -ProductName, Price, \r\n"
					+ "			 Category, availablequantity"
					);
			
			
			Products products = new Products(Category.valueOf(sc.next().toUpperCase()), sc.next(), sc.nextInt(), sc.nextInt());
			
			dao.insertProduct(products);
//			
		} //JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
