package hotelSystem;
import java.util.Scanner;

public class validation {

	public static void main(String[] args) {
	
		
	}

    public static String validatePhone (String phoneNumber, Scanner scan){
        String phoneReg = "^\\d{10}$";
        char phoneGood = 'n';
        while (phoneGood == 'n'){
            if (phoneNumber.matches(phoneReg)){
                phoneGood = 'y';
            }
            else {
                System.out.println("Your phone number is invalid. Remember to include both your 3-digit area code and your 7-digit phone number. Do not include parentheses or dashes. Please try again: ");
                phoneNumber = scan.next();
            }
        }
        return phoneNumber;
    }
    
	public static String validateCheckin (String checkin, Scanner scan){


        //validate check in time
		String checkinReg = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        char checkinTime = 'n';
        if (checkin.matches(checkinReg)){
            checkinTime = 'y';
        }
        while(checkinTime != 'y') {
            System.out.println("Your check in time is invalid. Remember, your check-in time must be in the military (24 hour) format. Please try again: ");
            checkin = scan.next();
            if (checkin.matches(checkinReg)){
                checkinTime = 'y';
            }
        }
        //end validation loop
        return checkin;
    }
    
    public static String validateCheckout (String checkout, Scanner scan){
 
        //validate check out time
        String checkoutReg = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        char checkoutTime = 'n';
        if (checkout.matches(checkoutReg)){
            checkoutTime = 'y';
        }
        while(checkoutTime != 'y') {
            System.out.println("Your check out time is invalid. Remember, your check-out time must be in the military (24 hour) format. Please try again: ");
            checkout = scan.next();
            if (checkout.matches(checkoutReg)){
                checkoutTime = 'y';
            }

    }
    //end validation loop
    return checkout;
}
	
	public static String validatePasswords(String password, Scanner scan){
        //validate passwords
        String passwordReg = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$";
        char passwordTime = 'n';
        if (password.matches(passwordReg)){
            passwordTime = 'y';
        }
        while(passwordTime != 'y'){
            System.out.println("Your password is invalid. Remember, your password must be at least 8 characters but no more than 20, and contain at least one uppercase letter, one number, and one special character.");
            password = scan.next();
            if (password.matches(passwordReg)){
                passwordTime = 'y';
            }
        }
    // end validation loop     
        return password;
    }

}
