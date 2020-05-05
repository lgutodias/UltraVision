/** 
 * @author luiz
 */

import java.util.ArrayList;
import java.util.List;

import interfaces.Title;
import model.Customer;
import model.Keyboard;
import model.Rental;

public class Main {
	
	static List<Title> titles = new ArrayList<>();
	static List<Customer> customers = new ArrayList<>();
	static List<Rental> rentals = new ArrayList<>();
	
	static int id = 1;
	

	public static void main(String[] args) {
		
		boolean running = false;
		
		
		do {
			
			System.out.println("=====::::::::::| ULTRA VISION |::::::::::=====\n");
			System.out.println("(1) RENT A TITLE");
			System.out.println("(2) ADD ALBUM/LIVE CONCERT");
			System.out.println("(3) ADD A MOVIE");
			System.out.println("(4) ADD BOX SET");
			System.out.println("(5) SEARCH TITLE");
			System.out.println("(6) ADD CUSTOMER\n");
			System.out.println("=====::::::::::| ============ |::::::::::=====\n");
			String option = Keyboard.textInput("ENTER AN OPTION: ");
			
			switch (option) {
			
			case "1":
				// Option to rent a title
				int counter = 0;
				int idCust = Keyboard.numberInput("TYPE THE CUSTOMER ID: ");
				
				for(Rental r : rentals) {
					
					if(r.getCustomer().getId() == idCust) {
						++counter;
					}
				}
				
				if(counter < 4) {
					--idCust;
					int idTitle = Keyboard.numberInput("TYPE THE TITLE ID: ")-1;
					
					Title title = titles.get(idTitle);
					Customer customer = customers.get(idCust);
					customer.getMemberid().addPoints(10);
					rentals.add(new Rental(customer).addTitle(title));
					
					System.out.println("***TITLE SUCCESSFULLY RENTED***\n");
					System.out.println("=====::::::::::| ============ |::::::::::=====\n");
					
				} else {
					System.out.println("SORRY! RENTAL LIMIT IS UP TO 4 PER CUSTOMER\n");
					System.out.println("=====::::::::::| ============ |::::::::::=====\n");
				}
			break;
			
			case "2":
				// Option to add an album
				String artist = Keyboard.textInput("ENTER ARTIST/BAND: ");
				String title = Keyboard.textInput("ENTER TITLE: ");
				String genre = Keyboard.textInput("ENTER GENRE: ");
				int year = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				String media = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				
				titles.add(makeAlbum(id++, artist, title, genre, year, media));
			break;
			
			}
			
			
		} while(!running);
		

	}

}
