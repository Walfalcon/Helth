import java.io.*;
import java.util.InputMismatchException;
/**
 * 
 * @author LNM
 * @version 1June2k17
 */
public class User
{
    //these are all the variables to be used in this class
    private int age;
    private int weight;
    private int height;
    private String dietaryPref;
    private int diet;
    private String activity;
    private int activeNum;
    private String dietSpec;
    private int dSpec;
    private String sex;
    private int sexNum;
    
    Scanner user = new Scanner(System.in);
    //sets up scanner
    //sets up zero constructor to force while loops to run
    public User()
    {
        age = -1;
        weight = -1;
        height = -1;
        dietaryPref = "";
        activity = "";
        sex = "unknown";
    }
    
    //multiple argument constructor
    public User(int age, int weight, int height, String dietaryPref, String activity, String sex)
    {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.dietaryPref = dietaryPref;
        this.activity = activity;
        this.sex = sex;
    }
    
    //the next 8 or so methods are just getters for the particular variables
    public int getAge()
    {
        return this.age;
    }
          
    public int getWeight()
    {
        return this.weight;
    }

    public int getHeight()
    {
        return this.height;
    }
       
    public String getDietaryPref()
    {
        return this.dietaryPref;
    }
    
    public String getActivity()
    {
        return this.activity;
    }
       
    public int getActiveNum()
    {
        return this.activeNum;
    }
    
    public String getDietSpec()
    {
        return this.dietSpec;
    }
       
    public int getDSpec()
    {
        return this.dSpec;
    }
    
    public String getSex()
    {
        return this.sex;
    }
    
    public int getSexNum()
    {
        return this.sexNum;
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
                age = user.nextInt();
            }catch( InputMismatchException e)
            {
                System.out.println("That is not a viable age... ");
                String notAge = user.nextLine();
            }
        }
        
        while ( weight < 0 || weight > 330) 
        {
            try
            {
                System.out.println("Please print out your weight (lbs): ");
                weight = user.nextInt();
            }catch( InputMismatchException e)
            {
                System.out.println("That is not a viable weight... ");
                String notWeight = user.nextLine();
            }
        }
        
        while( height < 0 || height > 108)
        {
            try
            {
                System.out.println("Please print out your height (inches): ");
                height = user.nextInt();
            }catch(InputMismatchException e)
            {
                System.out.println("This is not a viable height...");
                String notHeight = user.nextLine();
            }
        }
        
        do
        {
            try
            {
                System.out.println("What is your activity level?");
                System.out.println("Enter 1: if sedentary(less than 30 minutes per day of intentional exercise)");
                System.out.println("Enter 2: if lightly active( 30 minutes per day of intentional exercise at 4mph)");
                System.out.println("Enter 3: if active( Exercise that is equal to walking for 1 hour and 45 minutes at 4mph)");
                System.out.println("Enter 4: if very active( Exercise that is equal to walking for 4 houra and 45 minutes at 4mph)");
                activeNum = user.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Incorrect input");
                String notAactNum = user.nextLine();
             }
        }while(activeNum < 1 || activeNum > 4);
        
        switch ( activeNum)
        {
            case 1:
                activity = "sedentary";
                break;
            case 2:
                activity = "lightly active";
                break;
            case 3:
                activity = "active";
                break;
            case 4:
                activity = "very active";
                break;
                //http://antranik.org/proper-activity-level-for-calorie-intake/    
        }
        
        do
        {
            try
            {
                System.out.println("What is your dietary preference?");
                System.out.println("Enter 1: if omnivore");
                System.out.println("Enter 2: if vegetarian");
                System.out.println("Enter 3: if vegan");
                System.out.println("Enter 4: if pescetarian");
                System.out.println("Enter 5: if paleo"); 
                diet = user.nextInt(); 
            }catch (InputMismatchException e){
                 System.out.println("Incorrect input");
                 String notADietPref = user.nextLine();
            }
        }while( diet < 1 || diet > 5);
        
        switch( diet)
        {
            case 1:
                dietaryPref = "omnivore";
                break;
            case 2:
                dietaryPref = "vegetarian";
                break;
            case 3:
                dietaryPref = "vegan";
                break;
            case 4:
                dietaryPref = "pescetarian";
                break;
            case 5 :
                dietaryPref = "paleo";
                break;
        }
        
       
        while(dSpec < 1 || dSpec > 7 || dSpec != 7)
        {
            try
            {
                System.out.println("Any other diet specifications?"); 
                System.out.println("Enter 1: gluten free");
                System.out.println("Enter 2: lactose intolerant");
                System.out.println("Enter 3: diabetic");
                System.out.println("Enter 4: allergy: nut");
                System.out.println("Enter 5: allergy: eggs");
                System.out.println("Enter 6: allergy: fish");                
                System.out.println("Enter 7: No other diet specifications");
                
                //http://www.webmd.com/allergies/food-triggers
                dSpec = user.nextInt();
                    switch( dSpec)
                {
                    case 1:
                        dietSpec = "gluten Free";
                        break;
                    case 2:
                        dietSpec = "lactose intolerant";
                        break;
                    case 3:
                        dietSpec = "diabetic";
                        break;
                    case 4:
                        dietSpec = "allergy: nut";
                        break;
                   case 5:
                        dietSpec = "allergy: eggs";
                        break;
                   case 6:
                        dietSpec = "allergy: fish";
                        break;
                   case 7:
                        dietSpec = "No other diet specifications";
                        break;
                    }        
                }catch (InputMismatchException e){
                 System.out.println("Incorrect input");
                 String notDSpec = user.nextLine();                
            }
            
        }
        
        do
        {
            try
            {
                System.out.println("What is your sex(not gender)?");
                System.out.println("Enter 1: if male");
                System.out.println("Enter 2: if female");
                sexNum = user.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Incorrect input");
                String notSexNum = user.nextLine();
             }
        }while(sexNum < 1 || sexNum > 2);
        
        switch ( activeNum)
        {
            case 1:
                activity = "male";
                break;
            case 2:
                activity = "female";
                break;
            
        }
            
        String fileName = "user.txt";
        
        try {
            // 
            FileWriter fileWriter =
                new FileWriter(fileName);

            //wraped FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // 
            // append a newline character.
            bufferedWriter.write(String.valueOf(age));
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(weight) + " lbs");
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(height)+ " in");
            bufferedWriter.newLine();
            bufferedWriter.write(activity);
            bufferedWriter.newLine();
            bufferedWriter.write(dietaryPref);
            bufferedWriter.newLine();
            bufferedWriter.write(dietSpec);
            bufferedWriter.newLine();
            bufferedWriter.write(sex);
            // closed files
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '");
            
        }
    }
}   

