import java.util.ArrayList;

public abstract class FoodGroup {
    
    private ArrayList<String> grouping;
    private double servNeeded;
    private double additServe;
    private ArrayList<Double> grams;
    private double servEaten;

    public FoodGroup(){
        grouping = new ArrayList<String>();
    }
    
    public void setGrouping(String food){
        grouping.add(food);
    }
    
    public abstract void setAmtNeeded(int age, String sex);
    
    public String getAmtNeeded(){
        return servNeeded + " to " + (servNeeded+additServe) + " servings.";
    }
    
    public String amtRemain(double totalServe, double servEaten){
        totalServe = servNeeded + additServe;
        return (totalServe - servEaten) + " servings left.";
    }
    
    public abstract double calcEaten(ArrayList<Double> grams);
    
    public void setServEaten (double servEaten){
        this.servEaten = servEaten;
    }
}
