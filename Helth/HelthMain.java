import java.util.Scanner;
/**
 * The main class
 * All other classes will be called from here
 * 
 * It should only contain one method, main, and shouldn't have any of the code
 * to actually do anything in it. Just have other classes do all the work. This
 * is the organizer.
 * 
 * This will be the only class that everyone works on, so don't mess it up too much.
 */
public class HelthMain
{
    private static User user = new User();
    private static Diary diary;
    private static RecipeGetter recipeGet = new RecipeGetter(user);
    
    private enum Menu { //for use by the input method
        DIARY, GET_RECIPE, CALCULATOR, EXIT;
    }
    
    /**
     * The hub of the program. All the other classes come off of here.
     */
    public static void main(String[] args) {
        
        while(true){
            System.out.println("Do you want to:\n1. View Diary\n2. Get Recipes\n3. Calculate Nutrition\n4. Exit\n(Type a number)");
            
            switch(input()) {
                case DIARY:
                System.out.println("Checking priviledge");
                break;
                case GET_RECIPE: 
                try{
                    recipeGet.reader();
                } catch(Exception e) {
                    System.out.println("RecipeGetter failed. It's probably your fault.");
                }
                break;
                case CALCULATOR:
                System.out.println("LOL joke's on you there is no calculator!");
                break;
                case EXIT:
                System.out.println("exiting...");
                return;
            }
        }
    }
    
    /**
     * A simple input method. Gets which function of the program the user wants next and returns it.
     */
    private static Menu input() {
        Scanner key = new Scanner(System.in);
        int input;
        
        while(true) {
            try {//Try/catch in case the user enters a non-number
                input = key.nextInt();
            } catch (Exception e) {
                System.out.println("That's not a number pick a frigging number");
                key.next();
                continue;
            }
            
            //takes the input and turns it into an enum! Or something!
            switch(input) {
                case 1: return Menu.DIARY;
                case 2: return Menu.GET_RECIPE;
                case 3: return Menu.CALCULATOR;
                case 4: return Menu.EXIT;
                default:
                    if(input > 9000){
                        for(int i = 0; i <= 9000; i+= 1){
                        System.out.println("....Please wait, executing stalememes.txt....");
                    }
                        System.out.println("done");
                    } else{
                    System.out.println("That's not an option type one of the actual things.");
                }
            }
        }
    }
}
