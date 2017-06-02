package Diary;

import java.util.ArrayList;

public class FoodGroupDriver{
    public static void main(){
        Fruit fruits = new Fruit();
        int age = 17;
        String sex = "female";
        fruits.setAmtNeeded(age, sex);
        System.out.println(fruits.getAmtNeeded());
        ArrayList<Double> grams = new ArrayList<Double>();
        Fruit pineapple = new Fruit();
        grams.add(4.0);
        Fruit strawberry = new Fruit();
        grams.add(3.0);
        fruits.calcEaten(grams);
        System.out.println(fruits.amtRemain(fruits.getCalcEaten()));
    }
}
