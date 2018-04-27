package geekbitjava.delivery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import authentication.LoginService;

/*
Deborah Barndt
 Thomas Boller
 4-22-18
 DeliveryServlet.java
 Final Project
This class is the controller for the delivery service. It will work the data gained from the delivery.jsp page and then connect
with the DeliveryService, BillingService, and other files to forward teh users request and then inform the user of who will 
be picking up their package and when, as well as how much it will cost
*/


@WebServlet(urlPatterns = "/deliver.do")
public class DeliveryServlet extends HttpServlet {



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/delivery.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		//pulls data from the pickupform
		String pickStreet = request.getParameter("street1");
		String pickCity = request.getParameter("city1");
		String pickState = request.getParameter("state1");
		
		
		//pulls data from the dropoff form
		String dropStreet = request.getParameter("street2");
		String dropCity = request.getParameter("city2");
		String dropState = request.getParameter("state2");
		
		//pulls package size
		String packSize = request.getParameter("pkgsize");
		
		//pulls when to get it
		String nowOrLater = request.getParameter("when");
		
		//time for pickup
		String pickTime = request.getParameter("usertime");
		
		
		
		//This is for test and Debug
		System.out.println("pickup at " + pickStreet + " " + pickCity + " " + pickState);
		System.out.println("drop at " + dropStreet + " " + dropCity + " " + dropState);
	}

}