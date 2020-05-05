/**
 * 
 *  @author Diego
 * 
 */

package model;

public class Customer {
	
	//Attributes
	private String fname;
	private String lname;
	private String email;
	private int id;
	private int creditcard;
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
	public int getCreditcard() {
		return creditcard;
	}
	public Customer setCreditcard(int creditcard) {
		this.creditcard = creditcard;
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
		return "Customer [fname=" + fname + ", lname=" + lname + ", email=" + ","
				+ email + ", id=" + id + ", creditcard=" + creditcard 
				+ ", poins=" + this.memberid.getPoints() + "]";
	}
	
	
	
	
	

}
