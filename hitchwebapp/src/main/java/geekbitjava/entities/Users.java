package geekbitjava.entities;

/*
Deborah Barndt
	 Thomas Boller
	 3-27-18
	 Users.java
	 Project Assignment 3
	This is a class entity to hold Users
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.annotation.ManagedBean;

@ManagedBean
@Entity
@Table(name="users")
public class Users implements java.io.Serializable {


	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public Users () {
		}
		
		public Users(String firstName, String lastName, String email, String password) {
			 
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
		}
		
	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */

	    @Id
	    @Column(name="uid")
		private int userid;
	    
	    @Column(name="passwd")
		private String password;
	    
	    @Column(name="fname")
		private String firstName;
	    
	    @Column(name="lname")
		private String lastName;
	    
	    @Column(name="utype")
		private String userType;
	    
	    @Column(name="rating")
		private byte rating;
	    
	    @Column(name="email")
		private String email;
	    
	    @Column(name="location")
		private String curr_Loc;
	
	/* ---------------
	 * | Methods     |
	 * ---------------	
	 */			
	
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getUserType() {
			return userType;
		}
		public void setUserType(String userType) {
			this.userType = userType;
		}
		public byte getRating() {
			return rating;
		}
		public void setRating(byte rating) {
			this.rating = rating;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCurr_Loc() {
			return curr_Loc;
		}
		public void setCurr_Loc(String curr_Loc) {
			this.curr_Loc = curr_Loc;
		}

	
		
}
