/*
Deborah Barndt
	 Thomas Boller
	 2-23-18
	 Drivers.java
	 Project Assignment 1
	This is a class entity to hold Drivers
*/


import java.sql.Date;
import java.sql.Time;



public class Drivers {

	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public Drivers () {
		}
		
	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */
		
		private int vehicle_id;
		private String driver_type;
		private String license;
		private String user_id;
		private String name;
		private String current_loc;
		
		
	/* ---------------
	 * | Methods     |
	 * ---------------	
	 */			
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
		public Date getLicense() {
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
		public String getUserId() {
			return user_id;
		}
		/**
		 * @param user_id the user_id to set
		 */
		public void setUserId(String user_id) {
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