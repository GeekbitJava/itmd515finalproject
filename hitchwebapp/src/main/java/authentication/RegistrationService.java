package authentication;


/*
Deborah Barndt
 Thomas Boller
 4-22-18
 RegistrationService.java
 Final Project
This class will take data from the registration servlet gained from the register.jsp and send it to the database
*/

import geekbitjava.database.DAO;
import geekbitjava.entities.Payment;
import geekbitjava.entities.Users;


public class RegistrationService {

	public Users registerUser(Users tmpusr) {
		
		//create new dao obj
		DAO daoO = new DAO();
		
		//posts data to the database
		daoO.insertSingleUsers(tmpusr);
		
		//create a user testUser to send back to registration
		Users testUser = daoO.getUserByEmail(tmpusr.getEmail());
		
		return testUser;
	}
	
	public void registerPayment(Payment tmppay) {
		
		//create new dao obj
		DAO daoO = new DAO();
		
		//posts data to the database
		daoO.insertSinglePayment(tmppay);
		
		System.out.println("User payment registered");
		

	}

}
