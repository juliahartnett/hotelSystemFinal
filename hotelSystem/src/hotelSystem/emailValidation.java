import java.util.Scanner;
public class emailValidation {
    public static void main(String[] args){
            
    } 
    public static String validateEmail(String email){

        Scanner scan = new Scanner(System.in);
        //validate the format of the email users entered
        String reg = "^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][com|org|net|edu|gov|co.uk])*$";
        System.out.println("Enter your email address: ");
		String s = scan.next();
        if (s.matches(reg)) {
            System.out.println("Congratulations, you have successfully registered.");
            }
            else {
            System.out.println("FAILD, Your Email address must contain '@'' and '.', the length before @ is 3-18 characters and cannot end with a dot. the domain have to be 'com, org, net, edu, gov and co.uk, no empty between dot and '@''");
            }
    return email;
    }
}

