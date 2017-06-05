import java.util.Scanner;
public class Login
{
<<<<<<< HEAD
<<<<<<< HEAD
    private static String username;
    public static void main(String[] args) {
        //Prompt the user and pick String variables
=======
    public static void main(String[] args) {
>>>>>>> master
=======
    private static String username;
    public static void main(String[] args) {
        //Prompt the user and pick String variables
>>>>>>> KyndraBranch
     System.out.println("Please choose a username: ");
     Scanner in = new Scanner(System.in);
     String username = in.nextLine();
     System.out.println("Please enter password:\n(Must have 6 characters and at least one non-alphanumeric character @, +, -, *, /)");
     String password = in.nextLine();
     System.out.println("Please confirm password: ");
     String confirm = in.nextLine();     
     boolean condition;
     condition = isValid(password);
<<<<<<< HEAD
<<<<<<< HEAD
  //Create while loop to catch if you typed confirm password in correctly   
=======
     
>>>>>>> master
=======
  //Create while loop to catch if you typed confirm password in correctly   
>>>>>>> KyndraBranch
   while (!password.equals(confirm) || (!condition)) {
         System.out.println("");
         System.out.println("The password is invalid.");
         System.out.println("Please enter a password again: ");
         String Password = in.nextLine();
         System.out.print("Please re-confirm the password: ");
         String Confirm = in.nextLine();        
         if (isValid(password)) {
<<<<<<< HEAD
<<<<<<< HEAD
             //Print password is invalid if chosen password does not match confirmed password
=======
>>>>>>> master
=======
             //Print password is invalid if chosen password does not match confirmed password
>>>>>>> KyndraBranch
            System.out.println( "The password is valid");
            break;
        }
 }       
}
<<<<<<< HEAD
<<<<<<< HEAD
public static String getUsername() {
    return username;
}
public static boolean isValid(String password) {
    //Checks to see if there are any alphanumeric characters in the password
    System.out.println("");
    if(password.length() < 6) {
        //Checks if password is 6 characters or longer
        System.out.print(""); 
        return false;
    } else {
=======
=======
public static String getUsername() {
    return username;
}
>>>>>>> KyndraBranch
public static boolean isValid(String password) {
    //Checks to see if there are any alphanumeric characters in the password
    System.out.println("");
    if(password.length() < 6) {
        //Checks if password is 6 characters or longer
        System.out.print(""); 
        return false;
<<<<<<< HEAD
        } else {
>>>>>>> master
=======
    } else {
>>>>>>> KyndraBranch
     for( int i = 0; i < password.length(); i++) {
             if(password.charAt(i) == '@'){
                 return true;
             }
             else if(password.charAt(i) == '+') {
                 return true;
             }
             else if(password.charAt(i) == '-'){
                 return true;
             }
             else if(password.charAt(i) == '*'){
                 return true;
             }
             else if(password.charAt(i) == '/'){
                 return true;
             }
<<<<<<< HEAD
<<<<<<< HEAD
     }
     if(!true) {
                 System.out.println("Must have at least one alphaneumeric character.");                  
                }
    }
=======
            }
     if(!true) {
                 System.out.println("Must have at least one alphaneumeric character.");                  
                }
            }
>>>>>>> master
=======
     }
     if(!true) {
                 System.out.println("Must have at least one alphaneumeric character.");                  
                }
    }
>>>>>>> KyndraBranch
            return true;
        }
       }