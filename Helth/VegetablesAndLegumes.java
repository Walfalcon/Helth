import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.*;

public class VegetablesAndLegumes extends FoodGroup{
    
    private double servNeeded;
    private double additServe;
    private double servEaten;
    private double totalServe;
    private double calcEaten;
    
    public VegetablesAndLegumes(String group) throws IOException{
        super(group);
    }
    
    public void setAmtNeeded(int age, String sex){
        if (age < 2){
            servNeeded = 2;
            additServe = 1;
            return;
        }
        
        if (sex.equals("female")){
            if (age < 3){
                servNeeded = 2.5;
                additServe = 1;
            }else if (age < 8){
                servNeeded = 4.5;
                additServe = 1;
            } else if (age < 11){
                servNeeded = 5;
                additServe = 3;
            } else if (age < 13){
                servNeeded = 5;
                additServe = 2.5;
            } else if (age < 18){
                servNeeded = 5;
                additServe = 2.5;
            } else if (age < 50){
                servNeeded = 5;
                additServe = 2.5;
            } else if (age < 70){
                servNeeded = 5;
                additServe = 2.5;
            } else {
                servNeeded = 5;
                additServe = 2;
            }
        }
        
        if (sex.equals("male")){
            if (age < 3){
                servNeeded = 2.5;
                additServe = 1;
            } else if (age < 8){
                servNeeded = 4.5;
                additServe = 2.5;
            }else if (age < 11){
                servNeeded = 5;
                additServe = 3;
            } else if (age < 13){
                servNeeded = 5.5;
                additServe = 3;
            } else if (age < 18){
                servNeeded = 5.5;
                additServe = 5;
            } else if (age < 50){
                servNeeded = 6;
                additServe = 3;
            } else if (age < 70){
                servNeeded = 5.5;
                additServe = 2.5;
            } else {
                servNeeded = 5;
                additServe = 2.5;
            }
        }
        
    }
    
    public String getAmtNeeded(String activity){
        return super.getAmtNeeded(servNeeded, additServe, activity) + "of vegetables and legumes.";
    }
    
    public String amtRemain(double calcEaten){
        return super.amtRemain(calcEaten);
    }
    
    public void calcEaten() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("VeggiesAndLegumes.txt"));
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
    }
    
    public String getCalcEaten() throws IOException{
        return "Vegetables and Legumes: " + calcEaten + " grams";
    }
    
    public void setServEaten (String group, String grams2) throws IOException{
        super.setServEaten(group, grams2);
    }
    
    public void clearFoodGroup(String group) throws IOException{
        super.clearFoodGroup(group);
    }
}
