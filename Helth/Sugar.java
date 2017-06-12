import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Sugar extends FoodGroup{
    
    private double servNeeded;
    private double additServe;
    private double servEaten;
    private double calcEaten;
    private double amtNeeded;
    private double totalServe;
    
    public Sugar(String group) throws IOException{
        super(group);
    }
    
    public void setAmtNeeded(int age, String sex, String activi){
        servNeeded = 0;
        additServe = 1;
    }
    
    public String getAmtNeeded(double amtNeeded){
        return super.getAmtNeeded(amtNeeded) + "of sugar.";
    }
    
    public double getNeeded(){
        return amtNeeded;
    }
    
    public String amtRemain(double amtNeeded, double calcEaten){
        return super.amtRemain(amtNeeded, calcEaten);
    }
    
    public String getCalcEaten() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(HelthMain.login.getUsername() + "Sugar.txt"));
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
        return "Sugar: " + calcEaten + " grams";
    }
    
    /*public String getCalcEaten() throws IOException{
        return "Sugar: " + calcEaten + " grams";
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
