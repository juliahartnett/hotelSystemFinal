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
import java.util.Date;

	public class hotelSystem {
		
		public static char logInStat = 'F';
		public static String currentUser = "";
		public static String currentUserInfo = "";
		
		public static void main(String[] args) throws Exception {
			
			// set some values
			char kg = 'y'; // LCV
			
			// print welcome statement
			System.out.println("Welcome to the Halien Hotel!\n");
			// enter the loop to provide the users with options
			while(kg == 'y') {
				System.out.println("What would you like to do? ");
				// print the list of things to do
				System.out.println("1. Our Story\n2. See Room Types\n3. Make a Reservation\n4. Create or Sign In to an Account\n5. Contact Us\n6. Log Out of an Account\n7. Leave a Review\n8. Quit");
					
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
					feedback(scan);
				}
				
				else if(choice == 8) {
					
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
			System.out.println("a. Twin sized bed (For 1 person) - approximately 130 square feet\nb. Queen sized bed (For 1-2 people) - approximately 190 square feet\nc. King sized bed (For 1-2 people) - approximately 270 square feet\nd. 2 Queen sized bed (For 2-4 people) - approximately 350 square feet\ne. King & Queen bed (For 2-4 people) - approximately 370 square feet\nf. 2 King sized bed (For 2-4 people) - approximately 400 square feet\n");
		} // end see rooms function
		
		
		public static void reservationSteps(Scanner scan) {
			// once the customers info is in and they want to make a reservation

		
			System.out.println("Enter the number of occupants: ");
			int numPeople = scan.nextInt();
			char numPeopleG = 'y';
			if (numPeople < 1 || numPeople > 4) {
				numPeopleG = 'n';
			}
			while(numPeopleG == 'n') {
				System.out.println("For the best experience, we reccomend having between 1 and 4 people in a room. ");
				System.out.println("Enter the number of occupants: ");
				numPeople = scan.nextInt();
				if(numPeople >= 1 && numPeople <= 4) {
					numPeopleG = 'y';
				}
				
			}
			
			
			
			System.out.println("Enter the check-in Month & Date (numbers only, for example: mm/dd/yyyy): ");
			String checkinMonthD = scan.next();
			checkinMonthD = emailValidation.checkinMDValidation(checkinMonthD, scan);

			System.out.println("Enter the check in time: ");
			String checkin = scan.next();
			checkin = validation.validateCheckin(checkin, scan);
			
			System.out.println("Enter the check-out Month & Date (numbers only, for example: mm/dd/yyyy): ");
			String checkoutMonthD = scan.next();
			checkoutMonthD = emailValidation.checkoutMDValidation(checkoutMonthD, checkinMonthD, scan);

			System.out.println("Enter the check out time: ");
			String checkout = scan.next();
			checkout = validation.validateCheckout(checkout, scan);
			

			System.out.println("Select a room type: ");
			System.out.println("a. Twin sized bed (For 1 person) - approximately 130 square feet\nb. Queen sized bed (For 1-2 people) - approximately 190 square feet\nc. King sized bed (For 1-2 people) - approximately 270 square feet\nd. 2 Queen sized bed (For 2-4 people) - approximately 350 square feet\ne. King & Queen bed (For 2-4 people) - approximately 370 square feet\nf. 2 King sized bed (For 2-4 people) - approximately 400 square feet\n");
			
			char roomType = scan.next().charAt(0);
			
			roomType = (char) emailValidation.numPeopleValidation(numPeople, scan, roomType);
			
			String [] arrayOfCustomer = currentUserInfo.split(" ",8);
			
			System.out.println("RESERVATION CONFIRMATION: \n");
			System.out.println("NAME: " + arrayOfCustomer[2] + " "+  arrayOfCustomer[3]);
			System.out.println("COUNTRY: " + arrayOfCustomer[4]);
			System.out.println("ZIP CODE: " + arrayOfCustomer[5]);
			System.out.println("PHONE NUMBER: " + arrayOfCustomer[6]);
			System.out.println("\n");
			
			
			System.out.println("Room Reservation: ");
			// remind the customer what room they selected
			
			if(roomType == 'a' || roomType == 'A') {
				System.out.println("Twin sized bed (For 1 person) - approximately 130 square feet");
				
			}
			else if(roomType == 'b' || roomType == 'B') {
				System.out.println("Queen sized bed (For 1-2 people) - approximately 190 square feet");
			}
			else if(roomType == 'c' || roomType == 'C') {
				System.out.println("King sized bed (For 1-2 people) - approximately 270 square feet");
						
			}
			else if(roomType == 'd' || roomType == 'D') {
				System.out.println("2 Queen sized bed (For 2-4 people) - approximately 350 square feet");
				
			}
			else if (roomType == 'e' || roomType == 'E') {
				System.out.println("King & Queen bed (For 2-4 people) - approximately 370 square feet");
				
			}
			else {
				System.out.println("2 King sized bed (For 2-4 people) - approximately 400 square feet");
				
			}
						
			
			System.out.println("Check In Date: " + checkinMonthD); // print the check in day and time
			System.out.println("Check In Time: " + checkin);
			
			
			System.out.println("Check Out Date: " + checkoutMonthD); // print the check out day and time
			System.out.println("Check Out Time: " + checkout);
			
			System.out.println("\n");
			
			
			System.out.println("Thank you for your reservation, see you soon! \n");
			
			
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
						char numPeopleG = 'y';
						if (numPeople < 1 || numPeople > 4) {
							numPeopleG = 'n';
						}
						while(numPeopleG == 'n') {
							System.out.println("For the best experience, we reccomend having between 1 and 4 people in a room. ");
							System.out.println("Enter the number of occupants: ");
							numPeople = scan.nextInt();
							if(numPeople >= 1 && numPeople <= 4) {
								numPeopleG = 'y';
							}
							
						}
						
						System.out.println("Enter the check-in Month & Date (numbers only, for example: mm/dd/yyyy): ");
						String checkinMonthD = scan.next();
						checkinMonthD = emailValidation.checkinMDValidation(checkinMonthD, scan);

						System.out.println("Enter the check in time: ");
						String checkin = scan.next();
						checkin = validation.validateCheckin(checkin, scan);
						
						System.out.println("Enter the check-out Month & Date (numbers only, for example: mm/dd/yyyy): ");
						String checkoutMonthD = scan.next();
						checkoutMonthD = emailValidation.checkoutMDValidation(checkoutMonthD, checkinMonthD, scan);

						System.out.println("Enter the check out time: ");
						String checkout = scan.next();
						checkout = validation.validateCheckout(checkout, scan);
						

						System.out.println("Select a room type: ");
						System.out.println("a. Twin sized bed (For 1 people) - approximately 130 square feet\nb. Queen sized bed (For 1-2 people) - approximately 190 square feet\nc. King sized bed (For 1-2 people) - approximately 270 square feet\nd. 2 Queen sized bed (For 2-4 people) - approximately 350 square feet\ne. King & Queen bed (For 2-4 people) - approximately 370 square feet\nf. 2 King sized bed (For 2-4 people) - approximately 400 square feet\n");
						
						char roomType = scan.next().charAt(0);
						
						roomType = (char) emailValidation.numPeopleValidation(numPeople, scan, roomType);
						
						
						System.out.println("RESERVATION CONFIRMATION: \n");
						System.out.println("NAME: " + firstName + " "+  lastName);
						System.out.println("COUNTRY: " + country);
						System.out.println("ZIP CODE: " + zipCode);
						System.out.println("PHONE NUMBER: " + phoneNumber);
						System.out.println("\n");
						
						
						System.out.println("Room Reservation: ");
						// remind the customer what room they selected
						
						if(roomType == 'a' || roomType == 'A') {
							System.out.println("Twin sized bed (For 1 person) - approximately 130 square feet");
							
						}
						else if(roomType == 'b' || roomType == 'B') {
							System.out.println("Queen sized bed (For 1-2 people) - approximately 190 square feet");
						}
						else if(roomType == 'c' || roomType == 'C') {
							System.out.println("King sized bed (For 1-2 people) - approximately 270 square feet");
									
						}
						else if(roomType == 'd' || roomType == 'D') {
							System.out.println("2 Queen sized bed (For 2-4 people) - approximately 350 square feet");
							
						}
						else if (roomType == 'e' || roomType == 'E') {
							System.out.println("King & Queen bed (For 2-4 people) - approximately 370 square feet");
							
						}
						else {
							System.out.println("2 King sized bed (For 2-4 people) - approximately 400 square feet");
							
						}
									
						
						System.out.println("Check In Date: " + checkinMonthD); // print the check in day and time
						System.out.println("Check In Time: " + checkin);
						
						
						System.out.println("Check Out Date: " + checkoutMonthD); // print the check out day and time
						System.out.println("Check Out Time: " + checkout);
						System.out.println("\n");
						System.out.println("Thank you for your reservation, see you soon!\n");
						
						
							
						
					}// end the register as a guest function
					
					else {
						// if they do not enter 1,2, or 3
						System.out.println("This was not a valid option, returning to menu");
						
					}
							
					}
				}
				
				} // end the function


		
		public static void createAccount(Scanner scan) throws FileNotFoundException, IOException {
			System.out.println("Having an account at our hotel makes check-in more efficient. Also, \r\n"
					+ "- Guests and hotel staff can avoid close-contact interactions.\r\n"
					+ "- Hotels can collect all necessary information from guests.\r\n"
					+ "- Employees can use their time more effectively.\r\n"
					+ "- Guests can get to their rooms as soon as possible.\r\n"
					+ "");
			
			// write the users data to the file
			try {
				createFile();
				
			}catch(Exception e) {
				System.out.println("Error creating file");
			}

			//char emailGood = 'n';
			System.out.println("Enter your email address: ");
			String email = scan.next();
			
			email = emailValidation.validateEmail(email, scan); // call the function from emailValidation to validate the emails
			
			// check to see that there is not an account with that email
			
			// need to read in the file and then iterate over it, and see if the email is in the file at all
			
			char foundEmail = 'n';
			try(BufferedReader br = new BufferedReader(new FileReader("customers.txt"))){
				for(String line = br.readLine(); line != null; line = br.readLine()) {
					if (line.contains(email)) {
						foundEmail = 'y';
						
					}// end if
					
					
				}// end for
			
			
			}catch(Exception e){
				System.out.println("No file to search");
				
			}// end try
			
			if(foundEmail == 'n') {
				System.out.println("Create a password for your account. Passwords must be at least 8 characters but no more than 20, and must also contain one uppercase letter, one digit, and one special character: ");
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
								
				
				try {
					writeToFile(email, password, firstName, lastName, country, zipCode, phoneNumber);
					
				}catch(Exception e) {
					System.out.println("Error writing user data to file");
				}
				
				System.out.println("Account created. Please sign in.");				
				
			} // end if
			
			else {
				
				System.out.println("An account with that email address already exists. Try again with a new email address. ");
			}// end else
			
		} // end function
		
		
		public static void logIn(Scanner scan) throws FileNotFoundException, IOException {
			
			if(logInStat == 'T') {
				System.out.println("Account already logged in, log out to log in with a new account.\n");				
			} // end if 
			
			else {
				System.out.println("Enter your email: "); // ask the user for their email
				String email = scan.next();
				try(BufferedReader br = new BufferedReader(new FileReader("customers.txt"))){
					char foundEmail = 'n';			
					String line;
					while((line = br.readLine()) != null&& (foundEmail == 'n')) {
						// look through the file for the users email
						String [] arrayOfCustomer = line.split(" ",8);
						if(arrayOfCustomer[0].equals(email)) {
							foundEmail = 'y';
							// if we find the email, then ask for their password
							System.out.println("Enter your password: ");
							String password = scan.next();
							if(arrayOfCustomer[1].equals(password)) {
								// if the password matches, then sign the user in
								logInStat = 'T';
								currentUserInfo = line;
								System.out.println("Account logged in. ");
								String name = arrayOfCustomer[2]; // get the customers name
								System.out.println("Welcome, " + name); // print a welcome message									
							} // end if password matches
							else {
								// if the password does not match then let the user know and quit to the main menu
								System.out.println("The password is incorrect. Please try again. ");								
								
							} // end else the password does not match
														
						} // if email exists

						
						
						
					} // end while loop
				
					
				if(foundEmail == 'n') {
					
					// if we do not find the email, let the user know and quit to the main menu
					
					System.out.println("No account found with that email. Please try again or create an account. ");
					
				}
						
				}catch(Exception e){
					// print an error message if the file does not work as it is supposed to
					System.out.println("No file to search");
					
				}// end catch
				
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
		
		
		public static void feedback(Scanner scan) throws Exception {
			System.out.println("1. Make a review 2. See other comments");
			int fbSelect = scan.nextInt();
			if (fbSelect == 1) { 
				try {
					createFile2();
					
				}catch(Exception e) {
					System.out.println("Error creating file");
				} 
				
				Date date = new Date();
				System.out.println("Title:");
				scan.nextLine();
				String title = scan.nextLine();
	
				
				System.out.println("Please rate our service(enter a number between 1-5): ");
				int rate = scan.nextInt();
				
				System.out.println("Comment: ");
				scan.nextLine();
				String comment = scan.nextLine();
				
				try {
					writeToFile2(title, rate, date, comment);
				
				}catch(Exception e) {
					System.out.println("Error writing user data to file");
				}
				
				System.out.println("\n"+"Title: "+title +"\n"+ "Date: "+ date+"\n"+ "Rate: "+ rate +"\n" + "Comment: " + comment+"\n");
				}
				
				
			
			if(fbSelect == 2) {
				try(BufferedReader bfreader = new BufferedReader(new FileReader("review.txt"))){
				String s,str = new String();
				while(( s = bfreader.readLine())!= null) {
					str += s +"\n";
					}
				bfreader.close();
				System.out.println(str);
				}
				}
	}

	

		
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
		
		public static void createFile2() {
			try {
				File reviewStore = new File("review.txt");
				if(reviewStore.createNewFile()) {
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
		
		public static void writeToFile2(String title, int rate, Date date, String comment ) {
			try {
				String feedBack = "Title: "+title +"\n" + "Rate: "+ rate+"\n"+"Date: " + date +"\n" +"Comment: " +comment+ "\n";
				FileWriter myWriter2 = new FileWriter("review.txt", true);
				myWriter2.write(feedBack);
				myWriter2.close();
			} catch (IOException e) {
				System.out.println("Error writing to the file");
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