package geekbitjava.test;

import geekbitjava.database.DAO;
import geekbitjava.entities.Users;

public class TestHQL {
	
	public static void main(String[] args) {
		
		
		DAO daoO = new DAO();
		
		String testEmail = "xstorm@email.com";
		String testPass = "lightning";
		
		Users testUser = daoO.getUserByEmail(testEmail);
		
		
		if (testUser != null) {
			if (testUser.getPassword().equals(testPass)) {
				System.out.println("userlogin");
			} else {
				System.out.println("false user");
			}
			
			System.out.println(testUser.getPassword());
		} else {
			
			System.out.println("User not found");
		}
		
	}

}
