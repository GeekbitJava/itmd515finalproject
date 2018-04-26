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
	 LoginServelet.java
	 Final Project
	This class works with the login jsp pages and login services to allow for a user to login 
*/

@WebServlet(urlPatterns = "/registration.do")
public class RegistrationServlet extends HttpServlet {

	private LoginService service = new LoginService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("Before validateuser ran");
		
		
		boolean isValidUser = service.validateUser(username, password);
		
		System.out.println(isValidUser);

		if (isValidUser) {
			System.out.println("VALID");
			request.setAttribute("username", username);

			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}