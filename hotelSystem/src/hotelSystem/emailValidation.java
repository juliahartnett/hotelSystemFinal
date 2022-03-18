import java.util.Scanner;
public class emailValidation {
    public static void main(String[] args){
            
    } 
    public static String validateEmail(String email){

        Scanner scan = new Scanner(System.in);
        //validate the format of the email users entered
        String reg = "^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][com|org|net|edu|gov|co.uk]+)*$";
        char emailFormat = 'n';
        while(emailFormat !='y') {
            System.out.println("Your Email address must contain '@'' and '.' ");
            email = scan.next();
            if (email.matches(reg)){
                emailFormat = 'y';
            }
            //To the left of "@":
            //Letters, numbers from 0 to 9, underscores
            //minus sign, dot
            //The length is 3 to 18 characters
            //Cannot end with a dot, minus sign or underscore

            //To the Right of "@":
            //Letters, numbers from 0 to 9, underscores
            //There can only be one dot, and there cannot be an empty space between the dot and "@"
            //minus sign, dot
            //Cannot end with a dot, minus sign or underscore
        }
    //char emailDomain = 'n';
    //while(emailDomain !='y'){
      //  System.out.println("Your email domain is no valied");
        //email = scan.next();
        //if(email.matches){

        //}
    //}

    return email;
    }
}
