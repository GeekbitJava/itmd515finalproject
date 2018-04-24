package geekbitjava.database;
/*
	Deborah Barndt
 	 Thomas Boller
 	 2-23-18
 	 update: 4-23-18
 	 DAO.java
 	 Project Assignment 1
	This is a data access object that uses JDBC to create sql tables. Uses Hibernate to Post data in single or mass to database.
	
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.*;
import org.hibernate.*;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.criterion.Restrictions;

import org.hibernate.query.Query;

import geekbitjava.entities.*;

public class DAO {

	
	// method to create our table
	public void createTables() {
		
		// set up a  database URL String var
		
	// set up a  database URL String var
	 final String URL = "jdbc:mysql://localhost:3306/test";
	
	// set up credential strings
		 final String UID = "root";
		 final String PASSWD = "QW!@12odin";
	
	//database object definition
	Connection dbcon = null;
	Statement stmnt = null;
	
		try {


			//connect to the db
		      dbcon = DriverManager.getConnection(URL, UID, PASSWD);
		      System.out.println("Connection made to database for table creation");
		      System.out.println();

			//statement for connection
			stmnt = dbcon.createStatement();

			String dtTable = "CREATE TABLE IF NOT EXISTS deliverytransactions "
					+ "(tid int(10) NOT NULL AUTO_INCREMENT, "
					+ "	uid int(10) NOT NULL, "
					+ "	did int(10) NOT NULL, "
					+ "	dateofsale date, "
					+ "	rate numeric(9,2), "
					+ "	pickuptime time, "
					+ "	pickuplocation varchar(255) NOT NULL, "
					+ "	dropofftime time, "
					+ "	dropofflocation varchar(255) NOT NULL, "
					+ "	packagesize varchar(1), "
					+ "	PRIMARY KEY( tid ))";

			stmnt.executeUpdate(dtTable);
			System.out.println("Created dtTable in given database...");
			
			String taxiTable = "CREATE TABLE IF NOT EXISTS taxitransactions "
					+ "(tid int(10) NOT NULL AUTO_INCREMENT, "
					+ "	uid int(10) NOT NULL, "
					+ "	did int(10) NOT NULL, "
					+ "	dateofsale date, "
					+ "	rate numeric(9,2), "
					+ "	pickuptime time, "
					+ "	pickuplocation varchar(255) NOT NULL, "
					+ "	dropofftime time, "
					+ "	dropofflocation varchar(255) NOT NULL, "
					+ "	rating tinyint(1), "
					+ "	PRIMARY KEY( tid ))";

	stmnt.executeUpdate(taxiTable);
	System.out.println("Created taxiTable in given database...");			
	
		String UserTable = "CREATE TABLE IF NOT EXISTS users "
				+ "(uid int(10) NOT NULL AUTO_INCREMENT, "
				+ "	passwd varchar(20) NOT NULL, "
				+ "	fname varchar(20), "
				+ "	lname varchar(20), "
				+ "	utype varchar(10), "
				+ "	email varchar(30) NOT NULL, "
				+ "	location varchar(255), "
				+ "	rating tinyint(1), "
				+ "	PRIMARY KEY( uid ))";

	stmnt.executeUpdate(UserTable);
	System.out.println("Created User Table in given database...");		
	
		String PayTable = "CREATE TABLE IF NOT EXISTS payment "
				+ "(pid int(10) NOT NULL AUTO_INCREMENT, "
				+ "	nameoncard varchar(40) NOT NULL, "
				+ "	cardnumber varchar(20) NOT NULL, "
				+ "	expdate varchar(5) NOT NULL, "
				+ "	ccv smallint(4) NOT NULL, "
				+ "	uid int(10) NOT NULL, "
				+ "	PRIMARY KEY( pid ))";
	
	stmnt.executeUpdate(PayTable);
	System.out.println("Created Payment Table in given database...");		
	
		String VTable = "CREATE TABLE IF NOT EXISTS vehicles"
				+ "(vid int(10) NOT NULL AUTO_INCREMENT, "
				+ "	make varchar(20), "
				+ "	uid int(10) NOT NULL, "
				+ "	model varchar(20), "
				+ "	year int(5), "
				+ "	licenseplate varchar(20), "
				+ "	color varchar(20), "
				+ "	PRIMARY KEY( vid ))";
	
	stmnt.executeUpdate(VTable);
	System.out.println("Created Vehicle Table in given database...");	
	
		String DriverTable = "CREATE TABLE IF NOT EXISTS drivers"
				+ "(did int(10) NOT NULL AUTO_INCREMENT, "
				+ "	type varchar(10), "
				+ "	vid int(10) NOT NULL, "
				+ "	license varchar(20), "
				+ "	uid int(10) NOT NULL, "
				+ "	name varchar(30) NOT NULL, "
				+ "	location varchar(30), "
				+ "	PRIMARY KEY( did ))";
		
		stmnt.executeUpdate(DriverTable);
		System.out.println("Created Driver Table in given database...");	
			
		} catch (SQLException se) {
			
			// Handle errors for JDBC
			se.printStackTrace();
			
		} finally {
			
			// finally block used to close resources
			try {
				
				//if there is a statement logged and thus a connection created, then close the connection
				if (stmnt != null) {
					dbcon.close();
					System.out.println();
					System.out.println("Database connection for table creation Closed");
				}

				
			}//end of finally try
			
			catch (SQLException se){} // catch does nothing
			
		} // end of Finally
		
	}//end of createTable()


	//Inserts for Delivery Transactions (Mass and single)
	public void insertSingleDtRecord(DeliveryTransactions tempdel) {
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for single delivery transaction insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
			System.out.println("Saving Delivery transaction..");
			session.save(tempdel);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Insert made to deliverytransactions table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed single Delivery Transaction Insert");
		}

		
			
	}
	public void insertMassDtRecords(DeliveryTransactions[] dtList) {
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for mass delivery transaction insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
		      //cycles through the delivery transactions objects and stores them
		      for(int i=0;i<dtList.length;i++) {
		    	  DeliveryTransactions tmpdel = new DeliveryTransactions();
		    	//  tmpdel.setTid(dtList[i].getTid()); --> XML might have this but since db is auto inc not sure how it will affect
		    	  tmpdel.setUserid(dtList[i].getUserid());
		    	  tmpdel.setDriverid(dtList[i].getDriverid());
		    	  tmpdel.setDateOfSale(dtList[i].getDateOfSale());
		    	  tmpdel.setDropoffLocation(dtList[i].getDropoffLocation());
		    	  tmpdel.setDropoffTime(dtList[i].getDropoffTime());
		    	  tmpdel.setPickupLocation(dtList[i].getPickupLocation());
		    	  tmpdel.setPickupTime(dtList[i].getPickupTime());
		    	  tmpdel.setRate(dtList[i].getRate());
		    	  tmpdel.setPackageSize(dtList[i].getPackageSize());

					System.out.println("Saving Delivery transaction " + i);
					session.save(tmpdel);
					
					//ensures memory/connections don't overload
			        session.flush();
			        session.clear();
		     
		      }
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println();
			System.out.println("Mass insert made to deliverytransactions table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed Mass Delivery Transaction Insert");
		}		
			
	}
	
	//Inserts for Taxi Transactions (Mass and single)
	public void insertSingleTaxRecords(TaxiTransactions temptax) {
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for single Taxi transaction insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
			System.out.println("Saving Taxi transaction..");
			session.save(temptax);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Insert made to taxitransactions table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed single Taxi Transaction Insert");
		}
	}
	public void insertMassTaxRecords(TaxiTransactions[] taxList) {
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for mass Taxi transaction insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
		      //cycles through the taxi transactions objects and stores them
		      for(int i=0;i<taxList.length;i++) {
		    	  TaxiTransactions tmptax = new TaxiTransactions();
		    	//  tmptax.setTid(taxList[i].getTid()); --> XML might have this but since db is auto inc not sure how it will affect
		    	  tmptax.setUserid(taxList[i].getUserid());
		    	  tmptax.setDriverid(taxList[i].getDriverid());
		    	  tmptax.setDateOfSale(taxList[i].getDateOfSale());
		    	  tmptax.setDropoffLocation(taxList[i].getDropoffLocation());
		    	  tmptax.setDropoffTime(taxList[i].getDropoffTime());
		    	  tmptax.setPickupLocation(taxList[i].getPickupLocation());
		    	  tmptax.setPickupTime(taxList[i].getPickupTime());
		    	  tmptax.setRate(taxList[i].getRate());
		    	  tmptax.setRating(taxList[i].getRating());

					System.out.println("Saving Taxi transaction " + i);
					session.save(tmptax);
					
					//ensures memory/connections don't overload
			        session.flush();
			        session.clear();
		     
		      }
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println();
			System.out.println("Mass insert made to taxitransactions table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed Mass Taxi Transaction Insert");
		}	
	}

	
	//Inserts for Users (Mass and single)
	public void insertSingleUsers(Users tmpusr) {
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for single user insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
			System.out.println("Saving User..");
			session.save(tmpusr);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Insert made to user table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed single user Insert");
		}
	}
	public void insertMassUsers(Users[] usrList) {
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for mass user insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
		      //cycles through the taxi transactions objects and stores them
		      for(int i=0;i<usrList.length;i++) {
		    	  Users tmpusr = new Users();
		    	  //tmptax.setTid(taxList[i].getTid()); --> XML might have this but since db is auto inc not sure how it will affect
		    	 // tmptax.setUserid(usrList[i].getUserid());
		    	  tmpusr.setEmail(usrList[i].getEmail());
		    	  tmpusr.setCurr_Loc(usrList[i].getCurr_Loc());
		    	  tmpusr.setFirstName(usrList[i].getFirstName());
		    	  tmpusr.setLastName(usrList[i].getLastName());
		    	  tmpusr.setRating(usrList[i].getRating());
		    	  tmpusr.setPassword(usrList[i].getPassword());
		    	  tmpusr.setUserType(usrList[i].getUserType());

					System.out.println("Saving User " + i);
					session.save(tmpusr);
					
					//ensures memory/connections don't overload
			        session.flush();
			        session.clear();
		     
		      }
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println();
			System.out.println("Mass insert made to users table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed Mass User Insert");
		}	
	}

	//Inserts for payments (Mass and single)
	public void insertSinglePayment(Payment tmppay) {
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for single payment insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
			System.out.println("Saving Payment..");
			session.save(tmppay);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Insert made to payment table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed single payment Insert");
		}
	}
	public void insertMassPayment(Payment[] payList) {	
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for mass payment insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
		      //cycles through the payment objects and stores them
		      for(int i=0;i<payList.length;i++) {
		    	  Payment tmppay = new Payment();
		    	  tmppay.setUserid(payList[i].getUserid());
		    	  tmppay.setCardNumber(payList[i].getCardNumber());
		    	  tmppay.setCCV(payList[i].getCCV());
		    	  tmppay.setExpDate(payList[i].getExpDate());
		    	  tmppay.setNameOnCard(payList[i].getNameOnCard());
		    	  
					System.out.println("Saving Payment " + i);
					session.save(tmppay);
					
					//ensures memory/connections don't overload
			        session.flush();
			        session.clear();
		     
		      }
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println();
			System.out.println("Mass insert made to payment table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed Mass Payment Insert");
		}	
		
	}

	//Inserts for vehicles (Mass and single)
	public void insertSingleVehicles(Vehicles tmpveh) {
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for single vehicle insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
			System.out.println("Saving Vehicle..");
			session.save(tmpveh);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Insert made to vehicle table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed single Vehicle Insert");
		}
	}
	public void insertMassVehicles(Vehicles[] vehList) {

		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for mass Vehicle insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
		      //cycles through the vehicle objects and stores them
		      for(int i=0;i<vehList.length;i++) {
		    	  Vehicles tmpveh = new Vehicles();
		    	  tmpveh.setColor(vehList[i].getColor());
		    	  tmpveh.setLicensePlate(vehList[i].getLicensePlate());
		    	  tmpveh.setMake(vehList[i].getLicensePlate());
		    	  tmpveh.setModel(vehList[i].getModel());
		    	  tmpveh.setYear(vehList[i].getYear());
		    	  tmpveh.setuid(vehList[i].getuid());
		    	  
					System.out.println("Saving Vehicle " + i);
					session.save(tmpveh);
					
					//ensures memory/connections don't overload
			        session.flush();
			        session.clear();
		     
		      }
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println();
			System.out.println("Mass insert made to vehicles table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed Mass Vehicle Insert");
		}	
		
	}

	//Inserts for drivers (Mass and single)
	public void insertSingleDrivers(Drivers tmpdri) {
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for single Driver insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
			System.out.println("Saving Driver..");
			session.save(tmpdri);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Insert made to driver table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed single Driver Insert");
		}
	}
	public void insertMassDrivers(Drivers[] driList) {
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		System.out.println();
		System.out.println("Connection made for mass Drivers insert");

		
		try {
			
			//start up transaction
			session.beginTransaction();
			
		      //cycles through the driver objects and stores them
		      for(int i=0;i<driList.length;i++) {
		    	  Drivers tmpdri = new Drivers();
		    	  tmpdri.setCurrentLoc(driList[i].getCurrentLoc());
		    	  tmpdri.setDriverType(driList[i].getDriverType());
		    	  tmpdri.setLicense(driList[i].getLicense());
		    	  tmpdri.setName(driList[i].getName());
		    	  tmpdri.setUserId(driList[i].getUserId());
		    	  tmpdri.setVehicleId(driList[i].getVehicleId());

		    	  
					System.out.println("Saving Driver " + i);
					session.save(tmpdri);
					
					//ensures memory/connections don't overload
			        session.flush();
			        session.clear();
		     
		      }
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println();
			System.out.println("Mass insert made to drivers table!");
			System.out.println();
		
		}finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed Mass Driver Insert");
		}	
	}

	public Users getUserByEmail(String email) {
		
		SessionFactory factory = new Configuration()
		         .configure("hibernate.cfg.xml")
		         .addAnnotatedClass(Users.class)
		         .addAnnotatedClass(DeliveryTransactions.class)
		         .addAnnotatedClass(Drivers.class)
		         .addAnnotatedClass(TaxiTransactions.class)
		         .addAnnotatedClass(Payment.class)
		         .addAnnotatedClass(Vehicles.class)
		         .buildSessionFactory();
		Session session = factory.getCurrentSession();
	     
	      Transaction transaction = null;
	      try{
	    	  
	    	  //open transaction
	         transaction = session.beginTransaction();

	         //jpa criteria builder from session
	         CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Users> query = builder.createQuery(Users.class);
	         Root<Users> root = query.from(Users.class);
	         
	         //query from email of Users.java matching parameter email
	         query.select(root).where(builder.equal(root.get("email"), email));
	         Query<Users> q=session.createQuery(query);
	         //create temporary user set to value of return query
	         Users tmpusr=q.getSingleResult();
	         
	         //Prints out the userid for debug
	         System.out.println("User found id: " + tmpusr.getUserid());
		    

	         transaction.commit();
	         
	         return tmpusr;
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         if (transaction != null) {
	            transaction.rollback();
	         }
	         
	         return null;
	      } finally {
			factory.close();
			System.out.println();
			System.out.println("Session Factory closed find user by email");
	      }

	}


	public boolean checkPassword() {
		
		return false;
	}
	
}//end of class DAO
