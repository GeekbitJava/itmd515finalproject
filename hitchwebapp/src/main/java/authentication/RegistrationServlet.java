package authentication;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import geekbitjava.entities.Payment;
import geekbitjava.entities.Users;

/*
	Deborah Barndt
	 Thomas Boller
	 4-22-18
	 RegistrationServelet.java
	 Final Project
	This class works with the register jsp pages and registration services to allow for a user to register
*/

@WebServlet(urlPatterns = "/registration.do")
public class RegistrationServlet extends HttpServlet {

	
	private RegistrationService service = new RegistrationService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		//create temporary user and payment obj
		Payment tmppay = new Payment();
		Users tmpusr = new Users();
		System.out.println("Created Temp User and Payment");
		
		//Populate the tmpusr with the forms user information
		tmpusr.setFirstName(request.getParameter("fname"));
		tmpusr.setLastName(request.getParameter("lname"));
		tmpusr.setEmail(request.getParameter("email"));
		tmpusr.setPassword(request.getParameter("password"));
		
		//all initial users will be of type customer, type driver and admin altered later
		tmpusr.setUserType("customer");
		
		//service will register the user then pull that user to return with the user now having a userid
		Users tmpusr2 = service.registerUser(tmpusr);
		
		//used for testing/debug
		System.out.println(tmpusr2.getFirstName());
		System.out.println(tmpusr2.getUserid());		
		
		//Populate the tmppay with the forms payment information
		tmppay.setNameOnCard(request.getParameter("name_on_card"));
		tmppay.setCardNumber(request.getParameter("credit"));
		tmppay.setExpDate(request.getParameter("exp_date"));
		tmppay.setCCV(Short.parseShort(request.getParameter("ccv")));
		
		//will use the user id that was autogenerated when the user information was stored
		tmppay.setUserid(tmpusr2.getUserid());
		
		//Service will register the users payment, linking it to their account using their userid they just created
		service.registerPayment(tmppay);

		//redirect the user back to the login page
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}

}