package model;

import java.io.Serializable;

/** This Class we had Raul's orientation about how to use the serializable.
 * 	Membershipcard implements serializable to flat the code structure into a binary.
 *  It allows to be stored as an object in a text file. 
 * 
 */

public class MembershipCard implements Serializable{
	

	private static final long serialVersionUID = 1338643662423772499L;
	private int points;
	   private boolean freeRentAllowed;
	   
	   public void addPoints(int points){
			this.points += points;
			setRentAllowed();
	   }
	   
	   public boolean availFreeRent(){
			if(this.isfreeRentAllowed()){
				this.points -= 100;
				setRentAllowed();
				return true;
			} else {
				return false;
			}
	   }
	   
	   private void setRentAllowed(){
			if (this.points >= 100){
				this.freeRentAllowed = true;
			} else {
				this.freeRentAllowed = false;
			}
	   }
	   
	   public int getPoints() {
			return  points;
       }
	   
	   public boolean isfreeRentAllowed(){
			return freeRentAllowed;
	   
	   }
	   
}