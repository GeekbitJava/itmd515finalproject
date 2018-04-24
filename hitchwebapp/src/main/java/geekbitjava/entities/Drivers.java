package geekbitjava.entities;
/*
Deborah Barndt
	 Thomas Boller
	 3-27-18
	 Drivers.java
	 Project Assignment 3
	This is a class entity to hold Drivers
*/


import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@Entity
@Table(name="drivers")
public class Drivers implements java.io.Serializable {

	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public Drivers () {
		}
		
		
	//constructor for testing	
	public Drivers(int user_id, int driver_id, String driver_type, String license, String name, String current_loc) {
		super();
		this.user_id = user_id;
		this.driver_id = driver_id;
		this.driver_type = driver_type;
		this.license = license;
		this.name = name;
		this.current_loc = current_loc;
	}



	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */
		
		@Id
	    @Column(name="did")	 		
		private int driver_id;
		
	    @Column(name="vid")	 		
		private int vehicle_id;
		
	    @Column(name="uid")
		private int user_id;
	    
	    @Column(name="type")	 
		private String driver_type;
	    
	    @Column(name="license")	 
		private String license;
	    
	    @Column(name="name")	 
		private String name;
	    
	    @Column(name="location")	 
		private String current_loc;
		
		
	/* ---------------
	 * | Methods     |
	 * ---------------	
	 */			
		/**
		 * @return the vehicle_id
		 */
		public int getDriverID() {
			return driver_id;
		}
		/**
		 * @param vehicle_id the vehicle_id to set
		 */
		public void setDriverId(int driver_id) {
			this.driver_id = driver_id;
		}
		/**
		 * @return the vehicle_id
		 */
		public int getVehicleId() {
			return vehicle_id;
		}
		/**
		 * @param vehicle_id the vehicle_id to set
		 */
		public void setVehicleId(int vehicle_id) {
			this.vehicle_id = vehicle_id;
		}
		/**
		 * @return the driver_type
		 */
		public String getDriverType() {
			return driver_type;
		}
		/**
		 * @param driver_type the driver_type to set
		 */
		public void setDriverType(String driver_type) {
			this.driver_type = driver_type;
		}
		/**
		 * @return the license
		 */
		public String getLicense() {
			return license;
		}
		/**
		 * @param license the license to set
		 */
		public void setLicense(String license) {
			this.license = license;
		}
		/**
		 * @return the user_id
		 */
		public int getUserId() {
			return user_id;
		}
		/**
		 * @param user_id the user_id to set
		 */
		public void setUserId(int user_id) {
			this.user_id = user_id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the current_loc
		 */
		public String getCurrentLoc() {
			return current_loc;
		}
		/**
		 * @param name the name to set
		 */
		public void setCurrentLoc(String current_loc) {
			this.current_loc = current_loc;
		}	
}