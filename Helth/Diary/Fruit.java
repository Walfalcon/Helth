package Diary;

import java.util.ArrayList;

public class Fruit extends FoodGroup{
    
    private double servNeeded;
    private double additServe;
    private double servEaten;
    private double totalServe;
    
    public Fruit(){
        super();
    }
    
    public void setAmtNeeded(int age, String sex){
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
        
    }
    
    public String getAmtNeeded(){
        return super.getAmtNeeded(servNeeded, additServe) + "of fruit.";
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
