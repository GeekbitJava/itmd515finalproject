package geekbitjava.entities;

/*
Deborah Barndt
	 Thomas Boller
	 3-27-18
	 DeliveryTransactions.java
	 Project Assignment 3
	This is a class entity to hold DeliveryTransactions
*/


import java.sql.Date;
import java.sql.Time;

import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@ManagedBean
@Entity
@Table(name="deliverytransactions")
public class DeliveryTransactions implements java.io.Serializable {

	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public DeliveryTransactions () {}
		
		
		
		
	public DeliveryTransactions(int userid, int i,
			String pickupLocation, String dropoffLocation) {
		super();
		this.userid = userid;
		this.driverid = i;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;

	}




	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */
		




		//@Id
	  //  @Column(name="tid")
		//private int tid;
	    
		@Id
		@Column(name = "tid")
		private int tid;
	
	    @Column(name="uid")	    
		private int userid;
		
	    @Column(name="did")		
		private int driverid;
		
	    @Column(name="dateofsale")		
		private Date dateOfSale;
		
	    @Column(name="rate")		
		private double rate;
		
	    @Column(name="pickuptime")		
		private Time pickupTime;
		
	    @Column(name="pickuplocation")		
		private String pickupLocation;
		
	    @Column(name="dropofftime")		
		private Time dropoffTime;
		
	    @Column(name="dropofflocation")		
		private String dropoffLocation;
		
	    @Column(name="packagesize")		
		private char packageSize;
		
	/* ---------------
	 * | Methods     |
	 * ---------------	
	 */			
		/**
		 * @return the tid
		 */
		public int getTid() {
			return tid;
		}
		/**
		 * @param tid the tid to set
		 */
		public void setTid(int tid) {
			this.tid = tid;
		}
		/**
		 * @return the userid
		 */
		public int getUserid() {
			return userid;
		}
		/**
		 * @param userid the userid to set
		 */
		public void setUserid(int userid) {
			this.userid = userid;
		}
		/**
		 * @return the driverid
		 */
		public int getDriverid() {
			return driverid;
		}
		/**
		 * @param driverid the driverid to set
		 */
		public void setDriverid(int driverid) {
			this.driverid = driverid;
		}
		/**
		 * @return the dateOfSale
		 */
		public Date getDateOfSale() {
			return dateOfSale;
		}
		/**
		 * @param dateOfSale the dateOfSale to set
		 */
		public void setDateOfSale(Date dateOfSale) {
			this.dateOfSale = dateOfSale;
		}
		/**
		 * @return the rate
		 */
		public double getRate() {
			return rate;
		}
		/**
		 * @param rate the rate to set
		 */
		public void setRate(double rate) {
			this.rate = rate;
		}
		/**
		 * @return the pickupTime
		 */
		public Time getPickupTime() {
			return pickupTime;
		}
		/**
		 * @param pickupTime the pickupTime to set
		 */
		public void setPickupTime(Time pickupTime) {
			this.pickupTime = pickupTime;
		}
		/**
		 * @return the pickupLocation
		 */
		public String getPickupLocation() {
			return pickupLocation;
		}
		/**
		 * @param pickupLocation the pickupLocation to set
		 */
		public void setPickupLocation(String pickupLocation) {
			this.pickupLocation = pickupLocation;
		}
		/**
		 * @return the dropoffTime
		 */
		public Time getDropoffTime() {
			return dropoffTime;
		}
		/**
		 * @param dropoffTime the dropoffTime to set
		 */
		public void setDropoffTime(Time dropoffTime) {
			this.dropoffTime = dropoffTime;
		}
		/**
		 * @return the dropoffLocation
		 */
		public String getDropoffLocation() {
			return dropoffLocation;
		}
		/**
		 * @param dropoffLocation the dropoffLocation to set
		 */
		public void setDropoffLocation(String dropoffLocation) {
			this.dropoffLocation = dropoffLocation;
		}
		/**
		 * @return the packageSize
		 */
		public char getPackageSize() {
			return packageSize;
		}
		/**
		 * @param packageSize the packageSize to set
		 */
		public void setPackageSize(char packageSize) {
			this.packageSize = packageSize;
		}

		

}
