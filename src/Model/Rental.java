/**
 * @author diego
 */
package Model;

import java.util.ArrayList;
import java.util.List;

import Interfaces.Title;

public class Rental {
	
	//Attributes
	private List<Title> titles = new ArrayList<>();
	private Customer customer;
	
	// Constructor
	public Rental(Customer customer) {
		this.customer = customer;
	}
	
	//Getters and Setters
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public void setTitle(List<Title> titles) {
		this.titles = titles;
	}
	public List<Title> getTitles(List<Title> titles){
		return this.titles = titles;
	}
	// This method saves the title on the List
	public Rental addTitle(Title title) {
		this.titles.add(title);
		return this;
	}
	@Override
	public String toString() {
		
		String content = "";
		
		for (Title t : this.titles) {
			content = "Customer [id=" + this.customer.getId() + ", customer="
		+ this.customer.getFname() + "], Title[title=" + t.getTitle() 
		+ ", genre=" + t.getGenre() + "]";
		}
		return content;
   }
}
