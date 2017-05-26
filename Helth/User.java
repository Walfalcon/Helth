

/**
 *.
 * 
 * @author LNM
 * @version 5May2k17
 */
public class User
{
    private int age;
    private int weight;
    private int height;
    private String dietaryPref;
    private String activity;
    private String sex;
    
    public User()
    {
        age = 0;
        weight = 0;
        height = 0;
        dietaryPref = "";
        activity = "";
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
    
    public int getAge(int age)
    {
        return this.age;
    }
    
    public void setWeight(int weight)
    {
        this.age = age;
    }
    
    public int getWeight(int weight)
    {
        return this.weight;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    public int getHeight(int height)
    {
        return this.height;
    }
    
    public void setDietaryPref(String dietaryPref)
    {
        this.dietaryPref = dietaryPref;
    }
    
    public String getDietaryPref(String dietaryPref)
    {
        return this.dietaryPref;
    }
    
    public void setActivity(String activity)
    {
        this.activity = activity;
    }
    
    public String getActivity(String activity)
    {
        return this.activity;
    }
    
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    
    public String getSex(String sex)
    {
        return this.sex;
    }
}
