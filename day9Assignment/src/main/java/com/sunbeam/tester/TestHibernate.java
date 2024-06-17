package com.sunbeam.tester;


import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.*;


public class TestHibernate {
	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory()){
			System.out.println("My hibernate is up..!!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
