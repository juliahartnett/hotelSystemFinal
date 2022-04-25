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
}