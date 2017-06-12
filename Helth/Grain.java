import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Grain extends FoodGroup{
    
    private double servNeeded;
    private double additServe;
    private double servEaten;
    private double totalServe;
    private double calcEaten;
    private double amtNeeded;
    
    public Grain(String group) throws IOException{
        super(group);
    }
    
    public void setAmtNeeded(int age, String sex, String activity){
        if (age < 2){
            servNeeded = 4;
            additServe = 0;
            return;
        }
        
        if (sex.equals("female")){
            if (age < 8){
                servNeeded = 4;
                additServe = 1;
            } else if (age < 11){
                servNeeded = 4;
                additServe = 3;
            } else if (age < 13){
                servNeeded = 5;
                additServe = 2.5;
            } else if (age < 18){
                servNeeded = 7;
                additServe = 2.5;
            } else if (age < 50){
                servNeeded = 6;
                additServe = 2.5;
            } else if (age < 70){
                servNeeded = 4;
                additServe = 2.5;
            } else {
                servNeeded = 3;
                additServe = 2;
            }
        }
        
        if (sex.equals("male")){
            if (age < 3){
                servNeeded = 4;
                additServe = 1;
            } else if (age < 8){
                servNeeded = 4;
                additServe = 2.5;
            }else if (age < 11){
                servNeeded = 5;
                additServe = 3;
            } else if (age < 13){
                servNeeded = 6;
                additServe = 3;
            } else if (age < 18){
                servNeeded = 7;
                additServe = 5;
            } else if (age < 50){
                servNeeded = 6;
                additServe = 2.5;
            } else if (age < 70){
                servNeeded = 6;
                additServe = 2.5;
            } else {
                servNeeded = 4.5;
                additServe = 2;
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
        return super.getAmtNeeded(amtNeeded) + "of grains.";
    }
    
    public double getNeeded(){
        return amtNeeded;
    }
    
    public String amtRemain(double amtNeeded, double calcEaten){
        return super.amtRemain(amtNeeded, calcEaten);
    }
    
    public String getCalcEaten() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(Login.getUsername() + "Grain.txt"));
        String read = "";
        calcEaten = 0;
        double grams;
        for (int i = 0; i < lines.size(); i++){
            read = lines.get(i);
            try{
                grams = Double.parseDouble(read);
            } catch (NumberFormatException e){
                grams = 0;
            }
            calcEaten += grams;
        }
        return "Grain: " + calcEaten + " grams";
    }
    
    /*public String getCalcEaten() throws IOException{
        return "Grain: " + calcEaten + " grams";
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
