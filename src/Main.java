/** 
 * @author luiz
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import model.Customer;
import model.CustomerFactory;
import model.FileManager;
import model.Keyboard;
import model.Rental;
import model.TitleFactory;
import model.Titles;

public class Main {
	
	// Attributes
	static List<Titles> titles = new ArrayList<>();
	static List<Customer> customers = new ArrayList<>();
	static List<Rental> rentals = new ArrayList<>();
	static File file = new File("titles.txt");
	static File filec = new File("customers.txt");
	static File filer = new File("rentals.txt");
	static FileManager<Titles> fm = new FileManager<>();
	static FileManager<Customer> cm = new FileManager<>();
	static FileManager<Rental> rm = new FileManager<>();
	
	static int id = 1;
	static int idc = 1;
	static int idr = 1;
	static String planType;
	
	// Main method
	public static void main(String[] args) {
		
		
		boolean running = false;
		TitleFactory tf = new TitleFactory();
		CustomerFactory cf = new CustomerFactory();
		
		
		Titles[] dataTitles = fm.read(file);
		
		titles = new ArrayList<>(Arrays.asList(dataTitles));
		
		// Comparator used to catch the last Title ID number when adding a new Title on the list (avoid duplicated IDs)
		Titles greatestId = titles.stream().max(Comparator.comparing(Titles::getId)).orElseThrow(NoSuchElementException::new);
		id = (greatestId.getId() > 1) ? greatestId.getId() : 1;
		
		
		Customer[] dataCustomer = cm.read(filec);
		
		customers = new ArrayList<>(Arrays.asList(dataCustomer));
		
		// Comparator used to catch the last Customer ID number when adding a new Title on the list (avoid duplicated IDs)
		Customer greatestIdc = customers.stream().max(Comparator.comparing(Customer::getId)).orElseThrow(NoSuchElementException::new);
		idc = (greatestIdc.getId() > 1) ? greatestIdc.getId() : 1;
		
		
		Rental[] dataRental = rm.read(filer);
		
		rentals = new ArrayList<>(Arrays.asList(dataRental));
		Rental greatestIdr = rentals.stream().max(Comparator.comparing(Rental::getId)).orElseThrow(NoSuchElementException::new);
		idr = (greatestIdr.getId() > 1) ? greatestIdr.getId() : 1;
		
		// Do loop that runs the Main Menu
		do {
			
			System.out.println("=====::::::::::| ULTRA VISION |::::::::::=====\n");
			System.out.println("(1)  RENT A TITLE");
			System.out.println("(2)  RETURN A TITLE");
			System.out.println("(3)  SEARCH A TITLE");
			System.out.println("(4)  SEARCH A CUSTOMER");
			System.out.println("(5)  ADD AN ALBUM");
			System.out.println("(6)  ADD A LIVE CONCERT VIDEO");
			System.out.println("(7)  ADD A MOVIE");
			System.out.println("(8)  ADD A BOX SET");
			System.out.println("(9)  ADD A CUSTOMER");
			System.out.println("(10) UPDATE A CUSTOMER");
			System.out.println("(11) DELETE A CUSTOMER");
			System.out.println("(12) SHOW RENTALS LIST");
			System.out.println("(13) SHOW TITLES LIST");
			System.out.println("(14) SHOW CUSTOMERS LIST\n");
			System.out.println("=====::::::::::| ============ |::::::::::=====\n");
			String option = Keyboard.textInput("ENTER AN OPTION: ");
			
			// Beginning of a Switch statement that allows the user to catch one option in the Main Menu
			switch (option) {
			
			case "1":
				// Option to rent a title
				cf.displayCustomer(customers);
				
				int counter = 0;
				int idCust = Keyboard.numberInput("TYPE THE CUSTOMER ID: ");
				
				for(Rental r : rentals) {
					
					if(r.getCustomer().getId() == idCust) {
						++counter;
					}
				}
				
				if(counter < 4) {
					
					// We are using Lambda expression
					Customer c1 = customers.stream().filter(c-> idCust == c.getId()).findAny().orElse(null);	
					
					if(c1 == null) {
						System.out.println("INVALID ID!");
						break;
					}
					
					tf.display(titles, c1);
					int idTitle = Keyboard.numberInput("TYPE THE TITLE ID: ")-1;
					
					Titles title = titles.get(idTitle);
					Customer customer = customers.get(idCust);
					customer.getMemberid().addPoints(10);
					rentals.add(new Rental(customer).addTitle(title).setId(++idr));
					
					Rental[] dataRental2 = rentals.toArray(new Rental[rentals.size()]);
					System.out.println("RENTAL SAVED: " + rm.save(filer, dataRental2));
					
					System.out.println("***TITLE SUCCESSFULLY RENTED***\n");
					System.out.println("=====::::::::::| ============ |::::::::::=====\n");
					
				} else {
					System.out.println("SORRY! RENTAL LIMIT IS UP TO 4 PER CUSTOMER\n");
					System.out.println("=====::::::::::| ============ |::::::::::=====\n");
				}
			break;
			
			case "2":
				//Option to return a Title
				String word1 = Keyboard.textInput("ENTER CUSTOMER'S NAME OR SURNAME: ");
				System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====\n");
				Rental.displayRentals(Rental.searchRental(rentals, word1));
				System.out.println("\n");
				System.out.println("=====::::::::::| ============ |::::::::::=====\n");

				int idCust2 = Keyboard.numberInput("TYPE THE CUSTOMER ID: ");
				
				Rental r1 = rentals.stream().filter(r-> idCust2 == r.getId()).findAny().orElse(null);	
				
				if(r1 == null) {
					System.out.println("Id does not exist");
					break;
				}
				
				rentals.remove(r1);

				Rental[] dataRental1 = rentals.toArray(new Rental[rentals.size()]);
				System.out.println("RENTAL SAVED: " + rm.save(filec, dataRental1));

			break;
			
			case "3":
				//Option to search a Title
				String word2 = Keyboard.textInput("ENTER A KEY WORD: ");
				System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====\n");
				tf.displayTitle(tf.searchTitle(titles, word2));
				System.out.println("\n");
				System.out.println("=====::::::::::| ============ |::::::::::=====\n");
			break;
			
			case "4":
				//Option to search a Customer
				String word3 = Keyboard.textInput("ENTER CUSTOMER'S NAME OR SURNAME: ");
				System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====\n");
				cf.displayCustomer(cf.searchCustomer(customers, word3));
				System.out.println("\n");
				System.out.println("=====::::::::::| ============ |::::::::::=====\n");
			break;
			
			case "5":
				// Option to add an Album
				String artist = Keyboard.textInput("ENTER ARTIST/BAND: ");
				String title = Keyboard.textInput("ENTER TITLE: ");
				String genre = Keyboard.textInput("ENTER GENRE: ");
				int year = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				String media = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				
				titles.add(tf.makeAlbum(++id, artist, title, genre, year, media));
				
				Titles[] dataTitle = titles.toArray(new Titles[titles.size()]);
				System.out.println("TITLE SAVED: " + fm.save(file, dataTitle));
				
			break;
			
			case "6":
				// Option to add a Live Concert Video
				artist = Keyboard.textInput("ENTER ARTIST/BAND: ");
				title = Keyboard.textInput("ENTER TITLE: ");
				genre = Keyboard.textInput("ENTER GENRE: ");
				year = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				media = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				
				titles.add(tf.makeLiveConcertVideo(++id, artist, title, genre, year, media));
				
				Titles[] dataTitle2 = titles.toArray(new Titles[titles.size()]);
				System.out.println("TITLE SAVED: " + fm.save(file, dataTitle2));
				
			break;
			
			case "7":
				//Option to add a Movie
				title = Keyboard.textInput("ENTER MOVIE TITLE: ");
				genre = Keyboard.textInput("ENTER GENRE: ");
				String director = Keyboard.textInput("ENTER DIRECTOR: ");
				year  = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				media  = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				
				titles.add(tf.makeMovie(++id, director, title, genre, year,
						media));
				
				Titles[] dataTitle3 = titles.toArray(new Titles[titles.size()]);
				System.out.println("TITLE SAVED: " + fm.save(file, dataTitle3));
				
			break;
			
			case "8":
				//Option to add a Box Set
				title = Keyboard.textInput("ENTER BOX SET TITLE: ");
				int season = Keyboard.numberInput("ENTER SEASON NUMBER: ");
				genre = Keyboard.textInput("ENTER GENRE: ");
				year  = Keyboard.numberInput("ENTER YEAR OF RELEASE: ");
				media  = Keyboard.textInput("ENTER MEDIA FORMAT: ");
				
				titles.add(tf.makeBoxSet(++id, title, season, genre, year,
						media));
				
				Titles[] dataTitle4 = titles.toArray(new Titles[titles.size()]);
				System.out.println("TITLE SAVED: " + fm.save(file, dataTitle4));
				
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
				
				customers.add(cf.makeCustomer(++idc, fname, lname, email, creditcard, planType));
				
				Customer[] dataCustomer1 = customers.toArray(new Customer[customers.size()]);
				System.out.println("CUSTOMER SAVED: " + cm.save(filec, dataCustomer1));
				
			break;
			
			case "10":
				//Option to update a Customer
				String word4 = Keyboard.textInput("ENTER CUSTOMER'S NAME OR SURNAME: ");
				System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====\n");
				cf.displayCustomer(cf.searchCustomer(customers, word4));
				System.out.println("\n");
				System.out.println("=====::::::::::| ============ |::::::::::=====\n");
				
				int idCust3 = Keyboard.numberInput("TYPE THE CUSTOMER ID: ");
				--idCust3;
				if(idCust3 >= 0 && idCust3 < customers.size()) {
										
					customers.get(idCust3).setFname(Keyboard.textInput("ENTER CUSTOMER'S NAME"))
						.setLname(Keyboard.textInput("ENTER LAST NAME: "))
						.setEmail(Keyboard.textInput("ENTER EMAIL: "))
						.setCreditcard(Keyboard.textInput("ENTER CREDIT CARD: "));
					
					
					Customer[] dataCustomers = customers.toArray(new Customer[customers.size()]);
					System.out.println("CUSTOMER SAVED: " + cm.save(filec, dataCustomers));
								
				} else {
					System.out.println("INVALID ID!");
				}

			break;
			
			case "11":
				//Option to delete a Customer
				String word5 = Keyboard.textInput("ENTER CUSTOMER'S NAME OR SURNAME: ");
				System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====\n");
				cf.displayCustomer(cf.searchCustomer(customers, word5));
				System.out.println("\n");
				System.out.println("=====::::::::::| ============ |::::::::::=====\n");
				
				int idCust4 = Keyboard.numberInput("TYPE THE CUSTOMER ID: ");
				--idCust4;
				if(idCust4 >= 0 && idCust4 < customers.size()) {
										
					customers.remove(idCust4);
											
					Customer[] dataCustomers = customers.toArray(new Customer[customers.size()]);
					System.out.println("CUSTOMER SAVED: " + cm.save(filec, dataCustomers));
								
				} else {
					System.out.println("INVALID ID!");
				}

			break;
			
			case "12":
				// Option to show rentals entire list
				System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====\n");
				Rental.displayRentals(rentals);
				System.out.println("\n");
				System.out.println("=====::::::::::| ============ |::::::::::=====\n");
			break;
			
			case "13":
				// Option to show titles entire list
				System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====\n");
				tf.displayTitle(titles);
				System.out.println("\n");
				System.out.println("=====::::::::::| ============ |::::::::::=====\n");
			break;
			
			case "14":
				// Option to show customers entire list
				System.out.println("=====:::::::: | SEARCH RESULTS | ::::::::=====\n");
				cf.displayCustomer(customers);
				System.out.println("\n");
				System.out.println("=====::::::::::| ============ |::::::::::=====\n");
			break;
			
			default:
				System.out.println("*** SORRY! INVALID OPTION ***\n");
				break;
			}
			// End of the Switch statement
			
			
			//Ternary operator that allows the user to keep running the system or end it
			running = (Keyboard.textInput("PRESS ENTER FOR MAIN MENU OR X TO CLOSE THE SYSTEM")
					.equalsIgnoreCase("x")) ? true : false;
			
			
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
