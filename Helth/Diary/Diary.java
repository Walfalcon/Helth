package Diary;

import java.io.*;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Diary{
    
    private String fileName;
    private Scanner user;
    private FileWriter diary;
    
    public Diary(String username) throws IOException{
        this.fileName = "diary" + username + ".txt";
        this.user = new Scanner(System.in);
        this.diary = new FileWriter(fileName,true);
        BufferedWriter bw = new BufferedWriter(diary);
    }
    
    public void setEntry() throws IOException{
        System.out.println("What food did you eat?");
        String food = user.nextLine();
        boolean check = true;
        
        while (check == true){
            try{
                System.out.println("Which food group is this from?");
                System.out.println("1. Fruit");
                System.out.println("2. Meat");
                System.out.println("3. Grain");
                System.out.println("4. Dairy");
                System.out.println("5. Vegetables and Legumes");
            
                int foodGroup = user.nextInt();
               
                switch (foodGroup){
                    case 1:
                        Fruit fruit = new Fruit();
                        break;
                    case 2:
                        Meat meat = new Meat();
                        break;
                    case 3:
                        Grain grain = new Grain();
                        break;
                    case 4:
                        Dairy dairy = new Dairy();
                        break;
                    case 5:
                        VegetablesAndLegumes veggie = new VegetablesAndLegumes();
                        break;
                }
                while (true){
                    try{
                        System.out.println("Does this food fit another food group?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int answer = user.nextInt();
                        switch (answer){
                            case 1:
                                check = true;
                                break;
                            case 2:
                                check = false;
                                break;
                        }
                        break;
                    
                    } catch (InputMismatchException e){
                        System.out.println("Incorrect input");
                        String notANumber = user.nextLine();
                    }
                }
                
            } catch (InputMismatchException e){
                System.out.println("Incorrect input");
                String notANumber = user.nextLine();
            }
        }
    

        FileWriter diary = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(diary);
        bw.newLine();
        bw.write(food);
        bw.close();
    }
    
    public String getEntry() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        String read = "";
        for (int i = 0; i < lines.size(); i++) {
            read += lines.get(i) + "\n";
        }
        return read;
    }
    
    public void clearDiary() throws IOException{
        FileWriter diary = new FileWriter(fileName);
    }
}
