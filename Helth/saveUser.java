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
        //Determines if a file already exists or not
        String contentsToWrite = "enter username";
        //Prints out "enter username" on notepad++
        OutputStream outStream = new FileOutputStream(file);
        outStream.write(contentsToWrite.getBytes());
        outStream.close();
        
        //reader is not necessary for this but useful!
       /*BufferedReader reader = new BufferedReader(new InputStreamReader(
                 new FileInputStream(file)));
        String firstLine = reader.readLine();
        reader.close();
        System.out.println("Read a line: " + firstLine); */
        

        try {
            BufferedWriter writer = 
                          new BufferedWriter ( new FileWriter(".\\Login.txt"));
                          writer.Writer("What is your username?");
                          writer.close();
                        }
        catch (IOException e){
            e.printStackTrace();
            //Catch any exceptions
        }
    }
}