import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DiaryDriver{
    
    public static void main() throws IOException{
        Scanner user = new Scanner(System.in);
        Diary diary = new Diary();
        diary.clearDiary();
        boolean check = true;
        
        //decides whether while loop runs
        try{
            System.out.println("Do you have an entry for your diary?");
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
            //catches if wrong input
        } catch (InputMismatchException e){
            System.out.println("Incorrect input");
            String notANumber = user.nextLine();
        }
        
        //sets the entry in the diary
        while (check == true){
            diary.setEntry();
            
            //breaks out of while loop
            try{
                System.out.println("Do you have another entry?");
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
                //catches if wrong input
            } catch (InputMismatchException e){
                    System.out.println("Incorrect input");
                    String notANumber = user.nextLine();
            }
            if (check == false){
                break;
            }
        }

        //shows the diary content
        try{
            System.out.println("Do you want to see the contents of your diary?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int answer = user.nextInt();
            switch (answer){
                case 1:
                    System.out.println(diary.getEntry());
                    System.out.println(diary.dietRec());
                    break;
                case 2:
                    break;
            }       
            //catches if wrong input
            } catch (InputMismatchException e){
                System.out.println("Incorrect input");
                String notANumber = user.nextLine();
        }
        
        System.out.println("(Press Enter to continue)");
        String cont = user.nextLine();
        cont = user.nextLine();
    }
}
