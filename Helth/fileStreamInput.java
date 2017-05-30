import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class fileStreamInput {
    public static void main(String[] args) throws IOException {
        File path = new File("Login.txt");
        System.out.println("We got a file" + path);
        
        System.out.println("Does it exist?" + path.exists());
        System.out.println("What?" + path.isDirectory());
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                  new FileInputStream(path)));
             String firstLine = reader.readLine();
             reader.close();
             System.out.println("Read a line:" + firstLine);
            }
        }
        