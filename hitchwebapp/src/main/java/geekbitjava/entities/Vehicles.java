package geekbitjava.entities;

import javax.annotation.ManagedBean;
import javax.persistence.Column;

/*

Deborah Barndt
	 Thomas Boller
	 3-27-18
	 Vehicles.java
	 Project Assignment 3
	This is a class entity to hold Vehicles
*/

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@Entity
@Table(name="vehicles")
public class Vehicles implements java.io.Serializable {

	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public Vehicles () {
		}
		
		
		
	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */
		
		public Vehicles(int userid, String make, String model, int year) {
			super();
			this.userid = userid;
			this.make = make;
			this.model = model;
			this.year = year;
		}



		@Id
		@Column(name = "vid")
		private int vehicle_id;
		
		@Column(name = "uid")
		private int userid;
		
		@Column(name = "make")
		private String make;
		
		@Column(name = "model")
		private String model;
		
		@Column(name = "year")
		private int year;
		
		@Column(name = "licenseplate")
		private String license_plate;
		
		@Column(name = "color")
		private String color;
		
		
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
		public void setuid(int uid) {
			this.userid = uid;
		}
		/**
		 * @return the vehicle_id
		 */
		public int getuid() {
			return userid;
		}
		/**
		 * @param vehicle_id the vehicle_id to set
		 */
		public void setVehicleId(int vehicle_id) {
			this.vehicle_id = vehicle_id;
		}
		/**
		 * @return the make
		 */
		public String getMake() {
			return make;
		}
		/**
		 * @param make the make to set
		 */
		public void setMake(String make) {
			this.make = make;
		}
		/**
		 * @return the model
		 */
		public String getModel() {
			return model;
		}
		/**
		 * @param model the model to set
		 */
		public void setModel(String model) {
			this.model = model;
		}
		/**
		 * @return the year
		 */
		public int getYear() {
			return year;
		}
		/**
		 * @param year the year to set
		 */
		public void setYear(int year) {
			this.year = year;
		}
		/**
		 * @return the name
		 */
		public String getLicensePlate() {
			return license_plate;
		}
		/**
		 * @param license_plate the license_plate to set
		 */
		public void setLicensePlate(String license_plate) {
			this.license_plate = license_plate;
		}
		/**
		 * @return the color
		 */
		public String getColor() {
			return color;
		}
		/**
		 * @param color the color to set
		 */
		public void setColor(String color) {
			this.color = color;
		}	
}