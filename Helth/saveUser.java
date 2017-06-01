import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;


public class saveUser {
    public static void main(String[] args) throws IOException {
        File file = new File("Login.txt");
        System.out.println("We got a file: " + file);
        
        System.out.println("Does it exist? " + file.exists());
        System.out.println("What? " + file.isDirectory());
        
        String contentsToWrite = "enter username";
        OutputStream outStream = new FileOutputStream(file);
        outStream.write(contentsToWrite.getBytes());
        outStream.close();
        
       BufferedReader reader = new BufferedReader(new InputStreamReader(
                 new FileInputStream(file)));
        String firstLine = reader.readLine();
        reader.close();
        System.out.println("Read a line: " + firstLine); 
        
        String string = "Save.";
        try {
            BufferedWriter writer = 
                          new BufferedWriter ( new FileWriter(".\\Login.txt"));
                          writer.write(string);
                          writer.close();
                        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}