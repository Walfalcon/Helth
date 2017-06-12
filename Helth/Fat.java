import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.*;

public class Fat extends FoodGroup{
    
    private double servNeeded;
    private double additServe;
    private double servEaten;
    private double totalServe;
    private double calcEaten;
    private double amtNeeded;
    
    public Fat(String group) throws IOException{
        super(group);
    }
    
    public void setAmtNeeded(int age, String sex, String activity){
        servNeeded = 2;
        additServe = 1;
    }
    
    public String getAmtNeeded(double amtNeeded){
        return super.getAmtNeeded(amtNeeded) + "of fat.";
    }
    
    public double getNeeded(){
        return amtNeeded;
    }
    
    public String amtRemain(double amtNeeded, double calcEaten){
        return super.amtRemain(amtNeeded, calcEaten);
    }
    
    public String getCalcEaten() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(Login.getUsername() + "Fat.txt"));
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
        return "Fat: " + calcEaten + " grams";
    }
    
    /*public String getCalcEaten() throws IOException{
        return "Fat: " + calcEaten + " grams";
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
