import java.util.ArrayList;

public class Dairy extends FoodGroup{
    
    private double servNeeded;
    private double additServe;
    private double servEaten;
    private double totalServe;
    
    public Dairy(){
        super();
    }
    
    public void setAmtNeeded(int age, String sex){
        if (age < 2){
            servNeeded = 1;
            additServe = .5;
            return;
        }
        
        if (sex.equals("female")){
            if (age < 3){
                servNeeded = 1.5;
                additServe = 1;
            }else if (age < 8){
                servNeeded = 1.5;
                additServe = 1;
            } else if (age < 11){
                servNeeded = 3;
                additServe = 3;
            } else if (age < 13){
                servNeeded = 3.5;
                additServe = 2.5;
            } else if (age < 18){
                servNeeded = 3.5;
                additServe = 2.5;
            } else if (age < 50){
                servNeeded = 2.5;
                additServe = 2.5;
            } else if (age < 70){
                servNeeded = 4;
                additServe = 2.5;
            } else {
                servNeeded = 4;
                additServe = 2;
            }
        }
        
        if (sex.equals("male")){
            if (age < 3){
                servNeeded = 1.5;
                additServe = 1;
            } else if (age < 8){
                servNeeded = 2;
                additServe = 2.5;
            }else if (age < 11){
                servNeeded = 2.5;
                additServe = 3;
            } else if (age < 13){
                servNeeded = 3.5;
                additServe = 3;
            } else if (age < 18){
                servNeeded = 3.5;
                additServe = 5;
            } else if (age < 50){
                servNeeded = 2.5;
                additServe = 3;
            } else if (age < 70){
                servNeeded = 2.5;
                additServe = 2.5;
            } else {
                servNeeded = 3.5;
                additServe = 2.5;
            }
        }
        
    }
    
    public String getAmtNeeded(){
        return super.getAmtNeeded(servNeeded, additServe) + "of dairy.";
    }
    
    public String amtRemain(double servEaten){
        return super.amtRemain(servEaten);
    }
    
    public void calcEaten(ArrayList<Double> grams){
        for (int i = 0; i < grams.size(); i++){
            servEaten += grams.get(i);
        }
    }
    
    public double getCalcEaten(){
        return servEaten;
    }
    
    public void setServEaten (double servEaten){
        super.setServEaten(servEaten);
    }
}