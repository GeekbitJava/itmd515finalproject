package geekbitjava.test;

import java.sql.Connection;
import java.sql.DriverManager;

import geekbitjava.database.DAO;
import geekbitjava.entities.*;
import geekbitjava.xml.*;


/*
Deborah Barndt
Thomas Boller
4-17-2018
TestJdbc.java
ITMD 415 Final Project

!!!!!!!!!!!!!!!! THIS CLASS IS BORROWED FROM JAMES PAPADEMAS 
This class is used to test the connection to the mysql database
The class is derived from James Papademas's TestJdbc.java. 
Thanks James!!
*/

public class TestJdbc {
	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "QW!@12odin";
		
		//String jdbcUrl = "jdbc:mysql://www.papademas.net/ps?useSSL=false";
	//	String userName = "ps";
	//	String password = "ps1";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Connection Successful!");
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DAO daoO = new DAO();
		daoO.createTables();

		XmlParser parse = new XmlParser();

		
		parse.parseDTXML();
		daoO.createTables();
		daoO.insertMassDtRecords(parse.getDtArray());
		
		parse.parseTTXML();
		daoO.insertMassTaxRecords(parse.gettTaxArray());
		
		parse.parseUserXML();
		daoO.insertMassUsers(parse.getUsrArray());
		
		parse.parsePaymentXML();
		daoO.insertMassPayment(parse.getPayArray());
		
		parse.parseVehiclesXML();
		daoO.insertMassVehicles(parse.getVArray());
		
		parse.parseDriversXML();
		daoO.insertMassDrivers(parse.getDriverArray());

	}

}
