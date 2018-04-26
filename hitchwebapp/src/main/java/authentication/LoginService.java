package authentication;

/*
Deborah Barndt
 Thomas Boller
 4-22-18
 RegistrationServelet.java
 Final Project
This class validates the users vs the database
*/

import geekbitjava.database.DAO;
import geekbitjava.entities.Users;

public class LoginService {
	public boolean validateUserTest(String user, String password) {
		
		//test data
		String testEmail = "xstorm@email.com";
		String testPass = "lightning";
	
		
		return user.equalsIgnoreCase(testEmail) && password.equals(testPass);
		
	}
	
	public boolean validateUser(String user, String password) {
		
		//create new dao obj
		DAO daoO = new DAO();
		
		Users testUser = daoO.getUserByEmail(user);
		
		//if the user email is found/valid
		if (testUser != null) {
			//if the username and password match
			if (testUser.getPassword().equals(password)) {
				
				System.out.println("userlogin");
				System.out.println(testUser.getEmail() + testUser.getPassword());
				
				return true;
				//if the user is valid but password does not match
			} else {
				
				System.out.println("Invalid Password");
				
				return false;
			}
			
			//if the username was not found/invalid
		} else {
			
			System.out.println("User not found");
			
			return false;
		}
		
	}

}