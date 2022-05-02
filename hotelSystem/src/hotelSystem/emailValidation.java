package hotelSystem;
import java.util.Scanner;

public class emailValidation {
    public static void main(String[] args){


    } 
    public static String validateEmail(String email, Scanner scan){

        //Scanner scan = new Scanner(System.in);
        //validate the format of the email users entered
        String reg = "^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][com|org|net|edu|gov|co.uk])*$";
        //System.out.println("Enter your email address: ");
		//String s = scan.next();
        char emailGood = 'n';
        while(emailGood == 'n') {
        if (email.matches(reg)) {
            //System.out.println("Congratulations, you have successfully registered.");
        	emailGood = 'y';
            }
            else {
            	System.out.println("Your Email address must contain '@' and '.', the length before te @ is 3-18 characters and the email cannot end with a dot. The domain has to be '.com', '.org', '.net', '.edu', '.gov' or '.co.uk', and there can be no empty between '.' and '@'");
            	System.out.println("Enter a new email address: ");
            	email = scan.next();
            }
        }
    return email;
    }
	public static int numPeopleValidation(int numPeople, Scanner scan, char roomType) {
		char roomA = 'n';
		char roomB = 'n';
		char roomC = 'n';
		char roomD = 'n';
		char roomE = 'n';
		char roomF = 'n';
		String approve = "N";
		while (approve == "N"){
			if (roomType == 'a' && numPeople != 1) {
				System.out.println("Twin sized bed is only for 1 people.");
				System.out.println("Please try again:");
				roomType = scan.next().charAt(0); 
				System.out.println(roomType);
			}
			else {
				roomA = 'y';
				approve ="Y";
			}
			if (roomType =='b' && numPeople > 2 || numPeople <= 0) {
				System.out.println("1 Queen sized bed is for 1-2 people.");
				System.out.println("Please try again:");
				roomType = scan.next().charAt(0); 
				System.out.println(roomType);
			}
			else {
				roomB = 'y';
				approve ="Y";
			}
			if (roomType == 'c' && numPeople > 2 || numPeople <= 0) {
				System.out.println("1 King sized bed is for 1-2 people.");
				System.out.println("Please try again:");
				roomType = scan.next().charAt(0); 
				System.out.println(roomType);
			}
			else {
				roomC = 'y';
				approve ="Y";
			}
			if (roomType =='d' && numPeople < 2 && numPeople > 4) {
				System.out.println("2 Queen sized bed is for 2-4 people.");
				System.out.println("Please try again:");
				roomType = scan.next().charAt(0); 
				System.out.println(roomType);
			}
			else {
				roomD = 'y';
				approve ="Y";
			}
			if (roomType =='e' && numPeople < 2 && numPeople > 4) {
				System.out.println("King & Queen bed is for 2-4 people.");
				System.out.println("Please try again:");
				roomType = scan.next().charAt(0); 
				System.out.println(roomType);
			}
			else {
				roomE = 'y';
				approve ="Y";
			}
			if (roomType =='f' && numPeople < 2 && numPeople > 4) {
				System.out.println(" 2 King sized bed is for 2-4 people.");
				System.out.println("Please try again:");
				roomType = scan.next().charAt(0); 
				System.out.println(roomType);
			}
			else {
				roomF = 'y';
				approve ="Y";
				}
		}
		return roomType;
	}
	
	public static String checkinMDValidation(String checkinMonthD, Scanner scan) {
			String regMD = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
			char monthDGood = 'n';
			while (monthDGood == 'n'){
				if(checkinMonthD.matches(regMD)) {
					monthDGood = 'y';
				}
				else {
					System.out.println("Invalid, the format should be xx/xx/xxxx: ");
					checkinMonthD = scan.next();
				}
			}
			return checkinMonthD;
		}
	public static String checkoutMDValidation(String checkoutMonthD, String checkinMonthD, Scanner scan) {
			String regMD = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
			char monthDOK = 'n';
			while (monthDOK == 'n') {
				//checkoutMonthD.matches(regMD) && 
				if( checkoutMonthD.matches(regMD) && !checkoutMonthD.equals(checkinMonthD)) {
						System.out.println("check in date: "+ checkinMonthD +", "+"Check out date: "+checkoutMonthD );
						monthDOK = 'y';
				}
				else {
					System.out.println("check in date: "+ checkinMonthD +", "+"Check out date: "+checkoutMonthD );	
					System.out.println("Invalid, the format should be xx/xx/xxxx, check-in and check-out dates cannot be the same day: ");
					checkoutMonthD = scan.next();
					
				}
			}
		
		
		return checkoutMonthD;
	}
}








