/*
Deborah Barndt
	 Thomas Boller
	 2-23-18
	 Payment.java
	 Project Assignment 1
	This is a class entity to hold Payment information
*/


import java.sql.Date;
import java.sql.Time;



public class Payment {

	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public Payment () {
		}
		
	/* ---------------
	 * | ATTRIBUTES  |
	 * ---------------	
	 */
		
		private String name_on_card;
		private int card_number;
		private Date exp_date;
		private short ccv;
		private String user_id;
		
		
	/* ---------------
	 * | Methods     |
	 * ---------------	
	 */			
		/**
		 * @return the name_on_card
		 */
		public String getNameOnCard() {
			return name_on_card;
		}
		/**
		 * @param name_on_card the name_on_card to set
		 */
		public void setNameOnCard(String name_on_card) {
			this.name_on_card = name_on_card;
		}
		/**
		 * @return the card_number
		 */
		public int getCardNumber() {
			return card_number;
		}
		/**
		 * @param card_number the card_number to set
		 */
		public void setCardNumber(int card_number) {
			this.card_number = card_number;
		}
		/**
		 * @return the exp_date
		 */
		public Date getExpDate() {
			return exp_date;
		}
		/**
		 * @param exp_date the exp_date to set
		 */
		public void setExpDate(Date exp_date) {
			this.exp_date = exp_date;
		}
		/**
		 * @return the ccv
		 */
		public short getCCV() {
			return ccv;
		}
		/**
		 * @param ccv the ccv to set
		 */
		public void setCCV(short ccv) {
			this.ccv = ccv;
		}
		/**
		 * @return the userid
		 */
		public String getUserid() {
			return user_id;
		}
		/**
		 * @param user_id the user_id to set
		 */
		public void setUserid(String user_id) {
			this.user_id = user_id;
		}
			

}
