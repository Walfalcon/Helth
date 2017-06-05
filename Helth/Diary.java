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
    private Fruit fruit;
    private MeatsAndNuts meat;
    private Grain grain;
    private Dairy dairy;
    private VegetablesAndLegumes veggie;
    private Fat fat;
    private Sugar sugar;
    private Login login;
    
    public Diary(String username) throws IOException{
        this.login = new Login();
        this.fileName = "diary" + login.getUsername() + ".txt";
        this.user = new Scanner(System.in);
        this.diary = new FileWriter(fileName, true);
        this.fruit = new Fruit("Fruit");
        this.meat = new MeatsAndNuts("MeatsAndNuts");
        this.grain = new Grain("Grain");
        this.dairy = new Dairy("Dairy");
        this.veggie = new VegetablesAndLegumes("VeggiesAndLegumes");
        this.fat = new Fat("Fat");
        this.sugar = new Sugar("Sugar");
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
                System.out.println("2. Meats and Nuts (includes fish and egg)");
                System.out.println("3. Grain");
                System.out.println("4. Dairy");
                System.out.println("5. Vegetables and Legumes");
                System.out.println("6. Fat");
                System.out.println("7. Sugar");
                int foodGroup = user.nextInt();
                
                System.out.println("How many grams did you have of this food?");
                double grams = user.nextDouble();
                String grams2 = Double.toString(grams);
               
                switch (foodGroup){
                    case 1:
                        fruit.setServEaten("Fruit", grams2);
                        break;
                    case 2:
                        meat.setServEaten("MeatsAndNuts", grams2);
                        break;
                    case 3:
                        grain.setServEaten("Grain", grams2);
                        break;
                    case 4:
                        dairy.setServEaten("Dairy", grams2);
                        break;
                    case 5:
                        veggie.setServEaten("VeggiesAndLegumes", grams2);
                        break;
                    case 6:
                        fat.setServEaten("Fat", grams2);
                        break;
                    case 7:
                        sugar.setServEaten("Sugar", grams2);
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
        
        fruit.calcEaten();
        meat.calcEaten();
        grain.calcEaten();
        dairy.calcEaten();
        veggie.calcEaten();
        fat.calcEaten();
        sugar.calcEaten();
        System.out.println("Grams Eaten:\n");
        read += fruit.getCalcEaten() + "\n";
        read += meat.getCalcEaten() + "\n";
        read += grain.getCalcEaten() + "\n";
        read += dairy.getCalcEaten() + "\n";
        read += veggie.getCalcEaten() + "\n";
        read += fat.getCalcEaten() + "\n";
        read += sugar.getCalcEaten() + "\n";
        return read;
    }
    
    public void clearDiary() throws IOException{
        diary = new FileWriter(fileName);
        fruit.clearFoodGroup("Fruit");
        meat.clearFoodGroup("MeatsAndNuts");
        grain.clearFoodGroup("Grain");
        dairy.clearFoodGroup("Dairy");
        veggie.clearFoodGroup("VeggiesAndLegumes");
        fat.clearFoodGroup("Fat");
        sugar.clearFoodGroup("Sugar");
    }
}
