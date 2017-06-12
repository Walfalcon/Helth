import java.util.Scanner;
import java.io.*;

public class Login
{
    private String username;
    
    /**
     * the Login constructor is used when the user logs in.
     */
    public Login() {
        Scanner in = new Scanner(System.in);
        String password;
        String realPass = "";
        while(true) {
            System.out.print("\nUsername: ");
            username = in.nextLine();
            BufferedReader user;
            try {
                user = new BufferedReader(new FileReader(username + ".txt"));
                password = user.readLine();
                user.close();
                break;
            } catch (FileNotFoundException whoops1) {
                System.out.println("User not found.");
            } catch (IOException whoops2) {
                System.out.println("Something weird happened, try again.");
            }
        }
        for(int i = 0; i < password.length(); i++) {
            realPass += (char)(password.charAt(i) -1);
        }
        
                    System.out.print(realPass);
        while(true) {
            System.out.println("\nPassword: ");
            if(in.nextLine().equals(realPass)) {
                break;
            } else {
                System.out.println("Incorrect password");
            }
        }
    }
    
    public Login(String username) {
        this.username = username;
    }
    
    public static String signUp() throws IOException{
        //Prompt the user and pick String variables
        System.out.println("Please choose a username: ");
        Scanner in = new Scanner(System.in);
        String username = in.nextLine();
        System.out.println("Please enter password:\n(Must have 6 characters and at least one non-alphanumeric character @, +, -, *, /)");
        String password = in.nextLine();
        System.out.println("Please confirm password: ");
        String confirm = in.nextLine();     
        boolean condition;
        condition = isValid(password);
        //Create while loop to catch if you typed confirm password in correctly   
        while (!password.equals(confirm) || (!condition)) {
            System.out.println("");
            System.out.println("The password is invalid.");
            System.out.println("Please enter a password again: ");
            password = in.nextLine();
            System.out.print("Please re-confirm the password: ");
            confirm = in.nextLine();        
            if (isValid(password) && password.equals(confirm)) {
                //Print password is invalid if chosen password does not match confirmed password
                System.out.println( "The password is valid");
                break;
            }
        }
        
        BufferedWriter save = null;
        try {
            save = new BufferedWriter(new FileWriter(username + ".txt"));
            for(int i = 0; i < password.length(); i++) {
                save.write(password.charAt(i) +1);
            }
            save.flush();
        } catch(IOException frogs) {
            System.out.println("Somehow something went wrong somewhere.");
        } finally {
            save.close();
        }
        
        return username;
    }
    
    public String getUsername() {
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
            }
            System.out.println("Must have at least one alphaneumeric character.");
            return false;
        }
    }
}