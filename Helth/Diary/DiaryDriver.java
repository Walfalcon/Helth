package Diary;
import java.io.*;
import java.util.Scanner;

public class DiaryDriver{
    
    public static void main() throws IOException{
        Scanner user = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = user.nextLine();
        
        Diary diary = new Diary(name);
        diary.setEntry();
        System.out.println("Clear?");
        boolean clear = user.nextBoolean();
        if (clear == true){
            diary.clearDiary();
        }
        System.out.println("Get entry?");
        boolean entry = user.nextBoolean();
        if (entry == true){
            System.out.println(diary.getEntry());
        }
        
    }
}
