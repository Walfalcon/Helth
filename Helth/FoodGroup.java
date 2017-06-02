import java.io.*;

public abstract class FoodGroup {
    
    private double servNeeded;
    private double additServe;
    private double servEaten;
    private double totalServe;
    private double amtNeeded;
    private FileWriter groupings;
    private Login login;
    public FoodGroup(String group) throws IOException{
        this.login = new Login();
        this.groupings = new FileWriter(group + login.getUsername() + ".txt", true);
    }
    
    public abstract void setAmtNeeded(int age, String sex);
    
    public String getAmtNeeded(double servNeeded, double additServe, String activity){
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
        return "Approximately " + amtNeeded + " servings ";
    }
    
    public String amtRemain(double calcEaten){
        totalServe = servNeeded + additServe;
        
        if(totalServe - (servEaten/8.5) > 0){
            return "You have to eat " + (totalServe - (calcEaten/8.5)) + " servings left of";
        } else {
            return "No more servings needed.";
        }
    }
    
    public abstract void calcEaten() throws IOException;
    
    public void setServEaten (String group, String grams2) throws IOException{
        FileWriter groupings = new FileWriter(group + ".txt", true);
        BufferedWriter bw = new BufferedWriter(groupings);
        bw.newLine();
        bw.write(grams2);
        bw.close();
    }
    
    public void clearFoodGroup(String group) throws IOException{
        groupings = new FileWriter(group + ".txt");
    }
}