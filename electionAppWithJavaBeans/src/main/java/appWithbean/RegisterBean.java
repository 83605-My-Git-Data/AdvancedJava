package appWithbean;

import java.sql.Date;
import java.sql.PreparedStatement;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegisterBean {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	private String role;
	
	
	private int count;
	
	
	public RegisterBean() {
		
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}



	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public void registerMe() {
		Date bDate = Date.valueOf(dob);
		User user = new User(firstName, lastName, email, password, bDate, count, role);
		try(UserDao dao = new UserDaoImpl()) {
			count = dao.save(user);
			
			setCount(count);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
