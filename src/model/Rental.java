/**
 * @author diego
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.Title;

/** This Class we had Raul's orientation about how to use the serializable.
 * 	Rental implements serializable to flat the code structure into a binary.
 *  It allows to be stored as an object in a text file. 
 * 
 */

public class Rental implements Serializable {
	

	private static final long serialVersionUID = 4352976132442076566L;
	//Attributes
	private List<Titles> titles = new ArrayList<>();
	private Customer customer;
	
	// Constructor
	public Rental(Customer customer) {
		this.customer = customer;
	}
	
	// Method to show titles on the rentals list 
	public static void displayRentals(List<Rental> rentals) {
		String content = "";
		for (Rental r : rentals) {
			System.out.println(r);
			content += r.toString() + "\n";
		}
		
	}
	// Search method to get the titles rented 
	public static List<Rental> searchRental(List<Rental> rental, String word) {

		List<Rental> l = new ArrayList<>();
		word = word.toLowerCase();
		for (Rental r : rental) {
			if (r.getCustomer().toString().contains(word)) {
				l.add(r);
			} 
		}
		return l;
	}
	
	
	//Getters and Setters
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public void setTitle(List<Titles> titles) {
		this.titles = titles;
	}
	public List<Titles> getTitles(List<Titles> titles){
		return this.titles = titles;
	}
	// This method saves the title on the List
	public Rental addTitle(Titles title) {
		this.titles.add(title);
		return this;
	}
	
	@Override
	public String toString() {
		
		String content = "";
		
		for (Titles t : this.titles) {
			content = "Customer [id=" + this.customer.getId() + ", customer="
		+ this.customer.getFname() + "], Title[title=" + t.getTitle() 
		+ ", genre=" + t.getGenre() + ", title ID=" + t.getId() + "]";
		}
		return content;
   }
}
