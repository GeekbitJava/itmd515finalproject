package geekbitjava.entities;

/*
	 Deborah Barndt
	 Thomas Boller
	 3-27-18
	 Payment.java
	 Project Assignment 3
	This is a class entity to hold Payment information
*/




import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@Entity
@Table(name="payment")
public class Payment implements java.io.Serializable {

	/* ---------------
	 * | Constructors  |
	 * ---------------	
	 */	
	
		//Default Constructor
		public Payment () {
		}
		
		
		public Payment(String name_on_card, String card_number, String exp_date, short ccv, int user_id) {
			super();

			this.name_on_card = name_on_card;
			this.card_number = card_number;
			this.exp_date = exp_date;
			this.ccv = ccv;
			this.user_id = user_id;
		}

		/* ---------------
		 * | ATTRIBUTES  |
		 * ---------------	
		 */

		@Id
		@Column(name = "pid")
		private int pid;
		
		@Column(name = "nameoncard")
		private String name_on_card;
		
		@Column(name = "cardnumber")
		private String card_number;
		
		@Column(name = "expdate")
		private String exp_date;
		
		@Column(name = "ccv")
		private short ccv;
		
		@Column(name = "uid")
		private int user_id;
		
		
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
		public String getCardNumber() {
			return card_number;
		}
		/**
		 * @param card_number the card_number to set
		 */
		public void setCardNumber(String card_number) {
			this.card_number = card_number;
		}
		/**
		 * @return the exp_date
		 */
		public String getExpDate() {
			return exp_date;
		}
		/**
		 * @param exp_date the exp_date to set
		 */
		public void setExpDate(String exp_date) {
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
		public int getUserid() {
			return user_id;
		}
		/**
		 * @param user_id the user_id to set
		 */
		public void setUserid(int user_id) {
			this.user_id = user_id;
		}
			
		public int getPid() {
			return pid;
		}
		/**
		 * @param card_number the card_number to set
		 */
		public void setPid(int pid) {
			this.pid = pid;
		}
		/**
		 * @return the exp_date
		 */
}
