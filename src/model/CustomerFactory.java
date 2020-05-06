package model;

import java.util.List;

public class CustomerFactory {
	
	public static void displayCustomer(List<Customer> customer) {
		for (Customer c : customer) {
			System.out.println(c);
		}
	}
	
	public static Customer makeCustomer(int id, String fname, String lname,
			String email, String creditcard) {
		return new Customer().setFname(fname).setLname(lname).setEmail(email)
				.setCreditcard(creditcard).setId(id);
	}
	

}
