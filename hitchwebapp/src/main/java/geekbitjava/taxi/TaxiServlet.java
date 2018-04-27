package geekbitjava.taxi;

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
 TaxiServlet.java
 Final Project
This class is the controller for the taxi service. It will work the data gained from the taxi.jsp page and then connect
with the TaxiService, BillingService, and other files to forward the users request and then inform the user of who will 
be picking them up and when, as well as the cost
*/


@WebServlet(urlPatterns = "/taxi.do")
public class TaxiServlet extends HttpServlet {



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/ride.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

	}

}