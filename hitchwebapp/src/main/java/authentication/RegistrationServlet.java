package authentication;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name_on_card = request.getParameter("name_on_card");
		String credit = request.getParameter("credit");
		String exp_date = request.getParameter("exp_date");
		String ccv = request.getParameter("ccv");

		System.out.println("Befor");
		
		
		
		

	}

}