package model;

import java.util.ArrayList;
import java.util.List;


public class CustomerFactory {
	
	public void displayCustomer(List<Customer> customer) {
		for (Customer c : customer) {
			System.out.println(c);
		}
	}
	
	public List<Customer> searchCustomer(List<Customer> customer, String word) {
		
		List<Customer> l = new ArrayList<>();
		word = word.toLowerCase();
		for (Customer c : customer) {
			if (c.getFname().toLowerCase().contains(word) || c.getLname()
					.toLowerCase().contains(word)) {
				l.add(c);
			} 
		}
		return l;
	}
	
	public Customer makeCustomer(int id, String fname, String lname,
			String email, String creditcard, String planType) {
		return new Customer().setFname(fname).setLname(lname).setEmail(email)
				.setCreditcard(creditcard).setId(id).setPlanType(planType);
	}
	

}
