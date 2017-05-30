import java.util.ArrayList;

public abstract class FoodGroup {
    
    private ArrayList<String> grouping;
    private double servNeeded;
    private double additServe;
    private ArrayList<Double> grams;
    private double servEaten;
    private double totalServe;

    public FoodGroup(){
        grouping = new ArrayList<String>();
    }
    
    public abstract void setAmtNeeded(int age, String sex);
    
    public String getAmtNeeded(double servNeeded, double additServe){
        return servNeeded + " to " + (servNeeded+additServe) + " servings ";
    }
    
    public String amtRemain(double servEaten){
        totalServe = servNeeded + additServe;
        
        if(totalServe - (servEaten/8.5) > 0){
            return "You have to eat " + (totalServe - (servEaten/8.5)) + " servings left of";
        } else {
            return "No more servings needed.";
        }
    }
    
    public abstract void calcEaten(ArrayList<Double> grams);
    
    public void setServEaten (double servEaten){
        this.servEaten = servEaten;
    }
}