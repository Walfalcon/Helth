import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Get's recipes from the INTERFNEEERTTTSSSS!!!!11!!
 * AMAZING!!!!
 */
public class RecipeGetter
{
    private URL recipeSite;   //The website we're getting recipes from
    private User user;  //The user, so we can get their dietary preferences
    
    private enum Nav {  //to be used by the input method
        BACK, NEXT;
    }
    
    /**
     * Constructor for RecipeGetter. It's passed user, and set's it's own user object to the same thing. 
     * It also set's the URL
     */
    public RecipeGetter(User user)
    {
        this.user = user;
        try {
            URL recipeSite = new URL("http://allrecipes.com");
        }
        catch (MalformedURLException e) {
            System.out.println("Whoops, looks like we can't get you any recipes! Sorry about that!");
        }
    }
    
    /**
     * The method for reading the website. Gets recipes based on user's dietary preferences
     */
    public void reader() throws Exception
    {
        Scanner key = new Scanner(System.in);   //gets keyboard input
        String dietPref = user.getDietaryPref(); //gets the user's diet, set's it to it's own string for easy access
        ArrayList<String> keyword = new ArrayList<String>();  //Where we're going to put the keywords
        ArrayList<String> incl = new ArrayList<String>();  //Where we're going to put the ingredients to include
        ArrayList<String> excl = new ArrayList<String>();  //Where we're going to put the ingredients to exclude
        
        //get all the ingredients the user wants to cook with
        System.out.println("Are there any ingredients you want to add? (Type \"done\" when you're done adding ingredients)");
        String tempIn; //string for storing input
        while(true) {
            tempIn = key.nextLine();
            if(tempIn.toLowerCase().equals("done")) break;  //exits the loop
            
            incl.add(tempIn.replace(" ", "%20"));
        }
        
        //get all the dietary preferences
        if(dietPref.indexOf("lactose intolerent") != -1) {
            excl.add("cream");
            excl.add("milk");
            excl.add("cheese");
            excl.add("butter");
            excl.add("buttermilk");
            excl.add("curds");
            excl.add("whey");
        }
        if(dietPref.indexOf("vegan") != -1) {
            keyword.add("vegan");
        }
        if(dietPref.indexOf("vegetarian") != -1) {
            keyword.add("vegetarian");
        }
        
        //add the dietary preferences to the URL
        String appendUrl = "";
        if(keyword.size() > 0) {
            appendUrl += "wt=";
            for(int i = 0; i < keyword.size(); i++) {
                if(i == 0) {
                    appendUrl += keyword.get(i);
                } else {
                    appendUrl += "%20" + keyword.get(i);
                }
            }
            appendUrl += "&";
        }
        if(incl.size() > 0) {
            appendUrl += "ingIncl=";
            for(int i = 0; i < incl.size(); i++) {
                if(i == 0) {
                    appendUrl += incl.get(i);
                } else {
                    appendUrl += "," + incl.get(i);
                }
            }
            appendUrl += "&";
        }
        if(excl.size() > 0) {
            appendUrl += "ingExcl=";
            for(int i = 0; i < excl.size(); i++) {
                if(i == 0) {
                    appendUrl += excl.get(i);
                } else {
                    appendUrl += "," + excl.get(i);
                }
            }
            appendUrl += "&";
        }
        
        try {
            URL search = new URL(recipeSite + "/search/results/?" + appendUrl + "sort=re");
        }
        catch (MalformedURLException e) {
            System.out.println("Whoops, looks like we can't get you any recipes! Sorry about that!");
       }
    }
}
