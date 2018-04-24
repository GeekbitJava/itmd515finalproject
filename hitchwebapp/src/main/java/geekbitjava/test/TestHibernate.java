package geekbitjava.test;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import geekbitjava.entities.*;

/*
	 Deborah Barndt
	 Thomas Boller
	 4-17-2018
	 TestHibernate.java
	 ITMD 415 Final Project
	
	!!!!!!!!!!!!!!!! THIS CLASS IS BORROWED FROM JAMES PAPADEMAS 
	This class is used to test the programs ability to perform CRUD operations using
	Hibernate.  The class is derived from James Papademas's CreateStudentDemo.java. 
	Thanks James!!
*/


public class TestHibernate {

	public static void main(String[] args) {
 
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
		
		try {
			//System.out.println("Creating user object...");
			//Student tempStudent = new Student("Thomas","Boller","tboller@iit.edu");
			//Users tempUser = new Users("Thomas", "Boller", "tboller@iit.edu", "testpass");
			//grab current date
			//java.sql.Date ourJavaDateObject = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			//grab current time
		//    java.util.Date today = new java.util.Date();
		//    java.sql.Time currtime = new java.sql.Time(today.getTime());
		    //a later time
		 //   java.sql.Time ltrtime = new java.sql.Time(today.getTime());
		  //  char size = 'm';
		    
			//System.out.println("Creating delivery object...");
			//DeliveryTransactions tempdel = new DeliveryTransactions(1, 2,
			//		"pub street", "main street");
			
			//System.out.println("Creating delivery object...");
			//TaxiTransactions temptax = new TaxiTransactions(1, 2,
			//		"pub street", "main street");
			
			//System.out.println("Creating payment object...");
			//short tmp = 232;
			//Payment temppay = new Payment("John Jacob Schmidt" , 5545555, "04/44", tmp, 123);
			
			//System.out.println("Creating vehicle object...");
			//Vehicles tempveh = new Vehicles(3, "Honda", "Accord", 1998);
			
			Drivers tempdriver = new Drivers(10, 5, "taxi", "B450-333-2342", "Charles Gun", "xyz street");
			
			//start up transaction
			session.beginTransaction();
			
			//save the student
			//System.out.println("Saving the student...");
			//session.save(tempStudent);
			//System.out.println("Saving the User...");
			//session.save(tempUser);
			System.out.println("saving transaction..");
			session.save(tempdriver);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Process complete!");
		
		}finally {
			factory.close();
		}

	}

}
