import java.io.*;

public abstract class FoodGroup {
    private double servEaten;
    private FileWriter groupings;
    public FoodGroup(String group) throws IOException{
        this.groupings = new FileWriter(HelthMain.login.getUsername() + group + ".txt", true);
    }
    
    public abstract void setAmtNeeded(int age, String sex, String activity);
    
    public String getAmtNeeded(double amtNeeded){
        return "Approximately " + amtNeeded + " servings ";
    }
    
    public String amtRemain(double amtNeeded, double calcEaten){
        if(amtNeeded - (calcEaten/8.5) > 0){
            return "You have to eat " + (amtNeeded - (calcEaten/8.5)) + " servings left of";
        } else {
            return "No more servings needed.";
        }
    }
    
    public abstract String getCalcEaten() throws IOException;
    
    public void setServEaten (String group, String grams2) throws IOException{
        FileWriter groupings = new FileWriter(HelthMain.login.getUsername() + group + ".txt", true);
        BufferedWriter bw = new BufferedWriter(groupings);
        bw.newLine();
        bw.write(grams2);
        bw.close();
    }
    
    public void clearFoodGroup(String group) throws IOException{
        groupings = new FileWriter(group + ".txt");
    }
}