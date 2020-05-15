/**
 * 
 *  @author diego
 * 
 */

package model;

import java.io.Serializable;


/** This Class we had Raul's orientation about how to use the serializable.
 * 	Customer implements Serializable to flat the code structure into a binary.
 *  It allows to be stored as an object in a text file. 
 * 
 */
public class Customer implements Serializable {
	

	private static final long serialVersionUID = -5384152674287010033L;
	//Attributes
	private String fname;
	private String lname;
	private String email;
	private int id;
	private String creditcard;
	private String planType;
	private MembershipCard memberid = new MembershipCard();
	
	
	// Getters and Setters
	public String getFname() {
		return fname;
	}
	public Customer setFname(String fname) {
		this.fname = fname;
		return this;
	}
	public String getLname() {
		return lname;
	}
	public Customer setLname(String lname) {
		this.lname = lname;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Customer setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getId() {
		return id;
	}
	public Customer setId(int id) {
		this.id = id;
		return this;
	}
	public String getCreditcard() {
		return creditcard;
	}
	public Customer setCreditcard(String creditcard) {
		this.creditcard = creditcard;
		return this;
	}
	
	public String getPlanType() {
		return this.planType;
	}
	public Customer setPlanType(String planType) {
		this.planType = planType;
		return this;
	}
	public MembershipCard getMemberid() {
		return memberid;
	}
	public Customer setMemberid(MembershipCard memberid) {
		this.memberid = memberid;
		return this;
	}
	@Override
	public String toString() {
		return "Customer [MEMBERSHIP ID = " + id + ", NAME = " + fname + "_" + lname + ", EMAIL = " +
				email + ", CREDIT CARD = " + creditcard + ", POINTS = " 
				+ this.memberid.getPoints() + "]";
	}
	
	
	
	
	

}
