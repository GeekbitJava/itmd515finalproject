package groupproject.itmd515finalproject;
/*
	Deborah Barndt
 	 Thomas Boller
 	 2-23-18
 	 DAO.java
 	 Project Assignment 1
	This is a data access object that uses JDBC to create sql tables and post data to them. Later functionality to
	pull data from the tables.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	
	// set up a  database URL String var
	static final String URL = "jdbc:33.33.33.1";
	
	// set up credential strings
		static final String UID = "root";
		static final String PASSWD = "root";
	
	//database object definition
	Connection dbcon = null;
	Statement stmnt = null;
	 
	
	// method to create our tablea
	public void createTables() {
		try {
			
			//connect to the db
			dbcon = DriverManager.getConnection(URL, UID, PASSWD);

			//statement for connection
			stmnt = dbcon.createStatement();

			String dtTable = "CREATE TABLE IF NOT EXISTS DeliveryTransactions "
							+ "(tid int(10) NOT NULL, "
							+ "	userid varchar(10), "
							+ "	driverid varchar(11), "
							+ "	dateofsale date, "
							+ "	rate numeric(9,2), "
							+ "	pickuptime time, "
							+ "	pickuplocation varchar(255), "
							+ "	dropofftime time, "
							+ "	dropofflocation varchar(255), "
							+ "	packagesize varchar(1), "
							+ "	PRIMARY KEY( tid ))";

			stmnt.executeUpdate(dtTable);
			System.out.println("Created dtTable in given database...");
			
		} catch (SQLException se) {
			
			// Handle errors for JDBC
			se.printStackTrace();
			
		} finally {
			
			// finally block used to close resources
			try {
				
				//if there is a statement logged and thus a connection created, then close the connection
				if (stmnt != null)
					dbcon.close();
				
			}//end of finally try
			
			catch (SQLException se){} // catch does nothing
			
		} // end of Finally
		
	}//end of createTable()

	public void insertDtRecords(DeliveryTransactions [] dtList) {

		String dtTbl = null;
		
		try{
		  //Open connection to the PAPA server
	      System.out.println("Connecting to PAPA server to insert");
	      dbcon = DriverManager.getConnection(URL, UID, PASSWD);
	      System.out.println("Connection to PAPA server successful.");
	      
	      //create statment
	      System.out.println("Inserting records into the table...");
	      stmnt = dbcon.createStatement();
	      
	   
	      
	      //cycles through the delivery transactions objects and stores them
	      for(int i=0;i<dtList.length;i++) {
	    	  dtTbl = "INSERT INTO DeliveryTransactions(tid, userid, driverid, dateOfSale, rate, pickuptime, pickuplocation, dropofftime, dropofflocation, packagesize)" +
	      " VALUES('"+dtList[i].getTid()+"' , '"+dtList[i].getUserid()+"' , '"+dtList[i].getDriverid()+"' , '"+dtList[i].getDateOfSale()+
	      "' , '"+dtList[i].getRate()+"' , '"+dtList[i].getPickupTime()+"' , '"+dtList[i].getPickupLocation()+"' , '"+dtList[i].getDropoffTime()+
	      "' , '"+dtList[i].getDropoffLocation()+"' , '"+dtList[i].getPackageSize()+"')";

	      stmnt.executeUpdate(dtTbl); //run query to insert record by record
	     
	      }

	      System.out.println("dtList added to DB");

	   }catch(SQLException se){
		   
		// Handle errors for JDBC
		se.printStackTrace();
		
	  }finally {
		  
		// finally block used to close resources
		try {
			
			if (stmnt != null)
				dbcon.close();
			
		} catch (SQLException se) {  } // catch does nothing
	}// end finally try
		
}	
	
}//end of class DAO
