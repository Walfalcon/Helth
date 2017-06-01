import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * 
 * @author LNM
 * @version 1June2k17
 */
public class User
{
    private int age;
    private int weight;
    private int height;
    private String dietaryPref;
    private String activity;
    private String sex;
    
    Scanner user = new Scanner(System.in);
    
    public User()
    {
        age = 0;
        weight = 0;
        height = 0;
        dietaryPref = "";
        activity = "";
        sex = "unknown";
    }
    
    public User(int age, int weight, int height, String dietaryPref, String activity, String sex)
    {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.dietaryPref = dietaryPref;
        this.activity = activity;
        this.sex = sex;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    public void setWeight(int weight)
    {
        this.age = age;
    }
    
    public int getWeight()
    {
        return this.weight;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    public int getHeight()
    {
        return this.height;
    }
    
    public void setDietaryPref(String dietaryPref)
    {
        this.dietaryPref = dietaryPref;
    }
    
    public String getDietaryPref()
    {
        return this.dietaryPref;
    }
    
    public void setActivity(String activity)
    {
        this.activity = activity;
    }
    
    public String getActivity()
    {
        return this.activity;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public String getSex()
    {
        return this.sex;
    }
    
     //age,weight,height, pref, activity, sex
    public void doWork()
    {
        //this is the age, if it is below 0, it will not work, if above 117, it wont work
         while( age < 0 || age > 117)
         {
            
            try
            {
                System.out.println("Please print out your age: ");
                int input = user.nextInt();
            }catch( InputMismatchException e)
            {
                System.out.println("That is not a viable age... ");
                int notAge = user.nextInt();
            }
        }
        
        while ( weight < 0 || weight > 330) 
        {
            try
            {
                System.out.println("Please print out your weight (lbs): ");
                int input = user.nextInt();
            }catch( InputMismatchException e)
            {
                System.out.println("That is not a viable weight... ");
                int notWeight = user.nextInt();
            }
        }
        
        while( height < 0 || height > 108)
        {
            try
            {
                System.out.println("Please print out your height (inches): ");
                int input = user.nextInt();
            }catch(InputMismatchException e)
            {
                System.out.println("This is not a viable height...");
                int notHeight = user.nextInt();
            }
        }
        
    }   
        
    
    public void write()
    {
        String fileName = "user.txt";
        
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(String.valueOf(age));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(weight) + " lbs");
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(height)+ " in");
            bufferedWriter.newLine();
            bufferedWriter.write(dietaryPref);
            bufferedWriter.newLine();
            bufferedWriter.write(activity);
            bufferedWriter.newLine();
            bufferedWriter.write(sex);
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}   
