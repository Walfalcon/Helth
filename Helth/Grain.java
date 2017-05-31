import java.util.ArrayList;

public class Grain extends FoodGroup{
    
    private double servNeeded;
    private double additServe;
    private double servEaten;
    private double totalServe;
    
    public Grain(){
        super();
    }
    
    public void setGrouping(String food){
        super.setGrouping(food);
    }
    
    public void setAmtNeeded(int age, String sex){
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
        
    }
    
    public String getAmtNeeded(){
        return super.getAmtNeeded();
    }
    
    public String amtRemain(double totalServe, double servEaten){
        return super.amtRemain(totalServe, servEaten);
    }
    
    public double calcEaten(ArrayList<Double> grams){
        for (int i = 0; i < grams.size(); i++){
            servEaten += grams.get(i);
        }
        return servEaten;
    }
    
    public void setServEaten (double servEaten){
        super.setServEaten(servEaten);
    }
}
