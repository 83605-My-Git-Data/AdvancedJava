package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.entities.User;

public class RegisterBean {
	
	private String name;
	private String email;
	private String password;
	private String phone;
	private int count; 
	
	
	
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public RegisterBean() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void register() {
		System.out.println("inside register");
		try(UserDao userDao = new UserDao()){
			User user = new User(0, name, email, password, phone, null);
			count =  userDao.save(user);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
