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
        YES, NO, EXIT;
    }
    
    /**
     * Constructor for RecipeGetter. It's passed user, and set's it's own user object to the same thing. 
     * It also set's the URL
     */
    public RecipeGetter(User user)
    {
        this.user = user;
        try {
            recipeSite = new URL("http://allrecipes.com");
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
        BufferedWriter save = null;
        
        //get all the ingredients the user wants to cook with
    /*    System.out.println("Are there any ingredients you want to add? (Type \"done\" when you're done adding ingredients)");
        String tempIn; //string for storing input
        while(true) {
            tempIn = key.nextLine();
            if(tempIn.toLowerCase().equals("done")) break;  //exits the loop
            
            incl.add(tempIn.replace(" ", "%20"));
        }*/
        
        //get all the dietary preferences
        if(dietPref.contains("lactose intolerent")) {
            excl.add("cream");
            excl.add("milk");
            excl.add("cheese");
            excl.add("butter");
            excl.add("buttermilk");
            excl.add("curds");
            excl.add("whey");
        }
        if(dietPref.contains("vegan")) {
            keyword.add("vegan");
        }
        if(dietPref.contains("vegetarian")) {
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
        
        URL search; //get the search page
        try {
            search = new URL(recipeSite, "/search/results/?" + appendUrl + "sort=p");
        }
        catch (MalformedURLException e) {
            System.out.println("Whoops, looks like we can't get you any recipes! Sorry about that!");
            return;
        }
        
        
        System.out.println("\n\n------------Recipes------------\n\n");
        /*
         * Now actually reading from the website
         */
        BufferedReader input = new BufferedReader(new InputStreamReader(search.openStream())); //create a BufferedReader to be more efficient
        
        String currentLine = input.readLine();
        URL recipePage;
        BufferedReader recipeIn;
        String recipeName;
        String recipe = "";
        //each loop is one recipe
        while(currentLine != null) {
            System.out.println(currentLine);
            while(currentLine != null && currentLine.indexOf("/recipe/") == -1) {
                currentLine = input.readLine();
            }
            
            if(currentLine == null) {
            System.out.println(currentLine);
                    System.out.println("That's the last recipe. Returning to main menu.");
                    break;
            }
            
            //Get the page of the recipe
            recipePage = new URL(recipeSite, currentLine.substring(currentLine.indexOf("/recipe/"), currentLine.indexOf("/\"") +1));

            //Now get the description
            while(currentLine.indexOf("alt=") == -1) currentLine = input.readLine();
            System.out.println(currentLine.substring(currentLine.indexOf("alt=") + 5, currentLine.indexOf("\" title=")));
            System.out.println("Do you want to view this recipe?(VIEW, NEXT, or EXIT)");
            
            switch(input("VIEW", "NEXT", "EXIT")) {
                case EXIT:
                    System.out.println("Exiting...");
                    input.close();
                    return;
                case NO:
                    while(currentLine.indexOf("/recipe/") == -1) currentLine = input.readLine();
                    currentLine = input.readLine();
                    break;
                case YES:
                    System.out.print("[");
                    recipeIn = new BufferedReader(new InputStreamReader(recipePage.openStream()));
                    String recipeLine = recipeIn.readLine();
                    
                    System.out.print("#");
                    while(recipeLine.indexOf("title") == -1) recipeLine = recipeIn.readLine();
                    recipeName = recipeLine.substring(recipeLine.indexOf(">") +1, recipeLine.indexOf(" -"));
                    
                    System.out.print("#");
                    while((recipeLine = recipeIn.readLine()).indexOf("itemprop=\"name\">") == -1);
                    
                    System.out.print("#");
                    recipe = recipeLine.substring(recipeLine.indexOf("name\">") + 6, recipeLine.indexOf("</h1>")) + "\n\n";
                    
                    //Get the number of servings
                    System.out.print("#");
                    while(recipeLine.indexOf("Original recipe yields") == -1)recipeLine = recipeIn.readLine();
                    recipe += "\nServings: " + recipeLine.substring(recipeLine.indexOf("ds") + 3, recipeLine.indexOf(" s"));
                    
                    //Get the nutrition. I could use a loop, but I won't.
                    System.out.print("#");
                    recipe += "\n\nNutrition:\nCalories: ";
                    while(recipeLine.indexOf("\"calories\"") == -1)recipeLine = recipeIn.readLine();
                    recipe += recipeLine.substring(recipeLine.indexOf("n>") +2, recipeLine.indexOf("</s")).replace("&lt; ", "<") + " kcal\nFat: ";
                    while(recipeLine.indexOf("\"fatContent\"") == -1)recipeLine = recipeIn.readLine();
                    recipe += recipeLine.substring(recipeLine.indexOf("n>") +2, recipeLine.indexOf("</s")).replace("&lt; ", "<") + " g\nCarbs: ";
                    while(recipeLine.indexOf("hydrateContent\"") == -1)recipeLine = recipeIn.readLine();
                    recipe += recipeLine.substring(recipeLine.indexOf("n>") +2, recipeLine.indexOf("</s")).replace("&lt; ", "<") + " g\nProtein: ";
                    while(recipeLine.indexOf("roteinContent\"") == -1)recipeLine = recipeIn.readLine();
                    recipe += recipeLine.substring(recipeLine.indexOf("n>") +2, recipeLine.indexOf("</s")).replace("&lt; ", "<") + " g\nCholesterol: ";
                    while(recipeLine.indexOf("rolContent\"") == -1)recipeLine = recipeIn.readLine();
                    recipe += recipeLine.substring(recipeLine.indexOf("n>") +2, recipeLine.indexOf("</s")).replace("&lt; ", "<") + " mg\nSodium: ";
                    while(recipeLine.indexOf("umContent\"") == -1)recipeLine = recipeIn.readLine();
                    recipe += recipeLine.substring(recipeLine.indexOf("n>") +2, recipeLine.indexOf("</s")).replace("&lt; ", "<") + " mg\n";
                                        
                    //Add the ingredients
                    System.out.print("#");
                    recipe += "\nIngredients-\n";
                    while(recipeLine.indexOf("Add all ingredients to list") == -1) {
                        while(recipeLine.indexOf("\"ingredients\"") == -1 && recipeLine.indexOf("Add all ingredients to list") == -1) recipeLine = recipeIn.readLine();
                        if(recipeLine.indexOf("Add all ingredients to list") == -1) {
                            recipe += recipeLine.substring(recipeLine.indexOf(">") + 1, recipeLine.indexOf("</")) + "\n";
                            recipeLine = recipeIn.readLine();
                        }
                    }
                    
                    //Get the instructions!
                    System.out.print("#");
                    recipe += "\n\nDirections\n";
                    while(recipeLine.indexOf("stepIsActive") == -1)recipeLine = recipeIn.readLine();
                    while(recipeLine.indexOf("</ol>") == -1) {
                        recipe += "\n" + recipeLine.substring(recipeLine.indexOf("m\">") + 3, recipeLine.indexOf("</span>")) + "\n";
                        recipeLine = recipeIn.readLine();
                    }
                    
                    recipe = recipe.replace("&#39;", "'");
                    recipe = recipe.replace("&amp;", "&");
                    
                    System.out.println("]");
                    System.out.println(recipe);
                    System.out.println("Do you want to save this recipe, or do you want to see another?(SAVE, NEXT, or EXIT)");
                    switch(input("SAVE", "NEXT", "EXIT")) {
                        case NO:
                            System.out.println("\n\n\n\n\n\n");
                            break;
                        case EXIT:
                            System.out.println("Exiting...");
                            input.close();
                            recipeIn.close();
                            return;
                        case YES:
                            try {
                                save = new BufferedWriter(new FileWriter("recipes\\" + recipeName.replace(" ", "space") + ".txt"));
                                for(int c = 0; c < recipe.length(); c++/*lol*/) {
                                    if(recipe.charAt(c) == '\n') save.newLine();
                                    else save.write(recipe.charAt(c));
                                }
                                save.flush();
                                System.out.println("Saved to recipes\\" + recipeName.replace(" ", "space") + ".txt");
                            } catch(IOException dagnabbit) {
                                System.out.println("Saving the recipe failed, for some reason. Sorry.");
                            }finally {
                                save.close();
                            }
                    }
                    
                    recipeIn.close();
                    while(currentLine != null && currentLine.indexOf("/recipe/") == -1) currentLine = input.readLine();

                    currentLine = (currentLine == null) ? null : input.readLine();
            }
        }
        
        input.close(); //finito!
    }
    
    public Nav input(String yes, String no, String exit) {
        Scanner key = new Scanner(System.in);
        String in;
        while(true) {
            in = key.next().toUpperCase();
            if(in.equals(exit))
                return Nav.EXIT;
            else if(in.equals(no))
                return Nav.NO;
            else if(in.equals(yes))
                return Nav.YES;
            else
                System.out.println("Type " + yes + ", " + no + ", or " + exit + ".");
            }
        }
    }