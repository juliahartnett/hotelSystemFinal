package hotelSystem;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Paths;

	public class hotelSystem {
		
		public static char logInStat = 'F'; // made this a global variable to avoid some other annoying stuff
		public static String currentUser = ""; // maybe add users email here?
		
		public static void main(String[] args) throws FileNotFoundException, IOException {
			
			// set some values
			char kg = 'y'; // LCV
			
			// print welcome statement
			System.out.println("Welcome to the Halien Hotel!\n");
			// enter the loop to provide the users with options
			while(kg == 'y') {
				System.out.println("What would you like to do? ");
				// print the list of things to do
				System.out.println("1. Our Story\n2. See Room Types\n3. Make a Reservation\n4. Create or Sign In to an Account\n5. Contact Us\n6. Log Out of an Account\n7. Quit");
					
				// get user input
				Scanner scan = new Scanner(System.in); // creates a Scanner object that reads from the keyboard
				int choice = scan.nextInt();
					
				if(choice == 1) {
					history();
				} // end if
							
				else if(choice == 2){
					seeRooms();
				} // end else if
					
				else if(choice == 3) {
					makeReservation(currentUser, scan);		
				} // end else if
					
				else if(choice == 4) {
					// create or sign in to your account
					System.out.println("Would you like to 1. Create an account or 2. Sign in to an existing account? ");
					int c = scan.nextInt();
					if(c == 1) {
						createAccount(scan);
					}
					else if(c == 2) {
						logIn(scan);
					}
					else {
						System.out.println("This was not a valid option. Returning to main menu.\n");
					}
				} // end else if
					
				else if(choice == 5) {
					contactUs();
					
				}// end else if
					
				else if(choice == 6) {
					signOut();
				}
					
				else if(choice == 7) {
					System.out.println("Thank you for visiting the Halien Hotel! We hope to see you soon!");
					kg = 'n';	
					scan.close();
				}
					
				else {
					System.out.println("Please enter a valid option from the list\n");
						
				} // end else
					
					
			} // end the while loop

		} // end the main method 
			
			
		public static void history() {
			System.out.println("The Halien Hotel is located in the best viewpoint of the Boston Harbor, which allows guests to feel the natural scenery of the harbor and feel the breath of the sea. \r\n"
					+ "We are one of the most popular hotels in Boston Harbor, ideally located on the Harbor, just steps away from the shopping malls and restaurants.\nIn the meantime, we will also provide high-quality service, comfortable rooms, and a Boston-style breakfast. The Halien Hotel at the Boston harbor is \nsure to meet the needs of the most discerning travelers.\r\n");
				
		} // end history function
			
		public static void seeRooms() {
			System.out.println("a. Twin sized bed (For 1 people) - approximately 130 square feet\nb. Queen sized bed (For 1-2 people) - approximately 190 square feet\nc. King sized bed (For 1-2 people) - approximately 270 square feet\nd. 2 Queen sized bed (For 2-4 people) - approximately 350 square feet\ne. King & Queen bed (For 2-4 people) - approximately 370 square feet\nf. 2 King sized bed (For 2-4 people) - approximately 400 square feet\n");
		} // end see rooms function
		
		
		public static void reservationSteps(Scanner scan) {
			// once the customers info is in and they want to make a reservation
			// moved to its own function bc otherwise i'd be copying this 3x

			//ArrayList<String> cust = customers.get(currentUser);
			// write the version of this that gets it from the file
			
			System.out.println("To complete your Reservation: ");
			
			System.out.println("Enter the number of occupants: ");
			int numPeople = scan.nextInt();
			System.out.println("Enter the check in time: ");
			String checkin = scan.next();
			checkin = validation.validateCheckin(checkin, scan);
			System.out.println("Enter the check out time: ");
			String checkout = scan.next();
			checkout = validation.validateCheckout(checkout, scan);
			System.out.println("Select a room type: ");
			System.out.println("a. Twin sized bed (For 1 people) - approximately 130 square feet\nb. Queen sized bed (For 1-2 people) - approximately 190 square feet\nc. King sized bed (For 1-2 people) - approximately 270 square feet\nd. 2 Queen sized bed (For 2-4 people) - approximately 350 square feet\ne. King & Queen bed (For 2-4 people) - approximately 370 square feet\nf. 2 King sized bed (For 2-4 people) - approximately 400 square feet\n");
			
			char roomType = scan.next().charAt(0);
			
			if(roomType != 'a' && roomType != 'b' && roomType != 'c' && roomType != 'd' && roomType != 'e'&& roomType != 'f') {
				System.out.println("This is not a valid room type - reservation voided. ");	
			} // if the roomtype is not a,b,c,d,e then void the reservation 
			else {
				System.out.println("Thank you for your reservation, see you soon!");
			}
			
		}
			
		public static void makeReservation(String currentUser, Scanner scan) throws FileNotFoundException, IOException {

			System.out.println("Would you like to make a reservation? Enter '1' if yes ");
			int makeRes = scan.nextInt();
				
			if(makeRes == 1) {
				// what happens when they want to make a reservation
				// check to see if the guest is logged in
				if(logInStat == 'T') {
					reservationSteps(scan);
						
				} // end the logInStat T if statement
					
				else {
					// ask the user if they want to create an account, sign in, or continue as a guest
					System.out.println("Would you like to 1. Create an account 2. Sign in to an existing account or 3. Continue as a guest");
					int c = scan.nextInt();
					if(c == 1) {
						createAccount(scan); // create an account
						logIn(scan); // sign in to account
						reservationSteps(scan);
					}
					else if(c == 2) {
						logIn(scan);
						if(logInStat == 'T') {
						reservationSteps(scan);
						}

					}
					else if (c==3) {
						// if they want to continue as a guest
						System.out.println("Enter your email: ");
						String email = scan.next();
						
						email = emailValidation.validateEmail(email, scan);

						//} // end validation loop
						System.out.println("Enter your first name: ");
						String firstName = scan.next();
						System.out.println("Enter your last name: ");
						String lastName = scan.next();
						System.out.println("Enter your country: ");
						String country = scan.next();
						System.out.println("Enter your zip code: ");
						String zipCode = scan.next();
						System.out.println("Enter your phone number: ");
						String phoneNumber = scan.next();
						
						phoneNumber = validation.validatePhone(phoneNumber, scan);
						
						System.out.println("Enter the number of occupants: ");
						int numPeople = scan.nextInt();

						System.out.println("Enter the check in time: ");
						String checkin = scan.next();
						checkin = validation.validateCheckin(checkin, scan);

						System.out.println("Enter the check out time: ");
						String checkout = scan.next();
						checkout = validation.validateCheckout(checkout, scan);


						System.out.println("Select a room type: ");
						System.out.println("a. Twin sized bed (For 1 people) - approximately 130 square feet\nb. Queen sized bed (For 1-2 people) - approximately 190 square feet\nc. King sized bed (For 1-2 people) - approximately 270 square feet\nd. 2 Queen sized bed (For 2-4 people) - approximately 350 square feet\ne. King & Queen bed (For 2-4 people) - approximately 370 square feet\nf. 2 King sized bed (For 2-4 people) - approximately 400 square feet\n");
						
						char roomType = scan.next().charAt(0);
						System.out.println(roomType);
						
						if(roomType != 'a' && roomType != 'b' && roomType != 'c' && roomType != 'd' && roomType != 'e' && roomType != 'f') {
							System.out.println("This is not a valid room type - reservation voided. ");	
						} // if the roomtype is not a,b,c,d,e then void the reservation 
						else {
							System.out.println("Thank you for your reservation, see you soon!");
						}// end else				
						
					}// end the register as a guest
					
					else {
						// if they do not enter 1,2, or 3
						System.out.println("This was not a valid option, returning to menu");
						
					}
							
					}
				}
				
				} // end the function

		
		public static void createAccount(Scanner scan) {
			System.out.println("Having an account at our hotel makes check-in more efficient. Also, \r\n"
					+ "- Guests and hotel staff can avoid close-contact interactions.\r\n"
					+ "- Hotels can collect all necessary information from guests.\r\n"
					+ "- Employees can use their time more effectively.\r\n"
					+ "- Guests can get to their rooms as soon as possible.\r\n"
					+ "");

			//char emailGood = 'n';
			System.out.println("Enter your email address: ");
			String email = scan.next();
			
			email = emailValidation.validateEmail(email, scan); // call the function from emailValidation to validate the emails
			
			// check to see that there is not an account with that email
		
			System.out.println("Create a password for your account. Passwords must be at least 8 characters: ");
			String password = scan.next();

			password = validation.validatePasswords(password, scan);
					
			System.out.println("Enter your first name: ");
			String firstName = scan.next();
			System.out.println("Enter your last name: ");
			String lastName = scan.next();
			System.out.println("Enter your country: ");
			String country = scan.next();
			System.out.println("Enter your zip/postal code: ");
			String zipCode = scan.next();
			System.out.println("Enter your phone number: ");
			String phoneNumber = scan.next();
			
			phoneNumber = validation.validatePhone(phoneNumber, scan);
	
			
			
			// write the users data to the file
			try {
				createFile();
				
			}catch(Exception e) {
				System.out.println("Error creating file");
			}
			
			
			
			try {
				writeToFile(email, password, firstName, lastName, country, zipCode, phoneNumber);
				
			}catch(Exception e) {
				System.out.println("Error writing user data to file");
			}
			
			System.out.println("Account created. Please sign in.");

		}
		
		
		public static void logIn(Scanner scan) throws FileNotFoundException, IOException {
			
			if(logInStat == 'T') {
				System.out.println("Account already logged in, log out to log in with a new account.\n");				
			} // end if 
			
			else {
				System.out.println("Enter your email: "); // ask the user for their email
				String email = scan.next();
				
				try(BufferedReader br = new BufferedReader(new FileReader("customers.txt"))){
					String line;
					char foundEmail = 'n';
					while((line = br.readLine()) != null || foundEmail != 'y') {
						//System.out.println(line);
						if(line.contains(email)) {
							foundEmail = 'y' ;
							 // if the email address is in the row then check for the password
							 System.out.println("Enter your password: ");
							 String password = scan.next();
							 if(line.contains(password)) {
								 // if the row contains the password then sign the user in
								 currentUser = email;
								 logInStat = 'T'; // change the logInStat to T
								 String [] arrayOfCustomer = line.split(" ",8 );
								 String name = arrayOfCustomer[2]; // get the customers name
								 System.out.println("Welcome, " + name); // print a welcome message								
							 }
							 else {
								 // row does not contain password
								 System.out.println("Password does not match");								 
							 }							 
						 } // end if row contains email
					}// end the while loop
	
												
				}// end try 
				catch(Exception e) {
					System.out.println("No account with that email found");	
				} // end catch
			} // end else
			
			
		} // end logIn function
							
			
		public static void contactUs() {
				// print out the contact info for the hotel
			System.out.println("\nADDRESS\n1 Seaport Ln, Boston,\nMassachusetts, 022xx\n\nTELEPHONE\n+1-617-385-xxxx\n\nGENERAL FAX\n617-385-xxxx\n\nEMAIL\ninfo@halienboston.com\n");		
		} // end the contact us function
			
		
		public static void signOut() {
			// sign out of account if signed in, print a message if not signed 
			// in and attempt to sign out
			if(logInStat == 'F') {
				System.out.println("No account logged in.\n");
			}
			else {
				logInStat = 'F';
				System.out.println("Account successfully logged out.\n");	
			}			
			
		} // end signOut function
		
		public static void createFile() {
			try {
				File myObj = new File("customers.txt");
				if (myObj.createNewFile()) {
					//System.out.println("File created");
				}
				else {
					//System.out.println("File already exists");
				}	
			} catch (IOException e) {
				System.out.println("Error creating the file");
				e.printStackTrace();							
			}
						
		}
		
		public static void writeToFile(String email, String password, String firstName, String lastName, String country, String zipCode, String phoneNumber) {
			try {
				String customer = email + " " +  password  + " " + firstName + " " + lastName + " " + country + " " + zipCode + " " + phoneNumber + "\n";
				FileWriter myWriter = new FileWriter("customers.txt", true);
				myWriter.write(customer);
				myWriter.close();
			} catch (IOException e) {
				System.out.println("Error writing to the file");
				e.printStackTrace();
			}	
		}
			

	}  // end the hotel system class
