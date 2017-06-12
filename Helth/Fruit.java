import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.*;

public class Fruit extends FoodGroup{
    
    private double servNeeded;
    private double additServe;
    private double servEaten;
    private double totalServe;
    private double calcEaten;
    private double amtNeeded;
    
    public Fruit(String group) throws IOException{
        super(group);
    }
    
    public void setAmtNeeded(int age, String sex, String activity){
        if (age < 2){
            servNeeded = .5;
            additServe = 0;
            return;
        }
        
        if (sex.equals("female")){
            if (age < 3){
                servNeeded = 1;
                additServe = 1;
            }else if (age < 8){
                servNeeded = 1.5;
                additServe = 1;
            } else if (age < 11){
                servNeeded = 2;
                additServe = 3;
            } else if (age < 13){
                servNeeded = 2;
                additServe = 2.5;
            } else if (age < 18){
                servNeeded = 2;
                additServe = 2.5;
            } else if (age < 50){
                servNeeded = 2;
                additServe = 2.5;
            } else if (age < 70){
                servNeeded = 2;
                additServe = 2.5;
            } else {
                servNeeded = 2;
                additServe = 2;
            }
        }
        
        if (sex.equals("male")){
            if (age < 3){
                servNeeded = 1;
                additServe = 1;
            } else if (age < 8){
                servNeeded = 1.5;
                additServe = 2.5;
            }else if (age < 11){
                servNeeded = 2;
                additServe = 3;
            } else if (age < 13){
                servNeeded = 2;
                additServe = 3;
            } else if (age < 18){
                servNeeded = 2;
                additServe = 5;
            } else if (age < 50){
                servNeeded = 2;
                additServe = 3;
            } else if (age < 70){
                servNeeded = 2;
                additServe = 2.5;
            } else {
                servNeeded = 2;
                additServe = 2.5;
            }
        }
        
        switch (activity){
            case "sedentary":
                amtNeeded = servNeeded;
                break;
            case "lightly active":
                amtNeeded = servNeeded + (additServe / 3);
                break;
            case "active":
                amtNeeded = servNeeded + (2 * additServe / 3);
                break;
            case "very active":
                amtNeeded = servNeeded + additServe;
                break;
        }
    }
    
    public String getAmtNeeded(double amtNeeded){
        return super.getAmtNeeded(amtNeeded) + "of fruit.";
    }
    
    public double getNeeded(){
        return amtNeeded;
    }
    
    public String amtRemain(double amtNeeded, double calcEaten){
        return super.amtRemain(amtNeeded, calcEaten);
    }
    
    public String getCalcEaten() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(HelthMain.login.getUsername() + "Fruit.txt"));
        String read = "";
        this.calcEaten = 0;
        double grams = 0;
        for (int i = 0; i < lines.size(); i++){
            read = lines.get(i);
            try{
                grams = Double.parseDouble(read);
            } catch (NumberFormatException e){
                grams = 0;
            }
            calcEaten += grams;
        }
        return "Fruit: " + calcEaten + " grams";
    }
    
    /*public String getCalcEaten() throws IOException{
        return "Fruit: " + calcEaten + " grams";
    }*/
    
    public double getEaten() throws IOException{
        return calcEaten;
    }
    
    public void setServEaten (String group, String grams2) throws IOException{
        super.setServEaten(group, grams2);
    }
    
    public void clearFoodGroup(String group) throws IOException{
        super.clearFoodGroup(group);
    }
}
