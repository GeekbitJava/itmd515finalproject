package geekbitjava.entities;

/*
Deborah Barndt
	 Thomas Boller
	 3-27-18
	 TaxiTransactions.java
	 Project Assignment 3
	This is a class entity to hold TaxiTransactions
*/

import java.sql.Date;

import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Time;

@ManagedBean
@Entity
@Table(name="taxitransactions")
public class TaxiTransactions implements java.io.Serializable {
	

	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public TaxiTransactions () {
		}
		
		public TaxiTransactions(int userid, int i,
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
	    
	    @Column(name="rating")
		private byte rating;

		
	/* ---------------
	 * | Methods     |
	 * ---------------	
	 */		

		public int getTid() {
			return tid;
		}
		public void setTid(int tid) {
			this.tid = tid;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public int getDriverid() {
			return driverid;
		}
		public void setDriverid(int driverid) {
			this.driverid = driverid;
		}
		public Date getDateOfSale() {
			return dateOfSale;
		}
		public void setDateOfSale(Date dateOfSale) {
			this.dateOfSale = dateOfSale;
		}
		public double getRate() {
			return rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
		public Time getPickupTime() {
			return pickupTime;
		}
		public void setPickupTime(Time pickupTime) {
			this.pickupTime = pickupTime;
		}
		public String getPickupLocation() {
			return pickupLocation;
		}
		public void setPickupLocation(String pickupLocation) {
			this.pickupLocation = pickupLocation;
		}
		public Time getDropoffTime() {
			return dropoffTime;
		}
		public void setDropoffTime(Time dropoffTime) {
			this.dropoffTime = dropoffTime;
		}
		public String getDropoffLocation() {
			return dropoffLocation;
		}
		public void setDropoffLocation(String dropoffLocation) {
			this.dropoffLocation = dropoffLocation;
		}
		public byte getRating() {
			return rating;
		}
		public void setRating(byte rating) {
			this.rating = rating;
		}		
}
