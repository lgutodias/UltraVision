/** 
 * @author luiz
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.Title;
import model.Customer;
import model.CustomerFactory;
import model.Keyboard;
import model.Media;
import model.Rental;
import model.TitleFactory;

public class Main {
	
	static List<Title> titles = new ArrayList<>();
	static List<Customer> customers = new ArrayList<>();
	static List<Rental> rentals = new ArrayList<>();
	
	static int id = 1;
	static int idc = 1;
	static String planType;
	//static String media;
	
	
	public static void main(String[] args) {
		
		
		boolean running = false;
		
		//Default customers
		customers.add(CustomerFactory.makeCustomer(idc++, "Daniel", "Deronda", "d.deronda@hotmail.com",
				"4451653694824657", "PR"));
		customers.add(CustomerFactory.makeCustomer(idc++, "Hans", "Castorp", "hanscastorp15@yahoo.com",
				"5568925842276361", "Music"));
		customers.add(
				CustomerFactory.makeCustomer(idc++, "Tom", "Jones", "tjoness@hotmail.com", "5525344856451997", "Video"));
		customers.add(CustomerFactory.makeCustomer(idc++, "Molly", "Bloom", "molly-bloom@gmail.com", "5468223523238497",
				"TV"));
		customers.add(CustomerFactory.makeCustomer(idc++, "Anne", "Elliot", "lady.aelliot@yahoo.com",
				"4754995472713938", "PR"));
		customers.add(
				CustomerFactory.makeCustomer(idc++, "Louisa", "Pollit", "louisap@gmail.com", "4519242548200255", "Music"));

		// Default titles
		titles.add(TitleFactory.makeLiveConcertVideo(id++, "U2", "Innocence + Experience", "Rock", 2016, "Blu-ray"));
		titles.add(TitleFactory.makeBoxSet(id++, "Game of Thrones", 6, "Drama", 2016, "Blu-ray"));
		titles.add(TitleFactory.makeMovie(id++, "Jake Kasdan", "Jumanji: Next Level", "Comedy", 2019, "Blu-ray"));
		titles.add(TitleFactory.makeAlbum(id++, "Alicia Keys", "Girl On Fire", "R&B", 2012, "CD"));
		titles.add(TitleFactory.makeBoxSet(id++, "Friends", 10, "Comedy", 2004, "DVD"));
		titles.add(TitleFactory.makeMovie(id++, "Steve McQueen", "12 Years a Slave", "Drama", 2014, "DVD"));
		titles.add(TitleFactory.makeAlbum(id++, "Dua Lipa", "Future Nostalgia", "Pop", 2020, "CD"));
		titles.add(TitleFactory.makeLiveConcertVideo(id++, "Foo Fighters", "Live at Wembley Stadium", "Rock", 2008,
				"DVD"));
		titles.add(TitleFactory.makeMovie(id++, "Frank Darabont", "The Shawshank Redemption", "Drama", 1995, "DVD"));
		titles.add(TitleFactory.makeMovie(id++, "Steven Spielberg", "Saving Private Ryan", "War", 1998, "DVD"));
		titles.add(TitleFactory.makeLiveConcertVideo(id++, "Bob Marley", "Uprising Live!", "Reggae", 2014, "DVD"));
		titles.add(TitleFactory.makeAlbum(id++, "David Guetta", "7", "Dance", 2018, "CD"));
		
		
		do {
			
			System.out.println("=====::::::::::| ULTRA VISION |::::::::::=====\n");
			System.out.println("(1) RENT A TITLE");
			System.out.println("(2) RETURN A TITLE");
			System.out.println("(3) SEARCH A TITLE");
			System.out.println("(4) SEARCH A CUSTOMER");
			System.out.println("(5) ADD AN ALBUM");
			System.out.println("(6) ADD A LIVE CONCERT VIDEO");
			System.out.println("(7) ADD A MOVIE");
			System.out.println("(8) ADD A BOX SET");
			System.out.println("(9) ADD A CUSTOMER");
			System.out.println("(0) UPDATE A CUSTOMER\n");
			System.out.println("=====::::::::::| ============ |::::::::::=====\n");
			String option = Keyboard.textInput("ENTER AN OPTION: ");
			
			switch (option) {
			
			case "1":
				// Option to rent a title
				CustomerFactory.displayCustomer(customers);
				
				int counter = 0;
				int idCust = Keyboard.numberInput("TYPE THE CUSTOMER ID: ");
				
				for(Rental r : rentals) {
					
					if(r.getCustomer().getId() == idCust) {
						++counter;
					}
				}
				
				if(counter < 4) {
					--idCust;
					TitleFactory.display(titles, customers.get(idCust));
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
				//Option to return a Title
				int idTitle = Keyboard.numberInput("TYPE THE TITLE ID: ");
				
				
				
				
				
				/*System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====\n");
				TitleFactory.displayTitle(TitleFactory.searchTitle(rentals, idTitle));
				System.out.println("\n");
				System.out.println("=====::::::::::| ============ |::::::::::=====\n");*/
			break;
			
			case "5":
				// Option to add an Album
				String artist = Keyboard.textInput("ENTER ARTIST/BAND: ");
				String title = Keyboard.textInput("ENTER TITLE: ");
				String genre = Keyboard.textInput("ENTER GENRE: ");
				int year = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				String media = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				/*media  = "";
				do {
					media = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				} while (!= isMedia());*/
				
				titles.add(TitleFactory.makeAlbum(id++, artist, title, genre, year, media));
			break;
			
			case "6":
				// Option to add a Live Concert Video
				artist = Keyboard.textInput("ENTER ARTIST/BAND: ");
				title = Keyboard.textInput("ENTER TITLE: ");
				genre = Keyboard.textInput("ENTER GENRE: ");
				year = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				media = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				/*media  = "";
				do {
					media = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				} while (!= isMedia());*/
				
				titles.add(TitleFactory.makeLiveConcertVideo(id++, artist, title, genre, year, media));
			break;
			
			case "7":
				//Option to add a Movie
				title = Keyboard.textInput("ENTER MOVIE TITLE: ");
				genre = Keyboard.textInput("ENTER GENRE: ");
				String director = Keyboard.textInput("ENTER DIRECTOR: ");
				year  = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				media  = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				
				titles.add(TitleFactory.makeMovie(id++, director, title, genre, year,
						media));
			break;
			
			case "8":
				//Option to add a Box Set
				title = Keyboard.textInput("ENTER BOX SET TITLE: ");
				int season = Keyboard.numberInput("ENTER SEASON NUMBER: ");
				genre = Keyboard.textInput("ENTER GENRE: ");
				year  = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				media  = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				
				titles.add(TitleFactory.makeBoxSet(id++, title, season, genre, year,
						media));
			break;
			
			case "4":
				//Option to search a Title
				String word = Keyboard.textInput("ENTER A KEY WORD: ");
				System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====\n");
				TitleFactory.displayTitle(TitleFactory.searchTitle(titles, word));
				System.out.println("\n");
				System.out.println("=====::::::::::| ============ |::::::::::=====\n");
			break;
			
			case "9":
				//Option to add a Customer
				String fname = Keyboard.textInput("ENTER FIRST NAME: ");
				String lname = Keyboard.textInput("ENTER LAST NAME: ");
				String email = "";
					do {
						email = Keyboard.textInput("ENTER EMAIL: ");
					} while (!isEmail(email));
				
				String creditcard  = "";
					do {
						creditcard = Keyboard.textInput("ENTER CREDIT CARD: ");
					} while (!isCreditCard(creditcard));
				
				customers.add(CustomerFactory.makeCustomer(idc++, fname, lname, email, creditcard, planType));
			break;
			
			default:
				System.out.println("*** SORRY! INVALID OPTION ***\n");
				break;
			}
			
			//Ternary operator
			running = (Keyboard.textInput("PRESS ENTER FOR MAIN MENU OR X TO CLOSE THE SYSTEM")
					.equalsIgnoreCase("x")) ? true : false;
			
			
		} while(!running);
		
		
		
		System.out.println("========== Customer ============");
		CustomerFactory.displayCustomer(customers);
		
		System.out.println("========== Title ============");
		TitleFactory.displayTitle(titles);
		
		System.out.println("========== Rentals ============");
		Rental.displayRentals(rentals);
		

	}
	
	// Boolean to validate Email pattern
	static boolean isEmail(String email) {
		return email.matches("^[_a-z0-9-\\+]+(\\.[_a-z0-9-]+)*@"+ "[a-z0-9-]"
	            + "+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$");
	}
	
	//Boolean to validate Credit Card number pattern
	public static boolean isCreditCard(String creditcard) {
		return creditcard.matches("(\\d{4}[-. ]?){4}|\\d{4}[-. ]?\\d{6}[-. ]?\\d{5}");
	}
	
	
	/*public static boolean isMedia(String media) {
		return media.matches(^(?:("CD"))|(?:("DVD"))$);
	}*/
	

}
