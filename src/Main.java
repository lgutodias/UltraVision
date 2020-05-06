/** 
 * @author luiz
 */

import java.util.ArrayList;
import java.util.List;

import interfaces.Title;
import model.Customer;
import model.CustomerFactory;
import model.Keyboard;
import model.Rental;
import model.TitleFactory;

public class Main {
	
	static List<Title> titles = new ArrayList<>();
	static List<Customer> customers = new ArrayList<>();
	static List<Rental> rentals = new ArrayList<>();
	
	static int id = 1;
	static int idc = 1;
	//static int year;
	//static String title;
	//static String genre;
	//static String media;
	

	public static void main(String[] args) {
		
		boolean running = false;
		//TitleFactory tf = new TitleFactory();
		
		
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
				// Option to add an Album
				String artist = Keyboard.textInput("ENTER ARTIST/BAND: ");
				String title = Keyboard.textInput("ENTER TITLE: ");
				String genre = Keyboard.textInput("ENTER GENRE: ");
				int year = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				String media = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				
				titles.add(TitleFactory.makeAlbum(id++, artist, title, genre, year, media));
			break;
			
			case "3":
				//Option to add a Movie
				title = Keyboard.textInput("ENTER MOVIE TITLE: ");
				genre = Keyboard.textInput("ENTER GENRE: ");
				String director = Keyboard.textInput("ENTER DIRECTOR: ");
				year  = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				media  = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				
				titles.add(TitleFactory.makeMovie(id++, director, title, genre, year,
						media));
			break;
			
			case "4":
				//Option to add a Box Set
				title = Keyboard.textInput("ENTER BOX SET TITLE: ");
				int season = Keyboard.numberInput("ENTER SEASON NUMBER: ");
				genre = Keyboard.textInput("ENTER GENRE: ");
				year  = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				media  = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				
				titles.add(TitleFactory.makeBoxSet(id++, title, season, genre, year,
						media));
			break;
			
			case "5":
				//Option to search a Title
				String word = Keyboard.textInput("ENTER A KEY WORD: ");
				System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====");
				TitleFactory.displayTitle(TitleFactory.searchTitle(titles, word));
			break;
			
			case "6":
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
				
				customers.add(CustomerFactory.makeCustomer(idc++, fname, lname, email, creditcard));
			break;
			
			default:
				System.out.println("*** SORRY! INVALID OPTION ***\n");
				break;
			}
			
			//Ternary operator
			running = (Keyboard.textInput("=ENTER (Y)YES FOR MAIN MENU OR (N)NO CONTINUE=")
					.equalsIgnoreCase("y")) ? true : false;
			
			
		} while(!running);
		

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

}
