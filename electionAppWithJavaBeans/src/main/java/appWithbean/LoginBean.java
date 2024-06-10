package appWithbean;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	
	private String email;
	private String password;
	
	private int count;
	
	public LoginBean() {
		
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public void loginMe() {
		UserDao userDao;
		try {
			userDao = new UserDaoImpl();
		User user =	userDao.findByEmail(email);
		if(user != null && user.getPassword().equals(password)) {
			
			if(user.getRole().equals("voter")) {
				res.sendRedirect("candlist");
			}
		}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
